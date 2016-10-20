/**
 * Created by hxpeng on 2016/6/22.
 */

define(['baseutil','jqueryAniview',"nprogress"], function () {

    var loadData = true;
    var NProgress = require("nprogress");

    var init = function () {
        loadData = true;
        $('.aniview').AniView();

        var $container = $("#container");

        //记录从首页点击去详情页，返回时，回到上次浏览的位置
        $("body").on("click",".article_link",function(){
            $.cookie("scrollTo",$("#container").scrollTop());
            loadData = false;
        });

        //判断最后一个article元素是否出现在可视范围内！
        var lastArtice = $("article").eq(-1);
        var lastArticleHeight = lastArtice.outerHeight();
        var lastArticleOffSetTop = $("#leftBox").outerHeight() - lastArticleHeight;
        var windowHeight = $(document).height();
        var indexIntroduceBoxHeight = $(".index-introduce-box").outerHeight();
        var headerBox = $("#header-box");

        var oldContainerScrollTop = $("#oldContainerScrollTop").val();
        var containerScrollTop;

        $container.on("scroll.myScroll",function(){

            containerScrollTop = $("#container").scrollTop();
            if(containerScrollTop < 1){
                headerBox.removeClass("show");
            }else if(oldContainerScrollTop > containerScrollTop){
                headerBox.addClass("show");
            }else if(oldContainerScrollTop < containerScrollTop){
                headerBox.removeClass("show");
            }
            oldContainerScrollTop = containerScrollTop;

            if(loadData){
            //是否加载数据
                if((containerScrollTop - indexIntroduceBoxHeight  < lastArticleOffSetTop + lastArticleHeight)
                    && (containerScrollTop - indexIntroduceBoxHeight > lastArticleOffSetTop - windowHeight)) {
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
                            //
                            //console.log("leftBoxHeight:"+$("#leftBox").outerHeight());
                            //console.log("containerScrollTop:"+containerScrollTop);
                            //console.log("lastArtice.offset().top:"+lastArticleOffSetTop+",windowHeight:"+windowHeight);
                        }else{
                            loadData = false;
                            $(".no-more-data").show();
                        }
                        NProgress.done();
                    });
                }
            }
        });


    }


    return {
        init: init,
    }
})

