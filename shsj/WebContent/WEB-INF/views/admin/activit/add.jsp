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
	<title>添加活动</title>
	<link href="<%=basePath %>/jquery-ui-1.11.2/jquery-ui.css" type="text/css" rel="stylesheet" />
	<link href="<%=basePath %>/uploadify/uploadify.css" type="text/css" rel="stylesheet" />
</head>

<body>
<script type="text/javascript">
	$('#sidebar-nav ul').removeClass("in");
	$('#sidebar-nav #contents-menu').addClass("in");
	$('#sidebar-nav #contents-menu #contents-huodong').addClass("active");
</script>
	<div class="header">

		<h1 class="page-title">添加活动</h1>
	</div>

	<ol class="breadcrumb">
		<li><a href="<%=adminPath %>/">首页</a></li>
		<li><a href="<%=adminPath %>/">内容管理</a></li>
		<li><a href="<%=adminPath %>/huodong">活动管理</a></li>
		<li class="active">添加活动</li>
	</ol>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="btn-toolbar" role="toolbar">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-primary"
						onclick="location.href='<%=adminPath %>/huodong/'">
						<i class="fa fa-user-plus"></i>返回活动列表
					</button>
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<div class="well" style="margin-top: 10px;">
				<!-- 错误提示信息 -->
		       <div id="title-description"></div>
		       <div id="organizer-description"></div>
		       <div id="plotter-description"></div>
		       <div id="number-description"></div>
		       <div id="datetime-start-description"></div>
		       <div id="datetime-end-description"></div>
       
		       <div class="panel-body">
		       	<form role="form" action="<%=adminPath %>/huodong/save" method="post" id="activit-form">
					<table style="width: 100%;" class="form-table">
						<tr style="height: 32px; line-height: 32px;">
							<td style="width: 10%; padding-bottom: 15px;">标题：</td>
							<td style="width: 90%;" colspan="3">
								<div class="form-group">
									<input type="text" class="form-control" style="width: 89%;" id="activit-title" name="title" placeholder="标题长度1～50" 
										data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,50}$"
										data-describedby="title-description" data-description="title" />
								</div>
							</td>
						</tr>
						<tr style="height: 32px; line-height: 32px;">
							<td style="width: 10%; padding-bottom: 15px;">主办单位：</td>
							<td style="width: 40%;">
								<div class="form-group">
									<input type="text" class="form-control" style="width: 85%;" id="activit-organizer" name="organizer" placeholder="长度1～50" 
										data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,50}$"
										data-describedby="organizer-description" data-description="organizer" />
								</div>
							</td>
							<td style="width: 10%; padding-bottom: 15px;">活动策划：</td>
							<td style="width: 40%;">
								<div class="form-group">
									<input type="text" class="form-control" style="width: 75%;" id="activit-plotter" name="plotter" placeholder="长度1～50"
										data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,50}$"
										data-describedby="plotter-description" data-description="plotter" />
								</div>
							</td>
						</tr>
						<tr style="height: 32px; line-height: 32px;">
							<td style="width: 10%; padding-bottom: 15px;">参与人数：</td>
							<td style="width: 40%; padding-bottom: 15px;">
								<div class="input-group" style="width: 85%;">
									<input type="text" class="form-control" 
									id="activit-number" name="number" placeholder="人数0～999" 
									data-required="true" data-pattern="^[0-9]{1,3}$" 
									data-describedby="number-description" data-description="number" />
									<div class="input-group-addon">人</div>
								</div>
							</td>
							<td style="width: 10%; padding-bottom: 15px;">活动状态：</td>
							<td style="width: 40%;">
								<div class="form-group">
									<select class="form-control" style="width: 75%;"
										id="activit-statu" name="statu">
										<c:forEach items="${status }" var="statu">
											<option value="${statu.as_id}">${statu.as_name}</option>
										</c:forEach>
									</select>
								</div>
							</td>
						</tr>
						<tr style="height: 32px; line-height: 32px;">
							<td style="width: 10%; padding-bottom: 15px;">活动日期：</td>
							<td style="width: 90%;" colspan="3">
								<div class="form-group">
									<input type="text" class="form-control" style="width: 35%; display: block; float: left;"
										readonly="readonly" id="activit-datetime-start" name="datetime-start" placeholder="开始时间"
										data-required="true" data-pattern="^[0-9]{4}-[0-9]{2}-[0-9]{2}$" 
										data-describedby="datetime-start-description" data-description="datetimeStart" /> 
									<span style="display: block; float: left; width: 15px; text-align: center;">~</span>
									<input type="text" class="form-control" style="width: 35%; display: block; float: left;"
										readonly="readonly" id="activit-datetime-end" name="datetime-end" placeholder="结束时间"
										data-required="true" data-pattern="^[0-9]{4}-[0-9]{2}-[0-9]{2}$"
										data-describedby="datetime-end-description" data-description="datetimeEnd" />
									<br	style="clean: both;" />
								</div>
							</td>
						</tr>
						<tr>
							<td style="width: 10%;">活动详情：</td>
							<td style="width: 90%;" colspan="3"><textarea rows="3"
									style="resize: vertical;" name="content" id="activit-content"></textarea>
							</td>
						</tr>
						<tr>
							<td style="width: 10%;">图片：</td>
							<td style="width: 90%;" colspan="3">
								<div id="fileQueue"
									style="float: left; margin: 10px 10px 10px 0; width: 322px; height: 242px; border: 1px solid #000;">活动图片</div>
								<p style="float: left; margin-top: 100px; margin-left: 30px;">
									<input id="file-upload" name="file-upload" type="file" disabled="disabled" /> 
										<a href="javascript:$('#file-upload').uploadify('upload');">上传</a>|
									<a href="javascript:$('#file-upload').uploadify('cancel');">取消上传</a>
								</p> <input type="hidden" id="imgPath" name="imgPath" value="">
								<br style="clear: both;" />
							</td>
						</tr>
					</table>
					<button type="submit" class="btn btn-primary">发布</button>
				</form>
				<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script> 
				<script type="text/javascript" src="<%=basePath%>/jquery-ui-1.11.2/jquery-ui.js"></script> 
				<script type="text/javascript" src="<%=basePath%>/script/jquery/jquery-validate.js"></script>
				<script type="text/javascript" src="<%=basePath %>/uploadify/jquery.uploadify.js"></script>
		   		<script type="text/javascript">
		   			$(function(){
		   				CKEDITOR.replace('activit-content', {
		   					customConfig : '<%=basePath%>/ckeditor/job-edit-config.js' 
		   				});
		   				
		   				$( "#activit-datetime-start" ).datepicker({
		   					inline: true
		   				});
		   				$( "#activit-datetime-end" ).datepicker({
		   					inline: true
		   				});
		   				
		   				//校验数据
		   				$('#activit-form').validate({
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
								}, 
								organizer:{
									required : '<div class="alert alert-danger">主办单位不能为空</div>',
									pattern : '<div class="alert alert-danger">主办单位长度1～50</div>'
								}, 
								plotter:{
									required : '<div class="alert alert-danger">活动策划不能为空</div>',
									pattern : '<div class="alert alert-danger">活动策划长度1～50</div>'
								}, 
								number:{
									required : '<div class="alert alert-danger">人数不能为空</div>',
									pattern : '<div class="alert alert-danger">人数0～999</div>'
								}, 
								datetimeStart:{
									required : '<div class="alert alert-danger">开始时间不能为空</div>'
								}, 
								datetimeEnd:{
									required : '<div class="alert alert-danger">结束时间不能为空</div>'
								}
							}
						});
		   				
		   				setTimeout(function() {
		   					$("#file-upload").uploadify({
			   			        'debug' : false,
			   			        'auto':false,
			   			     	'multi':false,
			   			        'successTimeout':99999,
			   			        
			   			        'formData':{
			   			            'session':'<%=session.getId()%>'   			            
			   			        },
			   			        'swf': "<%=basePath %>/uploadify/uploadify.swf",
			   			        'buttonText' : '选择文件',
			   			        //不执行默认的onSelect事件
			   			        //'overrideEvents' : ['onDialogClose'],
			   			        'queueID':'fileQueue',
			   			        'fileObjName':'file',
			   			        'uploader':'<%=basePath %>/admin/huodong/img.json',
			   			        //浏览按钮的背景图片路径
			   			        //'buttonImage':'upbutton.gif',
			   			        //浏览按钮的宽度
			   			        'width':'100',
			   			        //浏览按钮的高度
			   			        'height':'32',
			   			        //expressInstall.swf文件的路径。
			   			        //'expressInstall':'expressInstall.swf',
			   			        //在浏览窗口底部的文件类型下拉菜单中显示的文本
			   			        //'fileTypeDesc':'支持的格式：',
			   			        //允许上传的文件后缀
			   			        'fileTypeExts':'*.jpg;*.jpeg;*.gif;*.png',
			   			        'fileSizeLimit':'2MB',
			   			        'queueSizeLimit' : 1,
			   			        //每次更新上载的文件的进展
			   			        'onUploadProgress' : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
			   			             //有时候上传进度什么想自己个性化控制，可以利用这个方法
			   			             //使用方法见官方说明
			   			        },
			   			        'onSelect' : function(file) {
			   			       		//选择上传文件后调用
			   			        },
			   			        'onSelectError':function(file, errorCode, errorMsg){
			   			            switch(errorCode) {
			   			                case -100:
			   			                    alert("上传的文件数量已经超出系统限制的"+$('#file-upload').uploadify('settings','queueSizeLimit')+"个文件！");
			   			                    break;
			   			                case -110:
			   			                    alert("文件 ["+file.name+"] 大小超出系统限制的"+$('#file-upload').uploadify('settings','fileSizeLimit')+"大小！");
			   			                    break;
			   			                case -120:
			   			                    alert("文件 ["+file.name+"] 大小异常！");
			   			                    break;
			   			                case -130:
			   			                    alert("文件 ["+file.name+"] 类型不正确！");
			   			                    break;
			   			            }
			   			        },
			   			        'onFallback':function(){
			   			            alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
			   			        },
			   			        'onUploadSuccess':function(file, data, response){
			   			        	var result = JSON.parse(data);
			   			        	var fileInfoDto = result.fileInfoDto;
			   			        	
			   			        	if(fileInfoDto.result == 'success') {
			   			        		$("#imgPath").val(fileInfoDto.path);
			   			        		var img = '<img src="<%=basePath %>/' + fileInfoDto.path + '" style="height:240px; width:320px;" />';
			   			        		$("#fileQueue").html(img);
			   			        	} else {
			   			        		alert("上传失败");
			   			        	}
			   			        }
			   			    });
		   				}, 10); 
		   			});
		   		</script>
		       </div>
			</div>
		</div>
	</div>
</body>
</html>