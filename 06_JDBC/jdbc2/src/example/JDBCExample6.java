package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCExample6 {
	public static void main(String[] args) throws ClassNotFoundException {
		

	
		String url = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
		String userName = "KH06_KDY"; // 사용자 계정명
		String password = "KH1234"; // 계정 비밀번호
		
		/* 2. DriverManager 객체를 이용해 Connection 객체 생성하기 */
		Class.forName("oracle.jdbc.OracleDriver");
		
		/* 3. SQL 작성 */
		String sql = """
					DELETE  FROM TB_USER
					WHERE 
						USER_ID = ?
					AND 
						USER_PW = ?
					""";
		
		/* 1. JDBC 객체 참조 변수 선언 */
		try(Connection conn = DriverManager.getConnection(url, userName, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				Scanner sc = new Scanner(System.in)) {
			
			// 자동 커밋 끄기
			conn.setAutoCommit(false);
			
			
			System.out.println("--- 사용자 삭제하기 ---");
			
			System.out.print("아이디 : ");
			String id = sc.next();
			
			System.out.print("비밀번호 : ");
			String pw = sc.next();
			
			
			/* 4. sql을 전달하고 결과를 받아올 
			 * PreparedStatement 객체 생성 + ? 값 세팅 */
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			/* 5. PreparedStatement 객체를 이용해서 SQL을 DB로 전달 후 수행 
			 1) SELECT문 : executeQuery() -> ResultSet으로 반환 
			 2) DML문    : executeUpdate() -> 결과 행의 개수(int) 반환
			*/

			int result = pstmt.executeUpdate();
			
			/* (DML 수행 시)
			 * 6. SQL 수행 결과에 따른 처리 + 트랜잭션 제어 */
			if(result == 0) { // 1행 수정 
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다");
				
				
			} else {
				System.out.println("정말 삭제하시겠습니까(Y/N)");
				String check =sc.next().toUpperCase();
				if (check.equals("Y")) {
					conn.commit();
					System.out.println("삭제 되었습니다");
				}else {
					conn.rollback();
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}