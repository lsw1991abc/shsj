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
	<title>添加招聘</title>
	<link href="<%=basePath %>/jquery-ui-1.11.2/jquery-ui.css" type="text/css" rel="stylesheet" />
</head>

<body>
<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #contents-menu').addClass("in");
	$('#sidebar-nav #contents-menu #contents-zhaopin').addClass("active");
</script>
<div class="header">
	<h1 class="page-title">添加招聘</h1>
</div>

<ol class="breadcrumb">
	<li><a href="<%=adminPath %>/">首页</a></li>
	<li><a href="<%=adminPath %>/">内容管理</a></li>
	<li><a href="<%=adminPath %>/zhaopin">招聘管理</a></li>
	<li class="active">添加招聘</li>
</ol>

<div class="container-fluid">
	<div class="row-fluid" style="margin-bottom: 10px;">
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group" role="group">
				<button type="button" class="btn btn-primary" onclick="location.href='<%=adminPath %>/zhaopin/'">
					<i class="fa fa-user-plus"></i>返回招聘列表
				</button>
			</div>
		</div>
	</div>
	<div class="row-fluid">
	  <div class="well">
		<!-- 错误提示信息 -->
       <div id="organizer-description"></div>
       <div id="title-description"></div>
       <div id="place-description"></div>
       <div id="salary-description"></div>
       <div id="datetime-work-description"></div>
       <div id="number-description"></div>
       <div id="number-limit-description"></div>
       <div id="contact-description"></div>
       <div id="datetime-start-description"></div>
       <div id="datetime-end-description"></div>
       <div id="audition-place-description"></div>
      
      <div class="panel-body">
       	<form role="form" action="<%=basePath%>/admin/zhaopin/save" method="post" id="job-form">
       		<table style="width: 100%;" class="form-table">
       			<tr style="height:32px; line-height:32px;">
       				<td style="width:10%; padding-bottom:15px;">招聘单位：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" 
				    		id="job_organnizer" name="organnizer" placeholder="名称长度1～50"
				    		data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,50}$" 
				    		data-describedby="organnizer-description" data-description="organnizer" />
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">职位名称：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" 
				    		id="job_title" name="title" placeholder="名称长度1～50"
							data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,50}$" 
				    		data-describedby="title-description" data-description="title" />
						 </div>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">职位分类：</td>
       				<td style="width:40%;">
       					<div class="form-group">
       						<select class="form-control" style="width:75%;" 
       						id="job_belong"  name="belong" >
       							<c:forEach items="${belongs}" var="belong">
       								<option value="${belong.jb_id}">${belong.jb_name}</option>
       							</c:forEach>
							</select>
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">工作类型：</td>
       				<td style="width:40%;">
       					<div class="form-group" >
       						<select class="form-control" style="width:75%;" id="job_type"  name="type" >
							  <option value="1">全职</option>
							  <option value="2">兼职</option>
							</select>
						 </div>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">工作区域：</td>
       				<td style="width:90%;" colspan="3">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:89%;" 
				    		id="job_place"  name="place" placeholder="地址长度1～100"
							data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,100}$" 
				    		data-describedby="place-description" data-description="place" />
						 </div>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">工作待遇：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" 
				    		id="job_salary"  name="salary" placeholder="工作待遇，长度1～50" 
				    		data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,50}$" 
				    		data-describedby="salary-description" data-description="salary" />
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">工作时间：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" 
				    		id="job_datetime-work"  name="datetime-work" placeholder="工作时间，长度1～50"
				    		data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,50}$" 
				    		data-describedby="datetime-work-description" data-description="datetimeWork" />
						 </div>
					 </td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">招聘人数：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" 
				    		id="job_number"  name="number" placeholder="人数0～999" 
				    		data-required="true" data-pattern="^[0-9]{1,3}$" 
							data-describedby="number-description" data-description="number"  />
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">人数限制：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" 
				    		id="job_number-limit"  name="number-limit" placeholder="限制人数0～999" 
				    		data-required="true" data-pattern="^[0-9]{1,3}$" 
							data-describedby="number-limit-description" data-description="numberLimit"  />
						 </div>
					</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">联系电话：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" 
				    		id="job_contact"  name="contact" placeholder="长度11" 
				    		data-required="true" data-pattern="^[1][3-8][0-9]{9}$" 
				    		data-describedby="contact-description" data-description="contact"  />
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">面试时间：</td>
       				<td style="width:40%;">
       					<div class="form-group" style="margin-top:-15px;">
				    		<input type="text" class="form-control" style="width:35%; display:block; float:left;" 
				    		readonly="readonly" id="job-datetime-start"  name="datetime-start" placeholder="开始时间" 
				    		data-required="true" data-pattern="^[0-9]{4}-[0-9]{2}-[0-9]{2}$" 
							data-describedby="datetime-start-description" data-description="datetimeStart" />
				    		
				    		<span style="display:block; float:left; width:15px; text-align:center;">~</span>
				    		<input type="text" class="form-control" style="width:35%;display:block; float:left;" 
				    		readonly="readonly" id="job-datetime-end"  name="datetime-end" placeholder="结束时间" 
				    		data-required="true" data-pattern="^[0-9]{4}-[0-9]{2}-[0-9]{2}$" 
							data-describedby="datetime-end-description" data-description="datetimeEnd" />
				    		
				    		<br style="clean:both;" />
						 </div>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">面试地址：</td>
       				<td style="width:90%;" colspan="3">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:89%;" 
				    		id="job_audition-place"  name="audition-place" placeholder="地址长度1～100"
							data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,100}$" 
				    		data-describedby="audition-place-description" data-description="auditionPlace" />
						 </div>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">工作详情：</td>
       				<td style="width:90%;" colspan="3">
       					<textarea rows="3" style="width:89%;resize:vertical;" name="content" id="job-content"></textarea>
       				</td>
       			</tr>
       		</table>
		  <button type="submit" class="btn btn-primary">发布</button>
		</form>
   		<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script> 
   		<script type="text/javascript" src="<%=basePath%>/script/jquery/jquery-validate.js"></script>
   		<script type="text/javascript" src="<%=basePath%>/jquery-ui-1.11.2/jquery-ui.js"></script> 
   		<script type="text/javascript">
   			$(function(){
   				CKEDITOR.replace('job-content', {
   					customConfig : '<%=basePath%>/ckeditor/job-edit-config.js' 
   				});
   				
   				$( "#job-datetime-start" ).datepicker({
   					inline: true
   				});
   				$( "#job-datetime-end" ).datepicker({
   					inline: true
   				});
   				
   				$('#job-form').validate({
   					onKeyup : true,
   					eachValidField : function() {
   						$(this).closest('div').removeClass('has-error').addClass('has-success');
   					},
   					eachInvalidField : function() {
   						$(this).closest('div').removeClass('has-success').addClass('has-error');
   					},
   					description : {
						organizer:{
							required : '<div class="alert alert-danger">招聘单位不能为空</div>',
							pattern : '<div class="alert alert-danger">招聘单位长度1～50</div>'
						},
						title : {
							required : '<div class="alert alert-danger">职位名称不能为空</div>',
							pattern : '<div class="alert alert-danger">职位名称长度1～50</div>'
						},
						place: {
							required : '<div class="alert alert-danger">工作地址不能为空</div>',
							pattern : '<div class="alert alert-danger">工作地址长度1～100</div>'
						},
						salary: {
							required : '<div class="alert alert-danger">工作待遇不能为空</div>',
							pattern : '<div class="alert alert-danger">工作待遇长度1～50</div>'
						},
						datetimeWork: {
							required : '<div class="alert alert-danger">工作时间不能为空</div>',
							pattern : '<div class="alert alert-danger">工作时间长度1～50</div>'
						},
						number: {
							required : '<div class="alert alert-danger">招聘人数不能为空</div>',
							pattern : '<div class="alert alert-danger">招聘人数0～999</div>'
						},
						numberLimit: {
							required : '<div class="alert alert-danger">人数限制不能为空</div>',
							pattern : '<div class="alert alert-danger">人数限制0～999</div>'
						},
						contact: {
							required : '<div class="alert alert-danger">联系电话不能为空</div>',
							pattern : '<div class="alert alert-danger">联系电话长度11</div>'
						},
						datetimeStart: {
							required : '<div class="alert alert-danger">面试开始时间不能为空</div>'
						},
						datetimeEnd: {
							required : '<div class="alert alert-danger">面试结束时间不能为空</div>'
						},
						auditionPlace: {
							required : '<div class="alert alert-danger">面试地址不能为空</div>',
							pattern : '<div class="alert alert-danger">面试地址长度1～100</div>'
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