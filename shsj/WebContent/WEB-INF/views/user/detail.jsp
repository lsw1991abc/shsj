<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>用户详情</title>

</head>

<body>
<c:if test="${user != null}">
	<h2>用户详情</h2>
	<p>用户名：${user.username}</p>
	<p>联系电话：${user.phoneno}</p>
	<p>注册时间：${user.buildDate}</p>
</c:if>
<c:if test="${user == null}">
	<h2>您查询的数据不存在</h2>
</c:if>
<p><a href="<%=basePath%>/user/list">返回</a></p>
</body>
</html>
