<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		function searchForm(){
			var form = document.getElementById('searchForm');
			var searchType = document.getElementById("searchType").value;
			var searchText = document.getElementById("searchText").value;
						
			document.getElementById("type").value = searchType;
			if(searchText == ''){
				alert("검색어를 입력해 주세요");
				return false;
			}
			
			form.submit();
		}

		function inCheck(){
			$.ajax({
				url: "inCheck",
				data: {
					type: $("#in").val()
				},
				success: function(data){
					$("#inout").attr("value", data);
				},
				error: function(e){
					alert("통신 실패.");
					console.log(e);
				}
			});
		}	
		function outCheck(){
			$.ajax({
				url: "inCheck",
				data: {
					type: $("#out").val()
				},
				success: function(data){
					$("#inout").attr("value", data);
				},
				error: function(e){
					alert("통신 실패.");
					console.log(e);
				}
			});
		}
		function minCheck(){
			$.ajax({
				url: "mmCheck",
				data: {
					type: $("#min").val()
				},
				success: function(data){
					$("#minmax").attr("value", data);
				},
				error: function(e){
					alert("통신 실패.");
					console.log(e);
				}
			});
		}		
		function maxCheck(){
			$.ajax({
				url: "mmCheck",
				data: {
					type: $("#max").val()
				},
				success: function(data){
					$("#minmax").attr("value", data);
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
	<h1>[ 가계부 ]</h1>
	${list }
	
	<c:forEach items="${list }" var="mb2" varStatus="status">
	<td>${mb2.moneybook_indate }</td>
	</c:forEach>
	${list2 }
	<c:forEach items="${list2 }" var="mb3" varStatus="status">
	<td>${mb3}</td>
	</c:forEach>
	<br><br><br>
	${list2[0] }
	<br>
	${list[0].moneybook_amount }
	${list.size()-1}
	<br><br><br>
	
	<table border=1>
		<tr>
			<td>번호</td>
			<td>메모</td>
			<td>종류</td>
			<td>금액</td>
			<td>작성일</td>
			<td></td>
			<td></td>
		</tr>
		<c:choose>
		<c:when test="${not empty list }">
		
		<c:forEach var="i" begin="0" end="${list.size()-1}" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${list[i].moneybook_memo }</td>
				<td>${list[i].moneybook_type }</td>
				<td>${list[i].moneybook_amount }</td>
				<td>${list2[i] }</td>
				<td><button onclick="location.href='/moneybook/bookUpdate?moneybook_no=${mb.moneybook_no }'">수정</button></td>
				<td><button onclick="location.href='/moneybook/delete?moneybook_no=${mb.moneybook_no }'">삭제</button></td>
			</tr>
		</c:forEach>	
		
		</c:when>
		<c:otherwise>
		<tr>
			<td colspan=7>등록된 데이터가 없습니다.</td>
		</tr>
		</c:otherwise>
		</c:choose>
	</table>
	
	<form action="bookInsert" method="get">
	<button onclick="submit">가게부 작성</button> <br><br>
	</form>
	
	<form id="searchForm" method="get" action="myBook">
	<input type="hidden" name="searchType" id="type">
	<select id="searchType">
		<option value="total">전체</option>
		<option value="in">수입</option>
		<option value="out">지출</option>
	</select>
	<input type="text" id = "searchText" name="searchText" placeholder="검색어 입력">
	<input type="button" onclick="searchForm()" value="검색">	<br><br>
	</form>
	
	<input type="button" id = "in" onclick = "inCheck();" value = "총 수입 구하기">
	<input type="button" id = "out" onclick = "outCheck();" value = "총 지출 구하기">
	<input type="text" id = "inout" placeholder="총 수입 또는 지출"> <br><br>
	
	<input type="button" id = "min" onclick = "minCheck();" value = "최소 금액 구하기">
	<input type="button" id = "max" onclick = "maxCheck();" value = "최대 금액 구하기">
	<input type="text" id = "minmax" placeholder="최소 또는 최대 금액">
	
</body>
</html>