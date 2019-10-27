package com.ssg.sb;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<BoardVo> list = SBDao.getBoardList();
		
		request.setAttribute("data", list);
		//request.getAttribute("data");
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		rd.forward(request, response);
		
	}
}
