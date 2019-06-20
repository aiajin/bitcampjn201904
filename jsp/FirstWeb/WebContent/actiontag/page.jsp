<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String pType = request.getParameter("type");
	String no = request.getParameter("no"); 
	
	if(pType == null){
		pType = "a";
	}
	
	
	if(pType.equals("a")){
%>
	<jsp:forward page="page_a.jsp"/>
<%
	} else if(pType.equals("b")) {
%>
	<jsp:forward page="page_b.jsp"/>
<%
	} else {
%>
	<jsp:forward page="page_c.jsp"/>
<%
	}
%>








