<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>

	<!-- action = form tag안에 있는 데이터가 전달될 'request' 주소
	method = form tag안에 있는 데이터를 전달할 때 사용할 Http method 방식을 지정(get, post)
	Tag의 name 속성에 지정한 값은 Java 쪽의 변수명과 일치
	 -->
	
	<form action="/join2" method="post">
		ID : <input type="text" name="id"> <br>
		PW : <input type="password" name="pw"> <br>
		이름 : <input type="text" name="name"> <br>
		나이 : <input type="number" name="age"> <br>
		<input type="submit" value="가입">
	
	</form>

</body>
</html>
