<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h3>
	
	
	
	
	
		<c:set var="price" value="100000"  />
		<c:set var="pi" value="0.141592"  />
		
		<fmt:formatNumber value="${price}" type="number" var="numberType" groupingUsed="true" />
		
		현재 숫자 : ${numberType} <br>
		통화 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="\\"/><br>
		% 표현 : <fmt:formatNumber value="${price}" type="percent" groupingUsed="false" /> / 
		       <fmt:formatNumber value="${pi}" type="percent" groupingUsed="false" /><br>
		패턴표현 : <fmt:formatNumber value="${price}" pattern="00,000,000.00"/> /
		         <fmt:formatNumber value="${pi}" pattern="00,000,000.00"/> / 
		         
	
	
	
	
	
	
	
	
	
	</h3>












</body>
</html>