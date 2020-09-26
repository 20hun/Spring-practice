<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function formCheck(){
		
		
	}
</script>

</head>
<body>
	<h1>[ 회원 가입 ]</h1>
	
	<form action="/member/join" method="post" onsubmit="return formCheck();">
	<table>
	<tr>
	<th>아이디</th>
	<td><input type="text" name="member_id"></td>
	</tr>
	<tr>
	<th>비밀번호</th>
	<td><input type="password" name="member_pw"></td>
	</tr>
	<tr>
	<th>비밀번호 확인</th>
	<td><input type="password"></td>
	</tr>
	<tr>
	<th>이름</th>
	<td><input type="text" name="member_nm"></td>
	</tr>
	<tr>
	<th>생년월일</th>
	<td><input type="text" placeholder="ex:19900316" name="member_birth"></td>
	</tr>
	</table>
	<input type="submit" value="전송">
	</form>
</body>
</html>