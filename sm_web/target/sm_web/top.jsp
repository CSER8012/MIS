<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Staff"%>
<%Staff user =(Staff) session.getAttribute("user");%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Information System</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="./css/common.css"/>
</head>

<body>
<div class="head clearfix">
    <div class="logo"><a href="#"><img src="./images/logo.png" width="126" height="72" alt="MIS"/></a></div>
    <div class="curr"><span>Welcome,<%=user.getName()%>[ <a href="logout.do" target="_top">Logout</a> ]</span></div>
</div>
</body>
</html>