<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String name = "";
	String sNum = ""; 
	String fileName = "";
	String saveFileName = "";
	long fileSize = 0;
	String uploadPath = "/upload";
	String dir = request.getSession().getServletContext().getRealPath(uploadPath);

	
	
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	
	// FileItem <- 폼 페이지에서 전송한 데이터들  , uName, sNumber, report
	List<FileItem> items= upload.parseRequest(request);
	
	Iterator<FileItem> itr = items.iterator();

	while(itr.hasNext()){
		
		FileItem item = itr.next();
		
		if(item.isFormField()){
			// type="file" 이 아닌경우
			
			if(item.getFieldName().equals("uName")){
				name = item.getString("utf-8");
			}
			
			if(item.getFieldName().equals("sNumber")){
				sNum = item.getString("utf-8");
			}
					
					
		} else {
			// type="file" 인 경우
			if(item.getFieldName().equals("report")){
				// 파일 이름
				fileName = item.getName();
				fileSize = item.getSize();
				//saveFileName = System.currentTimeMillis()+"_"+fileName;
				saveFileName = System.nanoTime()+"_"+fileName;
				item.write(new File(dir, saveFileName));
			}
		}
		
	}
	
	
	
	
	
	
	
	
%>
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

<h1>
	이름 : <%= name %> <br>
	학번 : <%= sNum %> <br>
	리포트 파일 : <%= fileName %> ( <%= fileSize %> ) <br>
	저장 파일 이름 : <%= saveFileName %> <br>
	저장 폴더 : <%= dir %>

</h1>



















</body>
</html>