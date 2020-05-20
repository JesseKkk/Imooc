<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.jesse.el.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student stu = (Student)request.getAttribute("student");
		String grade = (String)request.getAttribute("grade");
		out.println("<h1>姓名：" + stu.getName() + "</h1>");
		out.println("<h1>手机：" + stu.getMobile() + "</h1>");
		out.println("<h1>教师评级：" + grade + "</h1>");
		out.println("<h1>教师评级：" + grade + "</h1>");
	%>
</body>
</html>