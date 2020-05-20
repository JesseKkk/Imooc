<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>图书后台管理</title>
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
 		<script type="text/javascript"  src="js/jquery-3.4.1.js"></script>     
    </head>

    <body>
       <header>
            <div class="container">
                    <nav>
                            <a href="bookList.jsp" >图书信息管理</a>
                    </nav>
                    <nav>
                            <a href="categoryList.jsp" >分类管理</a>
                    </nav>
                   
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>图书管理系统</h1>
                    <p>图书信息管理</p>
                </div>
            </div>
        </section>
        <section class="main">


            <div class="container">

                <div class="form-group"  style="float: right;">
                    <div class="col-sm-offset-2 col-sm-10">
                    	<!-- 给查询按钮添加id属性，每点击一次按钮进行一次Ajax通信 -->
                        <button type="submit" id="querybtn" class="btn btn-primary">查询</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
                <div class="form-group" style="float: right;width: 300px;">
                    <div class="col-sm-8">
                        <input name="searchContent" class="form-control" id="searchContent"
                        placeholder="输入要查询的分类" style="width: 250px">
                    </div>
                </div>

            </div>
            <div class="container">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>图书编号</th>
                        <th>图书名称</th>
                        <th>分类</th>
                        <th>价格</th>
                        <th>图书封面</th>
                        <th>操作</th>

                    </tr>
                    </thead>
                    <tbody>
                    
                    	<!-- 用Ajax实现局部刷新，进行书籍信息展示 -->
                    	<script type="text/javascript">
                    		//给查询按钮绑定点击事件
                    		$("#querybtn").click(function(){
                    			//将搜索信息作为参数传递给/bookdata,当搜索信息默认为空时，显示所有信息
                     			var  searchContent = $("#searchContent").val();
                    			$.ajax({
                    				"url" : "/librarian/bookdata",
                    				"type" : "post",
                    				"data" :  {"searchContent" : searchContent},
                    				"dataType" : "json",
                    				"success" : function(json){
                    					//每次要先将tbody内容清空
                    					$("tbody").empty();
                    					for(var i = 0;  i < json.length; i++){
                    						var ch = json[i];             
                    						$("tbody").append("<tr id='tr1'>"
                    													+"<td>" + (i+1) + "</td>"
                    													+"<td>"+ch.bookId + "</td>"
                    													+"<td>"+ch.bookName + "</td>"
                    													+"<td>"+ch.categoryName + "</td>"
                    													+"<td>"+ch.bookPrice + "</td>"
                    													+"<td><img src='"+ch.bookPic+ "' style='width:160px;height:90px'></td>"
                    													+"<td>" + "<a href='/librarian/updatebooktransfer?bookId=" +ch.bookId+ "'>修改</a> "
                    													+ " <a href='/librarian/deletebook?bookId=" +ch.bookId+ "'>删除</a>" + "</td>"
                    													+"</tr>");
                    					}
                    				}
                    			})
                    		})
                    		//每次进入页面默认触发一次点击事件，进行请求数据
                    		$('#querybtn').trigger("click")
                    	</script>
                    	             	
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="addBook.jsp"><button>新建</button></a>
                </div>
            </div>
        </section>
        <footer>
            ©2020 POWERED BY Jesse
        </footer>
    </body>
</html>