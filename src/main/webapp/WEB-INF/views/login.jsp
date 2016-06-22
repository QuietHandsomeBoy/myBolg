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
    <link type="text/css" rel="stylesheet" href="${_cssUrl }/animate.min.css">
    <link type="text/css" rel="stylesheet" href="${_cssUrl }/main.css">
    <script src="${_jsUrl }/main.js"></script>
</head>
<body style="overflow:hidden;box-shadow: 0px 0px 100px black inset;">
<div id="st-content">
    <div id="loginBox" class="aniview" av-animation="bounceInUp">
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
        <div id="loginContent">
            <nav id="welComeLogin">
                <p class="active loginBefor">Welcome<br/>please login to you account .</p>
            </nav>
            <nav id="loginSuc" style="display: none;">
                <p class="loginResut" style="line-height: 4rem;">Login Successs !</p>
                <p class="loginResut" style="font-size:1rem">The page will be re-directed in a few seconds.</p>
                <p class="loginResut" style="font-size:1rem">Please wait a moment...</p>
                <%--<p class="active loginBefor">Welcome<br/>please login to you account .</p>--%>
            </nav>
            <div id="loginformBox" style="overflow: auto;">
                <form accept-charset="utf-8" action="#" id="loginForm" class="simform">
                    <div class="inputsBox"></div>
                    <div class="inputsBox">
                        <div class="input">
                            <input autocomplete="off" class="string optional" id="userName" name="userName" placeholder="User" size="50" required="required">
                        </div>
                    </div>
                    <div class="inputsBox">
                        <div class="input full">
                            <input autocomplete="off" class="string optional" id="userPwd" name="userPwd" placeholder="Password" type="password" size="50" required="required">
                        </div>
                    </div>
                    <div class="submitBtnBox">
                        <div class="forgatPasswordHref">
                            <a href="index.html" id="test">Forgot your password?</a>
                        </div>
                        <div class="button-container">
                            <button type="submit"><span>Sign in</span></button>
                        </div>
                    </div>
                </form>

            </div>
        </div>

    </div>
</div>
</body>
<script src="${_jsUrl }/plugins.js"></script>
</html>