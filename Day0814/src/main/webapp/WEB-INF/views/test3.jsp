<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배열 관리</title>
<style type="text/css">
	.cls{
		background-color: orange;
	}
	.cls2{
		font-size: 200%;
	}
</style>
<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	var arr = ["red","blue","green"];
	$(function(){
		//자바스크립트 기본 문법을 이용한 반복문
		for(var i = 0; i<arr.length; i++){
				console.log(i+","+arr[i]);
			}
		//jQuery 문법을 이용한 반복문
		$.each(arr, function(index, item){
			console.log(index+","+item);
		});

		// jQuery 문법을 이용한 반복문2
		$("div").each(function(i, data){
			//data는 div의 한줄 한줄 한줄
			$(data).css("color", arr[i]);
			//$(data).addClass("cls");
			//$(data).removeClass("cls2");
		
						//attr = 어트리뷰트 = 속성
		var attr = $(data).attr("class");
		console.log(attr);

		$(data).attr("class", "cls3"); //class 속성이 cls3으로 바뀜
		$(data).attr("data-blabla", "test"+i); //속성 부여
		});
	});
</script>
</head>
<body>
	<div class="cls cls2">첫 번째 줄</div>
	<div class="cls cls2">두 번째 줄</div>
	<div class="cls cls2">세 번째 줄</div>
</body>
</html>