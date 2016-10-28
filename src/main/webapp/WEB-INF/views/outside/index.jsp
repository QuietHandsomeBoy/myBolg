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
                <div class="navbar-inner animated fadeIn">
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
                        <li><a href="${_Weburl}/article/articleDetail/2cd08f5f017946cdaf04a0aa5691403d.html">首页</a></li>
                        <li><a href="${_Weburl}/article/articleDetail/2cd08f5f017946cdaf04a0aa5691403d.html">标签</a></li>
                        <li><a href="${_Weburl}/article/articleDetail/2cd08f5f017946cdaf04a0aa5691403d.html">关于</a></li>
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
        <div class="page-info aniview" av-animation="fadeInDown">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb">
                            <li>首页</li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h2>Custom Header</h2>
                    </div>
                </div>
            </div>
        </div>
        <div style="overflow: hidden;">
            <div id="main-content" class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-12 col-xs-12">
                        <section>
                            <c:forEach items="${articleList}" var="article" varStatus="status">
                                <article av-animation="bounceInLeft" class="aniview index-article">
                                    <div class="article-info">
                                        <div class="article-content">
                                            <h2 class="article_title">
                                                <a class="article_link"
                                                   href="${_Weburl}/article/articleDetail/${article.articleId}.html"
                                                   rel="bookmark">${article.articleTitle}</a>
                                            </h2>
                                            <div class="article-meta">
                                                <span class="article_meta_tags"><i
                                                        class="fa fa-tags"></i>${article.articleTagsStr}</span>
                                                <span><i class="fa fa-clock-o"></i><fmt:formatDate
                                                        value="${article.createDate}" pattern="yyyy/MM/dd"/></span>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="article_about">
                                                <p>${article.articleIntroduced}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </article>
                            </c:forEach>
                        </section>
                    </div>
                    <div class="col-lg-4 col-md-4 hidden-sm hidden-xs">
                        <div id="sidebar" class="sidebar-box">
                            <div class="auth-container sidebar-child-box aniview" av-animation="bounceInRight">
                                <div class="auth-cover"></div>
                                <div class="auth-thumb">
                                    <img src="${_imagesUrl}/head-img.png" alt="thumbnail"
                                         class="carousel-inner img-responsive img-rounded">
                                </div>
                                <div class="auth-info">
                                    <h3 class="title">干锅加鲁鲁</h3>
                                    <blockquote>瘦过</blockquote>
                                    <p class="location"><i class="fa fa-map-marker"></i>China--GuangZhou</p>
                                </div>
                            </div>
                            <div class="search-form-box sidebar-child-box aniview" av-animation="bounceInRight">
                                <form role="search" method="post" class="search-form" action="">
                                    <label>
                                        <input autocomplete="off" type="search" class="search-field"
                                               placeholder="Search..." value="" name="s" title="Search for">
                                    </label>
                                    <input type="submit" class="search-submit fa fa-search" value="Search">
                                </form>
                            </div>
                            <div class="categories-box sidebar-child-box box-name-absolute aniview" av-animation="bounceInRight">
                                <div class="sidebar-box-name"><span>专栏</span></div>
                                <div class="categories-list">
                                    <ul id="menuui" class="menuui">
                                        <li>
                                            <div class="link">Tags<i class="fa fa-chevron-down"></i></div>
                                            <ul class="childMenu" style="display: none;">
                                                <li><a href="#">Photoshop</a></li>
                                                <li><a href="#">HTML</a></li>
                                                <li><a href="#">CSS</a></li>
                                                <li><a href="#">Maquetacion web</a></li>
                                                <li><a href="#">Photoshop</a></li>
                                                <li><a href="#">HTML</a></li>
                                                <li><a href="#">CSS</a></li>
                                                <li><a href="#">CSS</a></li>
                                                <li><a href="#">Maquetacion web</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <div class="link">Tags<i class="fa fa-chevron-down"></i></div>
                                            <ul class="childMenu" style="display: none;">
                                                <li><a href="#">Photoshop</a></li>
                                                <li><a href="#">HTML</a></li>
                                                <li><a href="#">CSS</a></li>
                                                <li><a href="#">CSS</a></li>
                                                <li><a href="#">Maquetacion web</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <div class="link">Tags<i class="fa fa-chevron-down"></i></div>
                                            <ul class="childMenu" style="display: none;">
                                                <li><a href="#">Photoshop</a></li>
                                                <li><a href="#">HTML</a></li>
                                                <li><a href="#">CSS</a></li>
                                                <li><a href="#">Maquetacion web</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <div class="link">Tags<i class="fa fa-chevron-down"></i></div>
                                            <ul class="childMenu" style="display: none;">
                                                <li><a href="#">Photoshop</a></li>
                                                <li><a href="#">HTML</a></li>
                                                <li><a href="#">CSS</a></li>
                                                <li><a href="#">Maquetacion web</a></li>
                                                <li><a href="#">Photoshop</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="sidebar-tag-box sidebar-child-box box-name-absolute aniview" av-animation="bounceInRight">
                                <div class="sidebar-box-name"><span>标签</span></div>
                                <div style="width: 100%; min-height: 200px;">
                                    <div class="widget tagcloud">
                                        <a href="/tags/AOP/" style="font-size: 10px;">AOP</a>
                                        <a href="/tags/Bamboo/"style="font-size: 10px;">Bamboo</a>
                                        <a href="/tags/Cache/" style="font-size: 11.67px;">Cache</a> <a
                                            href="/tags/Confluence/" style="font-size: 13.33px;">Confluence</a> <a
                                            href="/tags/Dubbo/" style="font-size: 10px;">Dubbo</a> <a
                                            href="/tags/EhCache/" style="font-size: 10px;">EhCache</a> <a
                                            href="/tags/Eureka/" style="font-size: 15px;">Eureka</a> <a
                                            href="/tags/Feign/" style="font-size: 10px;">Feign</a> <a
                                            href="/tags/Ghost/" style="font-size: 11.67px;">Ghost</a> <a
                                            href="/tags/Hystrix/" style="font-size: 10px;">Hystrix</a> <a
                                            href="/tags/JIRA/" style="font-size: 11.67px;">JIRA</a> <a href="/tags/JVM/"
                                                                                                       style="font-size: 10px;">JVM</a>
                                        <a href="/tags/Java/" style="font-size: 10px;">Java</a> <a
                                            href="/tags/JdbcTemplate/" style="font-size: 10px;">JdbcTemplate</a> <a
                                            href="/tags/Kafka/" style="font-size: 10px;">Kafka</a> <a
                                            href="/tags/MongoDB/" style="font-size: 13.33px;">MongoDB</a> <a
                                            href="/tags/Mongodb/" style="font-size: 10px;">Mongodb</a> <a
                                            href="/tags/MyBatis/" style="font-size: 11.67px;">MyBatis</a> <a
                                            href="/tags/Netflix/" style="font-size: 15px;">Netflix</a> <a
                                            href="/tags/Node-js/" style="font-size: 15px;">Node.js</a> <a
                                            href="/tags/OpenFire/" style="font-size: 11.67px;">OpenFire</a> <a
                                            href="/tags/RESTful-Api/" style="font-size: 10px;">RESTful Api</a> <a
                                            href="/tags/RabbitMQ/" style="font-size: 11.67px;">RabbitMQ</a> <a
                                            href="/tags/Redis/" style="font-size: 11.67px;">Redis</a> <a
                                            href="/tags/Ribbon/" style="font-size: 11.67px;">Ribbon</a> <a
                                            href="/tags/Spark/" style="font-size: 10px;">Spark</a> <a
                                            href="/tags/Spring-Boot/" style="font-size: 20px;">Spring Boot</a> <a
                                            href="/tags/Spring-Cloud/" style="font-size: 18.33px;">Spring Cloud</a> <a
                                            href="/tags/Spring-Cloud-Bus/" style="font-size: 11.67px;">Spring Cloud
                                        Bus</a> <a href="/tags/Spring-Cloud-Config/" style="font-size: 11.67px;">Spring
                                        Cloud Config</a> <a href="/tags/Spring-Security/" style="font-size: 10px;">Spring
                                        Security</a> <a href="/tags/Spring-Data-JPA/" style="font-size: 10px;">Spring-Data-JPA</a>
                                        <a href="/tags/Swagger/" style="font-size: 11.67px;">Swagger</a> <a
                                            href="/tags/Transactional/" style="font-size: 10px;">Transactional</a> <a
                                            href="/tags/Zuul/" style="font-size: 10px;">Zuul</a> <a
                                            href="/tags/fastjson/" style="font-size: 10px;">fastjson</a> <a
                                            href="/tags/log4j/" style="font-size: 11.67px;">log4j</a> <a
                                            href="/tags/mongodb/" style="font-size: 10px;">mongodb</a> <a
                                            href="/tags/redis/" style="font-size: 10px;">redis</a> <a href="/tags/事务/"
                                                                                                      style="font-size: 10px;">事务</a>
                                        <a href="/tags/云服务/" style="font-size: 10px;">云服务</a> <a href="/tags/前端/"
                                                                                                 style="font-size: 10px;">前端</a>
                                        <a href="/tags/定时任务/" style="font-size: 10px;">定时任务</a> <a href="/tags/异常处理/"
                                                                                                   style="font-size: 10px;">异常处理</a>
                                        <a href="/tags/异步调用/" style="font-size: 10px;">异步调用</a> <a href="/tags/微服务/"
                                                                                                   style="font-size: 13.33px;">微服务</a>
                                        <a href="/tags/持续交付/" style="font-size: 10px;">持续交付</a> <a href="/tags/敏捷管理/"
                                                                                                   style="font-size: 16.67px;">敏捷管理</a>
                                        <a href="/tags/日志/" style="font-size: 16.67px;">日志</a> <a href="/tags/源码分析/"
                                                                                                  style="font-size: 11.67px;">源码分析</a>
                                        <a href="/tags/爬虫/" style="font-size: 11.67px;">爬虫</a> <a href="/tags/邮件/"
                                                                                                  style="font-size: 10px;">邮件</a>
                                    </div>
                                </div>
                            </div>
                        </div>
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
            require(["index"], function (common) {
                common.init();
            });
        </script>
    </div>
</div>
</body>
</html>