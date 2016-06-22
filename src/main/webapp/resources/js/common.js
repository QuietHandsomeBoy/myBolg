/**
 * Created by hxpeng on 2016/5/9.
 */




$(function () {

    var comtentScrollTop;

    $(window).load(function() {
        //保存滚动条位置，刷新时回到刷新之前的位置
        comtentScrollTop = $.cookie("comtentScrollTop");
        if (comtentScrollTop != null) {
            $("#st-content").scrollTop(comtentScrollTop);
        }
    });



    $("#st-content").scroll(function () {
        comtentScrollTop = $("#st-content").scrollTop();
        $.cookie("comtentScrollTop", comtentScrollTop, {path: "/"});
        comtentScrollTop > 1500 ? $("#backTop_box").fadeIn() : $("#backTop_box").fadeOut();
    })
    $("#backTop_box").click(function () {
        $("#st-content").animate({scrollTop: 0}, 800)
    })

})