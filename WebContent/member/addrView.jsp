<%@page import="com.jquery.AddressBean"%>
<%@page import="com.jquery.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
		request.setCharacterEncoding("utf-8");
		int num =Integer.parseInt(request.getParameter("num"));
		AddressDAO dao = AddressDAO.getInstance();
		AddressBean ab = dao.addressView(num);
		%>
<script>
function update(){
	frm.action="updateProc.jsp";
}
function showConfirm(){
	 if (confirm("정말삭제하시겠습니까??"))
	  {
	 	frm.action ="AddressDelete.jsp";
	  } else {
	   return;
	  }
}
</script>
<form id="frm" name ="frm">
<input type ="hidden" name ="num" value ="<%=ab.getNum()%>">
이름: <input type = "text"name ="name" value="<%=ab.getName()%>"><br>
주소:  <input type = "text" name ="addr" value="<%=ab.getAddr()%>"><br>
 폰:  <input type = "text" name ="phone"value="<%=ab.getPhone()%>"><br>
 <input type ='submit' onclick ="update()" value = "수정">
  <input type ='submit' onclick="showConfirm();" value = "삭제">
  </form>
</body>
</html>