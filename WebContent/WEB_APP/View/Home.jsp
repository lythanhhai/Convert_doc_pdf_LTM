<%@ page import="java.nio.file.Paths" %>
<%@ page import="java.io.InputStream" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
<link rel="stylesheet" type="text/css" href="../CSS/formUpload.css"/>
</head>
<body>
	<%
	 	String data = "";
		Part filePart = (Part)request.getAttribute("filePart");
		String fileName = (String)request.getAttribute("fileName");
		InputStream fileContent = (InputStream)request.getAttribute("fileContent");
		data = fileName;
		if(data != "")
		{
	%>
			<div class="notification">
				<p></p>
			</div>	
	<%
		}
	%>
	<div class="wrapper">
	    <header>UPLOAD FILES</header>
	    <p class="wrapper__title">Upload documents you want to convert it into pdf</p>
	    <form class="wrapper__form" action="/BTL_LTM/checkUpload" method="post" enctype="multipart/form-data">
	      <input class="wrapper__form-file" type="file" name="files" accept=".doc, .docx" multiple hidden/>
	      <i class="fas fa-cloud-upload-alt"></i>
	      <p>Browse File to Upload</p>
	      <input class="wrapper__form-button" type="submit" hidden/>
	    </form>
	    <section class="progress-area"></section>
	    <section class="uploaded-area"></section>
	    <button class="wrapper__submit">Upload</button>
  	</div>
	<script src="../JS/formUpload.js"></script>
</body>
</html>

<%-- 

<form name="formUpload" action="checkUpload" method="post">
			<h2>UPLOAD FILES</h2>
			<p>Upload documents you want to share with your team</p>
			<div class="upload">
				<input type="file" value="" hidden/>
			</div>
			<div class="list">
			
			</div>
	</form>
	
<%
	 	String data = "";
		Part filePart = (Part)request.getAttribute("filePart");
		String fileName = (String)request.getAttribute("fileName");
		InputStream fileContent = (InputStream)request.getAttribute("fileContent");
		data = fileName;
		if(data == "")
		{
	%>
			<div class="notification">
				<p></p>
			</div>	
	<%
		}
	%>
--%>