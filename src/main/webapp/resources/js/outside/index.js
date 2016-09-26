/**
 * Created by hxpeng on 2016/6/22.
 */

define(['baseutil',"jqueryAniview"], function () {

    var init = function () {

        $('.aniview').AniView();

        $("article").find(".article_link").on("click",function(){
            $.cookie("scrollTo",$("#leftBox").offset().top);
            console.log($("#leftBox").offset().top);
        })


        //var last = $("#leftBox");
        //$("#st-content").scroll(function(){
        //    var top = last.offset().top;
        //    console.log(top);
        //});

    }


    return {
        init: init,
    }
})

