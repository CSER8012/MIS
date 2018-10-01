<%@ page import="entity.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Staff user = (Staff)session.getAttribute("user");%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>Nav</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="./css/common.css"/>
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <!--height setting-->
    <script type="text/javascript">
        $(function(){
            $('.sidenav li').click(function(){
                $(this).siblings('li').removeClass('now');
                $(this).addClass('now');
            });

            $('.erji li').click(function(){
                $(this).siblings('li').removeClass('now_li');
                $(this).addClass('now_li');
            });

            var main_h = $(window).height();
            $('.sidenav').css('height',main_h+'px');
        })
    </script>
    <!--framework height setting-->
</head>

<body>
<div id="left_ctn">
    <ul class="sidenav">
        <li class="now">
            <div class="nav_m">
                <span><a>Staff Management</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="staff/list.do" target="main">Staff Management</a></span>
                </li>
                <li>
                    <span><a href="department/list.do" target="main">Department Management</a></span>
                </li>
            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>Personal Center</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="resetPassword.jsp" target="main">Reset Password</a></span>
                </li>
                <li>
                    <span><a href="info.jsp" target="main">Personal Information</a></span>
                </li>
            </ul>
        </li>
        <li>
        <div class="nav_m">
            <span><a>Log Management</a></span>
            <i>&nbsp;</i>
        </div>
        <ul class="erji">
            <li>
                <span><a href="log/operationLog.do" target="main">Operation Log</a></span>
            </li>
            <li>
                <span><a href="log/loginLog.do" target="main">Login Log</a></span>
            </li>
            <li>
                <span><a href="log/systemLog.do" target="main">System Log</a></span>
            </li>
        </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a href="logout.do" target="_top">Exit System</a></span>
            </div>
        </li>
    </ul>
</div>
</body>
</html>

