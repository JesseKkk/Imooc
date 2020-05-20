<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">

		<script type="text/javascript">
	    	function changeImg(){
	    		var codeImg = document.getElementById("codeImg");
	    		codeImg.src="${pageContext.request.contextPath }/KaptchaServlet?time=" + new Date().getTime();
	    	}
		</script>
		
	</head>
	<body>
		<div class="login">
			<div class="header">
	            <h1>
	                <a href="${pageContext.request.contextPath }/login.jsp">登录</a>
	                <a href="${pageContext.request.contextPath }/reg.jsp"">注册</a>
	            </h1>
				<button></button>
			</div>
			<p>${msg }</p>
			<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
				<div class="name">
					<input type="text"  name="username" placeholder="请输入登录用户名">
					<p></p>
				</div>
				<div class="pwd">
					<input type="password"  name="password" placeholder="6-16位密码，区分大小写，不能用空格">
					<p></p>
				</div>
                <div class="code">
                    <input type="text" id="code" name="verifyCode" style="width: 150px">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <img id="codeImg" src="${pageContext.request.contextPath }/KaptchaServlet" style="width: 150px;height: 42px;vertical-align: middle;cursor:pointer;" onclick="changeImg()">
                </div>
				<div class="btn-red">
					<input  type="submit" value="登录" id="login-btn">
				</div>
			</form>
		</div>
	</body>
</html>