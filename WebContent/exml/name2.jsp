<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
 <script>
   $(document).ready(function(){
      $("#btn").click(function(){
         if($("#name").val()==""){
            alert("이름 입력");
            return false;
         }
         if($("#age").val()==""){
            alert("나이 입력");
            return false;
         }
         if($("input[type=radio]:checked").length==0){
            alert("성별 선택");
            return false;
         }
         if($("#memo").val()==""){
            alert("자기소개 입력");
            return false;
         }
         $("#frm").submit();
      });
   });
</script> 
</head>
<body>
   <form id = "frm" action="formresult.jsp" >
   <fieldset>
   <legend> 개인정보 입력 </legend>
      이름 : <input type="text" name="name" id="name"> <br>
      나이 : <input type="text" name="age" id="age"> <br>
      성별 : <input type ="radio" value ="man" name = "gender" checked  > 남자
         <input type = "radio" value="woman" name ="gender" > 여자 <br>
      
      관심분야 <br>
      <input type="checkbox" name="hobby" value="exercise" checked> 운동
      <input type="checkbox" name="hobby" value="game" > 게임
      <input type="checkbox" name="hobby" value="hiking"> 등산
      <input type="checkbox" name="hobby" value="movie" > 영화 <br>
   
      직업 : 
      <select name ="job">
         <option value="학생"> 학생 </option>
         <option value="직장인"> 직장인 </option>    
         <option value="취준생"> 취준생 </option>    
      </select><br>
   
      자기소개<br>
      <textarea rows="20" cols="50" name ="memo" id="memo"></textarea><br>
   
      <input type="button" value="전송"    name ="btn" id="btn">
      <input type="button" value = "회원가입(buttoon)" >
      <input type ="button" value="취소">    
   </fieldset>
   </form>       
   


</body>
</html>