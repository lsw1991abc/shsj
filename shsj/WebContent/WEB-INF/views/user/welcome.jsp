<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户中心</title>
</head>

<body>
<div class="container">
	<h1>欢迎来到社会实践中心！</h1>
	<h2>您的登录用户名是：${myself.nickname}</h2>
	<a href="<%=basePath %>/user/myself">个人资料</a>
	<a href="<%=basePath %>/information/list">查看消息</a>
	<p><a href="<%=basePath %>/login/logout">退出</a></p>
</div>
</body>
</html>
