package com.kh.mvc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	public Connection getConnection() {
		Connection conn =null;
		try {
			conn = DriverManager.getConnection(URI,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Statement) {
		
	}
}
