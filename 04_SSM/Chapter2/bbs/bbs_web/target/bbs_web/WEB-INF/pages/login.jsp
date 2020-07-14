<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
                    <li ><a href="index.html"><i class="fa fa-home"></i> <span class="hidden-xs hidden-sm">首页</span></a></li>
                    <li class="hidden-sm hidden-xs"><a href="thread.html"><i class="fa fa-comments-o"></i> 话题</a></li>

                </ul>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="nav-search hidden-xs hidden-sm">
                    <form method="GET" action="/bbs/preLogin.do" accept-charset="UTF-8" class="navbar-form form-search active" target="_blank">
                        <div class="form-group">
                            <input placeholder="搜索" class="form-control" name="q" type="search">
                        </div>
                        <i class="fa fa-search"></i>
                    </form>
                </li>
                <li ><a href="/front/to_register" id="signup-btn">注册</a></li>
                <li class="active"><a href="/front/to_userLogin" id="login-btn">登录</a></li>
            </ul>
        </div>
    </nav>
</div>    <div id="main" class="main-container container">


    <div class="container-fluid">
        <div class="row">
            <div class="col-md-5 col-md-offset-2">
                <div class="panel panel-default">
                    <div class="panel-heading">登录</div>
                    <div class="panel-body">
                        <form role="form" method="POST" action="/front/login">

                            <div class="form-group">
                                <input type="login" class="form-control" name="username" value="" placeholder="用户名">
                            </div>

                            <div class="form-group">
                                <input type="password" class="form-control" name="password" placeholder="密码">
                            </div>
                            <div class="form-group">
                                <input type="submit" name="commit" value="登录" class="btn btn-primary btn-lg btn-block">
                            </div>
                        </form>
                    </div>
                    <div class="panel-footer">
                        <a href="/front/to_register">注册</a>

                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<footer class="footer">
    <div class="container">
        <div class="copyright">
            <blockquote class="pull-left">
                <p>慕课论坛</p>
                <p>Copyright &copy; 2015-2016 <a href="index.html">imooc</a>  1.0.0-rc2 <span class="pipe">|</span><span class="pipe">|</span></p>
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
                <a href="index.html" target="_blank"><img src="/images/imooc-logo.png" border="0" height="40" data-toggle="tooltip" data-placement="top" title="Powered by imooc" /></a>
            </p>
        </div>
    </div>
</footer>
</body>
</html>


