<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 기초 예제</title>
<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function idCheck(){
		$.ajax({
			url: "idCheck",
			data: {
				id: $("input:text").val() //자바스크립트 객체 안에서는 ; 쓰면 안됨
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
	<span>아이디: </span>
	<input type="text">
	<button onclick="idCheck();">ID 중복 검사</button>
	<div></div>
</body>
</html>