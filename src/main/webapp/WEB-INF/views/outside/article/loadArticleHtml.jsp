
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/top.jsp" %>
<div class="content data-box new-load-data-box">
    <c:forEach items="${articleList}" var="article" varStatus="status">
        <article av-animation="fadeIn" class="aniview fast index-article">
            <div class="article-info">
                <div class="article-content">
                    <h2 class="article_title">
                        <a class="article_link" href="http://localhost:8082/springDemo3/article/articleDetail/${article.articleId}.html" rel="bookmark">${article.articleTitle}</a>
                    </h2>
                    <div class="article-meta">
                        <span class="article_meta_tags"><i class="fa fa-tags"></i>${article.articleTagsStr}</span>
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
</div>
<%--<article av-animation="fadeIn" class="aniview fast index-article">--%>
    <%--<div class="article-info">--%>
        <%--<div class="article-content">--%>
            <%--<h2 class="article_title"><a href="javascript:;" rel="bookmark">There is--%>
                <%--something--%>
                <%--in the New York air that makes sleep useless</a></h2>--%>
            <%--<div class="article-meta">--%>
                <%--<span class="article_meta_tags"><i class="fa fa-tags"></i>Java,多线程,Html</span>--%>
                <%--<span><i class="fa fa-clock-o"></i>2014/04/16</span>--%>
                <%--<div class="clear"></div>--%>
            <%--</div>--%>
            <%--<div class="article_about">--%>
                <%--<p>--%>
                    <%--首先申明只是学摄影的弱犬，刚好这段时间在学习当代摄影，于是自己做一些功课，而知乎上又貌似在这块上存在空白，就全当分享个人学习体验。关于历史事件描述大多参考搜索结果，想了解更多相关内容请自行查找，其中对摄影师作品评说具有强烈的个人情感。不喜勿怪。--%>
                <%--</p>--%>
            <%--</div>--%>
            <%--<div class="clearfix"></div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</article>--%>
<%--<article av-animation="fadeIn" class="aniview fast index-article">--%>
    <%--<div class="article-info">--%>
        <%--<div class="article-content">--%>
            <%--<h2 class="article_title"><a href="javascript:;" rel="bookmark">There is--%>
                <%--something--%>
                <%--in the New York air that makes sleep useless</a></h2>--%>
            <%--<div class="article-meta">--%>
                <%--<span class="article_meta_tags"><i class="fa fa-tags"></i>Java,多线程,Html</span>--%>
                <%--<span><i class="fa fa-clock-o"></i>2014/04/16</span>--%>
                <%--<div class="clear"></div>--%>
            <%--</div>--%>
            <%--<div class="article_about">--%>
                <%--<p>--%>
                    <%--首先申明只是学摄影的弱犬，刚好这段时间在学习当代摄影，于是自己做一些功课，而知乎上又貌似在这块上存在空白，就全当分享个人学习体验。关于历史事件描述大多参考搜索结果，想了解更多相关内容请自行查找，其中对摄影师作品评说具有强烈的个人情感。不喜勿怪。--%>
                <%--</p>--%>
            <%--</div>--%>
            <%--<div class="clearfix"></div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</article>--%>
<%--<article av-animation="fadeIn" class="aniview fast index-article">--%>
    <%--<div class="article-info">--%>
        <%--<div class="article-content">--%>
            <%--<h2 class="article_title"><a href="javascript:;" rel="bookmark">There is--%>
                <%--something--%>
                <%--in the New York air that makes sleep useless</a></h2>--%>
            <%--<div class="article-meta">--%>
                <%--<span class="article_meta_tags"><i class="fa fa-tags"></i>Java,多线程,Html</span>--%>
                <%--<span><i class="fa fa-clock-o"></i>2014/04/16</span>--%>
                <%--<div class="clear"></div>--%>
            <%--</div>--%>
            <%--<div class="article_about">--%>
                <%--<p>--%>
                    <%--首先申明只是学摄影的弱犬，刚好这段时间在学习当代摄影，于是自己做一些功课，而知乎上又貌似在这块上存在空白，就全当分享个人学习体验。关于历史事件描述大多参考搜索结果，想了解更多相关内容请自行查找，其中对摄影师作品评说具有强烈的个人情感。不喜勿怪。--%>
                <%--</p>--%>
            <%--</div>--%>
            <%--<div class="clearfix"></div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</article>--%>