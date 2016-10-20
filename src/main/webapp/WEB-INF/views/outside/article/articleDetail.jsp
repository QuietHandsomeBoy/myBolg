<%--
  Created by IntelliJ IDEA.
  User: hxpeng
  Date: 2016/6/24
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/top.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="icon" type="image/png" href="${_imagesUrl}/resizeApi.png">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/font-awesome.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/main.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl}/animate.min.css">
    <script data-main="${_outsideJsUrl}/config" src="${_commonJsUrl}/require/require.js"></script>
    <title>${tbHxpArticle.articleTitle}</title>
</head>
<body>
<div id="st-container" class="st-container">
    <div class="st-pusher">
        <nav class="st-menu st-effect-3" id="menu-3">
            <div style="padding: 25px 20px;">
                <img src="${_imagesUrl}/logo.png">
            </div>
            <ul>
                <li><a class="icon icon-data" href="#">Home</a></li>
                <li><a class="icon icon-location" href="#">Bolg</a></li>
                <li><a class="icon icon-study" href="#">Articles</a></li>
                <li><a class="icon icon-photo" href="#">Inspiration</a></li>
            </ul>
        </nav>
        <div class="st-content" id="st-content">
            <div id="container" class="container">
                <div id="st-trigger-effects" class="column">
                    <button id="mobileMenuBtn" data-effect="st-effect-3"><i class="fa fa-navicon"></i></button>
                </div>
                <div id="leftBox" class="leftBox">
                    <input type="hidden" value="0" id="oldContainerScrollTop"/>
                    <section>
                        <div id="content" class="content">
                            <article class="detail-section animated fadeIn">
                                <div class="article-info">
                                    <div class="article-content">
                                        <h2 class="article_title"><a href="javascript:;" rel="bookmark">${tbHxpArticle.articleTitle}</a></h2>
                                        <div class="article-meta">
                                            <span class="article_meta_tags"><i class="fa fa-tags"></i>${tbHxpArticle.articleTagsStr}</span>
                                            <span><i class="fa fa-clock-o"></i><fmt:formatDate value="${tbHxpArticle.createDate}" pattern="yyyy/MM/dd"/></span>
                                            <span><i class="fa fa-comments"></i>3</span>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="article_about">
                                            ${tbHxpArticleContent.articleContent}
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </article>
                        </div>

                        <div class="pagination_box"></div>
                    </section>
                    <script>
                        var ctx = '${_Weburl}';
                        require(["articleDetail"], function (common) {
                            common.init();
                        });
                    </script>
                </div>
                <div class="clear" style=""></div>
            </div>
        </div>
    </div>
    <div id="backTop_box">
        <div class="backTop">
            <svg id="rocket" version="1.1" xmlns="http://www.w3.org/2000/svg" width="34" height="34" class="toTopSvg"
                 viewbox="0 0 64 64">
                <path fill="#999" d="M42.057,37.732c0,0,4.139-25.58-9.78-36.207c-0.307-0.233-0.573-0.322-0.802-0.329
            c-0.227,0.002-0.493,0.083-0.796,0.311c-13.676,10.31-8.95,35.992-8.95,35.992c-10.18,8-7.703,9.151-1.894,23.262
            c1.108,2.693,3.048,2.06,3.926,0.115c0.877-1.943,2.815-6.232,2.815-6.232l11.029,0.128c0,0,2.035,4.334,2.959,6.298
            c0.922,1.965,2.877,2.644,3.924-0.024C49.974,47.064,52.423,45.969,42.057,37.732z M31.726,23.155
            c-2.546-0.03-4.633-2.118-4.664-4.665c-0.029-2.547,2.012-4.587,4.559-4.558c2.546,0.029,4.634,2.117,4.663,4.664
            C36.314,21.143,34.272,23.184,31.726,23.155z"/>
            </svg>
        </div>
    </div>
</div>
</body>
</html>
