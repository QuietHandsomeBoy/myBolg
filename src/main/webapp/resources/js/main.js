/**
 * Created by hxpeng on 2016/6/22.
 */


$(function () {

    var a = 0;
    $.fn.scrolled = function (i, n) {
        "function" == typeof i && (n = i, i = 200);
        var t = "scrollTimer" + a++;
        this.scroll(function () {
            var a = $(this),
                o = a.data(t);
            o && clearTimeout(o),
                o = setTimeout(function () {
                        a.removeData(t),
                            n.call(a[0])
                    },
                    i),
                a.data(t, o)
        })
    },
        $.fn.AniView = function (a) {
            function i(a) {
                var i = $(a).offset(),
                    t = i.top + $(a).position().top,
                    o = (i.top + $(a).position().top + $(a).height(), $("#st-content").position().top + $("#st-content").height());
                if (t < o - n.animateThreshold) {
                    return !0;
                } else {
                    return !1;
                }
            }

            var n = $.extend({
                    animateThreshold: -600,
                    scrollPollInterval: 0
                },
                a),
                t = this;
            $(t).each(function (a, i) {
                $(i).wrap('<div class="av-container"></div>'),
                    $(i).css("opacity", 0)
            }),
                $(t).each(function (a, n) {
                    var t = $(n).parent(".av-container");
                    $(n).is("[av-animation]") && !$(t).hasClass("av-visible") && i(t) && ($(n).css("opacity", 1), $(t).addClass("av-visible"), $(n).addClass("animated " + $(n).attr("av-animation")))
                }),
                $("#st-content").scrolled(n.scrollPollInterval,
                    function () {
                        $(t).each(function (a, n) {
                            var t = $(n).parent(".av-container");
                            $(n).is("[av-animation]") && !$(t).hasClass("av-visible") && i(t) && ($(n).css("opacity", 1), $(t).addClass("av-visible"), $(n).addClass("animated " + $(n).attr("av-animation")))
                        })
                    })
        }


    $('.aniview').AniView();
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


    $(document).pjax("a", "#st-content")
        .on("pjax:timeout", function (event) {
            event.preventDefault()
        })
        .on("pjax:send", function() {
            alert("test!");
            NProgress.start();
            $(".loadingbox").addClass("loadingbox_test");
        })
        .on("pjax:complete", function() {

            $(".loadingbox").removeClass("loadingbox_test");
            NProgress.end();
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
                    setTimeout(function(){NProgress.done();},3000)
                }
            }); // end Ajax

        })

})