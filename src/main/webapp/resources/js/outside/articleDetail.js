/**
 * Created by hxpeng on 2016/6/22.
 */

define(['baseutil',"jqueryAniview","css!../css/highlight/googlecode.css"], function () {

    var init = function () {

        $("body").animate({scrollTop:0},500)
        //$(window).scrollTop(Number($("article").offset().top - $("header").outerHeight() - 20));
    }

    return {
        init: init,
    }
})


