<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	span {color: red};
</style>
<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn1").on("click", function(){
			console.log("a");
		});
		$("#btn1").click(function(){
			console.log("b");
			//$(this).off(); 이벤트 다 삭제 > a, b 한번만 출력 / off 없으면 ab 계속 출력
			//$(this).off("click"); click이벤트만 삭제
			$(this).off("mouseenter");
		});
		$("#btn1").mouseenter(function(){
			$(this).css({
				color: "white",
				backgroundColor: "black"
			});
		});
		$("#like").click(function(){
			var cnt = Number($("#cnt").text()); //자료형은 숫자처럼 보이지만 문자라 강제 형변환
			cnt += 1;
			$("#cnt").text(cnt); //기존 내용을 cnt로 덮어씌어라				
		});

		$("span").click(function(){
			$("#like").trigger("click"); //trigger = like에 있는 이벤트 실행하겠다
		}); //위에 있는 익명함수 만들고 이제 trigger만 사용하면 간단 or 밑에 raiseCnt함수 사용
	});

	function raiseCnt(){
		var cnt = Number($("#cnt").text()); //자료형은 숫자처럼 보이지만 문자라 강제 형변환
		cnt += 1;
		$("#cnt").text(cnt);
	} //따로 함수 만들어서 이놈을 재활용하거나
</script>
</head>
<body>
	<button id="btn1">Click!</button>
	<br>
	<br>
	<span>♥</span>
	<span id="cnt">0</span>
	<button id="like">좋아요!</button>
</body>
</html>