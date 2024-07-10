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
        * {
            padding: 0;
            margin: 0;
        }

        .nav {
            height: 30px;
            width: 100%;
            box-shadow: 5px 5px 8px 0px gray;
        }

        .icon {
            float: left;
        }

        ul {
            list-style-type: none;
        }

        ul li:first-child {
            padding-left: 50px;
        }

        ul li {
            float: left;
            line-height: 30px;
            text-align: center;
            box-sizing: border-box;
            cursor: pointer;
            padding-left: 20px;
        }

        ul > li > a:hover {
            color: lightblue;
        }

        a {
            text-decoration: none;
            color: black;
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
<div align="center" style="padding-top: 100px">
    <h1>用户信息列表</h1>
    <table border="2" style="font-size: 25px;">
        <tr>
            <td colspan="8">
                <form action="${pageContext.request.contextPath}/user/getList" method="get">
                    姓名：<input type="text" id="name" name="name" value="${query.name}">
                    用户名：<input type="text" id="username" name="username" value="${query.username}">
                    邮箱：<input type="text" id="email" name="email" value="${query.email}">
                    <input type="submit" class="button" value="搜索">
                </form>
                <button><a href="${pageContext.request.contextPath}/user/addPage">添加用户</a></button>
            </td>
        </tr>
        <tr>
            <th>姓名</th>
            <th>用户名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>住址</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr align="center">
                <td>${user.name}</td>
                <td>${user.username}</td>
                <td>
                    <c:if test="${user.gender == 1}">男</c:if>
                    <c:if test="${user.gender == 2}">女</c:if>
                </td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td>
                    <button><a href="${pageContext.request.contextPath}/user/updatePage?id=${user.id}">修改</a></button>
                    <button><a href="${pageContext.request.contextPath}/user/deleteById?id=${user.id}">删除</a></button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8">
                <div>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <c:if test="${pages == 1}">
                                <li class="disabled">
                                </li>
                            </c:if>
                            <c:if test="${pages != 1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/user/getList?name=${user.name}&email=${user.email}&pageNum=${pageNum - 1}"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach begin="1" end="${pages}" var="i">
                                <c:if test="${pageNum == i}">
                                    <li class="active"><a
                                            href="${pageContext.request.contextPath}/user/getList?name=${user.name}&email=${user.email}&pageNum=${i}">${i}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageNum != i}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/user/getList?name=${user.name}&email=${user.email}&pageNum=${i}">${i}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${pages == 1}">
                                <li class="disabled">
                                </li>
                            </c:if>
                            <c:if test="${pages != 1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/user/getList?name=${user.name}&email=${user.email}&pageNum=${pageNum + 1}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <span style="font-size: 25px;margin-left: 5px;">
                                共${total}条记录，共${pages}页
                            </span>
                        </ul>
                    </nav>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

