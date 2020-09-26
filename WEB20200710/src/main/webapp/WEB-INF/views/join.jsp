<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>

	<script type="text/javascript">
		function formCheck(){
			var user_id = document.getElementById('user_id').value;
			var user_pw = document.getElementById('user_pw').value;
			var user_phone1 = document.getElementById('user_phone1').value;
			var user_phone2 = document.getElementById('user_phone2').value;
			var user_phone3 = document.getElementById('user_phone3').value;
			document.getElementById('phone').value = user_phone1+"-"+user_phone2+"-"+user_phone3;
			
			if(user_id ==''){
				alert('ID 반드시 입력해주세요');
				return false;
			}else if(4>user_id.length || user_id.length>12){
				alert('ID는 4~12글자로 해주세요')
				return false;
			}

			if(user_pw ==''){
				alert('PW 반드시 입력해주세요');
				return false;
			}else if(4>user_pw.length || user_pw.length>12){
				alert('PW는 4~12글자로 해주세요')
				return false;
			}
			
			if(user_phone1 == ''){
				alert('Phone 반드시 입력해주세요');
				return false;
			}
			
			for(var i = 0; i<user_phone1.length; i++){
				var ch = user_phone1.charAt(i);
				if(isNaN(ch)){
					alert('번호는 숫자로 입력해 주세요');
					return false;
				}
			}

			if(user_phone2 == ''){
				alert('Phone 반드시 입력해주세요');
				return false;
			}
			
			for(var i = 0; i<user_phone2.length; i++){
				var ch = user_phone2.charAt(i);
				if(isNaN(ch)){
					alert('번호는 숫자로 입력해 주세요');
					return false;
				}
			}

			if(user_phone3 == ''){
				alert('Phone 반드시 입력해주세요');
				return false;
			}
			
			for(var i = 0; i<user_phone3.length; i++){
				var ch = user_phone3.charAt(i);
				if(isNaN(ch)){
					alert('번호는 숫자로 입력해 주세요');
					return false;
				}
			}
			return true;
		}

	</script>

</head>
<body>
	<h1>[회원 가입 폼]</h1>
	
	<form action="/join2" onsubmit="return formCheck()" method="POST">
		<input type="hidden" id="phone" name="phone">
		<div>ID : <input type="text" id="user_id" name="id"></div>
		<div>PW : <input type="password" id="user_pw" name="pw"></div>
		<div>Phone : <input type="text" id="user_phone1" name="p1"><span>-</span><input type="text" id="user_phone2" name="p2"><span>-</span><input type="text" id="user_phone3" name="p3"></div>
		<div><input type="submit" value="가입"></div>
	</form>
	
</body>
</html>