<%--
  Created by IntelliJ IDEA.
  User: hxpeng
  Date: 2016/6/21
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="icon" type="image/png" href="images/resizeApi.png">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <script src="${_jsUrl }/jquery-1.11.3.js"></script>
    <script src="${_jsUrl }/plugins.js"></script>

    <link type="text/css" rel="stylesheet" href="${_cssUrl }/main.css">
</head>
<script>
    $(function () {

        $(window).resize(function(){
            var leftPX = ($(window).width() - $('#loginBox').outerWidth()) / 2;
            var topPX = ($(window).height() - $('#loginBox').outerHeight()) / 2 + $(document).scrollTop();

            if(topPX < 70){
                topPX = 70;
            }
            $('#loginBox').css({
                position: 'absolute',
                left: leftPX,
                top: topPX
            });
        });
        $(window).resize();

//        $("#test").click(function(){
//            $(".loadingbox").addClass("loadingbox_test");
//        })
        $(document).pjax("a", "#loginContentBox")
                .on("pjax:timeout", function(event) {
                    event.preventDefault()
                })
                .on("pjax:start", function() {
                    $(".loadingbox").addClass("loadingbox_test");
                })
                .on("pjax:send", function() {
                    NProgress.start();
                    $("#loginContent").fadeTo(500, 0);
                })
                .on("pjax:success", function() {
                    setTimeout(function(){NProgress.done();$(".loadingbox").removeClass("loadingbox_test");},500);
                })
                .on("pjax:end", function() {
                    setTimeout(function(){NProgress.done();$(".loadingbox").removeClass("loadingbox_test");},5000);
                })
//                .on("click", ".forgatPasswordHref", function(e){
//                    alert("test");
//                })

    })
</script>
<body style="overflow-y:scroll;box-shadow: 0px 0px 100px black inset;">
<div id="loginContentBox">
    <div id="loginBox">
        <div class="loadingbox">
            <div id="loading">
                <div id="loading-center">
                    <div id="loading-center-absolute">
                        <div class="object" id="object_one"></div>
                        <div class="object" id="object_two"></div>
                        <div class="object" id="object_three"></div>
                        <div class="object" id="object_four"></div>
                        <div class="object" id="object_five"></div>
                    </div>
                </div>
            </div>
        </div>
        <div id="loginContent" style="padding: 2rem 0;">
            <nav>
                <a style="float: left;" class="active">Welcome<br/>please login to you account .</a>
            </nav>
            <div style="overflow: auto;">
                <form accept-charset="utf-8" action="#" class="simform">
                    <div class="inputsBox"></div>
                    <div class="inputsBox">
                        <div class="input">
                            <input class="string optional" maxlength="255" id="user-email" placeholder="Email" type="email" size="50" required="required">
                        </div>
                    </div>
                    <div class="inputsBox">
                        <div class="input full">
                            <input class="string optional" maxlength="255" id="user-pw" placeholder="Password" type="password" size="50" required="required">
                        </div>
                    </div>
                    <div class="submitBtnBox">
                        <div class="forgatPasswordHref">
                            <a href="index.html" id="test">Forgot your password?</a>
                        </div>
                        <div class="button-container">
                            <button><span>Sign in</span></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>
</body>
</html>