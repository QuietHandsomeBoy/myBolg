/**
 * Created by hxpeng on 2016/6/22.
 */

define(['baseutil','jqueryAniview'], function () {

    var init = function () {

        //$("#st-content").scrollTop(0);

        $('.aniview').AniView();

        $("article").find(".article_link").on("click",function(){
            $.cookie("scrollTo",$("#container").scrollTop());
        })

        //$("#container").scroll(function(){
        //    console.log($("#container").scrollTop());
        //});

    }


    return {
        init: init,
    }
})

