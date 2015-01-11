<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户中心</title>
	<link href="<%=basePath%>/style/bootstrap/bootstrap-switch.min.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>/script/bootstrap/bootstrap-switch.min.js"></script>
</head>

<body>
<div class="user-cp-item user-contral-panel">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">控制面板</h3>
		</div>
		<div class="panel-body">Panel content</div>
	</div>
</div>
</body>
</html>
