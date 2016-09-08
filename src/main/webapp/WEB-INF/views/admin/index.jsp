<%--
  Created by IntelliJ IDEA.
  User: hxpeng
  Date: 2016/7/6
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/png" href="${_imagesUrl}/myweb.png">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/bootstrap/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/bootstrap/bootstrap-select.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/font-awesome.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/animate.min.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/bootstrap/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/adminIndex.css">
    <script data-main="${_adminJsUrl}/config" src="${_commonJsUrl}/require/require.js"></script>
    <title>--------</title>
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
                <li class="">
                    <a href="layouts.html"><i class="fa fa-book"></i> <span class="nav-label">Article</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse" style="height: 0px;">
                        <li><a href="${_Weburl}/admin/article/articleList.html">笔记列表<span class="label label-warning pull-right">${article_count_num}</span></a></li>
                        <li><a href="${_Weburl}/admin/article/insertArticle.html">写笔记</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-pencil-square-o"></i> <span class="nav-label">Leave Message</span><span class="fa arrow"></span></a>
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
                        <li><a href="${_Weburl}/admin/tags/tagsList.html">标签管理<span class="label label-warning pull-right">${article_tag_count_num}</span></a></li>
                        <li><a href="javascript:;">权限管理</a></li>
                        <li><a href="${_Weburl}/admin/logs/logsList.html">操作日志</a></li>
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
                <ul class="nav navbar-top-links navbar-right top-nav">
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
                                    <a href="notifications.html"><strong>See All Alerts</strong><i
                                            class="fa fa-angle-right"></i></a>
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
        <div style="display: none;"><a href="" id="vehicle-a"></a></div>
        <div id="content" class="content-container">
            <div class="breadcrumb-box">
                <ol class="breadcrumb">
                    <li><a href="javascript:;">Home</a></li>
                    <li><a HREF="javascript:;">&nbsp;</a></li>
                    <!--<li class="active"><strong>Flot Charts</strong></li>-->
                </ol>
            </div>
            <script>require(["index"],function(index){
                index.init();
            });</script>
            <div class="animated fadeInUp">
                <div class="welcome-message-box">
                    <!--<h2>晚上好&nbsp;,&nbsp;<span>干锅加鲁鲁</span></h2>-->
                    <span id="nowTime" class="now-time-box">2016-07-09 15:34:22</span>
                </div>
                <section class="view-container animate-fade-up">
                    <div class="content-char-info animated fadeInUp">
                        <div class="close-btn-box">
                            <label style="float: left;">数据统计</label>
                            <a title="关闭" href="javascript:closeCharBox();" class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                        <div class="home-box">
                            <div class="bar-chart-box">
                                <div id="bar-chart-container"></div>
                            </div>

                            <!--<div class="home-img-box">-->
                            <!--<img src="images/background5.jpg">-->
                            <!--</div>-->
                        </div>
                    </div>

                    <div class="top-info">
                        <div class="row">
                            <div class="text-center">
                                <div class="col-lg-3">
                                    <div class="panel mini-box">
                                    <span class="btn-icon btn-icon-round btn-icon-lg-alt bg-success bg-book">
                                        <span class="fa fa-book"></span>
                                    </span>
                                        <div class="box-info">
                                            <p class="size-h2"><strong>129</strong><span class="size-h4">篇</span></p>
                                            <p class="text-muted"><span class="ng-scope">笔记</span>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="panel mini-box">
                                    <span class="btn-icon btn-icon-round btn-icon-lg-alt bg-success bg-comments">
                                        <span class="fa fa-comments"></span>
                                    </span>
                                        <div class="box-info">
                                            <p class="size-h2"><strong>90</strong><span class="size-h4">条</span></p>
                                            <p class="text-muted"><span class="ng-scope">评论</span>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="panel mini-box">
                                    <span class="btn-icon btn-icon-round btn-icon-lg-alt bg-success bg-leaveMsg">
                                        <span class="fa fa-pencil-square-o"></span>
                                    </span>
                                        <div class="box-info">
                                            <p class="size-h2"><strong>120</strong><span class="size-h4">条</span></p>
                                            <p class="text-muted"><span class="ng-scope">留言</span>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="panel mini-box">
                                    <span class="btn-icon btn-icon-round btn-icon-lg-alt bg-success bg-watchCount">
                                        <span class="fa fa-space-shuttle"></span>
                                    </span>
                                        <div class="box-info">
                                            <p class="size-h2"><strong>4203</strong><span class="size-h4">次</span></p>
                                            <p class="text-muted"><span data-translate="GROWTH"
                                                                        class="ng-scope">路过</span>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
</html>
