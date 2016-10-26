/**
 * Created by hxpeng on 2016/5/9.
 */
var hxp = {
    begin: function () {
        var e = navigator.userAgent;
        $.browser = {},
            $.browser.msie = !1,
            $.browser.version = 0,
            $.mobile = {},
            $.mobile.is = /android|webos|iphone|ipad|ipod|blackberry|iemobile|opera mini/i.test(e.toLowerCase()),
            $.mobile.width = 992

        var UA = window.navigator.userAgent,
            isQQBrowser = /(?:MQQBrowser | QQ)/.test(UA),
            isWindowsPhone = /(?:Windows Phone)/.test(UA),
            isSymbian = /(?:SymbianOS)/.test(UA) || isWindowsPhone,
            isAndroid = /(?:Android)/.test(UA),
            isFireFox = /(?:Firefox)/.test(UA),
            isChrome = /(?:Chrome|CriOS)/.test(UA),
            isIpad = /(?:iPad|PlayBook)/.test(UA),
//isTablet = /(?:iPad|PlayBook)/.test(ua)||(isFireFox && /(?:Tablet)/.test(ua)),
            isSafari = /(?:Safari)/.test(UA),
            isPhone = /(?:iPhone)/.test(UA) && !isTablet,
            isOpen = /(?:Opera Mini)/.test(UA),
            isUC = /(?:UCWEB|UCBrowser)/.test(UA),
            isPc = !isPhone && !isAndroid && !isSymbian;

        var device = isQQBrowser ? 'QQ浏览器' : isWindowsPhone ? 'winPhone' : isSymbian ? '塞班系统' : isAndroid ? '安卓'
            : isFireFox ? '火狐' : isChrome ? '谷歌' : isIpad ? 'ipad' : isSafari ? 'Safari' : isPhone ? 'iphone'
            : isOpen ? '欧鹏' : isUC ? 'UC' : isPc ? 'PC' : 'unknow';

        $.fn.resizeComplete = function (e, t, n) {
            var i = 0;
            this.resize(function () {
                clearTimeout(i),
                    i = setTimeout(e, t)
            }),
                "load" === n ? this.on("load", e) : "ready" === n && e()
        }

        console.log(device);

    },
    header: function () {

        function e(e, t) {
            return e.length ? parseInt(e.removeAttr("style").css(t), 10) : 0
        }

        var aniviewSet = $(".aniview");
        //滚动显示初始化
        $.fn.AniView = function (a) {
            var n = $.extend({animateThreshold: 0, scrollPollInterval: 20}, a), t = this;
            $(t).each(function (a, i) {
                $(i).wrap('<div class="av-container"></div>'), $(i).css("opacity", 0)
            });
            $(t).each(function (a, n) {
                var t = $(n).parent(".av-container");
                $(n).is("[av-animation]") && !$(t).hasClass("av-visible") && aniviewIsShow(t) && ($(n).css("opacity", 1), $(t).addClass("av-visible"), $(n).addClass("animated " + $(n).attr("av-animation")))
            });
        }
        //是否出现在可视范围内
        function aniviewIsShow(a){
            var i = $(a).offset(), t = i.top + $(a).scrollTop(), o = (i.top + $(a).scrollTop() + $(a).height(), $(window).scrollTop() + $(window).height());
            return t < o ? !0 : !1
        }
        aniviewSet.AniView();


        function t() {

            //滚动显示
            $.each(aniviewSet,function (a, n) {
                var t = $(n).parent(".av-container");
                $(n).is("[av-animation]") && !$(t).hasClass("av-visible") && aniviewIsShow(t) && ($(n).css("opacity", 1), $(t).addClass("av-visible"), $(n).addClass("animated " + $(n).attr("av-animation")))
            });

            if($(window).scrollTop() > 0){
                $(".navbar-inner").css("margin-top","15px");
                $("#main-menu li").css("padding-bottom","15px");
                $(".logo").css("height","33.33px");
            }else if($(window).scrollTop() == 0){
                $(".navbar-inner").css("margin-top","30px");
                $("#main-menu li").css("padding-bottom","30px");
                $(".logo").css("height","40px");
            }


        }

        var n, a, r = $("#header"), s = !1;
        if(!r.hasClass("sticky-off") && r.length ){
            $("#header-space").height(r.addClass("sticky").height());
        }

        $(window).scroll(t).resizeComplete(t, 50, "ready");
    },
    navigation: function () {
        $("#main-menu").on("click", "i.carret, > li > a, .dropdown > li > a", function () {
            if ($(window).outerWidth() < $.mobile.width) {
                if ($(this).is(".carret")) return $(this).toggleClass("rotate").closest("li").children("ul.dropdown").slideToggle(300),
                    !1;
                if ($(this).parent().children("ul.dropdown").length && "#" == $(this).attr("href")) return $(this).children("i.carret").toggleClass("rotate"),
                    $(this).closest("li").children("ul.dropdown").slideToggle(300),
                    !1
            }
        })
    },
    banner: function () {
        var s = $("#main-banner .img-carousel div");
        var l = s.size();
        var index = 0;
        function e() {
            s.stop();
            s.eq(index).siblings().animate({opacity: 0}, 1000)
            s.eq(index).animate({opacity: 1}, 1000)
        }
        function a() {
            index = index + 1;
            if (index <= l - 1) {
                e(index);
            } else {
                index = 0;
                e(index);
            }
        }
        setInterval(a, 10000);
    },
    init: function () {
        var e = this;
        this.begin(),
            $(function () {
                e.header(),
                    e.banner(),
                    e.navigation()
            })
    }

}
