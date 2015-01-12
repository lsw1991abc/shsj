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
	<title>修改密码</title>
</head>

<body>
	<div class="user-cp-item user-password">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">修改密码</h3>
			</div>
			<div class="panel-body">
			<form class="form-horizontal" id="password-form" role="form" action="<%=basePath%>/user/passwd" method="post">
				<c:if test="${msg eq 'success'}">
					<div class="alert alert-success" role="alert">修改成功</div>
				</c:if>
				<c:if test="${msg eq 'error'}">
					<div class="alert alert-danger" role="alert">修改失败</div>
				</c:if>
				<div id="olddescription"></div>
				<div id="newdescription"></div>
				<div id="new2description"></div>
				<div class="form-group">
					<label for="inputPassword_old">原始密码：</label> 
					<input type="password" class="form-control" id="inputPassword_old" placeholder="原始密码"
								data-required="true" data-pattern="^[a-z0-9A-Z_]{6,32}$" name="oldPasswd"
								data-describedby="olddescription" data-description="oldpassword" />
				</div>
				<div class="form-group">
					<label for="inputPassword_new">新密码：</label> 
					<input type="password" class="form-control" id="inputPassword_new" placeholder="新密码，长度6～32"
								data-required="true" data-pattern="^[a-z0-9A-Z_]{6,32}$" name="newPasswd1"
								data-describedby="newdescription" data-description="newpassword" />
				</div>
				<div class="form-group">
					<label for="inputPassword_new2">确认密码：</label> 
					<input type="password" class="form-control" id="inputPassword_new2" placeholder="确认密码，长度6～32"
								data-required="true" data-pattern="^[a-z0-9A-Z_]{6,32}$" name="newPasswd2" data-conditional="new2password"
								data-describedby="new2description" data-description="new2password" />
				</div>
				<button type="submit" class="btn btn-primary">提交修改</button>
			</form>
		</div>
	</div>
</div>
<style type="text/css">
	#password-form .form-group{ margin-left:0; margin-right:0;}
</style>
<script type="text/javascript" src="<%=basePath%>/script/jquery/jquery-validate.js"></script>
<script type="text/javascript">
$(function() {
	$('#password-form').validate({
			onKeyup : true,
			eachValidField : function() {
				$(this).closest('div').removeClass('has-error').addClass('has-success');
			},
			eachInvalidField : function() {
				$(this).closest('div').removeClass('has-success').addClass('has-error');
			},
			description : {
				oldpassword : {
					required : '<div class="alert alert-danger">原始密码不能为空</div>',
					pattern : '<div class="alert alert-danger">原始密码长度6～32</div>',
				}, 
				newpassword : {
					required : '<div class="alert alert-danger">新密码不能为空</div>',
					pattern : '<div class="alert alert-danger">新密码长度6～32</div>',
				}, 
				new2password : {
					required : '<div class="alert alert-danger">确认密码不能为空</div>',
					pattern : '<div class="alert alert-danger">确认密码长度6～32</div>',
					conditional : '<div class="alert alert-danger">两次输入密码不一致</div>',
			},
			conditional : {
				new2password : function() {
					return $(this).val() == $('#inputPassword_new').val();
				}
			}
		}
	});
});
</script>
</body>
</html>
