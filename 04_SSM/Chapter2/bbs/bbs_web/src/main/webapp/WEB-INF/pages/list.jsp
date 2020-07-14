<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>慕课论坛</title>
    <link rel="stylesheet" href="/static/css/all-df86af5803.css">

</head>
<body class="forum" data-page="forum">
<div class="header">
    <nav class="navbar navbar-inverse navbar-fixed-top navbar-default">
        <div class="container">
            <div class="navbar-header" id="navbar-header">
                <a href="/front/list" class="navbar-brand"><img src="/images/logo.png">
                </a>
            </div>
            <div id="main-nav-menu">
                <ul class="nav navbar-nav">
                    <li class="active"><a href=""><i class="fa fa-home"></i> <span
                            class="hidden-xs hidden-sm">首页</span></a></li>
                    <li class="hidden-sm hidden-xs"><a href="thread.html"><i class="fa fa-comments-o"></i> 话题</a></li>

                </ul>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="nav-search hidden-xs hidden-sm">
                    <form method="GET" action="###" accept-charset="UTF-8"
                          class="navbar-form form-search active" target="_blank">
                        <div class="form-group">
                            <input placeholder="搜索" class="form-control" name="q" type="search">
                        </div>
                        <i class="fa fa-search"></i>
                    </form>
                </li>

                <!-- 登录成功要显示的内容 -->
                <c:if test="${sessionScope.user != null}">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="true">
                        ${sessionScope.user.username}  <!-- 此处显示用户名 -->

                        <span class="caret"></span></a>
                    <button class="navbar-toggle" type="button" data-toggle="dropdown" role="button" aria-expanded="true">
                        <span class="sr-only">Toggle</span>
                        <i class="fa fa-reorder"></i>
                    </button>
                    <ul class="dropdown-menu" role="menu"><li class=""><a href="my.html">我的主页</a></li>
                        <li><div class='divider'></div></li>
                        <li><a href="my.html">个人设置</a></li>

                        <li><a href="score.html">我的积分</a></li>
                        <li class='divider'></li>
                        <li><a href="###" onclick=" return confirm('你确定要退出吗?')"><i class="fa fa-sign-out"></i> 退出
                        </a></li>
                    </ul>
                </li>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                <!-- 未登录显示的内容 -->
                <li><a href="/front/to_register" id="signup-btn">注册</a></li>
                <li><a href="/front/to_userLogin" id="login-btn">登录</a></li>
                </c:if>

            </ul>
        </div>
    </nav>
</div>
<div id="main" class="main-container container">
    <!-- 首页通栏(4个推荐位) -->
    <div class="col-md-9 threads-index main-col">
        <div class="panel panel-default">

            <div class="panel-heading">
                <div class="pull-left hidden-sm hidden-xs">
                    <i class="fa fa-list"></i> 首页
                </div>
                <div class="clearfix"></div>
            </div>


            <div class="panel-body remove-padding-horizontal">
                <ul class="list-group row thread-list">

                    <!-- 显示帖子，每个li显示一个帖子的内容 -->
                    <c:forEach items="${postList}" var="post">
                    <li class="list-group-item media " style="margin-top: 0px;">
                        <div class="avatar pull-left">
                            <a href="post.html">
                                <img class="media-object img-thumbnail avatar-48" alt="imooc" src="/images/avatar.jpg"/>
                            </a>
                        </div>
                        <div class="infos">
                            <div class="media-heading">
                                <i class="fa fa-thumb-tack text-danger"></i>
                                <a href="/front/to_post?id=${post.id}">
                                    ${post.title}   <!-- 此处显示帖子标题 -->
                                </a>
                            </div>
                            <div class="media-body meta">
                                <span>${post.username}</span>
                                <span> • </span>
                                <span class="timeago " data-toggle="tooltip" data-placement="top"><sping:eval expression="post.createTime"/></span>
                            </div>
                        </div>
                    </li>
                    </c:forEach>


                </ul>
            </div>


        </div>
    </div>

    <div class="col-md-3 side-bar">
        <div class="panel panel-default corner-radius">
            <div class="panel-heading">
                <h3 class="panel-title">BBS</h3>
            </div>

            <!-- 登录后显示的内容 -->
            <c:if test="${sessionScope.user != null}">
                <c:if test="${sessionScope.user.userStatus == 0}">
                <div class="panel-body text-center">
                    <a href="/front/to_addPost" class="btn btn-primary">
                        <i class="fa fa-user"> </i> 发帖
                    </a>
                </div>
                </c:if>
                <c:if test="${sessionScope.user.userStatus == 1}">
                    <div class="panel-body text-center">
                        <span style="color: red;" >用户已被锁定，请联系管理员！</span>
                    </div>
                </c:if>
            </c:if>
            <!-- 未登录显示的内容 -->
            <c:if test="${sessionScope.user == null}">
            <div class="panel-body text-center">
                <a href="/front/to_register" class="btn btn-primary">
                    <i class="fa fa-user"> </i> 注册
                </a>
            </div>
            <div class="panel-footer text-center">
                已注册用户请 <a href="/front/to_userLogin">登录</a>
            </div>
            </c:if>

        </div>

        <div class="panel panel-default corner-radius">
            <div class="panel-heading">
                <h3 class="panel-title">热门标签</h3>
            </div>
            <div class="panel-body">
                <div class="badge badge-tag-cloud">
                    <a href="">Java</a> &nbsp;&nbsp; <a href="">Python</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default corner-radius">
            <div class="panel-heading">
                <h3 class="panel-title">小贴士</h3>
            </div>
            <div class="panel-body">
                猪有猪的思想，人有人的思想。如果猪有人的思想，那它就不是猪了——是八戒!
            </div>
        </div>

        <div class="panel panel-default corner-radius">
            <div class="panel-heading">
                <h3 class="panel-title">统计信息</h3>
            </div>
            <ul class="list-group">
                <li class="list-group-item">社区会员: 747</li>
                <li class="list-group-item">主题数: 95</li>
                <li class="list-group-item">回帖数: 218</li>
            </ul>
        </div>


    </div>
    <div class="clearfix"></div>

</div>

<footer class="footer">
    <div class="container">
        <div class="copyright">
            <blockquote class="pull-left">
                <p>慕课论坛</p>
                <p>Copyright &copy; 2015-2016 <a href="index.html">imooc</a> 1.0.0-rc2 <span class="pipe">|</span><span class="pipe">|</span></p>
            </blockquote>
        </div>
        <div class="pull-right hidden-sm hidden-xs">
            <p>
                <a href="###">关于我们</a>
                <span class="pipe">|</span>
                <a href="###">联系我们</a>
                <span class="pipe">|</span>
                <a href="###">常见问题解答</a>
            </p>
            <p>
                <a href="index.html" target="_blank"><img src="/images/imooc-logo.png" border="0" height="40"
                                                          data-toggle="tooltip" data-placement="top"
                                                          title="Powered by imooc"/></a>
            </p>
        </div>
    </div>
</footer>
</body>
</html>
