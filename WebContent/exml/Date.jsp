<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>여기에 제목을 입력하십시오</title>
</head>
<body>
<%
Calendar cal = Calendar.getInstance();
String[] arr = {"일","월","화","수","목","금","토"};
%>
<%!
		public String getDay(int x){
		String str="";
		switch (x){
		case 1 : str="일" ; break;
		case 2 : str ="월"; break;
		case 3 : str ="화"; break;
		case 4 : str ="수"; break;
		case 5 : str ="목"; break;
		case 6 : str ="금"; break;
		case 7 : str ="토"; break;
		}
		return str;
	}
	%>
오늘은
<%= cal.get(Calendar.YEAR) %>년
<%= cal.get(Calendar.MONTH)+1 %>월
<%= cal.get(Calendar.DATE) %>일
<%= arr[cal.get(Calendar.DAY_OF_WEEK)-1]%>요일
배열이용 요일 :<%=arr[cal.get(Calendar.DAY_OF_WEEK)-1] %>
함수이용 요일:<%= getDay(cal.get(Calendar.DAY_OF_WEEK)) %>
</body>
</html>