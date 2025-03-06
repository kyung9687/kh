package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCExample4 {

	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url ="jdbc:oracle:thin:@112.221.156.34:12345:XE";
			String userName ="KH06_KDY";
			String password ="KH1234";
			
			
			
			conn = DriverManager.getConnection(url,userName,password);
			conn.setAutoCommit(false);
			
			String sql = """
					UPDATE TB_USER SET 
					USER_PW =? 
					where USER_ID =? 
					AND USER_PW =?
					"""	;
					
			
			
			Scanner sc = new Scanner(System.in);
			System.out.print("아이디 입력:");
			String id = sc.next();
			System.out.print("비밀번호 입력:");
			String pw = sc.next();
			System.out.print("수정할 비밀번호 입력:");
			String pw2 = sc.next();
			
			
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, pw2);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			
			int result =pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("비밀번호 수정 성공");
				conn.commit();
			}else {
				System.out.println("비밀번호 수정 실패");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
