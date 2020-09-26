<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		/*document.getElementById("div1").onclick = function(){
			alert("world!");
		} */
		
		$("#div1").on("click", function(){
			alert("world!");
		});

		//this = 이 함수 실행시키는 주최, 여기서는 div
		$("#div1").on("mouseenter", function(){
			$(this).html("world!");
			$(this).css("color","white");
			$(this).css("background-color","black");
			/* $(this).css({
				color: "white",
				backgroundColor: "black"
			}); */
		});

		$("#div1").on("mouseleave", function(){
			$(this).html("hello,");
			$(this).css({
				color: "black",
				backgroundColor: "white"
			});
		});

		$("input[type=text]").on("keydown", function(e){
			//console.log(e);
			/* if(e.keyCode == 13){
				//로그인 진행
			} */
		});
		$("input[type=text]").on("keyup", function(e){
			var txt = $(this).val();
			$("#div2").html(txt);		
		});

		$("input[type=radio]").on("change", function(){
			var val = $(this).val();
			$("#div2").html(val);
		});
	});
</script>
</head>
<body>
	<div id="div1">hello,</div>
	
	<input type="text">
	<div id="div2"></div>
	
	<input type="radio" name="r" value="first">
	<input type="radio" name="r" value="seconde">
	<input type="radio" name="r" value="third">
	
</body>
</html>