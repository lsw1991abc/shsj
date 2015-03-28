<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE HTML>
<html>
<head>
	<title>此路不通</title>
</head>

<body>
<div class="container text-center">
	<h1>您未登录或登录已超时。</h1>
	<h1><a href="<%=basePath%>/login/">点我登录&gt;&gt;</a></h1>
</div>
</body>
</html>
