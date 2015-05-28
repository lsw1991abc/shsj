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
	<title>添加导航</title>
</head>

<body>
<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #options-menu').addClass("in");
	$('#sidebar-nav #options-menu #options-menu').addClass("active");
</script>
<div class="header">
	<h1 class="page-title">添加导航</h1>
</div>

<ol class="breadcrumb">
	<li><a href="<%=adminPath %>/">首页</a></li>
	<li><a href="<%=adminPath %>/">导航管理</a></li>
	<li class="active">添加导航</li>
</ol>

<div class="container-fluid">
	<div class="row-fluid" style="margin-bottom: 10px;">
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group" role="group">
				<button type="button" class="btn btn-primary" onclick="location.href='<%=adminPath %>/menu/'">
					<i class="fa fa-user-plus"></i>返回导航列表
				</button>
			</div>
		</div>
	</div>
	<div class="row-fluid">
	  <div class="well">
      <div class="panel-body">
       	<form role="form" action="<%=adminPath %>/menu/save" method="post">
		  <div class="form-group">
		    <label for="menu-name">显示名称</label>
		    <input type="text" class="form-control" id="menu-name" name="name" />
		  </div>
		  <div class="form-group">
		    <label for="menu-url">链接地址</label>
		    <input type="text" class="form-control" id="menu-url" name="url" />
		  </div>
		  <div class="form-group">
		    <label for="menu-type">链接类型</label>
		    <select class="form-control" id="menu-type" name="type">
			  <option value="1">站内链接</option>
			  <option value="2">站外链接</option>
			</select>
		  </div>
		  <div class="form-group">
		    <label for="menu-target">打开位置</label>
		    <select class="form-control" id="menu-target" name="target">
			  <option value="_self">当前窗口</option>
			  <option value="_blank">新窗口</option>
			  <option value="_parent">父窗口</option>
			</select>
		  </div>
		  <div class="form-group">
		    <label for="menu-sort">排序</label>
		    <input type="text" class="form-control" id="menu-sort" name="sort" />
		  </div>
		  <button type="submit" class="btn btn-primary">发布</button>
		</form>
		
       		</div>
		</div>
	</div>
</div>
</body>
</html>