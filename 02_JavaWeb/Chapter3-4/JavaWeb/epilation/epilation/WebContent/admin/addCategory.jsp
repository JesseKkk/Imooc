<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>新建数据分类</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/add.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="">
                        数据分类
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${sessionScope.existUser.username }!</h1>
                <p>请小心地新增数据分类，要是建了一个错误的就不好了。。。</p>
            </div>
            <div class="page-header">
                <h3><small>新建</small></h3>
            </div>
            <p style="color:red;text-align:center">${msg }</p>
            <form class="form-horizontal" action="${pageContext.request.contextPath }/CategoryServlet" method="post">
            	<input type="hidden" name="method" value="addCategory">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">分类ID ：</label>
                    <div class="col-sm-8">
                        <input name="categoryId" class="form-control" id="categoryId">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">分类名称 ：</label>
                    <div class="col-sm-8">
                        <input name="categoryName" class="form-control" id="categoryName">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            ©2020 POWERED BY Jesse
        </footer>
    </body>
</html>
