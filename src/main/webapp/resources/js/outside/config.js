/**
 * Created by hxpeng on 2016/7/20.
 */

require.config({
    baseUrl: "/" + document.URL.split("/")[3] + "/resources/js",
    paths:{
        "jQuery":"common/jquery/jquery",
        "sidebar":"outside/sidebar/sidebar-transitions",
        "jqueryAniview":"outside/aniview/jquery.aniview.min",
        "ie":"common/ie",
        "pjax":"common/pjax/outside/pjax",
        "nprogress":"common/nprogress/nprogress",
        "jqueryCookie":"common/jquery/jquery.cookie",
        "icheck":"common/icheck/icheck",
        "bootstrapJs":"admin/bootstrap/bootstrap.min",
        "baseutil": 'common/util/base-util',
        "index":"outside/index",
        "articleDetail":"outside/articleDetail",
        "commonJS":"outside/common",
    },
    map: {
        '*': {
            'css': 'common/require/css'
        }
    },
    shim : {
        "jqueryAniview":['jQuery'],
        "pjax":['jQuery'],
        "nprogress":['jQuery'],
        "jqueryCookie":['jQuery'],
        "icheck":['jQuery'],
        "sidebar":['jQuery','ie'],
        "bootstrapJs":['jQuery'],
        "baseutil":['jQuery']
    },
    urlArgs: "bust=" +  (new Date()).getTime()
});

require(['nprogress'],function(NProgress){
    require(['jQuery', 'jqueryAniview', 'pjax','sidebar','jqueryCookie'], function() {

        $(document).pjax('a', '#main-content', {fragment:'#main-content', timeout:5000, scrollTo:false})
            .on("pjax:click", function(){
            })
            .on("pjax:timeout", function (event) {
                event.preventDefault()
            })
            .on("pjax:start", function () {
            })
            .on("pjax:send", function () {
                //替换之前，销毁已存在的滚动监听
                NProgress.start();
            })
            .on("pjax:success", function () {
            })
            .on("pjax:popstate",function(){
            })
            .on("pjax:end",function(){
            })
            .on("pjax:complete",function(){
                setTimeout(function(){NProgress.done();}, 500);
            })
            .on("pjax:beforeReplace",function(){
            })
            .on("click","article .article_link",function(){
                $.cookie("scrollTo",$(window).scrollTop());
            })
            .on("submit", "#loginForm", function() {
                event.preventDefault();
                $.ajax( {
                    url: "http://localhost:8084/springDemo3/accountLogin",
                    data: $(this).serialize(),
                    type: "post",
                    beforeSend: function(){
                        $(".loadingbox").addClass("loadingbox_test");
                    },
                    error: function(request) {
                        console.log("Comment Failed to Post: " + request.responseText);
                        alert("错误！");
                    },
                    success: function(data) {
                        setTimeout(function(){$(".loadingbox").removeClass("loadingbox_test");$("#loginformBox").hide();$("#welComeLogin").hide();$("#loginSuc").show();},1500)
                        setTimeout(function(){NProgress.done();window.location="/springDemo3";},3000)
                    }
                }); // end Ajax

            })

        //$(window).resize(function () {
        //    var leftPX = ($(window).width() - $('#loginBox').outerWidth()) / 2;
        //    var topPX = ($(window).height() - $('#loginBox').outerHeight()) / 2 + $(document).scrollTop();
        //
        //    if (topPX < 70) {
        //        topPX = 70;
        //    }
        //    $('#loginBox').css({
        //        position: 'absolute',
        //        left: leftPX,
        //        top: topPX
        //    });
        //});
        //$(window).resize();
        ////隐藏右侧栏
        //$(".hidelink").click(function(){
        //    $("#rightBox").attr("av-animation","bounceOutRight");
        //    $("#rightBox").removeClass("bounceInRight").addClass("bounceOutRight");
        //    setTimeout(function(){$("#leftBox").css("width","100%");},300);
        //    setTimeout(function(){$("#rightBox").css("display","none");},500);
        //
        //})
    });
})


var initPage = function(NProgress){
    //替换完成重新监听滚动，完成基本操作
    var $container = $("#container");
    $container.off(".myScroll");

    var headerBox = $("#header-box");
    headerBox.css("width",$('#container')[0].scrollWidth+"px");


    //判断最后一个article元素是否出现在可视范围内！
    var lastArtice = $("article").eq(-1);
    var lastArticleHeight = lastArtice.outerHeight();
    var lastArticleOffSetTop = $("#leftBox").outerHeight() - lastArticleHeight;
    var windowHeight = $(document).height();
    var indexIntroduceBoxHeight = $(".index-introduce-box").outerHeight();
    var loadData = true;


    var containerScrollTop;
    $container.on("scroll.myScroll",function() {
        containerScrollTop = $("#container").scrollTop();
        if (containerScrollTop > 0) {
            headerBox.addClass("active");
        }else if(containerScrollTop == 0){
            headerBox.removeClass("active");
        }

        console.log(loadData);
        if(loadData){
            var loadDataFlag = $("#loadDataFlag").val();
            if(loadDataFlag != "true"){
                loadData = false;
            }
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
