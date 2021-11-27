<%@page import="java.util.List"%>
<%@page import="model.BO.CheckLoginBO"%>
<%@page import="model.Bean.urlFile"%>
<%@page import="org.apache.commons.codec.binary.Hex"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/account1.css">
    <title>Document</title>
</head>
<body>
<%

ArrayList<urlFile> l = (ArrayList<urlFile>)request.getSession().getAttribute("url123");
	
	if(l.size() == 0)
	{
%>
	<p align="center">Danh sách hiện tại không có file nào</p>
<%		
	}
	for(int i = 0 ; i< l.size();i++){
		
		
%>
<div class="hinh1" >
          <div>
          <form action="pdf" method="post">
         <div class="ten">
         <% if(l.get(i).getStatus()==0 )
         {%>
           <p><%=l.get(i).getUrl()%> ...Processing.... </p>
         <%}else{
        	 int k = l.get(i).getUrl().split("_")[0].length();
      	    byte[] data = new byte[k / 2];
      	    for (int j = 0; j < k; j += 2) {
      	        data[j / 2] = (byte) ((Character.digit(l.get(i).getUrl().split("_")[0].charAt(j), 16) << 4)
      	                + Character.digit(l.get(i).getUrl().split("_")[0].charAt(j + 1), 16));
      	    }
      	   String newUrl = new String(data, StandardCharsets.UTF_8) + "_Converted.pdf";
         %>
         <input class="dangxuata" name ="ip123" value="<%=l.get(i).getUrl()%>" hidden>
         <input type="submit" class="dangxuata" name ="ip1234" value="<%=newUrl%>">
        <%} %>
        </div>
			 </form>
            </div>
            
      
			
    </div>
      <%} %>    
</body>
</html>
<%-- 
int k = l.get(i).getUrl().length();
	    byte[] data = new byte[k / 2];
	    for (int j = 0; j < k; j += 2) {
	        data[j / 2] = (byte) ((Character.digit(l.get(i).getUrl().charAt(j), 16) << 4)
	                + Character.digit(l.get(i).getUrl().charAt(j + 1), 16));
	    }
		String newUrl = new String(data, StandardCharsets.UTF_8);
--%>