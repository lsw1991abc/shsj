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
	<title>活动管理</title>
	<link href="<%=basePath %>/jquery-ui-1.11.2/jquery-ui.css" type="text/css" rel="stylesheet" />
	<link href="<%=basePath %>/uploadify/uploadify.css" type="text/css" rel="stylesheet" />
</head>

<body>

<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #contents-menu').addClass("in");
	$('#sidebar-nav #contents-menu #contents-huodong').addClass("active");
</script>
	<div class="header">

		<h1 class="page-title">活动列表</h1>
	</div>

	<ol class="breadcrumb">
		<li><a href="<%=adminPath %>/">首页</a></li>
		<li><a href="<%=adminPath %>/">内容管理</a></li>
		<li class="active">活动列表</li>
	</ol>

	<div class="container-fluid">
	
		<div class="row-fluid" style="margin-bottom:10px;">
			<div class="btn-toolbar" role="toolbar">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-primary" onclick="location.href='<%=adminPath %>/huodong/add'">
						<i class="fa fa-user-plus"></i>添加活动
					</button>
				</div>
				<!-- 
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default">导出</button>
				</div>
				-->
			</div>
		</div>
		<div class="row-fluid">
			<div class="well">
				<table class="table table-hover" style="margin-bottom: 0;">
					<thead>
						<tr>
							<th style="width: 55%">活动名称</th>
							<th style="width: 15%" class="text-center">开始时间</th>
							<th style="width: 15%" class="text-center">结束时间</th>
							<th style="width: 15%" class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${activits}" var="activit" begin="0" step="1">
							<tr>
								<td><a href="<%=basePath %>/huodong/${activit.aId}" target="_blank">${activit.aTitle}</a></td>
								<td class="text-center">${fn:substring(activit.aDatetimeStart, 0, 10)}</td>
								<td class="text-center">${fn:substring(activit.aDatetimeEnd, 0, 10)}</td>
								<td class="text-center">
									<a href="<%=adminPath %>/huodong/edit/${activit.aId}" title="编辑"><i class="fa fa-pencil"></i></a> 
									<a href="<%=adminPath %>/huodong/delete/${activit.aId}" title="删除"><i class="fa fa-remove"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav class="text-center" style="border-top: 1px solid #DDDDDD;">
					<ul class="pager">
						<li><a href="<%=adminPath %>/huodong/?page=${navigator.firstPage}">首页</a></li>
						<li><a href="<%=adminPath %>/huodong/?page=${navigator.prePage}">上一页</a></li>
						<li><a href="<%=adminPath %>/huodong/?page=${navigator.nextPage}">下一页</a></li>
						<li><a href="<%=adminPath %>/huodong/?page=${navigator.lastPage}">末页</a></li>
						<li>&nbsp;
							当前 ${navigator.nowPage}/${navigator.pageCount}页&nbsp;&nbsp;
							每页${navigator.pageSize}条&nbsp;&nbsp;
							共${navigator.count}条
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>