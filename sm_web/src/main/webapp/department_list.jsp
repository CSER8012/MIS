<%@ page import="entity.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%Staff user = (Staff)session.getAttribute("user");
    if(user == null) {
        response.sendRedirect("/login.jsp?valid=2");
    }%>
<%String flag = (String)request.getParameter("flag");
%>
<head>
<title>Department List</title>
<link rel="stylesheet" type="text/css" href="./css/reset.css"/>
<link rel="stylesheet" type="text/css" href="./css/common.css"/>
<link rel="stylesheet" type="text/css" href="./css/thems.css">
<script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
<script>
    var flag = '<%=flag%>';
    if(flag == '1')
        alert("This department has staff, you can not edit it!");
    else if (flag == '0')
        alert("This department has staff, you can not delete it!");
</script>
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
<script type="text/javascript">
    $(function(){
        //match screen width
        window.onresize=function(){ location=location };

        var main_h = $(window).height();
        $('.hy_list').css('height',main_h-45+'px');

        var search_w = $(window).width()-40;
        $('.search').css('width',search_w+'px');
        //$('.list_hy').css('width',search_w+'px');
    });

</script>

<style>
    #id {
        text-align:center;
        float:right;
        color:black;
    }
</style>
<!--height setting-->
</head>
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">Department List</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Operations</th>
                </tr>
                <c:forEach items="${Deplist}" var="department">
                <tr>
                    <td>${department.name}</td>
                    <td>${department.address}</td>
                    <td>
                        <a href="department/toEdit.do?id=${department.id}" class="btn">Edit</a>
                        <a href="department/find.do?id=${department.id}" class="btn">View Details</a>
                        <a href="department/delete.do?id=${department.id}" class="btn">Delete</a>
                    </td>
                </tr>
                </c:forEach>
                <tr>
                    <th scope="col"></th>
                    <th scope="col"><a href = "department_add.jsp" class="btn">Add</a></th>
                    <th scope="col"></th>
                </tr>
            </table>

        </div>
    </div>
</div>
</body>
</html>