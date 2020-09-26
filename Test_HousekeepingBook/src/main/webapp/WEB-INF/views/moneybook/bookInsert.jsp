<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>[ 가계부 입력 ]</h1>
	<form action="insert" onsubmit="return formCheck()" method="post">
	<input type="hidden" name="acc_id" value="${sessionScope.loginId }">
	메모 <input name="moneybook_memo" id="memo" type="text"><br>
	분류 <select name="moneybook_type">
		<option>수입</option>
		<option>지출</option>
		</select><br>
	금액 <input name="moneybook_amount" id="money" type="number"><br>
	<input type="submit" value="입력하기">
	</form>
</body>
</html>