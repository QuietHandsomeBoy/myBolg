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
    <link type="text/css" rel="stylesheet" href="${_cssUrl }/main.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl }/animate.min.css">
    <script data-main="${_outsideJsUrl}/config" src="${_commonJsUrl}/require/require.js"></script>
    <title>--------</title>
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
                    <section>
                        <div id="content" class="content">
                            <c:forEach items="${articleList}" var="article">
                                <article av-animation="fadeInUp" class="aniview fast">
                                    <div class="article-info">
                                        <div class="article-content">
                                            <h2 class="article_title">
                                                <a href="http://localhost:8082/springDemo3/article/articleDetail/${article.articleId}.html" rel="bookmark">${article.articleTitle}</a>
                                            </h2>
                                            <div class="article-meta">
                                                <span class="article_meta_tags"><i class="fa fa-tags"></i>Java,多线程,Html</span>
                                                <span><i class="fa fa-clock-o"></i><fmt:formatDate value="${article.createDate}" pattern="yyyy/MM/dd"/></span>
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

                            <article av-animation="fadeInUp" class="aniview fast">
                                <div class="article-info">
                                    <div class="article-content">
                                        <h2 class="article_title"><a href="javascript:;" rel="bookmark">There is
                                            something
                                            in the New York air that makes sleep useless</a></h2>
                                        <div class="article-meta">
                                            <span class="article_meta_tags"><i class="fa fa-tags"></i>Java,多线程,Html</span>
                                            <span><i class="fa fa-clock-o"></i>2014/04/16</span>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="article_about">
                                            <p>
                                                首先申明只是学摄影的弱犬，刚好这段时间在学习当代摄影，于是自己做一些功课，而知乎上又貌似在这块上存在空白，就全当分享个人学习体验。关于历史事件描述大多参考搜索结果，想了解更多相关内容请自行查找，其中对摄影师作品评说具有强烈的个人情感。不喜勿怪。
                                            </p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </article>
                        </div>

                        <div class="pagination_box">

                        </div>
                    </section>


                </div>

                <%--<div id="rightBox" class="rightBox aniview" av-animation="slideInRight">--%>
                    <%--<div class="hideRigthBox">--%>
                        <%--<a class="hidelink">隐藏右边栏目</a>--%>
                    <%--</div>--%>
                    <%--<section>--%>
                        <%--<div class="searchBox">--%>
                            <%--<form role="search" method="get" class="search-form" action="">--%>
                                <%--<label>--%>
                                    <%--<i class="fa fa-search"></i>--%>
                                    <%--<input required="required" autocomplete="off" type="search" class="search-field" placeholder="Search..."--%>
                                           <%--value="" name="s" title="Search for">--%>
                                <%--</label>--%>
                                <%--<input type="submit" class="search-submit fa fa-search" value="Search">--%>
                            <%--</form>--%>
                        <%--</div>--%>
                        <%--<div class="about-website-box">--%>
                            <%--<h3 class="about-website-title title">About</h3>--%>
                            <%--<div class="about-website-info">--%>
                                <%--<p>Lovecraft is a beautiful WordPress theme for bloggers. It is available as a free--%>
                                    <%--download--%>
                                    <%--from the official WordPress theme depository .</p>--%>
                                <%--<p>Lovecraft is developed by <a href="http://www.andersnoren.se">Anders Norén</a>.</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="tags_box">--%>
                            <%--<h3 class="tags_title title">Tags</h3>--%>
                            <%--<div class="tags">--%>
                                <%--<ul>--%>
                                    <%--<li>XX</li>--%>
                                    <%--<li>XXX</li>--%>
                                    <%--<li>XX</li>--%>
                                    <%--<li>XXX</li>--%>
                                    <%--<li>XX</li>--%>
                                    <%--<li>XXX</li>--%>
                                    <%--<li>XX</li>--%>
                                    <%--<li>XXX</li>--%>
                                    <%--<li>XX</li>--%>
                                    <%--<li>XXX</li>--%>
                                    <%--<li>XX</li>--%>
                                    <%--<li>XXX</li>--%>
                                    <%--<li>XX</li>--%>
                                    <%--<li>XXX</li>--%>
                                <%--</ul>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="recent_posts_box">--%>
                            <%--<h3 class="recent_posts_title title">Recent Posts</h3>--%>
                            <%--<div class="recent_posts">--%>
                                <%--<ul>--%>
                                    <%--<li>--%>
                                        <%--<a href="javascript:void(0);">There is something in the New York air that makes--%>
                                            <%--sleep useless</a>--%>
                                    <%--</li>--%>
                                    <%--<li>--%>
                                        <%--<a href="javascript:void(0);">Bears are classified as caniforms, or doglike--%>
                                            <%--carnivorans</a>--%>
                                    <%--</li>--%>
                                    <%--<li>--%>
                                        <%--<a href="javascript:void(0);">Pure mathematics is, in its way, the poetry of--%>
                                            <%--logical ideas.</a>--%>
                                    <%--</li>--%>
                                    <%--<li>--%>
                                        <%--<a href="javascript:void(0);">I like coffee because it gives me the illusion--%>
                                            <%--that I might be awake</a>--%>
                                    <%--</li>--%>
                                    <%--<li>--%>
                                        <%--<a href="javascript:void(0);">It is not down in any map; true places never--%>
                                            <%--are</a>--%>
                                    <%--</li>--%>
                                <%--</ul>--%>
                                <%--<div class="clear"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--&lt;%&ndash;<div class="recent_comments_box">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<h3 class="recent_comments_title title">Comments</h3>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="recent_comments_container">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<ul>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<div class="comments">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<img src="${_imagesUrl}/head.png">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<h4>干锅加鲁鲁</h4>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<p>&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;Really amazing wordpress theme list. there are many interesting themes&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;in your list. I will use these themes in my upcoming projects.&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<div class="comments">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<img src="${_imagesUrl}/head.png">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<h4>干锅加鲁鲁</h4>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<p>&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;Really amazing wordpress theme list. there are many interesting themes&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<div class="comments">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<img src="${_imagesUrl}/head.png">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<h4>干锅加鲁鲁</h4>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<p>&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;Really amazing wordpress theme list.&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<div class="comments">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<img src="${_imagesUrl}/head.png">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<h4>干锅加鲁鲁</h4>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<p>&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;Really amazing wordpress theme list. there are many interesting themes&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;in your list.&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<div class="comments">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<img src="${_imagesUrl}/head.png">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<h4>干锅加鲁鲁</h4>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<p>&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;there are many interesting themes&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;in your list. I will use these themes in my upcoming projects.&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<div class="comments">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<img src="${_imagesUrl}/head.png">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<h4>干锅加鲁鲁</h4>&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;<p>&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;Really amazing wordpress theme list,I will use these themes in my&ndash;%&gt;--%>
                                                <%--&lt;%&ndash;upcoming projects.&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="comment-info_button">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<button style="float: left;">Read Comments</button>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<button style="float: right;">Leave Comments</button>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<div class="clear"></div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--</section>--%>
                <%--</div>--%>

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