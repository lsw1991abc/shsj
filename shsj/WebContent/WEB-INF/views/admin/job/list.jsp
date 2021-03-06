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
	<title>招聘列表</title>
	<link href="<%=basePath %>/jquery-ui-1.11.2/jquery-ui.css" type="text/css" rel="stylesheet" />
</head>

<body>
<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #contents-menu').addClass("in");
	$('#sidebar-nav #contents-menu #contents-zhaopin').addClass("active");
</script>
<div class="header">

	<h1 class="page-title">招聘列表</h1>
</div>

<ol class="breadcrumb">
	<li><a href="<%=adminPath %>/">首页</a></li>
	<li><a href="<%=adminPath %>/">内容管理</a></li>
	<li class="active">招聘列表</li>
</ol>

<div class="container-fluid">

	<div class="row-fluid" style="margin-bottom:10px;">
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group" role="group">
				<button type="button" class="btn btn-primary" onclick="location.href='<%=adminPath %>/zhaopin/add'">
					<i class="fa fa-user-plus"></i>添加招聘
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
         			<th style="width:40%;">标题</th>
         			<th style="width:15%;" class="text-center">职位</th>
         			<th style="width:15%;" class="text-center">地点</th>
         			<th style="width:15%;" class="text-center">时间</th>
         			<th style="width:15%;" class="text-center">操作</th>
         		</tr>
         	</thead>
         	<tbody>
	            <c:forEach var="job" items="${jobs}">
	              <tr>
	              	<c:choose>
	              		<c:when test="${job.job.jType == '1' || job.job.jType == '3'}">
	              			<td style="width:40%;">[${job.jobType.jtName}]<a href="<%=basePath%>/zhaopin/${job.job.jId}" target="_blank">${job.job.jTitle}</a></td>
	              		</c:when>
	              		<c:when test="${job.job.jType == '2'}">
	              			<td style="width:40%;">[${job.jobType.jtName}]<a href="<%=basePath%>/jianzhi/${job.job.jId}" target="_blank">${job.job.jTitle}</a></td>
	              		</c:when>
	              	</c:choose>
                    <td style="width:15%;" class="text-center">${job.jobBelong.jbName}</td>
                    <td style="width:15%;" class="text-center">${job.job.jWorkPlace}</td>
                    <td style="width:15%;" class="text-center">${fn:substring(job.job.jDatetimeBuild, 0, 10)}</td>
                    <td style="width:15%;" class="text-center">
                    	<a href="<%=adminPath %>/zhaopin/edit/${job.job.jId}" title="编辑"><i class="fa fa-pencil"></i></a> 
						<a href="<%=adminPath %>/zhaopin/delete/${job.job.jId}" title="删除"><i class="fa fa-remove"></i></a>
					</td>
                  </tr>
	            </c:forEach>
	            </tbody>
              </table>
           	<nav class="text-center" style="border-top: 1px solid #DDDDDD;">
                 <ul class="pager">
                   <li><a href="<%=adminPath %>/zhaopin/?page=${navigator.firstPage}">首页</a></li>
                     <li><a href="<%=adminPath %>/zhaopin/?page=${navigator.prePage}">上一页</a></li>
                     <li><a href="<%=adminPath %>/zhaopin/?page=${navigator.nextPage}">下一页</a></li>
                     <li><a href="<%=adminPath %>/zhaopin/?page=${navigator.lastPage}">末页</a></li>
                     <li>&nbsp;
                     	当前 ${navigator.nowPage}/${navigator.pageCount} 页&nbsp;&nbsp;
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