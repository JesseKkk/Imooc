<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>新建数据信息</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/add.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/dept/list.do">
                        数据信息
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${sessionScope.existUser.username }!</h1>
                <p>请小心地新增数据信息，要是建了一个错误的就不好了。。。</p>
            </div>
            <div class="page-header">
                <h3><small>新建</small></h3>
            </div>
            <p style="color:red;text-align:center">${msg }</p>
            <form class="form-horizontal"  enctype="multipart/form-data"  action="${pageContext.request.contextPath }/DataServlet?method=addData" method="post">

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">数据编号 ：</label>
                    <div class="col-sm-8">
                        <input name="dataId" class="form-control" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">数据名称 ：</label>
                    <div class="col-sm-8">
                        <input name="dataName" class="form-control" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="categoryId" class="col-sm-2 control-label">分类 ：</label>
                    <select  name="categoryName" class="col-sm-2 form-control" style="width: auto;margin-left: 15px">
                       <c:forEach  items="${applicationScope.categoryList }" var="cate">
	                       <option value="${cate.categoryName }" selected="">${cate.categoryName }</option>
                       </c:forEach>              
                    </select>
                </div>

                 <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">日期：</label>
                    <div class="col-sm-8">
                        <input name="dataDate" class="form-control" >
                    </div>
                  </div>
                   
                  <div class="form-group" >
                    <label for="name" class="col-sm-2 control-label">数据图片 ：</label>
                    <input type="file"  name="dataPic" style="padding-left: 15px">
                  </div>

                  <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">备注 ：</label>
                    <div class="col-sm-8">
                        <input name="remarks" class="form-control" >
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
