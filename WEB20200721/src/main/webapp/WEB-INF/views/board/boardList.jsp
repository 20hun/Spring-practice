<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ 글 목록 페이지 ]</title>
<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>

	<script type="text/javascript">
		function boardWriteForm(){
			location.href ="/board/boardWriteForm";
		}

	</script>
	
	<script>
	function pagingFormSubmit(currentPage) {
		var form = document.getElementById('pagingForm');
		var searchType = document.getElementById("searchType").value;
		document.getElementById('page').value = currentPage;
		document.getElementById("type").value = searchType;

		form.submit();
	}
	</script>
</head>
<body>
	<h1>[ 글 목록 ]</h1>
	<table>
		<tr>
			<td>전체: ${navi.totalRecordsCount }</td>
		</tr>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list }" var="data" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>
					<a href="boardRead?board_no=${data.BOARD_NO }">${data.BOARD_TITLE }</a>
				</td>
				<td>${data.MEMBER_NM }</td>
				<td>${data.BOARD_INDATE }</td>
				<td>${data.BOARD_HITS }</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="javascript:pagingFormSubmit(${navi.currentPage - navi.pagePerGroup})">◁◁ </a> &nbsp;&nbsp;
	<a href="javascript:pagingFormSubmit(${navi.currentPage - 1})">◀</a> &nbsp;&nbsp;

	<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}"> 
		<c:if test="${counter == navi.currentPage}"><b></c:if>
			<a href="javascript:pagingFormSubmit(${counter})">${counter}</a>&nbsp;
		<c:if test="${counter == navi.currentPage}"></b></c:if>
	</c:forEach>
	&nbsp;&nbsp;
	<a href="javascript:pagingFormSubmit(${navi.currentPage + 1})">▶</a> &nbsp;&nbsp;
	<a href="javascript:pagingFormSubmit(${navi.currentPage + navi.pagePerGroup})">▷▷</a>
	
	<br><br>
	
	<input type="button" value="글쓰기" onclick="boardWriteForm()">
	<br>
	
	<form id="pagingForm" method="get" action="boardList">
	<input type="hidden" name="page" id="page">
	<input type="hidden" name="searchType" id="type">
	${searchType }
	<select id="searchType">
		<c:choose>
		<c:when test="${searchType eq'name'}">
			<option value="title">제목</option>
			<option value="name" selected="selected">작성자</option>
		</c:when>
		<c:otherwise>
			<option value="title" selected="selected">제목</option>
			<option value="name">작성자</option>
		</c:otherwise>
		</c:choose>
	</select>
	<input hidden="hidden">
	<input type="text"  name="searchText" value="${searchText}">
	<input type="button" onclick="pagingFormSubmit(1)" value="검색">
	</form>
</body>
</html>