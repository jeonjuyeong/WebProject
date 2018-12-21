<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
	BoardDAO dao  = BoardDAO.getInstance();
	int num = Integer.parseInt(request.getParameter("num"));
	String passwda =request.getParameter("passwd");
	out.println(passwda);
	String passwdb =dao.getPasswd(num);
	if(passwda.equals(passwdb)){
		dao.boardDelete(num);	
		response.sendRedirect("boadList.jsp");
	}else{%>
	<script>
	 	alert("비밀번호가 틀렸습니다!");
	 	history.back();
	 	</script>
	<%}
	%>
</body>
</html>