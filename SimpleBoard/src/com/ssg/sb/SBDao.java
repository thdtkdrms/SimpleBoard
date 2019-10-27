package com.ssg.sb;

import java.sql.*;
import java.util.*;

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
	
	private static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		close(con, ps);
	}
	
	/*
	public static int insertBoard(String title, String content) {
		int result = 0;
		
		return result;
	}
	*/
	//글쓰기
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

	//글쓴거 가져오기
	public static List<BoardVo> getBoardList(){
		List<BoardVo> list = new ArrayList();
		
		String query = " SELECT i_board, title, regdatetime FROM T_BOARD ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getCon();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();  //select는 executeQuery
			while(rs.next()) {
				int i_board = rs.getInt("i_board"); // 컬럼 입력(대소문자 가리지않음)
				String title = rs.getString("title");
				//String content = rs.getString("content");
				String regDateTime = rs.getString("regdatetime");
				
				BoardVo vo = new BoardVo(i_board, title, "", regDateTime);
				list.add(vo);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		
		return list;
	}
	
	public static BoardVo getBoardDetail(int i_board) {
		BoardVo vo = null;
		
		String query = " SELECT * FROM T_BOARD WHERE I_BOARD = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getCon();
			ps = con.prepareStatement(query);
			ps.setInt(1, i_board);
			rs = ps.executeQuery();
			/* ps.execute();  // 정상적으로 실행되었는지 확인(true, false)
			ps.executeUpdate(); //실행 
			*/
			if(rs.next()) { //if 사용해도됨, 1건인경우, 아니면  while사용
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regDateTime = rs.getString("regdatetime");
				
				vo = new BoardVo(i_board, title, content, regDateTime);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		
		return vo;		
	}
	
	
	
	
	
	
}
