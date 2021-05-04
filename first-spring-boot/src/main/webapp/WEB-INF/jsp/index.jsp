<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>排课系统</title>
</head>
<body>

阿里的 easyexcel

<br/>

<a href="addUser.jsp">添加</a>
<br/>
<a href="userList.jsp">查询所有+删除</a>
<br/>
<a href="userListFenye.jsp">分页查询</a>
<br/>
<a href="userListEdit.jsp">修改</a>
<br/>

</body>

</html>