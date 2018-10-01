<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String valid = request.getParameter("valid");%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="./css/common.css"/>
    <link rel="stylesheet" type="text/css" href="./css/thems.css"/>
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>

    <script type="text/javascript">
        $(function(){

            window.onresize=function(){ location=location };

            var w_height=$(window).height();
            $('.bg_img').css('height',w_height+'px');

            var bg_wz=1920-$(window).width();
            $('.bg_img img').css('margin-left','-'+bg_wz/2+'px')

            $('.language .lang').click(function(){
                $(this).siblings('.lang_ctn').toggle();
            });
        })

        var valid = '<%=valid%>';
        if(valid == '0')
            alert("Your password or username is incorrect!");
        else if(valid == '2')
            alert("Please login at first!");
    </script>
    <!--框架高度设置-->
</head>

<body>
<!--登录-->
<div class="login">
    <div class="bg_img"><img src="./images/login_bg.jpg"/></div>
    <div class="logo">
        <a href=""><img src="./images/logo.png" width="196" height="124" alt=""/></a>
    </div>
    <div class="login_m">
        <form action="login.do" method="post" name="login_form">
            <ul>
                <li class="wz">Username</li>
                <li><input name="account" type="text"></li>
                <li class="wz">Password</li>
                <li><input name="password" type="password"></li>
                <li class="l_btn">
                    <a href="javascript:login_form.submit();">Login</a>
                </li>
            </ul>
        </form>
    </div>
</div>
<!--登录-->
</body>
</html>