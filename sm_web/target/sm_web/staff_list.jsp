<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Staff List</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="./css/common.css"/>
    <link rel="stylesheet" type="text/css" href="./css/thems.css">
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){

            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var search_w = $(window).width()-40;
            $('.search').css('width',search_w+'px');
            //$('.list_hy').css('width',search_w+'px');
        });
    </script>
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
</head>

<body onLoad="Resize();">

<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">Staff List</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--List-->
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Sex</th>
                    <th scope="col">Entry Time</th>
                    <th scope="col">Department</th>
                    <th scope="col">Status</th>
                    <th scope="col">Operation</th>
                </tr>
                <c:forEach items="${list}" var="staff">
                    <tr>
                        <td>${staff.name}</td>
                        <td>${staff.sex}</td>
                        <td><fmt:formatDate value="${staff.workTime}" pattern="yyyy-MM-dd HH:mm"/> </td>
                        <td>${staff.department.name}</td>
                        <td>${staff.status}</td>
                        <td>
                            <a href="staff/toEdit.do?id=${staff.id}" class="btn">Edit</a>
                            <a href="staff/find.do?id=${staff.id}" class="btn">View</a>
                            <a href="staff/delete.do?id=${staff.id}" class="btn">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col"><a href = "staff/toAdd.do" class="btn">Add</a></th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </table>

        </div>

    </div>
</div>
</body>
</html>
