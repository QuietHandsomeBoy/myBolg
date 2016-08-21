<%--
  Created by IntelliJ IDEA.
  User: hxpeng
  Date: 2016/7/6
  Time: 21:14
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
            <form action="${_Weburl}/admin/article/saveArticle" method="post" id="articleForm">
                <input type="hidden" name="articleId" value="${articleId}"/>
                <div>
                    <div class="row">
                        <div class="col-lg-3">
                            <div id="left-box" class="animated fadeInUp">
                                <div class="left-box-content">
                                    <div class="file-manager">
                                        <h5>所属分类</h5>
                                        <div class="type-confition form-group">
                                            <select class="selectpicker" name="articleRange">
                                                <option value="">-请选择-</option>
                                                <c:forEach items="${articleRangeEnumMap}" var="articleRangeEnum">
                                                    <option value="${articleRangeEnum.key}">${articleRangeEnum.value}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <h5>关键字设置<label class="label label-gray">用&nbsp;|&nbsp;字符隔开&nbsp;;&nbsp;最多设置四个关键字</label></h5>
                                        <div class="key-words form-group">
                                            <div style="position: relative;">
                                                <div id="key-words-list">
                                                </div>
                                                <input type='text' name="keyWords" class="form-control key-words-input"/>
                                            </div>
                                        </div>
                                        <h5>标签设置<label class="label label-gray">最多可选择8个标签</label></h5>
                                        <div class="article-tags-box">
                                            <ul class="tags-list">
                                                <li><label class=""><input type="checkbox" value="work" name="articleTags" class="i-checks">Work</label></li>
                                                <li><label class=""><input type="checkbox" value="1" name="articleTags" class="i-checks">Documents</label></li>
                                                <li><label class=""><input type="checkbox" value="2" name="articleTags" class="i-checks">Social</label></li>
                                                <li><label class=""><input type="checkbox" value="3" name="articleTags" class="i-checks">Advertising</label></li>
                                                <li><label class=""><input type="checkbox" value="4" name="articleTags" class="i-checks">Clients</label></li>
                                                <li><label class=""><input type="checkbox" value="5" name="articleTags" class="i-checks">Work</label></li>
                                                <li><label class=""><input type="checkbox" value="6" name="articleTags" class="i-checks">Documents</label></li>
                                                <li><label class=""><input type="checkbox" value="7" name="articleTags" class="i-checks">Social</label></li>
                                                <li><label class=""><input type="checkbox" value="8" name="articleTags" class="i-checks">Advertising</label></li>
                                                <li><label class=""><input type="checkbox" value="9" name="articleTags" class="i-checks">Clients</label></li>
                                            </ul>
                                            <button type="button" id="choosArticleTagsBtn">添加标签</button>
                                        </div>
                                        <h5>关联文章<label class="label label-gray">最多可添加两个文章链接</label></h5>
                                        <div class="related-article-box">
                                            <div>
                                                <input type='text' name="aboutArticleUrl" class="form-control key-words-input" value="http://www.baidu.com"/>
                                                <button class="add-btn fa fa-plus" type="button" data-type="add"></button>s
                                            </div>
                                        </div>
                                        <h5>其他设置</h5>
                                        <div class="other-condition form-group">
                                            <label class=""><input type="checkbox" name="isPublic" class="i-checks" checked value="1">公开</label>
                                            <label class=""><input type="checkbox" name="onTop" class="i-checks" value="1">置顶</label>
                                            <label class=""><input type="checkbox" name="limitComments" class="i-checks" value="1">限制评论</label>
                                        </div>
                                        <div style="height: 80px;width: 100%;"></div>
                                        <div class="save-as-draft-box">
                                            <a href="javascript:;" id="save-as-draft">保存为草稿</a>
                                        </div>
                                        <div class="view-article-box">
                                            <a href="insert.html" id="view-article">预览</a>
                                        </div>
                                        <div class="save-article-box">
                                            <a href="javascript:;" id="save-article">保存</a>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <div class="right-main-box animated fadeInRight">
                                <div class="pagination-loading" style="display: none;"></div>
                                <div class="article-info-box">
                                    <h3> Compose A New Article </h3>
                                    <div class="article-title-box">
                                        <h5>choose the type of article and enter the title</h5>
                                        <div class="row">
                                            <div class="col-lg-2">
                                                <select class="selectpicker" name="articleRights">
                                                    <option value="">-请选择-</option>
                                                    <c:forEach items="${articleRightsEnumMap}" var="articleRightsEnum">
                                                        <option value="${articleRightsEnum.key}">${articleRightsEnum.value}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col-lg-10">
                                                <input placeholder="请输入标题.." type="text" class="" name="articleTitle" value="Openstack Manila源码阅读笔记(一)manilaclient调用过程">
                                            </div>
                                        </div>
                                        <h5>enter the introduce of article</h5>
                                        <div class="title-introduce-box">
                                            <textarea id="summary" name="articleIntroduced" style="">
                                                最近开始研究Openstack Manila的源码. 开发环境在之前的文章里已经提到过了. Openstack版本为Mitaka, IDE用的是Pycharm远程调试. 这篇文章主要是理解一下当我们在shell里输入了一个manila API指令之后, 后台到底发生了什么, 整个调用的过程是怎么样的, 真正干活的人是谁. 其实也就是Command-Line Interface.
                                            </textarea>
                                        </div>
                                    </div>
                                </div>
                                <div id="article-content-box" class="article-content-box">
                                    <div id="uploadFile_box" class="uploadFile_box">
                                        <div style="width:100%;padding: 10px;">
                                            <i id="removeImage" class="fa fa-close" style="display: none;"></i>
                                            <input type="file" style="display:none;" id="uploadImg" name="uploadImg" data-max_size="3145728"/>
                                            <div class="fileIcon" id="uploadimgbtn">
                                                <i class="fa fa-plus"></i>
                                            </div>
                                            <button id="confimbtn" class="confimbtn"> 确 认 </button>
                                        </div>
                                    </div>
                                    <textarea id="article-content" name="articleContent">在此输入正文...</textarea>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <script>
                var ctx = '${_Weburl}';
                require(["insertArticle"],function(common){
                    common.init();
                });
            </script>
        </div>
    </div>
</div>
<%--<div class="tips-div" id="choosArticleTags">--%>
    <%--<div class="operate-content">--%>
        <%--<h3>选择标签</h3>--%>
        <%--<div>--%>
            <%--<div class="choose-tags-input-box">--%>
                <%--<p>已选择标签：</p>--%>
                <%--<input/>--%>
            <%--</div>--%>
            <%--<div class="choose-tags-sources-box">--%>
                <%--<p>已选择标签：</p>--%>
                <%--<div>--%>
                    <%--<input placeholder="请输入标签名字"/>--%>
                    <%--<select class="selectpicker" name="tagType">--%>
                        <%--<option value="">-请选择-</option>--%>
                        <%--<option value=" ">技术标签</option>--%>
                        <%--<option value=" ">日记标签</option>--%>
                        <%--<option value=" ">文摘标签</option>--%>
                    <%--</select>--%>
                    <%--<button type="button">查询</button>--%>
                <%--</div>--%>
                <%--<div class="tags-sources-box"></div>--%>
            <%--</div>--%>
            <%--<button class="btn btn-default pull-right" id="closeTipsBox" onclick="closeTips('choosArticleTags')">Close me!</button>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<div class="tips-background-div"></div>--%>
</body>
</html>
