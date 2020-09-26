<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원 가입 폼</title>
	
	<script type="text/javascript">

		function formCheck(){

				var id = document.getElementById('id').value;
				var pw = document.getElementById('pw').value;
				var p1 = document.getElementById('p1').value;
				var p2 = document.getElementById('p2').value;
				var p3 = document.getElementById('p3').value;
				document.getElementById("phone").value = p1+'-'+p2+'-'+p3;

				if(id == ''){
					alert("id 반드시 입력");
					return false;
					}else if(4>id.length || id.length>12){
						alert("id는 4~12글자");
						return false;
						}
				
				if(pw == ''){
					alert("pw 반드시 입력");
					return false;
					}else if(4>pw.length || pw.length>12){
						alert("pw는 4~12글자");
						return false;
						}

				if(p1 == ''){
					alert("번호 반드시 입력");
					return false;
					}
				for(var i = 0; i<p1.length; i++){
					var ch = p1.charAt(i);
					if(isNaN(ch)){
						alert("번호는 숫자로만 입력");
						return false;
						}
					}

				if(p2 == ''){
					alert("번호 반드시 입력");
					return false;
					}
				for(var i = 0; i<p2.length; i++){
					var ch = p2.charAt(i);
					if(isNaN(ch)){
						alert("번호는 숫자로만 입력");
						return false;
						}
					}

				if(p3 == ''){
					alert("번호 반드시 입력");
					return false;
					}
				for(var i = 0; i<p3.length; i++){
					var ch = p3.charAt(i);
					if(isNaN(ch)){
						alert("번호는 숫자로만 입력");
						return false;
						}
					}

				return true;
			}
	
	</script>
	
</head>
<body>
	<h1>[회원 가입 폼]</h1>
	<form action="/join" onsubmit="return formCheck()" method="post">
		<input type="hidden" id="phone" name="phone">
		<span>ID : </span><input type="text" id="id" name="id"><br>
		<span>PW : </span><input type="password" id="pw" name="pw"><br>
		<span>Phone </span><input type="text" id="p1"><span>-</span><input type="text" id="p2"><span>-</span><input type="text" id="p3"><br>
		<input type="submit" value="가입">
	</form>
</body>
</html>