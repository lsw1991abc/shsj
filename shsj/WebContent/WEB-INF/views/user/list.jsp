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

<title>用户列表</title>

</head>

<body>
<h2>用户列表</h2>
<ul>
	<c:forEach var="user" items="${users}" step="1" begin="0">
		<li><a href="<%=basePath%>/user/detail?id=${user.id}">${user.username}</a></li>
	</c:forEach>
</ul>
<p>
<a href="<%=basePath%>/user/list?page=${navigator.firstPageNo}">首页</a> - 
<a href="<%=basePath%>/user/list?page=${navigator.prePageNo}">上一页</a> - 
<span>${navigator.nowPageNo} / ${navigator.pageCount}</span> - 
<a href="<%=basePath%>/user/list?page=${navigator.nextPageNo}">下一页</a> - 
<a href="<%=basePath%>/user/list?page=${navigator.lastPageNo}">末页</a> - 
<span>共 ${navigator.count} 条数据</span>
</p>
<p><a href="<%=basePath%>/user/">回主页</a></p>
</body>
</html>
