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
	<title>编辑链接</title>
</head>

<body>
<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #options-menu').addClass("in");
	$('#sidebar-nav #options-menu #options-link').addClass("active");
</script>
<div class="header">
	<h1 class="page-title">编辑链接</h1>
</div>

<ol class="breadcrumb">
	<li><a href="<%=adminPath %>/">首页</a></li>
	<li><a href="<%=adminPath %>/">链接管理</a></li>
	<li class="active">编辑链接</li>
</ol>

<div class="container-fluid">
	<div class="row-fluid" style="margin-bottom: 10px;">
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group" role="group">
				<button type="button" class="btn btn-primary" onclick="location.href='<%=adminPath %>/link/'">
					<i class="fa fa-user-plus"></i>返回链接列表
				</button>
			</div>
		</div>
	</div>
	<div class="row-fluid">
	  <div class="well">
      <div class="panel-body">
       	<form role="form" action="<%=adminPath %>/link/update" method="post">
       	  <input type="hidden" name="id" value="${link.lId }">
		  <div class="form-group">
		    <label for="link-name">显示名称</label>
		    <input type="text" class="form-control" id="link-name" name="name" value="${link.lName }" />
		  </div>
		  <div class="form-group">
		    <label for="link-url">链接地址</label>
		    <input type="text" class="form-control" id="link-url" name="url" value="${link.lUrl }" />
		  </div>
		  <div class="form-group">
		    <label for="link-type">链接类型</label>
		    <select class="form-control" id="link-type" name="type" >
			  <option value="1">友情链接</option>
			  <option value="2">站内链接</option>
			  <option value="3">校园链接</option>
			</select>
			<script type="text/javascript">
				$("#link-type option[value='${link.lType}']").attr("selected", "selected");
			</script>
		  </div>
		  <div class="form-group">
		    <label for="link-target">打开位置</label>
		    <select class="form-control" id="link-target" name="target">
			  <option value="_self">当前窗口</option>
			  <option value="_blank">新窗口</option>
			  <option value="_parent">父窗口</option>
			</select>
			<script type="text/javascript">
				$("#link-target option[value='${link.lTarget}']").attr("selected", "selected");
			</script>
		  </div>
		  <div class="form-group">
		    <label for="link-sort">排序</label>
		    <input type="text" class="form-control" id="link-sort" name="sort" value="${link.lSort }" />
		  </div>
		  <button type="submit" class="btn btn-primary">保存</button>
		</form>
		
       		</div>
		</div>
	</div>
</div>
</body>
</html>