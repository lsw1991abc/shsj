<%@page import="com.lssrc.cms.common.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	String adminPath = basePath + Constants.ADMIN_PATH;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><sitemesh:write property="title">管理平台</sitemesh:write> - WITCMS</title>
<link rel="shortcut icon" href="<%=basePath %>/images/favicon.ico" />
<link rel="stylesheet" href="<%=basePath %>/lib/bootstrap/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath %>/lib/font-awesome/css/font-awesome.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath %>/style/theme.css" type="text/css" />
<script src="<%=basePath %>/lib/jquery-1.11.1.js"></script>
<script src="<%=basePath %>/lib/bootstrap/js/bootstrap.js"></script>
<sitemesh:write property="head" />
<style type="text/css">
    #line-chart {
        height:300px;
        width:800px;
        margin: 0px auto;
        margin-top: 1em;
    }
    .brand { font-family: georgia, serif; }
    .brand .first {
        color: #ccc;
        font-style: italic;
    }
    .brand .second {
        color: #fff;
        font-weight: bold;
    }
</style>
</head>

<body>
	<div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                	<li style="padding: 10px 15px;">您好：admin，欢迎使用WITCMS!</li>
                	<li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">网站主页</a></li>
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">设置</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-user"></i> Carl Li
                            <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-right">
                            <li><a tabindex="-1" href="#">我的帐号</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="#">设置</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="<%=basePath %>/login/logout">退出</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="index.html"><span class="first">WIT</span> <span class="second">CMS</span></a>
        </div>
    </div>
    
    <div class="sidebar-nav" id="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-dashboard"></i>控制台</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li class="active"><a href="<%=adminPath%>/">首页</a></li>
            <!-- 
            <li ><a href="users.html">Sample List</a></li>
            <li ><a href="user.html">Sample Item</a></li>
            <li ><a href="media.html">Media</a></li>
            <li ><a href="calendar.html">Calendar</a></li>
             -->
        </ul>

        <a href="#contents-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-database"></i>内容管理<span class="label label-info">+3</span></a>
        <ul id="contents-menu" class="nav nav-list collapse">
            <li id="contents-huodong"><a href="<%=adminPath %>/huodong">活动管理</a></li>
            <li id="contents-zhaopin"><a href="<%=adminPath %>/zhaopin">招聘管理</a></li>
            <li id="contents-gonggao"><a href="<%=adminPath %>/gonggao">公告管理</a></li>
            <li id="contents-baodian"><a href="<%=adminPath %>/baodian">宝典管理</a></li>
        </ul>

        <a href="#users-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-users"></i>用户管理</a>
        <ul id="users-menu" class="nav nav-list collapse">
            <li id="users-list"><a href="<%=adminPath %>/user">用户列表</a></li>
            <li id="users-admins"><a href="<%=adminPath %>/user/admin">管理员列表</a></li>
            <!-- <li id="users-groups"><a href="<%=adminPath %>/user/group">用户组</a></li> -->
        </ul>
        <!-- 
        <a href="#pages-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-clipboard"></i>页面管理</a>
        <ul id="pages-menu" class="nav nav-list collapse">
            <li ><a href="privacy-policy.html">Privacy Policy</a></li>
            <li ><a href="terms-and-conditions.html">Terms and Conditions</a></li>
        </ul>

        <a href="#options-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-gears"></i>系统管理</a>
        <ul id="options-menu" class="nav nav-list collapse">
            <li ><a href="privacy-policy.html">基本设置</a></li>
            <li ><a href="terms-and-conditions.html">Terms and Conditions</a></li>
        </ul>
         -->
		<!-- 
        <a href="help.html" class="nav-header" ><i class="fa fa-question-circle"></i> 帮助</a>
        <a href="faq.html" class="nav-header" ><i class="fa fa-comment"></i>问答</a>
         -->
        <a href="<%=basePath %>/login/logout" class="nav-header" ><i class="fa fa-sign-out"></i>退出</a>
    </div>

	<div class="content">
		<sitemesh:write property="body" />
		<!-- 
		<div class="container-fluid">
			<div class="row-fluid">
				<footer>
					<hr>
					<p class="pull-right">
						<a href="http://www.lssrc.com/" target="_blank">WITCMS</a> by <a href="http://www.lssrc.com/" target="_blank">WIT TECH.</a>
					</p>
					<p>&copy; 2014 <a href="http://www.lssrc.com/" target="_blank">WITCMS</a></p>
				</footer>
			</div>
		</div>
		 -->
	</div>

	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>
</body>
</html>
