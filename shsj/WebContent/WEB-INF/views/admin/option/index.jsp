<%@page import="com.lssrc.cms.common.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	String adminPath = basePath + Constants.ADMIN_PATH;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>基本设置</title>
</head>

<body>
<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #options-menu').addClass("in");
	$('#sidebar-nav #options-menu #options-basic').addClass("active");
</script>
<div class="header">
	<h1 class="page-title">基本设置</h1>
</div>

<ol class="breadcrumb">
	<li><a href="<%=adminPath %>/">首页</a></li>
	<li><a href="<%=adminPath %>/">系统设置</a></li>
	<li class="active">基本设置</li>
</ol>

<div class="container-fluid">
	<div class="row-fluid">
	  <div class="well">
      	<div class="panel-body">
	       	<form role="form" action="<%=adminPath %>/setting/update" method="post">
	       		<c:forEach items="${options}" var="option" begin="0">
				  <div class="form-group">
				    <label for="notice-content">${option.oName}</label>
				    <textarea class="form-control" rows="1" style="resize:vertical;" name="${option.oKey}">${option.oValue}</textarea>
				  </div>
				</c:forEach>
				<button type="submit" class="btn btn-primary">保存</button>
			</form>
        </div>
	  </div>
	</div>
</div>
</body>
</html>