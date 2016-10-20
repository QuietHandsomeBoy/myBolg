/**
 * Created by hxpeng on 2016/6/22.
 */

define(['baseutil',"jqueryAniview","css!../css/highlight/googlecode.css"], function () {

    var init = function () {

        var $container = $("#container");
        var headerBox = $("#header-box");
        if(headerBox.hasClass("show")){
            $("#header-box").removeClass("show");
        }
        $container.scrollTop($(".index-introduce-box").outerHeight());

        var containerScrollTop;
        $container.on("scroll.myScroll",function() {
            containerScrollTop = $("#container").scrollTop();
            if (containerScrollTop < 1) {
                headerBox.removeClass("show");
            } else if (oldContainerScrollTop > containerScrollTop) {
                headerBox.addClass("show");
            } else if (oldContainerScrollTop < containerScrollTop) {
                headerBox.removeClass("show");
            }
            oldContainerScrollTop = containerScrollTop;
        });

    }


    return {
        init: init,
    }
})

