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
	<title>添加公告</title>
</head>

<body>
<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #contents-menu').addClass("in");
	$('#sidebar-nav #contents-menu #contents-zhaopin').addClass("active");
</script>
<div class="header">
	<h1 class="page-title">添加公告</h1>
</div>

<ol class="breadcrumb">
	<li><a href="<%=adminPath %>/">首页</a></li>
	<li><a href="<%=adminPath %>/">内容管理</a></li>
	<li><a href="<%=adminPath %>/gonggao">公告管理</a></li>
	<li class="active">添加公告</li>
</ol>

<div class="container-fluid">
	<div class="row-fluid" style="margin-bottom: 10px;">
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group" role="group">
				<button type="button" class="btn btn-primary" onclick="location.href='<%=adminPath %>/gonggao/'">
					<i class="fa fa-user-plus"></i>返回公告列表
				</button>
			</div>
		</div>
	</div>
	<div class="row-fluid">
	  <div class="well">
		<!-- 错误提示信息 -->
		<div id="title-description"></div>      
      <div class="panel-body">
       	<form role="form" action="<%=adminPath %>/gonggao/save" method="post" id="notice-form">
       	
		  <div class="form-group">
		    <label for="notice-title">标题</label>
		    <input type="text" class="form-control" id="notice-title" name="title" placeholder="标题长度1～50"
		    			data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,50}$"
						data-describedby="title-description" data-description="title" />
		  </div>
		  <div class="form-group">
		    <label for="notice-content">内容</label>
		    <textarea class="form-control" rows="3" style="resize:vertical;" id="notice-content" name="content"></textarea>
		  </div>
		  <button type="submit" class="btn btn-primary">发布</button>
		</form>
		
		<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script>  
		<script type="text/javascript" src="<%=basePath%>/script/jquery/jquery-validate.js"></script>
		<script type="text/javascript">
			$(function() {
				CKEDITOR.replace('notice-content', {
					customConfig : '<%=basePath%>/ckeditor/daily-edit-config.js' 
				});
				
				$('#notice-form').validate({
					onKeyup : true,
					eachValidField : function() {
						$(this).closest('div').removeClass('has-error').addClass('has-success');
					},
					eachInvalidField : function() {
						$(this).closest('div').removeClass('has-success').addClass('has-error');
					},
					description : {
						title : {
							required : '<div class="alert alert-danger">标题不能为空</div>',
							pattern : '<div class="alert alert-danger">标题长度1～50</div>'
						}
					}
				});
			});
		</script>
       		</div>
		</div>
	</div>
</div>
</body>
</html>