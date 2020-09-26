<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>please</title>
<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		readReply();
	});

	function readReply() {
		$.ajax({
			url: "/board/readReply",
			type: "post",
			data: {
				board_no: ${map.BOARD_NO}
			},
			success: function(data) {
				output(data);
			},
			error: function(e) {alert("통신 실패...");console.log(e);}
		});
	}

	function output(data){
		var str = "";

		$.each(data, function(index, item){
			str += "<tr>";
			str += "	<td>";
			str += "		" + item.writer;
			str += "	</td>";
			str += "	<td>";
			str += "		" + item.indate;
			str += "	</td>";
			str += "	<td>";
			str += "		" + item.content;
			str += "	</td>";
			str += "</tr>";
		});

		console.log(str);
		
		$("#re").html(str);
	}
	
	function boardDelete(){
		var board_no = document.getElementById("board_no").value;
		location.href = "boardDelete?board_no="+board_no;
	}
	function boardUpdateForm(){
		var board_no = document.getElementById("board_no").value;
		location.href = "boardUpdateForm?board_no="+board_no;
	}
</script>
</head>
<body>
	글번호 : ${map.BOARD_NO } <br>
	글제목 : ${map.BOARD_TITLE } <br>
	글내용 : ${map.BOARD_CONTEXT} <br>
	작성일 : ${map.BOARD_INDATE } <br>
	조회수 : ${map.BOARD_HITS } <br>
	작성자 : ${map.MEMBER_NM } <br>
	첨부파일 : <a href="/board/download?board_no=${map.BOARD_NO }">${map.ORIGINALFILE }</a> <br>
	<c:if test="${map.MEMBER_ID.equals(sessionScope.loginId) }">
	<input type="hidden" id="board_no" value="${map.BOARD_NO }">
	<input type="button" value="수정" onclick="boardUpdateForm()"> <input type="button" value="삭제" onclick="boardDelete()">
	</c:if>
	
	<table border=1 id="re">
	
	</table>
	<button onclick="location.href='/board/boardList'">게시판으로 이동</button>
	<button onclick="readReply();">댓글 다시 가져오기(디벨로퍼에서 댓글 추가해서 눌러보자)</button>
</body>
</html>