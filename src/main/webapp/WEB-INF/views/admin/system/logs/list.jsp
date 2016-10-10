<%--
  Created by IntelliJ IDEA.
  User: hxpeng
  Date: 2016/8/31
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: hxpeng
  Date: 2016/7/14
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/top.jsp" %>
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
    <title>--------</title>
</head>
<body>
<div id="myWorld">
    <nav class="left-menu" id="left-menu">
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
                <li>
                    <a href="layouts.html"><i class="fa fa-book"></i> <span class="nav-label">Article</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse" style="height: 0px;">
                        <li><a href="${_Weburl}/admin/article/articleList.html">笔记列表
                            <span class="label label-warning pull-right">24</span></a></li>
                        <li><a href="${_Weburl}/admin/article/insertArticle.html" href="javascript:;">写笔记</a></li>
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
                <li class="active">
                    <a href="metrics.html"><i class="fa fa-cog"></i> <span class="nav-label">System</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="javascript:;">菜单管理</a></li>
                        <li><a href="${_Weburl}/admin/tags/tagsList.html">标签管理</a></li>
                        <li><a href="javascript:;">权限管理</a></li>
                        <li class="active"><a data-a-href="${_Weburl}/admin/logs/logsList.html" href="javascript:;">操作日志</a></li>
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
        <div style="display: none;"><a href="" id="vehicle-a"></a></div>
        <div id="content" class="content-container">
            <div class="breadcrumb-box">
                <ol class="breadcrumb">
                    <li><a href="javascript:;">Home</a></li>
                    <li><a HREF="javascript:;">System</a></li>
                    <li><a HREF="javascript:;">操作日志</a></li>
                </ol>
            </div>
            <div>
                <div class="row">
                    <div class="left-tags-box animated fadeIn">
                        <form id="searchLogsParam" method="post" action="${_Weburl}/admin/logs/logsList.html">
                            <div class="logs-condition">
                                <div class="group">
                                    <h5>操作人：</h5>
                                    <div class="form-group">
                                        <input type='text' class="form-control search-title-input"
                                               autocomplete="off"
                                               name="operationUserName"/>
                                    </div>
                                </div>
                                <div class="group">
                                    <h5>开始时间：</h5>
                                    <div class="input-group date">
                                        <input type='text' class="form-control"  name="createDateBegin"/>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                    </div>
                                </div>
                                <div class="group">
                                    <h5>结束时间：</h5>
                                    <div class="input-group date">
                                        <input type='text' class="form-control" name="createDateEnd"/>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                    </div>
                                </div>
                                <div class="group">
                                    <h5>&nbsp;</h5>
                                    <div class="search-box">
                                        <a href="javascript:;" id="searchBtn">Search</a>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </form>
                    </div>
                    <div class="right-tags-box animated fadeIn">
                        <input type="hidden" id="totalPages" value="${pagination.totalPages}">
                        <input type="hidden" id="totalRecords" value="${pagination.totalRecords}">
                        <input type="hidden" id="page" name="page" value="${pagination.currentPage}">
                        <input type="hidden" id="order" name="order" value="${order}">
                        <div class="pagination-loading" style="display: none;"></div>
                        <div class="list-header-box">
                            <h2 style="font-size: 16px;margin-bottom: 10px;">共查找出<span id="totalRecordsSpan">${pagination.totalRecords}</span>条记录</h2>
                            <div class="list-pagination-box pull-right">
                                <ul class="pagination" id="articlePagination">
                                    <li class="page">
                                        <button id="lastBtn" disabled="true">&laquo;</button>
                                    </li>
                                    <li class="active page">
                                        <button class="paginationNum">1</button>
                                    </li>
                                    <c:forEach begin="2" end="${pagination.totalPages}" var="page">
                                        <li class="page">
                                            <button class="paginationNum">${page}</button>
                                        </li>
                                    </c:forEach>
                                    <li class="page">
                                        <c:choose>
                                            <c:when test="${pagination.totalPages le 1}">
                                                <button id="nextBtn" disabled="true">&raquo;</button>
                                            </c:when>
                                            <c:otherwise>
                                                <button id="nextBtn">&raquo;</button>
                                            </c:otherwise>
                                        </c:choose>
                                    </li>
                                </ul>
                            </div>
                            <div class="header-tool-box">
                                <button id="refresh-all" class="btn-white btn-sm"><i class="fa fa-refresh"></i>Refresh</button>
                            </div>
                        </div>
                        <div class="list-content-box">
                            <table class="table table-hover log-table" style="table-layout: fixed;">
                                <thead>
                                <tr>
                                    <th>操作人</th>
                                    <th>操作方法</th>
                                    <th>操作描述</th>
                                    <th>IP地址</th>
                                    <th>操作时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${fn:length(logsList) le 0}">
                                    <td style="text-align: center;" colspan="8">暂无数据.......</td>
                                </c:if>
                                <c:forEach items="${logsList}" var="log">
                                    <tr>
                                        <td class="log-user-name">${log.operationUserName}</td>
                                        <td>${log.operationMethod}</td>
                                        <td>${log.operationContent}</td>
                                        <td>${log.operationIp}</td>
                                        <td><fmt:formatDate value="${log.operationDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="clearfix"></div>
                        <script>
                            var ctx = '${_Weburl}';
                            require(["logsList"], function (common) {
                                common.init();
                            });
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
