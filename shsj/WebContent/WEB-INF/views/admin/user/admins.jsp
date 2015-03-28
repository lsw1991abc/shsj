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
	<title>管理员列表</title>
</head>

<body>
<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #users-menu').addClass("in");
	$('#sidebar-nav #users-menu #users-admins').addClass("active");
</script>
<div class="header">
	<h1 class="page-title">管理员列表</h1>
</div>

<ol class="breadcrumb">
	<li><a href="<%=adminPath %>/">首页</a></li>
	<li><a href="<%=adminPath %>/">用户管理</a></li>
	<li class="active">管理员列表</li>
</ol>

<div class="container-fluid">
	<div class="row-fluid" style="margin-bottom:10px;">
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group" role="group">
				<button type="button" class="btn btn-primary" onclick="location.href='<%=adminPath %>/user/add'">
					<i class="fa fa-user-plus"></i>添加用户(可删除)
				</button>
			</div>
			<div class="btn-group" role="group">
				<button type="button" class="btn btn-default">导出</button>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="well">
			<table class="table table-striped">
         	<thead>
         		<tr>
         			<th style="width:25%;">用户名</th>
         			<th style="width:15%;" class="text-center">QQ</th>
         			<th style="width:15%;" class="text-center">电话</th>
         			<th style="width:15%;" class="text-center">E-mail</th>
         			<th style="width:15%;" class="text-center">注册时间</th>
         			<th style="width:15%;" class="text-center">操作</th>
         		</tr>
         	</thead>
         	<tbody>
	            <c:forEach var="user" items="${users}">
	              <tr>
                    <td style="width:25%;"><a href="<%=adminPath %>/user/${user.userId}" target="_blank">${user.username}</a></td>
                    <td style="width:15%;" class="text-center">${user.qq}</td>
                    <td style="width:15%;" class="text-center">${user.phoneno}</td>
                    <td style="width:15%;" class="text-center">${user.email}</td>
                    <td style="width:15%;" class="text-center">${fn:substring(user.buildDate, 0, 19)}</td>
                    <td style="width:15%;" class="text-center">
                    	<a href="<%=adminPath %>/user/edit/${user.userId}"><i class="fa fa-pencil"></i></a> 
						<a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-remove"></i></a>
					</td>
                  </tr>
	            </c:forEach>
	            </tbody>
              </table>
            	<nav class="text-center" style="border-top: 1px solid #DDDDDD;">
                  <ul class="pager">
                    <li><a href="<%=adminPath %>/user/admin?page=1">首页</a></li>
                      <li><a href="<%=adminPath %>/user/admin?page=${navigator.prePageNo}">上一页</a></li>
                      <li><a href="<%=adminPath %>/user/admin?page=${navigator.nextPageNo}">下一页</a></li>
                      <li><a href="<%=adminPath %>/user/admin?page=${navigator.pageCount}">末页</a></li>
                      <li>&nbsp;当前 ${navigator.nowPageNo}/${navigator.pageCount} 页&nbsp;&nbsp;每页${navigator.pageSize}条&nbsp;&nbsp;共${navigator.count}条</li>
                  </ul>
                </nav>
		</div>
	</div>
</div>
</body>
</html>