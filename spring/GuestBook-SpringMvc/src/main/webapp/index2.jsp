<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
div {
	border: 2px solid #666;
	width: 200px;
}
</style>
</head>
<body>


	<script>
		$(document).ready(function() {

			$.ajax({
				url : 'guest/listJson',
				type : 'get',
				success : function(data) {
					// data : 자바스크립트 객체				
					alert(data.currentPageNumber);
					console.log(data);	
					alert(JSON.stringify(data));
					
				}

			});

		});
	</script>

</body>
</html>