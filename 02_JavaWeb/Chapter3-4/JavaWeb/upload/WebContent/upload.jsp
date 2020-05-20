<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>文件上传</h1>
	<form action="${pageContext.request.contextPath }/uploadservlet" method="post"  enctype="multipart/form-data">
		<input type="text" name= "name"><br/>
		<input type="file" name= "upload"><br/>
		<input type="submit" value= "上传">
	</form>
</body>
</html>