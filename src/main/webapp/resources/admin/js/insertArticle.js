/**
 * Created by hxpeng on 2016/7/15.
 */



//全屏切换
//function changeStyle(sysiwyg) {
//    var box = $(sysiwyg).parents(".wysiwyg-container").parent();
//    if (box && box.hasClass("full-screen-style")) {
//        $("#fullscreenBox").removeClass("full-screen-style");
//        $("#myWorld").css("visibility","visible").css("height","auto");
//        $("#article-content-box").html($("#fullscreenBox").clone());
//        $("#article-content-box").html($("#fullscreenBox").html());
//        $("#article-content-box").find(".fullscreenBtn").attr("title", "全屏模式").html("<i class='fa fa-expand'></i>");
//        $("#article-content-box").find(".wysiwyg-container").css("min-height", "350px");
//        $("#fullscreenBox").html("");
//    } else {
//        $("#myWorld").css("visibility","hidden").css("height","0px");
//        $("#fullscreenBox").html($("#article-content-box").clone());
//        $("#fullscreenBox").find(".fullscreenBtn").attr("title", "正常模式").html("<i class='fa fa-compress'></i>");
//        $("#fullscreenBox").addClass("full-screen-style");
//        $("#fullscreenBox").find(".wysiwyg-container").css("min-height", document.documentElement.clientHeight);
//        $("#article-content-box").html("");
//    }
//};