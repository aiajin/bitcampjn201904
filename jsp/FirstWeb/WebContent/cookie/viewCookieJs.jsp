<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>

</style>
</head>
<body>

쿠키이름 <input type="text" id="cName">, 
쿠키 데이터 <input type="text" id="cValue">
<input type="button" id="createCookie" value="쿠키 생성">
<hr>
<input type="button" id="viewCookie" value="쿠키값 확인">
<div id="view">

</div>


<script>

	$(document).ready(function(){
		
		var name  = 'name';
		
		
		$('#createCookie').click(function(){
			
			var cName = $('#cName').val();
			var cValue = $('#cValue').val();
			
			setCookie(cName, cValue, 1);
			
		});
		
		var setCookie = function(name, value, day) {
			var date = new Date();
			date.setTime(date.getTime() + day * 60 * 60 * 24 * 1000);
			document.cookie = name + '=' + value
			+ ';expires=' + date.toUTCString()
			+ ';path=/';
		};
		
		
		
		
		
		$('#viewCookie').click(function(){
			
			name = $('#cName').val();
			
			var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
			
			value = value?value[2]:null;
			
			alert(value);
			
			$('#view').html('name='+value);
		});
		
		
		
	});
	
	

</script>















</body>
</html>