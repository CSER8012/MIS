<%@ page import="entity.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% Staff user = (Staff)session.getAttribute("user");
    if(user == null) {
        response.sendRedirect("/login.jsp?valid=2");
    }
    %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>Reset Password</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="./css/common.css"/>
    <link rel="stylesheet" type="text/css" href="./css/thems.css">
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){

            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var main_w = $(window).width();
            $('.xjhy').css('width',main_w-40+'px');

        });

    </script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">Change Password</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="resetPassword.do" method="post" name="addForm">
                <input  name="id" type="hidden" value="<%=user.getId()%>"/>
                <div class="xjhy">

                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">Name：</span>
                            <div class="li_r">
                                <input class="chang"  type="text" value="<%=user.getName()%>" readonly/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Sex</span>
                            <div class="li_r">
                                <input class="chang" type="text" value="<%=user.getSex()%>" readonly/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Id</span>
                            <div class="li_r">
                                <input class="chang" type="text" value = "<%=user.getId()%>" readonly/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Account</span>
                            <div class="li_r">
                                <input class="chang" type="text" value="<%=user.getAccount()%>" readonly/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Department</span>
                            <div class="li_r">
                                <input class="chang" type="text" value="<%=user.getDepartment().getName()%>" readonly/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Born Date</span>
                            <div class="li_r">
                                <fmt:formatDate value="<%= user.getBornDate()%>" pattern="yyyy-MM-dd"/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Work Time</span>
                            <div class="li_r">
                                <fmt:formatDate value="<%= user.getWorkTime()%>" pattern="yyyy-MM-dd"/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Leave Time</span>
                            <div class="li_r">
                                <fmt:formatDate value="<%= user.getLeaveTime()%>" pattern="yyyy-MM-dd"/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Remark</span>
                            <div class="li_r"><%= user.getInfo()%></div>
                        </li>
                    </ul>
                    <!--advanced setting-->
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

