<%@ page import="entity.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Staff user = (Staff)session.getAttribute("user");
    if(user == null) {
        response.sendRedirect("/login.jsp?valid=2");
    }%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>Add</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="./css/common.css"/>
    <link rel="stylesheet" type="text/css" href="./css/thems.css">
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //fit screen width
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
                <span class="name">Add Department</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="department/add.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--advanced setting-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">Name：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Address：</span>
                            <div class="li_r">
                                <input class="chang" name="address" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="tj_btn">
                            <a href="department_list.jsp" class="back">Back</a>
                            <a href="javascript:addForm.submit();">Add</a>
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
