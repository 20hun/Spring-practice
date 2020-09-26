<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ 글 수정 화면 ]</title>
</head>
<body>
	<h1>[ 글 수정 ]</h1>
	
	<form action="boardUpdate" method="post">
		글 제목 : <input type="text" name="board_title" value="${map.BOARD_TITLE}"> <br>
		글 내용  <br>
		<textarea rows="10" cols="40" name="board_context">${map.BOARD_CONTEXT }</textarea>
		<input type="submit" value="글  수정">
		<input type="hidden" name="board_no" value="${map.BOARD_NO }">
	</form>
</body>
</html>