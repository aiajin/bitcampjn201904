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
<input type="button" id="deleteCookie" value="쿠키 삭제">
<hr>
<input type="button" id="viewCookie" value="쿠키값 확인">
<div id="view">

</div>


<script>

	$(document).ready(function(){
		
		//var name  = 'name';
		
		$('#deleteCookie').click(function(){
			var cName = $('#cName').val();
			deleteCookie(cName);
			alert('쿠키가 삭제되었습니다.')
		});
		
		
		$('#createCookie').click(function(){
			
			var cName = $('#cName').val();
			var cValue = $('#cValue').val();
			
			setCookie(cName, cValue, 1);
			alert("쿠키가 생성되었습니다.")
			
		});
		
		var setCookie = function(name, value, day) {
			var date = new Date();
			date.setTime(date.getTime() + day * 60 * 60 * 24 * 1000);
			document.cookie = name + '=' + value
			+ ';expires=' + date.toUTCString()
			+ ';path=/';
		};
		
		var deleteCookie = function(name) {
			var date = new Date();
			document.cookie = name + "= " + "; expires=" 
			+ date.toUTCString() + "; path=/";
		}
		
		
		
		$('#viewCookie').click(function(){
			
			var name = $('#cName').val();
			
			var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
			
			value = value?value[2]:null;
			
			alert(value);
			
			$('#view').html(name+'='+value);
		});
		
		
		
	});
	
	

</script>















</body>
</html>