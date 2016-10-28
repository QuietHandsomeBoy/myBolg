<%--
  Created by IntelliJ IDEA.
  User: hxpeng
  Date: 2016/5/26
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/top.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="icon" type="image/png" href="${_imagesUrl}/resizeApi.png">
    <link type="text/css" rel="stylesheet" href="${_cssUrl }/font-awesome.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl }/bootstrap/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl }/animate.min.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl }/home.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl }/common.css">
    <script data-main="${_outsideJsUrl}/config" src="${_commonJsUrl}/require/require.js"></script>
    <title>--------</title>
</head>
<body>
<div class="body">
    <header id="header" class="sticky">
        <div class="navbar megamenu-width">
            <div class="container">
                <div class="navbar-inner">
                    <a href="index.html" class="logo">
                        <img src="${_imagesUrl}/logo.png" alt="hxp">
                    </a>
                    <ul id="mobile-menu">
                        <li>
                            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse"
                                    data-target=".navbar-collapse">
                                <i class="fa fa-reorder"></i>
                            </button>
                        </li>
                    </ul>

                    <ul id="main-menu" class="navbar-collapse nav slide collapse">
                        <li><a href="javascript:;">首页</a></li>
                        <li><a href="javascript:;">标签</a></li>
                        <li><a href="javascript:;">关于</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </header>
    <div id="header-space" style="height: 85px;"></div>
    <div id="main-banner">
        <div class="banner-bg-img">
            <div class="img-carousel">
                <div style="background-image: url('${_imagesUrl}/bg-one.jpg'); opacity: 1;"></div>
                <div style="background-image: url('${_imagesUrl}/bg-two.jpg')"></div>
                <div style="background-image: url('${_imagesUrl}/bg-three.jpg')"></div>
            </div>
        </div>
        <div class="banner-mask"></div>
    </div>
    <div class="main" id="main-box">
        <div class="page-info animated fadeInUp">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb">
                            <li>首页</li>
                            <li>笔记</li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h2>${tbHxpArticle.articleTitle}</h2>
                    </div>
                </div>
            </div>
        </div>
        <div style="overflow:hidden;">
            <div id="main-content" class="container">
                <div class="row">
                    <div class="col-md-12">
                        <section>
                            <article class="detail-section animated fadeIn">
                                <div class="article-info">
                                    <div class="article-content">
                                        <%--<h2 class="article_title"><a href="javascript:;" rel="bookmark">${tbHxpArticle.articleTitle}</a></h2>--%>
                                        <div class="article_about">
                                            ${tbHxpArticleContent.articleContent}
                                        </div>
                                        <div class="article-meta">
                                            <span class="article_meta_tags"><i
                                                    class="fa fa-tags"></i>${tbHxpArticle.articleTagsStr}</span>
                                            <span><i class="fa fa-clock-o"></i><fmt:formatDate
                                                    value="${tbHxpArticle.createDate}" pattern="yyyy/MM/dd"/></span>
                                            <span><i class="fa fa-comments"></i>3</span>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </article>
                        </section>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div id="backTop_box">
            <div class="backTop">
                <img src="${_imagesUrl}/back-top.png">
                <button class="backTopBtn">&nbsp;</button>
            </div>
        </div>
        <script>
            var ctx = '${_Weburl}';
            require(["articleDetail"], function (common) {
                common.init();
            });
        </script>
    </div>
</div>
</body>
</html>