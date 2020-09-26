<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function formCheck(){

	var memo = document.getElementById('memo').value;
	var money = document.getElementById('money').value;
	
	if(memo == ''){
		alert("메모를 입력해 주세요");
		return false;
		}
	
	if(money == ''){
		alert("금액을 입력해 주세요");
		return false;
		}
	}
</script>

</head>
<body>
	<h1>[ 가계부 수정 ]</h1>
	<form action="update" onsubmit="return formCheck()" method="post">
	<input type="hidden" name="acc_id" value="${sessionScope.loginId }">
	<input type="hidden" name="moneybook_no" value="${list.moneybook_no }">
	메모 <input name="moneybook_memo" id="memo" type="text" value="${list.moneybook_memo }"><br>
	분류 <select name="moneybook_type">
		<c:choose>
		<c:when test="${list.moneybook_type eq'지출'}">
			<option>수입</option>
			<option selected="selected">지출</option>
		</c:when>
		<c:otherwise>
			<option selected="selected">수입</option>
			<option>지출</option>
		</c:otherwise>
		</c:choose>
		</select><br>
	금액 <input name="moneybook_amount" id="money" type="number" value="${list.moneybook_amount }"><br>
	<input type="submit" value="수정하기">
	</form>
</body>
</html>