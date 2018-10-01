<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Staff" %>
<%Staff user = (Staff)session.getAttribute("user");
  if(user == null)
      response.sendRedirect("login.jsp?valid=2");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>MIS</title>

</head>
<frameset rows="85,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="top.jsp" name="topFrame" scrolling="no">
    <frameset cols="250,*" name="btFrame" frameborder="NO" border="0" framespacing="0">
        <frame src="left.jsp" noresize name="menu" scrolling="yes">
        <frame src="department/list.do" class="frame_r" noresize name="main" scrolling="yes">
    </frameset>
</frameset>
<noframes>
    <body>您的浏览器不支持框架！</body>
</noframes>
</html>
