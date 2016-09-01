<%--
  Created by IntelliJ IDEA.
  User: hxpeng
  Date: 2016/8/26
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/top.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="icon" type="image/png" href="${_imagesUrl}/myweb.png">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/bootstrap/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/bootstrap/bootstrap-select.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/font-awesome.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/animate.min.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/bootstrap/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/adminIndex.css">
    <script data-main="${_adminJsUrl}/config" src="${_commonJsUrl}/require/require.js"></script>
    <title>MyBolg</title>
</head>
<body>
<div id="myWorld">
    <nav class="left-menu">
        <div class="sidebar-collapse animated fadeInLeft">
            <div class="nav-header">
                <div class="dropdown profile-element">
                    <span><img alt="image" class="img-circle" src="${_imagesUrl}/head.png"></span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="clear" style="display: block;overflow: hidden;">
                            <span class="block m-t-xs">
                                <strong class="font-bold">干锅加鲁鲁</strong>
                            </span>
                        </span>
                    </a>
                </div>
            </div>
            <ul class="nav metismenu" id="side-menu">
                <li class="active">
                    <a href="layouts.html"><i class="fa fa-book"></i> <span class="nav-label">Article</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="${_Weburl}/admin/article/articleList.html">笔记列表<span class="label label-warning pull-right">24</span></a></li>
                        <li class="active"><a data-a-href="${_Weburl}/admin/article/insertArticle.html" href="javascript:;">写笔记</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-pencil-square-o"></i> <span class="nav-label">Leave Message</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse" style="height: 0px;">
                        <li><a href="javascript:;">留言管理<span class="label label-warning pull-right">10</span></a></li>
                    </ul>
                </li>
                <li>
                    <a href="mailbox.html"><i class="fa fa-bar-chart"></i> <span
                            class="nav-label">Statistics</span><span class="fa arrow"></span></a>
                    <!--<a href="mailbox.html"><i class="fa fa-envelope"></i> <span class="nav-label">统计报表</span><span class="label label-warning pull-right">16/24</span></a>-->
                    <ul class="nav nav-second-level collapse">
                        <li><a href="javascript:;">点赞统计</a></li>
                        <li><a href="javascript:;">留言统计</a></li>
                        <li><a href="javascript:;">访问统计</a></li>
                    </ul>
                </li>
                <li>
                    <a href="metrics.html"><i class="fa fa-cog"></i> <span class="nav-label">System</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="javascript:;">菜单管理</a></li>
                        <li><a href="javascript:;">标签管理</a></li>
                        <li><a href="javascript:;">权限管理</a></li>
                        <li><a href="javascript:;">操作日志</a></li>
                        <li><a href="javascript:;">用户管理</a></li>
                        <li><a href="javascript:;">其他</a></li>
                    </ul>
                </li>
            </ul>

        </div>
    </nav>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top animated fadeInDown" style="margin-bottom: 0;">
                <div class="navbar-header">
                    <!--<a class="btn btn-primary minimalize-styl-2" href="#"><i class="fa fa-bars"></i> </a>-->
                    <span class="m-r-sm text-muted system-version">HXPENG Admin Version1.0</span>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <!--<span class="m-r-sm text-muted welcome-message">Welcome to INSPINIA+ Admin Theme.</span>-->
                    </li>
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="true">
                            <!--<a class="dropdown-toggle count-info" aria-expanded="true" href="#">-->
                            <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts animated fadeInUp m-t-xs">
                            <li>
                                <a href="mailbox.html">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="profile.html">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                        <span class="pull-right text-muted small">12 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="grid_options.html">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html">
                                        <strong>See All Alerts</strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> Log out
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="breadcrumb-box">
            <ol class="breadcrumb">
                <li><a href="javascript:;">Home</a></li>
                <li><a HREF="javascript:;">笔记列表</a></li>
                <!--<li class="active"><strong>Flot Charts</strong></li>-->
            </ol>
        </div>
        <div id="content" class="content-container">
            <form action="${_Weburl}/admin/article/saveArticle" method="post" id="articleForm">
                <input type="hidden" name="articleId" value="${articleId}"/>
                <div>
                    <div class="row">
                        <div class="col-lg-3">
                            <div id="left-box" class="animated fadeInUp">
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <div class="right-main-box animated fadeInRight"></div>
                        </div>
                    </div>
                </div>
            </form>
            <script>
                var ctx = '${_Weburl}';
                require(["insertArticle"],function(common){
                    console.log("。。。。。。");
                });
            </script>
        </div>
    </div>
</div>
</body>
</html>

