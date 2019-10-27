package com.ssg.sb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SBDao {
	public static void main(String[] args) {
		try {
			getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Connection getCon() throws Exception {
		final String URL = "jdbc:mysql://localhost:3306/jsp?characterEncoding=UTF-8&serverTimezone=UTC";
		final String USER = "root";
		final String PW = "1234";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PW);
		System.out.println("DB 접속 성공!!");
		return con;
	}
	
	private static void close(Connection con, PreparedStatement ps) {
		if (ps != null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	public static int insertBoard(String title, String content) {
		int result = 0;
		
		return result;
	}
	*/
	public static int insertBoard(BoardVo vo) {
		int result = 0;
		
		String qurey = " INSERT INTO T_BOARD"
				     + " (TITLE, CONTENT)"
				     + " VALUES"
				     + " (?, ?)";		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getCon();
			ps = con.prepareStatement(qurey);
			ps.setString(1,  vo.getTitle());
			ps.setString(2,  vo.getContent());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			close(con, ps);
		}
		
		return result;
	}

	
	
	
	
	
}
