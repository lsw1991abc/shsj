<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人信息</title>
</head>

<body>
<div class="container">
	<c:if test="${myself != null}">
		<h2>个人信息</h2>
		<p>用户名：${myself.nickname}</p>
		<p>注册时间：${myself.buildDate}</p>
	</c:if>
	<c:if test="${myself == null}">
		<h2>您查询的数据不存在</h2>
	</c:if>
	<p><a href="<%=basePath%>/user/">返回</a></p>
</div>
</body>
</html>
