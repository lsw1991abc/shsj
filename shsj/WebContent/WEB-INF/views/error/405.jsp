<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE HTML>
<html>
<head>
<title>Error - 405</title>
</head>

<body>
<div class="container text-center">
	<h1>您访问的页面未找到。</h1>
	<h1><a href="javascript:history.go(-1);">返回</a>，或者<a href="<%=basePath%>/">回首页</a>&gt;&gt;</h1>
</div>
</body>
</html>
