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
	<title>链接管理</title>
</head>

<body>
<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #options-menu').addClass("in");
	$('#sidebar-nav #options-menu #options-link').addClass("active");
</script>
<div class="header">
	<h1 class="page-title">链接列表</h1>
</div>

<ol class="breadcrumb">
	<li><a href="<%=adminPath %>/">首页</a></li>
	<li><a href="<%=adminPath %>/">链接管理</a></li>
	<li class="active">链接列表</li>
</ol>

<div class="container-fluid">
	<div class="row-fluid" style="margin-bottom:10px;">
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group" role="group">
				<button type="button" class="btn btn-primary" onclick="location.href='<%=adminPath %>/link/add'">
					<i class="fa fa-user-plus"></i>添加链接
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
			<table class="table table-striped">
         	<thead>
         		<tr>
         			<th style="width:15%;">名称</th>
         			<th style="width:55%;" class="text-center">地址</th>
         			<th style="width:10%;" class="text-center">类型</th>
         			<th style="width:5%;" class="text-center">排序</th>
         			<th style="width:15%;" class="text-center">操作</th>
         		</tr>
         	</thead>
         	<tbody>
	            <c:forEach var="link" items="${links}">
	              <tr>
	              	<td style="width:15%;" class="text-center">${link.lName }</td>
	              	<td style="width:55%;" class="text-center">${link.lUrl }</td>
	              	<td style="width:10%;" class="text-center">
	              		<c:choose>
	              			<c:when test="${link.lType == 1}">友情链接</c:when>
	              			<c:when test="${link.lType == 2}">站内链接</c:when>
	              			<c:when test="${link.lType == 3}">校园链接</c:when>
	              		</c:choose>
	              	</td>
	              	<td style="width:5%;" class="text-center">${link.lSort }</td>
                    <td style="width:15%;" class="text-center">
                    	<a href="<%=adminPath %>/link/edit/${link.lId}" title="编辑"><i class="fa fa-pencil"></i></a> 
						<a href="<%=adminPath %>/link/delete/${link.lId}" title="删除"><i class="fa fa-remove"></i></a>
					</td>
                  </tr>
	            </c:forEach>
	            </tbody>
              </table>
		</div>
	</div>
</div>
</body>
</html>