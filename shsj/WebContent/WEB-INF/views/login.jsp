<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<title>用户登录</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div style="border: 1px solid #DFDFDF;">
					<h2 class="text-center" style="background: #F9F9F9; margin: 0; height: 70px; line-height: 70px; border-bottom: 1px solid #E9E9E9;">用户登录</h2>
					<div style="width: 600px; margin: 50px auto;">
						<form class="form-horizontal" id="login-form" role="form" action="<%=basePath%>/login/login" method="post">
							<div id="result-msg">
								<c:if test="${msg eq 'error1'}">
									<div class="alert alert-danger">验证码错误</div>
								</c:if>
								<c:if test="${msg eq 'error2'}">
									<div class="alert alert-danger">用户名或密码错误</div>
								</c:if>
							</div>
							<!-- 错误信息提示 -->
							<div id="username-description"></div>
							<div id="password-description"></div>
							<div id="verifyCode-description"></div>
							
							<div class="form-group">
								<label for="inputUsername" class="col-md-2 control-label">用户名</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="inputUsername" name="username" 
										data-required="true" data-pattern="^[a-z0-9A-Z_]{6,32}$"
										data-describedby="username-description" data-description="username"  placeholder="用户名" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-md-2 control-label">密码</label>
								<div class="col-md-10">
									<input type="password" class="form-control" id="inputPassword" name="password" 
										data-required="true" data-pattern="^[a-z0-9A-Z_]{6,32}$"
										data-describedby="password-description" data-description="password" placeholder="密码" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-md-2 control-label">验证码</label>
								<div class="col-md-5">
									<input type="text" class="form-control" id="inputVerifyCode" name="verifyCode"
										data-required="true" data-pattern="^[a-z0-9A-Z_]{4}$"
										data-describedby="verifyCode-description" data-description="verifyCode" placeholder="验证码长度4" />
								</div>
								<div class="col-md-5">
									<img id="verifycode" src="#" alt="验证码" title="点击刷新" style="cursor:pointer;"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-offset-2 col-md-10">
									<button type="submit" class="btn btn-primary">登录</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="javascript:alert('功能开发中');">忘记密码？</a>&nbsp;&nbsp;还没有帐号？<a
										href="<%=basePath%>/login/register">注册&gt;&gt;</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="<%=basePath%>/script/jquery/jquery-validate.js"></script>
<script type="text/javascript">
	$("#verifycode").click(function() {
		var timeNow = new Date().getTime();
	    this.src="<%=basePath%>/login/verifyCode?time="+timeNow;
	});
	$(function() {
		$("#verifycode").click();
		$('#login-form').validate({
				onKeyup : true,
				eachValidField : function() {
					$(this).closest('div').removeClass('has-error').addClass('has-success');
				},
				eachInvalidField : function() {
					$(this).closest('div').removeClass('has-success').addClass('has-error');
				},
				description : {
					username : {
						required : '<div class="alert alert-danger">用户名不能为空</div>',
						pattern : '<div class="alert alert-danger">用户名长度6～32</div>'
					},
					password : {
						required : '<div class="alert alert-danger">密码不能为空</div>',
						pattern : '<div class="alert alert-danger">密码长度6～32</div>'
					},
					verifyCode : {
						required : '<div class="alert alert-danger">验证码不能为空</div>',
						pattern : '<div class="alert alert-danger">验证码长度4</div>'
					}
				}
			});
	});
</script>
</body>
</html>
