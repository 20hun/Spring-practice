<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<c:choose>
		<c:when test="${not empty av }">
	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>취미</th>
			<th>취미2</th>
			<th>취미3</th>
			<th>취미4</th>
			<th>성별</th>
			<th>자기소개</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="i" begin="0" end="${av.size() -1}">
			<tr>
				<td>${i+1 }</td>
				<td>${av[i].id }</td>
				<td>${av[i].name }</td>
				<td>${fn:length(av[i].hobby)}</td>
				<td>
				<c:forEach var="j" begin="0" end="${fn:length(av[i].hobby) -1}">
				${av[i].hobby[j] }
				</c:forEach>
				</td>
				<td>${av[i].hobby }</td>
				<td>
				<c:forEach var="j" begin="0" end="${fn:length(av[i].hidden) -1}">
				${av[i].hidden[j] }
				</c:forEach>
				</td>
				<td>${av[i].gender }</td>
				<td>${av[i].info }</td>
				<td><a href="/member/delete?id=${av[i].id }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/member/delete2">삭제하러 갑시다</a>
	</c:when>
		<c:otherwise>
			<h1>저장된 값 없음</h1>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>