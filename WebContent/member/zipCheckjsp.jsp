<%@page import="com.jquery.ZipCodeDBA"%>
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
	$("#send").click(sendIt)	;//#send button
		$("#dong").keydown(function(e){
			if(e.keyCode==13){
				sendIt();
				return false;
			}
	});
		$("#result").on("click","tr",function(){
			var address = 	$("td:eq(1)",this).text()+" "+
									$("td:eq(2)",this).text()+" "+
									$("td:eq(3)",this).text()+" "+
									$("td:eq(4)",this).text()+" ";
			$(opener.document).find("#zipcode").val( $("td:eq(0)",this).text());
			$(opener.document).find("#addr").val(address);
			self.close();
		});
});//document
function sendIt(){
	
	$.ajax({
		type:"post",
		url:"zipCheckProc.jsp?dong="+$("#dong").val(),
	//	data:{"dong":$("#dong").val()},
		success: function(data){
			data=$.parseJSON(data);
			var htmlStr="";
			//데이터를 테이블에 뿌려줌
			htmlStr+="<table>";
			for(var i=0;i<data.length;i++){
				htmlStr+="<tr>";
				htmlStr+="<td>"+data[i].zipcode+"</td>";
				htmlStr+="<td>"+data[i].sido+"</td>";
				htmlStr+="<td>"+data[i].gugun+"</td>";
				htmlStr+="<td>"+data[i].dong+"</td>";
				htmlStr+="<td>"+data[i].bunji+"</td>";
				htmlStr+="</tr>";
			}
			htmlStr+="</table>";
			$("#result").html(htmlStr);
		},
		error:function(e){
			alert(e);
		},
		beforeSend:check
	});
}
function check(){
	if($("#dong").val()==""){
		alert("동이름을 입력해주세요.");
		return false;
	}
	return true;
}

//get방식--------------------------------------
// 	$.get("zipCheckProc.jsp",
// 		{"dong":$("#dong").val()},
// 		function(data){
		
// 			data=$.parseJSON(data);
// 			var htmlStr="";
// 			//데이터를 테이블에 뿌려줌
// 			htmlStr+="<table>";
// 			for(var i=0;i<data.length;i++){
// 				htmlStr+="<tr>";
// 				htmlStr+="<td>"+data[i].zipcode+"</td>";
// 				htmlStr+="<td>"+data[i].sido+"</td>";
// 				htmlStr+="<td>"+data[i].gugun+"</td>";
// 				htmlStr+="<td>"+data[i].dong+"</td>";
// 				htmlStr+="<td>"+data[i].bunji+"</td>";
// 				htmlStr+="</tr>";
// 			}
// 			htmlStr+="</table>";
// 			$("#result").html(htmlStr);
// 		});

</script>


</head>
<body>
<table>


	<tr>
		<td>
		동이름입력<input type="text" name="dong" id="dong">
		<input type="button" id="send" value="검색">
		</td>
	</tr>

</table>
<table>
<div id="result"></div>
</table>
</html>