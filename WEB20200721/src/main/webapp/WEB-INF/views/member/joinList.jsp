<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${list }
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>가입날짜</th>
		</tr>
		<c:forEach items="${list }" var="member" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${member.member_id }</td>
				<td>
					<a href="selectOne?member_id=${member.member_id }">${member.member_nm }</a>
				</td>
				<td>${member.member_indate }</td>
				<td><a href="/member/delete?member_id=${member.member_id }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>