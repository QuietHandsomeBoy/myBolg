<%--
  Created by IntelliJ IDEA.
  User: hxpeng
  Date: 2016/7/14
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="icon" type="image/png" href="${_adminImagesUrl}/myweb.png">
    <link type="text/css" rel="stylesheet" href="${_adminCssUrl}/bootstrap/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${_adminCssUrl}/bootstrap/bootstrap-select.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/font-awesome.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/animate.min.css">
    <link type="text/css" rel="stylesheet" href="${_adminCssUrl}/bootstrap/bootstrap-datetimepicker.min.css">
    <link type="text/css" rel="stylesheet" href="${_adminCssUrl}/index.css">
    <script src="${_jsUrl}/jquery-1.11.3.js"></script>
    <script src="${_adminJsUrl}/plugins.js"></script>
    <script src="${_adminJsUrl}/bootstrap/bootstrap.js"></script>
    <script src="${_adminJsUrl}/highcharts.js"></script>
    <script src="${_adminJsUrl}/bootstrap/bootstrap-datetimepicker.min.js"></script>
    <script src="${_adminJsUrl}/jquery.twbsPagination.js"></script>
    <script src="${_adminJsUrl}/index.js"></script>
    <script src="${_adminJsUrl}/wysiwyg/wysiwyg-editor.js"></script>
    <script src="${_adminJsUrl}/wysiwyg/wysiwyg.js"></script>
    <title>MyBolg</title>
</head>
<body>
<div id="myWorld">
    <nav class="left-menu">
        <div class="sidebar-collapse animated fadeInLeft">
            <div class="nav-header">
                <div class="dropdown profile-element">
                    <span><img alt="image" class="img-circle" src="${_adminImagesUrl}/head.png"></span>
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
                    <a href="layouts.html"><i class="fa fa-book"></i> <span class="nav-label">Article</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse" style="height: 0px;">
                        <li><a href="articleList.html">笔记列表<span class="label label-warning pull-right">24</span></a></li>
                        <li><a href="javascript:;">写笔记</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-comments"></i> <span class="nav-label">Comments</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse" style="height: 0px;">
                        <li><a href="javascript:;">评论管理<span class="label label-warning pull-right">30</span></a></li>
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
                        <li><a href="javascript:;">评论统计</a></li>
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
            <div>
                <div class="row">
                    <div class="col-lg-3">
                        <div id="left-box" class="animated fadeInUp">
                            <div class="left-box-content">
                                <div class="file-manager">
                                    <div class="left-box-tab-header">
                                        <ul id="navigation">
                                            <li><a class="active" href="javascript:;">全部<span class="label label-info pull-right">34</span></a></li>
                                            <li><a href="javascript:;">笔记<span class="label label-info pull-right">18</span></a></li>
                                            <li><a href="javascript:;">日记<span class="label label-info pull-right">11</span></a></li>
                                            <li><a href="javascript:;">其他<span class="label label-info pull-right">5</span></a></li>
                                            <li><a href="javascript:;">草稿<span class="label label-info pull-right">5</span></a></li>
                                        </ul>
                                    </div>
                                    <h5>Title Like</h5>
                                    <div class="form-group">
                                        <input type='text' class="form-control search-title-input"/>
                                    </div>
                                    <h5>Time Frame</h5>
                                    <div class="form-group">
                                        <span>startDate：</span>
                                        <div class='input-group date'>
                                            <input type='text' class="form-control" readonly/>
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                        <span>endDate：</span>
                                        <div class='input-group date'>
                                            <input type='text' class="form-control" readonly/>
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                    <!--<h5>Categories</h5>-->
                                    <!--<ul class="category-list">-->
                                    <!--<li><label class=""><input type="checkbox" class="i-checks">Work</label></li>-->
                                    <!--<li><label class=""><input type="checkbox" class="i-checks">Documents</label>-->
                                    <!--</li>-->
                                    <!--<li><label class=""><input type="checkbox" class="i-checks">Social</label></li>-->
                                    <!--<li><label class=""><input type="checkbox" class="i-checks">Advertising</label>-->
                                    <!--</li>-->
                                    <!--<li><label class=""><input type="checkbox" class="i-checks">Clients</label></li>-->
                                    <!--</ul>-->
                                    <h5>Others</h5>
                                    <div class="other-condition form-group">
                                        <label class="">
                                            <input type="checkbox" class="i-checks">原创
                                        </label>
                                        <label class="">
                                            <input type="checkbox" class="i-checks">转载
                                        </label>
                                        <label class="">
                                            <input type="checkbox" class="i-checks">公开
                                        </label>
                                        <label class="">
                                            <input type="checkbox" class="i-checks">置顶
                                        </label>
                                        <label class="">
                                            <input type="checkbox" class="i-checks">限制评论
                                        </label>
                                    </div>
                                    <div class="search-box">
                                        <a href="javascript:;" id="searchBtn">Search</a>
                                    </div>
                                    <div class="add-article-box">
                                        <a href="insert.html" id="addArticleBtn">ADD </a>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="list-main-box animated fadeInRight">
                            <div class="list-header-box">
                                <h2> 全部 (16) </h2>
                                <div class="list-pagination-box pull-right">
                                    <ul id="pagination-demo" class="pagination-sm"></ul>
                                    <!--<button class="btn btn-white btn-sm"><i class="fa fa-arrow-left"></i></button>-->
                                    <!--<button class="btn btn-white btn-sm active">1</button>-->
                                    <!--<button class="btn btn-white btn-sm">2</button>-->
                                    <!--<button class="btn btn-white btn-sm">3</button>-->
                                    <!--<button class="btn btn-white btn-sm"><i class="fa fa-arrow-right"></i></button>-->
                                </div>
                                <div class="header-tool-box">
                                    <button id="toggle-all" class="btn-white btn-sm"><input type="hidden" value="0"/><i class="fa fa-check-square-o"></i> Toggle All</button>
                                    <button id="refresh-all" class="btn-white btn-sm"><i class="fa fa-refresh"></i> Refresh</button>
                                    <button id="edit-one-article" class="btn-white btn-sm"><i class="fa fa-edit"></i> Edit</button>
                                    <button id="delete-some" class="btn-white btn-sm"><i class="fa fa-trash"></i> Delete</button>
                                    <button class="btn-white btn-sm"><i class="fa fa-level-up"></i> Top</button>
                                </div>
                            </div>
                            <div class="list-content-box">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>Article Title</th>
                                        <th>Article Type</th>
                                        <th><a href="javascript:;">Likes<i class="fa fa-chevron-down"></i></a></th>
                                        <th><a href="javascript:;">Reads<i class="fa fa-chevron-down"></i></a></th>
                                        <th><a href="javascript:;">Comments<i class="fa fa-chevron-down"></i></a></th>
                                        <th>Admin</th>
                                        <th><a href="javascript:;">Create Time<i class="fa fa-chevron-down"></i></a></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-biji">笔记</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-riji">日记</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="checkbox" class="i-checks">
                                        </td>
                                        <td><a href="javascript:;" class="article-title">There is something in the New York air that makes sleep useless</a></td>
                                        <td><label class="label label-qita">其他</label></td>
                                        <td>120</td>
                                        <td>310</td>
                                        <td>70</td>
                                        <td>干锅加鲁鲁</td>
                                        <td>2016-07-12</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                $(".form-group .date").datetimepicker({
                    autoclose: true,
                    todayBtn: true
                });
                $('table input[type=checkbox]').on('ifChecked', function(){
                    $("#edit-one-article").attr("disabled","disabled");
                });
                $('table input[type=checkbox]').on('ifUnchecked', function(){
                    $("#edit-one-article").removeAttr("disabled");
                });
                $("#toggle-all").click(function(){
                    if($(this).find("input[type=hidden]").val()=="0"){
                        $(".list-content-box table tr").each(function(i,z){
                            $(z).find("input[type=checkbox]").iCheck('check');
                        })
                        $(this).find("input[type=hidden]").val(1)
                    }else{
                        $(".list-content-box table tr").each(function(i,z){
                            $(z).find("input[type=checkbox]").iCheck('uncheck');
                        })
                        $(this).find("input[type=hidden]").val(0)
                    }
                })
                $('.category-list .i-checks').iCheck({
                    checkboxClass: 'icheckbox_flat-blue'
                });
                $('.other-condition .i-checks').iCheck({
                    checkboxClass: 'icheckbox_flat-orange'
                });
                $('.folder-list .i-checks').each(function(){
                    var self = $(this),
                            label = self.next(),
                            label_text = label.text();

                    label.remove();
                    self.iCheck({
                        checkboxClass: 'icheckbox_line-blue',
                        radioClass: 'icheckbox_line-blue',
                        insert: '<div class="icheck_line-icon"></div>' + label_text
                    });
                });
                $('.folder-list .i-checks').iCheck('check');

                $('.list-content-box .i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green'
                });
                $(function(){
                    $("#navigation li a").click(function(){
                        $("#navigation li a").each(function(){
                            $(this).removeClass("active");
                        })
                        $(this).addClass("active");
                    })

                    $('#pagination-demo').twbsPagination({
                        totalPages: 5,
                        visiblePages: 3,
                        onPageClick: function (event, page) {
                            $('#page-content').text('Page ' + page);
                        }
                    });
                })
            </script>
        </div>
    </div>
</div>
</body>
</html>
