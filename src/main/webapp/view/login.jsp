<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户管理系统-登录</title>
</head>
<body style="margin:0px;background: url(${pageContext.request.contextPath}/static/images/login.jpg) no-repeat;background-size:100% 100%;background-attachment:fixed;">
<div align="center" style="padding-top: 100px">
    <h1>欢迎登录</h1>
    <form action="${pageContext.request.contextPath}/user/login" method="post" style="border:3px solid black;width: 25%;padding-bottom: 20px">
        <p>用户名:&nbsp<input id="username" name="username" type="text" value="${user.username}">&nbsp&nbsp</p>
        <p>密码:&nbsp<input id="password" name="password" type="password" value="${user.password}"></p>
        <input type="submit" class="button" value="登录">
        <button><a href="${pageContext.request.contextPath}/user/registerPage">注册</a></button><br><br>
        <span style="color:red;font-size:20px;font-weight: bold">${msg}</span>
    </form>
</div>
</body>
</html>