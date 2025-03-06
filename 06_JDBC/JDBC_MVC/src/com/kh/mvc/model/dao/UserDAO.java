package com.kh.mvc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.mvc.model.UserDTO;

/*
 * dao
 * 데이터 베이스 관련된 작업(crud)을 전문적으로 담당하는 객체
 * dao안에 모든 메소드들은 데이터 베이스와 관련된 기능으로 만들 것
 * 
 * controller를 통해 호출ㄷ괸 기능을 수행
 * DB에 직접 접근한 후 SQL문을 수행하고 결과 받기
 */
public class UserDAO {

	/*
	 *  jdbc 용 객체
	 *  - connection: db와의 연결정보를 담고있는 객체
	 *  - statment: connection이 가지고 있는 연결정보DB에
	 *  						SQL문을 전달하고 실행하고 결과도 받아오는 객체
	 *  - resultSet: 실행한 sql문이 select문일 경우 조회된 결과가 처음 담기는 객체
	 *  
	 *  - prepareStatement: sql문을 미리 준비하는 개념
	 *  										?(위치홀더_ 로 확보해놓은 공간을
	 *  										사용자가 입력한 값들과 바인딩해서 SQL문을 수행
	 *  
	 *  
	 *  ** 처리절차
	 *  
	 *	1) jdbc driver 등록 : 해당 DBMC에서 제공하는 클래스를 동적으로 등록
	 *	2) Connection rorcp todtjd : 접속하고자 하는 DB의 정보를 입력해서 생성
	 *
	 *	3_1) preparedStatment 객체 생성 :
	 *			 Connection 객체를ㄹ 이용해서 생성(미완성된SQL문을 미리 전달)
	 *
	 *	3_2)미완성된 sql문을 완성형태로 만드렁 주어야 함
	 *	=>	미완성된 경우에만 해당 / 오나성된 경우에는 생략
	 *	4) sql문을 실행 : executeXXX() =?sql을 인자로 전달하지 않음
	 * 									?Select(dql) :excuteQuery()
	 * 									?dml				 :excuteUpdate()
	 * 5) 결과 받기
	 * 								>select :resultSet 타입 객체 (조회데이터 담김)
	 * 								>dml : int(처리된 행의 개수)
	 * 6_1) resultSet 에 담겨있는 데이터들을 하나하나씩 뽑아서 DTO객체 필드에
	 * 			옮겨담은 후 조회 결과가 여러 행일 경우 List로 관리
	 * 6_2) 트랜잭션 처리
	 * 7(생략될 수 있음) ) 자원반납(close)=> 생성의 역순으로
	 * 8) 결과 반환 -> controller
	 * 							 select >6_1에서 만든거
	 * 							 DML : 처리된 행의 개수
	 */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc잘넣었나");
			e.printStackTrace();
		}
		
		
	}
	
	
	public List<UserDTO> findAll() {
		
		List<UserDTO> list =new ArrayList();
		String sql ="select "
				+ " user_no"
				+ ", user_id"
				+ ", user_pw"
				+ ", user_name"
				+ ", enroll_date "
				+ "from "
				+ "tb_user "
				+ "order "
				+ "by "
				+ "enroll_date desc";
				
		String url = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
		String userName = "KH06_KDY"; // 사용자 계정명
		String password = "KH1234"; // 계정 비밀번호
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UserDTO user =new UserDTO();
				user.setUserNo(rset.getInt("user_no"));
				user.setUserId(rset.getString("user_id"));
				user.setUserPw(rset.getString("user_pw"));
				user.setUserName(rset.getString("user_name"));
				user.setEnrollDate(rset.getDate("enroll_date"));
				
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
				
			} catch (SQLException e) {
				System.out.println("db서버오류");
			}
		}
		
		return list;
	}
	
	
	public int insertUser(UserDTO user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert "
				+ "into "
				+ "tb_user "
				+ "values "
				+ "(seq_user_no.nextval, ?, ?, ?, sysdate)";
		
		String url = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
		String userName = "KH06_KDY"; // 사용자 계정명
		String password = "KH1234"; // 계정 비밀번호
		
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, userName, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(pstmt !=null) {
						pstmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(conn !=null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}
		return result;
		
	}
	
}

