<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
<script type="text/javascript">
	function formCheck(){
		var id = document.getElementById("id").value;
		var pw = document.getElementById("pw").value;
		var pwc = document.getElementById("pwc").value;
		var name = document.getElementById("name").value;
		var hobby = document.getElementsByName("hobby");
		
		if(id.length<4 || id.length>10){
			alert('id는 4~10');
			return false;
		}

		if(pw.length<4 || pw.length>10){
			alert('pw는 6~12');
			return false;
		}

		if(pwc != pw){
			alert('pw와 pwc 다름');
			return false;
		}

		if(name == ''){
			alert('이름 반드시 입력');
			return false;
		}

		var arr = [0,0,0,0,0];
		
		var cnt = 0;
		for(var i = 0; i<hobby.length; i++){
			if(hobby[i].checked == true){
				arr[i] = 1;
				cnt++;
			}
		}

		alert(arr);

		var arr2 = ["축구","농구","볼링","영화","독서"];

		for(var i = 0; i<arr2.length; i++){
			if(arr[i]==0){
				arr2[i] = "";
			}
		}

		alert(arr2);

		document.getElementById("hidden").value = arr2;
		
		if(cnt < 2){
			alert('취미 2개 이상 선택해 주세요');
			return false;
		}
			
		return true;
	}
</script>
</head>
<body>

	<form action="/member/join" onsubmit="return formCheck();" method="post">
	<input type="hidden" id="hidden" name="hidden">
	ID : <input type="text" id="id" name="id"> <br>
	PW : <input type="password" id="pw" name="pw"> <br>
	PW-Check : <input type="password" id="pwc"> <br>
	이름 : <input type="text" id="name" name="name"> <br>
	취미 <br>
	축구<input type="checkbox" id="c1" name="hobby" value="축구">
	농구<input type="checkbox" id="c2" name="hobby" value="농구">
	볼링<input type="checkbox" id="c3" name="hobby" value="볼링">
	영화<input type="checkbox" id="c4" name="hobby" value="영화">
	독서<input type="checkbox" id="c5" name="hobby" value="독서"> <br>
	성별 <br>
	남 : <input type="radio" name="gender" value="남자" checked="checked">
	여 : <input type="radio" name="gender" value="여자"> <br>
	자기소개 <br>
	<textarea name="info"></textarea> <br>
	<input type="submit" value="가입">
	</form>

</body>
</html>