<%@ page import="entity.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%Staff user = (Staff)session.getAttribute("user");
    if(user == null) {
        response.sendRedirect("/login.jsp?valid=2");
    }%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>Staff Details</title>
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
                <span class="name">Staff Information</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">Account Name</span>
                            <div class="li_r">
                                <input class="chang" name="account" type="text" value = "${OBJ.account}" readonly/>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Department：</span>
                            <div class="li_r">
                                <input class="chang" name="account" type="text" value = "${OBJ.department.name}" readonly/>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Staff Name：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text"  value = "${OBJ.name}" readonly/>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Sex：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text"  value = "${OBJ.sex}" readonly/>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">ID Number：</span>
                            <div class="li_r">
                                <input class="chang" name="id_number" type="text" value = "${OBJ.idNumber}" readonly/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Birth Date：</span>
                            <div class="li_r">
                                <input class="chang" name="bornDate" type="text" value="<fmt:formatDate value="${OBJ.bornDate}" pattern="yyyy-MM-dd"/>" readonly/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">Remark：</span>
                            <div class="li_r">
                                <input class="chang" name="info" type="text" value = "${OBJ.info}" readonly/>
                            </div>
                        </li>
                        <li class="tj_btn">
                            <a href="staff_list.jsp" class="back">Back</a>
                            <a href="staff/toEdit.do?id=${OBJ.id}">Edit</a>
                        </li>
                    </ul>

                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>