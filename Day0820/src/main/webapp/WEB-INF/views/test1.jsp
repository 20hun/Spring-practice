<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function first(){
		$.ajax({
			url: "/first",
			success: function(){
				alert("통신 성공!");
			} //url, success 약속된 키 값, 정확히 외우라
		});
	}

	function second(){
		var data = {
			msg: "안녕하세요?"
		}
		var settings = {
			url: "/second",
			//data: "안녕하세요?", null값 나옴, 전달 변수명에 맞게 값 넣어줘야함
			/* data: {
				msg: "안녕하세요?"
			}, */
			data: data,
			success: function(){
				alert("통신 성공!");
			}
		}
		$.ajax(settings);
	}

	function third() {
		$.ajax({
			url: "/third",
			success: function(data){
				alert("통신 성공!");
				alert("컨트롤러에서 받은 데이터: "+data);
			}
		});
	}

	function fourth(){
		$.ajax({
			url: "/fourth",
			type: "post", //기본값 get
			data: {
				msg: "안녕하세요!"
			},
			success: function(data){
				alert("통신 성공!");
				alert("컨트롤러에서 받은 데이터: "+ data);
			}
		});
	}
</script>
</head>
<body>
	<button onclick="first();">AJAX단순 통신하기</button>
	<button onclick="second();">컨트롤러로 문자열 보내기</button>
	<button onclick="third();">컨트롤러에서 문자열 받기</button>
	<button onclick="fourth();">컨트롤러에서 문자열 주고 받기</button>
</body>
</html>