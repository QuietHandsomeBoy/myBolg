/**
 * Created by hxpeng on 2016/6/22.
 */

define(['baseutil','jqueryAniview',"nprogress"], function () {

    var loadData = true;
    var NProgress = require("nprogress");

    var init = function () {
        $('.aniview').AniView();

        //记录从首页点击去详情页，返回时，回到上次浏览的位置
        $("article").find(".article_link").on("click",function(){
            $.cookie("scrollTo",$("#container").scrollTop());
        })

        //判断最后一个article元素是否出现在可视范围内！
        var lastArtice = $("article").eq(-1);
        var lastArticleHeight = lastArtice.outerHeight();
        var lastArticleOffSetTop = $("#leftBox").outerHeight() - lastArticleHeight;
        var windowHeight = $(document).height();
        var containerScrollTop;
        $("#container").scroll(function(){
            if(loadData){
                containerScrollTop = $("#container").scrollTop();
                if((containerScrollTop < lastArticleOffSetTop + lastArticleHeight) && (containerScrollTop > lastArticleOffSetTop - windowHeight)) {
                    loadData = false;
                    NProgress.start();
                    var currentPage = Number($("#currentPage").val()) + 1;//下一页
                    $("#loadDataBox").load(ctx + "/article/loadArticleDataHtml.html",{currentPage:currentPage},function(){
                        var loadDataBox = $("#loadDataBox");
                        var articleLen = loadDataBox.find("article").length;
                        if(articleLen > 0){

                            $("#leftBox").find("section").append(loadDataBox.html());
                            loadDataBox.html("");
                            $(".new-load-data-box").find(".aniview").AniView();
                            $(".new-load-data-box").removeClass("new-load-data-box");
                            loadData = true;
                            $("#currentPage").val(currentPage);

                            //刷新判断出现在可视范围内的参数
                            lastArtice = $("article").eq(-1);
                            lastArticleHeight = lastArtice.outerHeight();
                            lastArticleOffSetTop = $("#leftBox").outerHeight() - lastArticleHeight;

                            console.log("leftBoxHeight:"+$("#leftBox").outerHeight());
                            console.log("containerScrollTop:"+containerScrollTop);
                            console.log("lastArtice.offset().top:"+lastArticleOffSetTop+",windowHeight:"+windowHeight);
                        }else{
                            loadData = false;
                            $(".no-more-data").show();
                        }
                        setTimeout(function(){NProgress.done();}, 1000);
                    });
                }
            }
        });
    }


    return {
        init: init,
    }
})

