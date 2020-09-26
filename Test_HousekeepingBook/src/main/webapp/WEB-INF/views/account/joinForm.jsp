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
	var pw2 = document.getElementById('pw2').value;
	var nm = document.getElementById('nm').value;

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

	if(pw != pw2){
		alert("동일한 비밀번호를 입력해 주세요");
		return false;
	}

	if(nm == ''){
		alert("이름을 입력해 주세요");
		return false;
	}

	return true;
}
</script>
</head>
<body>

	<h1>[ 회원 가입 ]</h1>
	<form action="/account/join" onsubmit="return formCheck()" method="post">
	아이디		<input type="text" name="acc_id" id="id">	<br>
	비밀번호		<input type="password" name="acc_pw" id="pw">	<br>
	비밀번호 확인	<input type="password" id="pw2">	<br>
	이름			<input type="text" name="acc_nm" id="nm">	<br><br>
	<input type="submit" value="가입하기">
	</form>
		
</body>
</html>