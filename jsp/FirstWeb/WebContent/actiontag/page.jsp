<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String pType = request.getParameter("type");
	String no = request.getParameter("no"); 
	String uname = request.getParameter("uname");
	
	if(pType == null){
		pType = "a";
	}
	
	if(no == null){
		no = "0";
	}
	
	if(uname == null){
		uname = "noname";
	}
	
	
	if(pType.equals("a")){
%>
	<jsp:forward page="page_a.jsp">
		<jsp:param value="<%= no%>" name="num"/>
		<jsp:param value="<%= uname %>" name="username"/>
	</jsp:forward>
<%
	} else if(pType.equals("b")) {
%>
	<jsp:forward page="page_b.jsp">
		<jsp:param value="<%= no%>" name="num"/>
		<jsp:param value="<%= uname %>" name="username"/>
	
	</jsp:forward>
<%
	} else {
%>
	<jsp:forward page="page_c.jsp">
		<jsp:param value="<%= no%>" name="num"/>
		<jsp:param value="<%= uname %>" name="username"/>
	
	</jsp:forward>
<%
	}
%>








