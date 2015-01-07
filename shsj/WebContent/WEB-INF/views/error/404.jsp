<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>您迷路了</title>

</head>

<body>
<div class="container text-center">
	<h1>404 - 您是不是迷路了？？</h1>
	<h1><a href="<%=basePath%>/">180度转身向前一步走</a>，或者<a href="<%=basePath%>/">回首页</a>吧&gt;&gt;</h1>
</div>
</body>
</html>
