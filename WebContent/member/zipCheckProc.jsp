<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.jquery.ZipCode"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jquery.ZipCodeDBA"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String dong = request.getParameter("dong");
//String dong = "서면";
ZipCodeDBA dba = ZipCodeDBA.getInstance();
ArrayList<ZipCode> arr= dba.zipSearch(dong);
System.out.println(arr.size());
JSONArray jarr = new JSONArray();
for(ZipCode z:arr){
	JSONObject obj = new JSONObject();
	obj.put("zipcode", z.getZipcode());
	obj.put("sido",z.getSido());
	obj.put("gugun",z.getGugun());
	obj.put("dong",z.getDong());
	obj.put("bunji",z.getBunji());
	jarr.add(obj);
}
out.println(jarr.toString());
%>