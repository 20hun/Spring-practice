<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ 개인회원정보 ]</title>
<script type="text/javascript">
	function memberUpdateForm(){
		var member_id = document.getElementById("member_id").value;
		location.href = "/member/memberUpdateForm?member_id="+member_id;	
	}
</script>
</head>
<body>
	<h1>[ 회원 정보 ]</h1>
	ID : ${member.member_id } <br>
	PW : ${member.member_pw } <br>
	Name : ${member.member_nm } <br>
	등록일 : ${member.member_indate } <br>
	
	<input type = "button" value = "수정하기" onclick="memberUpdateForm()">
	<input type = "hidden" id = "member_id" value="${member.member_id }">
</body>
</html>