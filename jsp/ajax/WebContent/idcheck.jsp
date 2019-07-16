<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String uId = request.getParameter("uId");
//	out.print(uId);
	if(!uId.equals("admin")){
		out.print("Y");
	} else {
		out.print("N");
	}
%>













