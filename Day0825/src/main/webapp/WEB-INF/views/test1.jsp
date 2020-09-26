<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX 심화2</title>
<script type="text/javascript" src="/resources/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function sendFile(){
		var formData = new FormData(); //jquery에서 파일 전달할 때 사용하라고 제공하는
		var file = $("input:file")[0].files[0];
		formData.append("mfile",file);

		$.ajax({
			url: "/sendFile",
			type: "post",
			data: formData,
			contentType: false,
			processData: false,
			success: function() {alert("통신 성공!");},
			error: function(e) {alert("통신 실패...");console.log(e);}
		});
	}

	function sendFileList() {
		var formData = new FormData();
		var fileList = $("#multi")[0].files;
		for (var i = 0; i<fileList.length; i++) {
			console.log(fileList[i]);
			formData.append("fileList", fileList[i]); //requestparam 이름과 동일하게
		}

		// var formData = new FromData($("form")[0]); 이렇게 하면 한번에 다 담김

		$.ajax({
			url: "/sendFileList",
			type: "post",
			data: formData,
			contentType: false,
			processData: false,
			success: function() {alert("통신 성공!");},
			error: function(e) {alert("통신 실패...");console.log(e);}
		});
	}
</script>
</head>
<body>
	<form>
		<input type="file">
	</form>
	<button onclick="sendFile();">컨트롤러에 파일 보내기</button>
	<br>
	<form>
		<input type="file" id="multi" multiple="multiple">
	</form>
	<button onclick="sendFileList();">컨트롤러로 다중 파일 보내기</button>
</body>
</html>