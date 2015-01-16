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
	<link rel="shortcut icon" href="<%=basePath %>/images/favicon.ico" />
	<title><sitemesh:write property="title">管理中心</sitemesh:write> - 大学生社会实践</title>
	<link rel="stylesheet" href="<%=basePath %>/style/bootstrap/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="<%=basePath %>/style/bootstrap/bootstrap-datetimepicker.min.css" type="text/css" />
	<script src="<%=basePath %>/script/jquery-1.11.1.js"></script>
	<script src="<%=basePath %>/script/bootstrap/bootstrap.min.js"></script>
	<script src="<%=basePath %>/script/bootstrap/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/lssrc/dateFormater.lssrc.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/jquery/jquery-validate.js"></script>
	<sitemesh:write property="head" />
</head>

<body>
<div class="container-fluid">
  	<div class="row">
    	<div class="col-md-12">
        	<h3>大学生社会实践中心管理平台&nbsp;&nbsp;&nbsp;&nbsp;<small>当前登录用户名：${myself.username}</small></h3>
        </div>
    </div>
    <div class="row">
      <div class="col-md-2">
        <ul class="list-unstyled admin-menu">
        	<li><a href="<%=basePath%>/admin">管理中心</a></li>
        	<li><a href="<%=basePath%>/admin/gonggao">公告管理</a></li>
            <li><a href="<%=basePath%>/admin/zhaopin">招聘管理</a></li>
            <li><a href="<%=basePath%>/admin/huodong">活动管理</a></li> 
            <li><a href="<%=basePath%>/user/">返回</a></li>
        </ul>
        <style type="text/css">
        	.admin-menu li{ height:45px; line-height:45px; text-indent:32px;}
        </style>
      </div>
      <sitemesh:write property="body" />
    </div>
  </div>
</body>
</html>
