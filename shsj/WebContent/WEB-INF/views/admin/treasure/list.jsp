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
	<title>宝典管理</title>
</head>

<body>
<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #contents-menu').addClass("in");
	$('#sidebar-nav #contents-menu #contents-baodian').addClass("active");
</script>
<div class="header">
	<h1 class="page-title">宝典列表</h1>
</div>

<ol class="breadcrumb">
	<li><a href="<%=adminPath %>/">首页</a></li>
	<li><a href="<%=adminPath %>/">内容管理</a></li>
	<li class="active">宝典列表</li>
</ol>

<div class="container-fluid">

	<div class="row-fluid" style="margin-bottom:10px;">
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group" role="group">
				<button type="button" class="btn btn-primary" onclick="location.href='<%=adminPath %>/baodian/add'">
					<i class="fa fa-user-plus"></i>添加宝典
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
         			<th style="width:70%;">标题</th>
         			<th style="width:15%;" class="text-center">时间</th>
         			<th style="width:15%;" class="text-center">操作</th>
         		</tr>
         	</thead>
         	<tbody>
	            <c:forEach var="notice" items="${notices}">
	              <tr>
                    <td style="width:70%;"><a href="<%=basePath%>/baodian/${notice.n_id}" target="_blank">${notice.n_title}</a></td>
                    <td style="width:15%;" class="text-center">${fn:substring(notice.n_datetime_build, 0, 19)}</td>
                    <td style="width:15%;" class="text-center">
                    	<a href="<%=adminPath %>/baodian/edit/${notice.n_id}" title="编辑"><i class="fa fa-pencil"></i></a> 
						<a href="<%=adminPath %>/baodian/delete/${notice.n_id}" title="删除"><i class="fa fa-remove"></i></a>
					</td>
                  </tr>
	            </c:forEach>
	            </tbody>
              </table>
            	<nav class="text-center" style="border-top: 1px solid #DDDDDD;">
                  <ul class="pager">
                    <li><a href="<%=adminPath %>/baodian/?page=1">首页</a></li>
                      <li><a href="<%=adminPath %>/baodian/?page=${navigator.prePageNo}">上一页</a></li>
                      <li><a href="<%=adminPath %>/baodian/?page=${navigator.nextPageNo}">下一页</a></li>
                      <li><a href="<%=adminPath %>/baodian/?page=${navigator.pageCount}">末页</a></li>
                      <li>&nbsp;
	                      当前 ${navigator.nowPageNo}/${navigator.pageCount} 页&nbsp;&nbsp;
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