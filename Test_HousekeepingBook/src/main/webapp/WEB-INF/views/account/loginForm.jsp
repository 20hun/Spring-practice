<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function formCheck(){

	var id = document.getElementById('id').value;
	var pw = document.getElementById('pw').value;

	if(id == ''){
		alert("아이디를 입력해 주세요");
		return false;
		}else if(3>id.length || id.length>8){
			alert("아이디는 3~8글자로 입력해 주세요");
			return false;
			}
	
	if(pw == ''){
		alert("비밀번호를 입력해 주세요");
		return false;
		}else if(5>pw.length || pw.length>10){
			alert("비밀번호는 5~10글자로 입력해 주세요");
			return false;
			}
	return true;
	}
</script>
</head>
<body>
	<h1>[ 로그인 ]</h1>
	
	<form action="login" onsubmit="return formCheck()" method="post">
		아이디	<input type="text" name="acc_id" id="id">	<br>
		비밀번호	<input type="password" name="acc_pw" id="pw">	<br><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>