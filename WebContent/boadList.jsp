<%@page import="com.board.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>  

	body { background: #fff; padding : 30px;}
	#blueone {
	  border-collapse: collapse;
	}  
	#blueone th {
	  padding: 10px;
	  color: #168;
	  border-bottom: 3px solid #FACC2E;
	  text-align: left;
	}
	#blueone td {
	  color: #669;
	  padding: 10px;
	  border-bottom: 1px solid #ddd;
	}
	
</style>
</head>
<body>
<div class="container">
<%
	BoardDAO dao  = BoardDAO.getInstance();
	int pageSize=7;
	String pageNum=request.getParameter("pageNum");
	if(pageNum==null)pageNum="1";
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage-1)*pageSize+1;
	int endRow = currentPage*pageSize;
	String word="";
	String field="";
	if(request.getParameter("word")!=null){
		word=request.getParameter("word");
		field=request.getParameter("field");
	}
	ArrayList<BoardBean> arr = dao.boardList(field,word,startRow,endRow);
	int count = dao.size(word,field);
%>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>
$(document).ready(function () {
	$("#searchIt").click(function(){
		if(search.word.value==""){
			alert("검색어를 넣어주세요");
			search.word.focus();
			return;
		}
			search.submit();
	});
});

</script>
<form name="search" action="boadList.jsp">
<div class="col-xs-2">
	<select id="field" class="form-control"name = "field">
		<option value="subject"> 제목
		<option value="writer"> 작성자
	</select>
</div>
<div class="col-xs-3">
	<input type='text' id='word' name='word' size='10' class="form-control" placeholder="검색어입력">
</div>
	<input type='button' class="btn btn-default" value="검색" id='searchIt'>
</form>
<table id="blueone" class="table table-hover">
	<tr>
		<th colspan="5">
		<th>
	</tr>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회</th>
		<th>ip</th>
	</tr>
	<% 
	 for(int i =0; i <arr.size(); i ++){
		 %> 
		 <tbody>
		
			 <tr>
			 	<td><%=arr.get(i).getNum() %></td>
			 	
			 	<td><%
			 		int wid=0;
			 		if(arr.get(i).getRe_level()>0){
			 			wid=5*(arr.get(i).getRe_level());
			 		%>
			 		<img src="images/level.gif" width="<%=wid%>" height="16">
			 		<img src="images/re.gif">
			 	<%
		 			}else{
				 %>
					 <img src="images/level.gif" width="<%=wid %>"height="16">
			 	
			 	<%}%>
			 	<a href ="boardView.jsp?num=<%=arr.get(i).getNum()%>"><%=arr.get(i).getSubject()%></a></td>
			 	<td><%=arr.get(i).getWriter() %></td>
			 	<td><%=arr.get(i).getReg_date() %></td>
			 	<td><%=arr.get(i).getReadcount() %></td>
			 	<td><%=arr.get(i).getIp() %></td>
			 </tr>
		</tbody>
		
		 <%
	 }
		%>
</table>
<%
	if(count>0){//53
		//총페이지수
		int pageCount = count/pageSize+(count%pageSize==0?0:1);
		int pageBlock = 3;//[이전] 4|5|6 [다음]
		
		int startPage=(int) ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage=startPage +pageBlock-1;
		if(endPage >pageCount){
			endPage=pageCount;
		}//12
		// 이전출력부분
		if(startPage>pageBlock){
			%><a href="boadList.jsp?pageNum=<%=startPage%>&field=<%=field%>&word=<%=word%>">[이전]</a><% 
		}
		//페이지 수 출력부분
		for(int i =startPage; i<=endPage; i++){
			if(i==currentPage){
				%>[<%=i%>]<%
			}else{
			%>[<a href ="boadList.jsp?pageNum=<%=i%>&field=<%=field%>&word=<%=word%>"><%=i%></a>]<% 
		}
			//다음 출력부분
			if(endPage<pageCount){
				%><a href="boadList.jsp?pageNum=<%=startPage+pageBlock%>&field=<%=field%>&word=<%=word%>">[이후]</a><%
			}
		}
	}
%>
</div>
</body>
</html>