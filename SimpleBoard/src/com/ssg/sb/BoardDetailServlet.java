package com.ssg.sb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(str_board);		
		BoardVo vo = SBDao.getBoardDetail(i_board);
		request.setAttribute("vo",  vo);
		
		request.getRequestDispatcher("WEB-INF/jsp/detail.jsp").forward(request, response);
		
	}

	
	
	

}
