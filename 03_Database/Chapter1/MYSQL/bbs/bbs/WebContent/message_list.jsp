<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>留言板</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css">
    </head>

    <body>
        <header>
            <div class="container">
                <% if (null != request.getSession().getAttribute("existUser")) {%>
                    <nav>
                        <a href="${pageContext.request.contextPath }/MyMessageServlet">我的留言</a>
                    </nav>
                    <nav>
                        <a href="${pageContext.request.contextPath }/UserServlet?method=display">我的信息</a>
                    </nav>
                <%} else { %>
                    <nav>
                        <a href="${pageContext.request.contextPath }/login.jsp">登录</a>
                        <a href="${pageContext.request.contextPath }/reg.jsp">注册</a>
                    </nav>
                <% } %>
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>慕课网留言板</h1>
                    <p>慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。 </p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                
                <c:forEach var="message" items="${pageBean.list }">
                    <div class="alt-item">
                        <div class="alt-head">
                            <div class="alt-info">
                                <span>作者：${message.user.username }</span>
                                <span>时间：${message.createTime }</span>
                            </div>
                        </div>
                        <div class="alt-content">
                            <h3>${message.title }</h3>
                            <p>${message.content }</p>
                        </div>
                    </div>
               		</c:forEach>
            </div>
        </section>
       <section class="page">
         <div class="container">
			  <div class="page-nav">
				<ul>
					<c:if test="${pageBean.page != 1 }">
						<li><a href="${pageContext.request.contextPath }/MessageServlet?page=1">首页</a></li>
						<li><a href="${pageContext.request.contextPath }/MessageServlet?page=${pageBean.page-1}">上一页</a></li>
					</c:if>
					<c:forEach var="i" begin="1" end="${pageBean.totalPage }">
					<c:if test="${pageBean.page == i }">
						<li><span class="first-page" style="color:black;">${ i }</span></li>			
					</c:if>
					<c:if test="${pageBean.page != i }">
						<li><a href="${pageContext.request.contextPath }/MessageServlet?page=${ i }">${ i }</li>			
					</c:if>
					</c:forEach>
				    <c:if test="${pageBean.page != pageBean.totalPage }">
						<li><a href="${pageContext.request.contextPath }/MessageServlet?page=${pageBean.page+1}">下一页</a></li>
						<li><a href="${pageContext.request.contextPath }/MessageServlet?page=${pageBean.totalPage }">尾页</a></li>
					</c:if>
				</ul>
			  </div>
		  </div>
        </section>
        <footer>
            copy@慕课网
        </footer>
    </body>
</html>