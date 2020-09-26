<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
	// 아이디 입력란에 keyup 이벤트를 연결한다.
	$("input[type=text]").keyup(function(e) {
		// 아이디 입력란에 입력된 데이터를 변수에 저장한다.
		var data = $(this).val();

		// 입력된 데이터의 글자 수가 4글자 미만인지 검사한다.
		if (data.length < 4) {
			// 글자 수가 4글자 미만이면 빨간 글씨로 바꾸고 적절한 메시지를 입력한다.
			$("#idCheck").css("color", "red");
			$("#idCheck").text("아이디는 4자리 이상 입력하세요.");
		} else {
			// 글자 수가 4글자 이상이면 초록 글씨로 바꾸고 적절한 메시지를 입력한다.
			$("#idCheck").css("color", "green");
			$("#idCheck").text("사용할 수 있는 아이디입니다.");
		}

		// 만약 사용자가 아이디 입력란에서 엔터 키를 입력하면 유효성 검사를 실행한다.
		if (e.keyCode == 13) formCheck();
	});

	// 비밀번호 입력란에 keyup 이벤트를 연결한다.
	$("input[type=password]").keyup(function(e) {
		// 비밀번호 입력란에 입력된 데이터를 변수에 저장한다.
		var data = $(this).val();

		// 입력된 데이터의 글자 수가 4글자 미만인지 검사한다.
		if (data.length < 4) {
			// 글자 수가 4글자 미만이면 빨간 글씨로 바꾸고 적절한 메시지를 입력한다.
			$("#pwCheck").css("color", "red");
			$("#pwCheck").text("비밀번호는 4자리 이상 입력하세요.");
		} else {
			// 글자 수가 4글자 이상이면 초록 글씨로 바꾸고 적절한 메시지를 입력한다.
			$("#pwCheck").css("color", "green");
			$("#pwCheck").text("사용할 수 있는 비밀번호입니다.");
		}

		// 만약 사용자가 비밀번호 입력란에서 엔터 키를 입력하면 유효성 검사를 실행한다.
		if (e.keyCode == 13) formCheck();
	});

	// 가입하기 버튼에 click 이벤트를 연결한다.
	// 만약 사용자가 가입하기 버튼을 클릭하면 유효성 검사를 실행한다.
	$("input[type=button]").click(formCheck);
	//click(formCheck()) > formCheck의 리턴값
});

// 유효성 검사 함수
function formCheck() {
	// 사용자가 입력한 데이터들을 가져온다.
	var userid = $("input[type=text]").val();
	var userpw = $("input[type=password]").val();
	var gender = $("input[type=radio]:checked"); // 사용자가 선택한 항목을 배열 형태로 가져온다.
	var hobby = $("input[type=checkbox]:checked"); // 사용자가 선택한 항목을 배열 형태로 가져온다.

	// 데이터 전송(submit) 여부를 결정할 boolean 변수를 선언하고 우선 true로 초기화한다.
	var flag = true;

	// 아이디 유효성 검사
	if (userid.length < 4) {
		$("#idCheck").css("color", "red");
		$("#idCheck").text("아이디는 4자리 이상 입력하세요.");
		// 만약 아이디를 조건에 따라 제대로 입력하지 않았을 경우, 데이터 전송을 막기 위해 flag를 false로 초기화한다.
		flag = false;
	} else {
		$("#idCheck").css("color", "green");
		$("#idCheck").text("사용할 수 있는 아이디입니다.");
	}

	// 비밀번호 유효성 검사
	if (userpw.length < 4) {
		$("#pwCheck").css("color", "red");
		$("#pwCheck").text("비밀번호는 4자리 이상 입력하세요.");
		// 만약 비밀번호를 조건에 따라 제대로 입력하지 않았을 경우, 데이터 전송을 막기 위해 flag를 false로 초기화한다.
		flag = false;
	} else {
		$("#pwCheck").css("color", "green");
		$("#pwCheck").text("사용할 수 있는 비밀번호입니다.");
	}

	// 성별 유효성 검사
	if (gender.length < 1) {
		// 배열의 길이가 1보다 작을 경우(=아무런 값도 선택하지 않았을 경우), 실행할 문장
		$("#genderCheck").css("color", "red");
		$("#genderCheck").text("성별을 선택하세요.");
		flag = false;
	} else {
		$("#genderCheck").css("color", "green");
		$("#genderCheck").text("");
	}

	// 취미 유효성 검사
	if (hobby.length < 1) {
		// 배열의 길이가 1보다 작을 경우(=아무런 값도 선택하지 않았을 경우), 실행할 문장
		$("#hobbyCheck").css("color", "red");
		$("#hobbyCheck").text("취미를 한 개 이상 선택하세요.");
		flag = false;
	} else {
		$("#hobbyCheck").css("color", "green");
		$("#hobbyCheck").text("");
	}

	// 모든 데이터가 제대로 입력되었다면 flag는 true로써 데이터 전송을 진행한다.
	// 데이터가 하나라도 제대로 입력되지 않았다면 flag는 false로써 데이터 전송을 중지한다.
	if (flag) {$("form").submit();}
}
</script>
</head>
<body>
<h1>회원 가입</h1>
<form action="/join" method="get">
	<table>
		<tr>
			<td>아이디</td> 
			<td>
				<!-- 4자리 이상 입력할 것 -->
				<input type="text" name="userid">
			</td>
			<td>
				<!-- 아이디 유효성 검사 결과 메시지를 출력할 div -->
				<div id="idCheck"></div>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<!-- 4자리 이상 입력할 것 -->
				<input type="password" name="userpw">
			</td>
			<td>
				<!-- 비밀번호 유효성 검사 결과 메시지를 출력할 div -->
				<div id="pwCheck"></div>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<!-- 무조건 하나 선택할 것 -->
				<label>남자<input type="radio" name="gender" value="male"></label>&nbsp;
				<label>여자<input type="radio" name="gender" value="female"></label>
			</td>
			<td>
				<!-- 성별 유효성 검사 결과 메시지를 출력할 div -->
				<div id="genderCheck"></div>
			</td>
		</tr>
		<tr>
			<td>취미</td>
			<td>
				<!-- 무조건 하나 이상 선택할 것 -->
			독서<input type="checkbox" name="hobby" value="read">
					음악감상<input type="checkbox" name="hobby" value="music">
					게임<input type="checkbox" name="hobby" value="game">		
				</td>
				<!-- 취미 유효성 검사 결과 메시지를 출력할 div -->
				<td><div id="hobbyCheck"></div></td>
			</tr>
		</table>
		<input type="button" value="가입하기">
	</form>
</body>
</html>