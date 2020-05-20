<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("amt", 1987654.326);
		request.setAttribute("now", new java.util.Date());
		request.setAttribute("html", "<a href='index.html'>index</a>");
		request.setAttribute("nothing", null);
	%>
	<h2>${now }</h2>
	<!-- formateDate pattern
	yyyy - 四位年
	MM  - 两位月
	dd   - 两位日
	HH  - 24小时制 
	hh    -  12小时制
	mm  - 分钟
	ss     - 秒数
	SSS  - 毫秒  
	 -->
	 <h2>
		<fmt:formatDate value="${requestScope.now }" pattern="yyyy年MM月dd日HH时mm分ss秒SSS毫秒"/>
	</h2>
	
	<h2>${amt }</h2>
	<h2>
		¥<fmt:formatNumber value = "${amt }" pattern = "0,000.00"></fmt:formatNumber>元
	</h2>
	<h2>null默认值：<c:out value="${nothing }" default="无"></c:out></h2>
	<h2><c:out value="${html }" escapeXml="true"></c:out></h2>
</body>
</html>