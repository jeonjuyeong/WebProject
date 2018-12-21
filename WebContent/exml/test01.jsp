<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	$("#b1").click(function(){
		$.get("test02.jsp",
				{"name":"jsp공부","status":"get study"},
		function(data){
			$("#result").html(data);
		});//get
	});
	//load
	$("#b2").click(function(){
		$("#result").load("test02.jsp",{"name":"jsp공부","status":"load study"},
			function(d){
	 	 	$("#result").html(d);
		})
	});
	//post
	$("#b3").click(function(){
		$.post("test02.jsp",
				{"name":"jsp공부","status":"post study"},
		function(data){
			$("#result").html(data);
		});//get
	});
	$("#b4").click(function(){
		$.ajax({
			type:"post",
			url:"test02.jsp",
			data:{"name":"jsp공부","status":"ajax study"},
			success: function(d){
				$("#result").html(d);
			},
			error:function(e){
				alert(e);
			}
			
		})
	});
	
})</script> 
</head>
<body>
<button id="b1">$get 방식</button>
<button id="b2">$post 방식</button>
<button id="b3">$load 방식</button>
<button id="b4">$ajax 방식</button>
<div id ="result">$get 방식</div>
</body>
</html>