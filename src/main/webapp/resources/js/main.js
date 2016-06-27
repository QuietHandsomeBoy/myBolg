/**
 * Created by hxpeng on 2016/6/22.
 */


$(function () {

    $(window).resize(function () {
        var leftPX = ($(window).width() - $('#loginBox').outerWidth()) / 2;
        var topPX = ($(window).height() - $('#loginBox').outerHeight()) / 2 + $(document).scrollTop();

        if (topPX < 70) {
            topPX = 70;
        }
        $('#loginBox').css({
            position: 'absolute',
            left: leftPX,
            top: topPX
        });
    });
    $(window).resize();

    //隐藏右侧栏
    $(".hidelink").click(function(){
        $("#rightBox").attr("av-animation","bounceOutRight");
        $("#rightBox").removeClass("bounceInRight").addClass("bounceOutRight");
        setTimeout(function(){$("#leftBox").css("width","100%");},300);
        setTimeout(function(){$("#rightBox").css("display","none");},500);

    })
    $(document).pjax('a', '#leftBox', {fragment:'#leftBox', timeout:5000})
        .on("pjax:timeout", function (event) {
            event.preventDefault()
        })
        .on("pjax:start", function () {
        })
        .on("pjax:send", function () {
            NProgress.start();
        })
        .on("pjax:success", function () {
        })
        .on("pjax:popstate",function(){
        })
        .on("pjax:end",function(){
            $('#leftBox .aniview').AniView();
        })
        .on("pjax:complete0",function(){
            setTimeout(function(){NProgress.done();}, 500);
        })
        .on("pjax:beforeReplace",function(){
        })
        .on("submit", "#loginForm", function() {
            event.preventDefault();
            $.ajax( {
                url: "http://localhost:8084/springDemo3/accountLogin",
                data: $(this).serialize(),
                type: "post",
                beforeSend: function(){
                    NProgress.start();
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

})