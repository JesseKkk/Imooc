<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String a = (String)request.getAttribute("name");
		out.println("<h1  style='color:blue'>" + a + "<h1>");
	%>
</body>
</html>