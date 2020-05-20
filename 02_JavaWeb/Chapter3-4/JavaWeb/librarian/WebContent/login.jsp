<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">
        <script type="text/javascript">
        	function changeImg(){
        		var codeImg = document.getElementById("codeImg");
        		codeImg.src="${pageContext.request.contextPath }/kaptchaservlet?time=" + new Date().getTime();
        	}
        </script>
    </head>
    <body>
        <div class="login">
            <div class="header">
                <h1>
                    <a href="javascript:void(0)">登录</a>
                </h1>
                <button></button>
            </div>
            <p>${msg }</p>
            <form action="${pageContext.request.contextPath }/loginservlet" method="post">
                <div class="name">
                    <input type="text" id="name" name="username">
                    <p></p>
                </div>
                <div class="pwd">
                    <input type="password" id="pwd" name="password">
                    <p></p>
                </div>
                <div class="code">
                    <input type="text" id="code" name="verifyCode" style="width: 150px">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <img id="codeImg" src="${pageContext.request.contextPath }/kaptchaservlet" style="width: 150px;height: 42px;vertical-align: middle;cursor:pointer;" onclick="changeImg()">
                    <p></p>
                </div>
                <div class="btn-red">
                    <input type="submit" value="登录" id="login-btn">
                </div>
            </form>
        </div>
    </body>
</html>