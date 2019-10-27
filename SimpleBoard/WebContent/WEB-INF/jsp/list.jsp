<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ssg.sb.*" %>
<%
	List<BoardVo> data = (List<BoardVo>)request.getAttribute("data");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div>보드 리스트</div>
	<div>
		<a href="write">
			<button>글쓰기</button>
		</a>
	</div>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
	<% for(BoardVo vo:data) { %>
		<tr>
			<td><%=vo.getI_board() %></td>
			<td><% out.print(vo.getTitle()); %></td>
			<td><%=vo.getRegDateTime() %></td>		
		</tr>
	
	<% } %>
	</table>

</body>
</html>