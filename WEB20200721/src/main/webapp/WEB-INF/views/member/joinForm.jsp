<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
function idCheck(){
	$.ajax({
		url: "idCheck",
		data: {
			id: $("#member_id").val() //자바스크립트 객체 안에서는 ; 쓰면 안됨
		},
		success: function(data){
			$("div").text(data);
		},
		error: function(e){
			alert("통신 실패.");
			console.log(e);
		}
	});
}
</script>
</head>
<body>

	<h1>[ 회원 가입 폼 ]</h1>
	
	<form action="/member/join" method="post">
		ID : <input type="text" name="member_id" id="member_id">
			<input type="button" onclick="idCheck();" value="ID 중복 검사">
			<div></div>
		PW : <input type="password" name="member_pw"> <br>
		Name : <input type="text" name="member_nm"> <br>
		<input type="submit" value="전송">
	</form>
	
</body>
</html>