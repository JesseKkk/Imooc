<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>脱毛数据管理系统</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    </head>

    <body>
       <header>
            <div class="container">
                    <nav>
                            <a href="${pageContext.request.contextPath }/admin/dataList.jsp">数据信息</a>
                    </nav>
                    <nav>
                            <a href="${pageContext.request.contextPath }/admin/categoryList.jsp" >数据分类</a>
                    </nav>
                   
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>脱毛数据管理系统</h1>
                    <p>数据分类</p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>分类编号</th>
                        <th>分类名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
						<c:forEach items="${applicationScope.categoryList }" var="cate"  varStatus="idx">
                            <tr>
                                <td>${idx.index + 1 }</td>
                                <td>${cate.categoryId }</td>
                                <td>${cate.categoryName }</td>
                                <td><a href="${pageContext.request.contextPath }/CategoryServlet?method=deleteCategory&categoryId=${cate.categoryId }">删除</a></td>
                                <!--在循环显示数据时，此处的ca0001可以用EL表达式进行替换-->
                            </tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="${pageContext.request.contextPath }/admin/addCategory.jsp"><button>新建</button></a>
                </div>
            </div>
        </section>
        <footer>
            ©2020 POWERED BY Jesse
        </footer>
    </body>
</html>