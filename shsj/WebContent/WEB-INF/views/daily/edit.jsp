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
	<title>编辑日志</title>
</head>

<body>
	<div class="user-cp-item user-password">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">编辑日志</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" id="daily-form" role="form"
					action="<%=basePath%>/user/rizhi/save" method="post">
					<c:if test="${msg eq 'success'}">
						<div class="alert alert-success" role="alert">修改成功</div>
					</c:if>
					<c:if test="${msg eq 'error'}">
						<div class="alert alert-danger" role="alert">修改失败</div>
					</c:if>
					<div id="dailyTitle-description"></div>
					<div class="form-group" style="margin-left:0; margin-right:0;">
						<div class="input-group">
							<div class="input-group-addon">标题</div>
							<input type="text" class="form-control" id="daily_title"
								placeholder="标题长度1~50" value="${daily.nTitle}" data-required="true"
								data-pattern="^\w{1,50}$" name="title"
								data-describedby="dailyTitle-description"
								data-description="dailyTitle" />
						</div>
					</div>
					<div class="lead daily_content">
						<textarea class="form-control" rows="8" cols="100" style="resize: vertical;" id="daily_content" name="content">${daily.nDesc}</textarea>
					</div>
					<p class="text-center">
						<input type="hidden" name="id" value="${daily.nId}" />
						<button type="submit" class="btn btn-primary">保存</button>
					</p>
				</form>
			</div>
		</div>

	</div>
	<script type="text/javascript" src="<%=basePath%>/script/jquery/jquery-validate.js"></script>
	<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script>   
	<script type="text/javascript">
$(function() {
	CKEDITOR.replace('daily_content', {
		customConfig : '<%=basePath%>/ckeditor/daily-edit-config.js' 
	});
	$('#daily-form').validate({
			onKeyup : true,
			eachValidField : function() {
				$(this).closest('div').removeClass('has-error').addClass('has-success');
			},
			eachInvalidField : function() {
				$(this).closest('div').removeClass('has-success').addClass('has-error');
			},
			description : {
				dailyTitle : {
					required : '<div class="alert alert-danger">标题不能为空</div>',
					pattern : '<div class="alert alert-danger">标题长度1～50</div>',
				}
			}
		});
	});
</script>
</body>
</html>
