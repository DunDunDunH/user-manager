<%@ page import="java.util.List" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" th:href="@{/api/css/jquery.pagination.css}">
<script th:src="@{/api/js/jquery.pagination.min.js}"></script>
<html>
<head>
    <title>用户管理系统</title>
    <style type="text/css">
        .nav {
            height: 30px;
            width: 100%;
            box-shadow: 5px 5px 8px 0px gray;
        }

        .lnr {
            font-size: 20px;
            vertical-align: -5px;
        }

        .rightside-nav {
            float: right;
        }

        .rightside-nav a {
            line-height: 30px;
            text-align: center;
            box-sizing: border-box;
            cursor: pointer;
        }

        .rightside-nav a:last-child {
            padding-right: 80px;
        }
    </style>
</head>
<body style="margin:0px;background: url(${pageContext.request.contextPath}/static/images/login.jpg) no-repeat;background-size:100% 100%;background-attachment:fixed;">
<div class="nav" style="background-color: antiquewhite">
    <div class="rightside-nav" style="color: white">
        <a href="${pageContext.request.contextPath}/user/indexPage"><span class="lnr lnr-user"></span><span>Hi,${name}</span></a>&nbsp&nbsp&nbsp&nbsp
        <a href="${pageContext.request.contextPath}/user/indexPage"><span class="lnr lnr-home"></span><span>首页</span></a>&nbsp&nbsp&nbsp&nbsp
        <a href="${pageContext.request.contextPath}/user/logout"><span class="lnr lnr-home"></span><span>注销</span></a>
    </div>
</div>
<div align="center" style="padding-top: 100px" class="no-style">
    <h1>修改用户</h1>
    <form action="${pageContext.request.contextPath}/user/save" method="post"
          style="border:3px solid black;width: 25%;padding-bottom: 20px">
        <input id="id" name="id" type="hidden" value="${user.id}"></p>
        <p>&nbsp&nbsp&nbsp姓名:&nbsp&nbsp&nbsp<input id="name" name="name" type="text" value="${user.name}" readonly>&nbsp&nbsp</p>
        <p>&nbsp&nbsp用户名:&nbsp&nbsp<input id="username" name="username" type="text" value="${user.username}">&nbsp&nbsp</p>
        <p>&nbsp&nbsp&nbsp密码:&nbsp&nbsp&nbsp<input id="password" name="password" type="password" value="${user.password}"></p>
        <p>确认密码:<input id="confirmPassword" name="confirmPassword" type="password" value="${user.confirmPassword}"></p>
        <p>性别:
            <input type="radio" name="gender" value="1" <c:if test="${user.gender!=2}">checked="checked"</c:if>>男
            <input type="radio" name="gender" value="2" <c:if test="${user.gender==2}">checked="checked"</c:if>>女
        <p>&nbsp&nbsp&nbsp年龄:&nbsp&nbsp&nbsp<input id="age" name="age" type="number" value="${user.age}"></p>
        <p>&nbsp&nbsp&nbsp住址:&nbsp&nbsp&nbsp<input id="address" name="address" type="text" value="${user.address}"></p>
        <p>&nbsp&nbsp&nbspQQ:&nbsp&nbsp&nbsp&nbsp<input id="qq" name="qq" type="number" value="${user.qq}"></p>
        <p>&nbsp&nbsp&nbsp邮箱:&nbsp&nbsp&nbsp<input id="email" name="email" type="text" value="${user.email}"></p>
        <input type="submit" class="button" value="确定">
        <button><a href="${pageContext.request.contextPath}/user/indexPage">返回</a></button><br><br>
        <span style="color:red;font-size:20px;font-weight: bold">${msg}</span>
    </form>
</div>
</body>
</html>

