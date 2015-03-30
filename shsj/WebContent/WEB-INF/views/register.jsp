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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户注册</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div style="border: 1px solid #DFDFDF;">
					<h2 class="text-center" style="background: #F9F9F9; margin: 0; height: 70px; line-height: 70px; border-bottom: 1px solid #E9E9E9;">用户注册</h2>
					<div style="width: 600px; margin: 35px auto;">
						<form class="form-horizontal" id="register-form" role="form" action="<%=basePath%>/login/reg" method="post">
							<div id="result-msg">
								<c:choose>
									<c:when test="${msg eq 'success'}">
										<div class="alert alert-success">注册成功，去<a href="<%=basePath%>/login/" class="alert-link">登录&gt;&gt;</a></div>
									</c:when>
									<c:when test="${msg eq 'error'}">
										<div class="alert alert-danger">注册失败</div>
									</c:when>
									<c:when test="${msg eq 'error1'}">
										<div class="alert alert-danger">验证码错误</div>
									</c:when>
									<c:when test="${msg eq 'error2'}">
										<div class="alert alert-danger">用户名已存在</div>
									</c:when>
								</c:choose>
							</div>
							<div id="username-description"></div>
							<div id="password-description"></div>
							<div id="password2-description"></div>
							<div id="qq-description"></div>
							<div id="phoneno-description"></div>
							<div id="email-description"></div>
							<div class="form-group">
								<label for="inputUsername" class="col-md-2 control-label">用户名<span style="color: #f00;">*</span></label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="inputUsername"
										data-required="true" data-pattern="^[a-z0-9A-Z_]{6,32}$"
										data-describedby="username-description" data-description="username"  placeholder="长度6～32" name="username" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-md-2 control-label">密码<span style="color: #f00;">*</span></label>
								<div class="col-md-10">
									<input type="password" class="form-control" id="inputPassword"
										data-required="true" data-pattern="^[a-z0-9A-Z_]{6,32}$"
										data-describedby="password-description" data-description="password" placeholder="长度6～32" name="password" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword2" class="col-md-2 control-label">确认密码<span style="color: #f00;">*</span></label>
								<div class="col-md-10">
									<input type="password" class="form-control" id="inputPassword2"
										data-required="true" data-pattern="^[a-z0-9A-Z_]{6,32}$" data-conditional="password2"
										data-describedby="password2-description" data-description="password2" placeholder="长度6～32" name="password2" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputQQ" class="col-md-2 control-label">QQ帐号</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="qq"
										placeholder="长度5～12" name="qq" data-pattern="^[1-9][0-9]{4,11}$"
										data-describedby="qq-description" data-description="qq" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPhoneno" class="col-md-2 control-label">手机号码</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="inputPhoneno"
										placeholder="长度11" name="phoneno" data-pattern="^[1][3-8][0-9]{9}$"
										data-describedby="phoneno-description" data-description="phoneno"  />
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-md-2 control-label">邮箱地址</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="inputEmail"
										placeholder="示例:username@shsj.com" name="email" data-pattern="^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"
										data-describedby="email-description" data-description="email"  />
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
									<button type="submit" class="btn btn-primary">注册</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									已有帐号，<a href="<%=basePath%>/login/">登录&gt;&gt;</a>
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
		$('#register-form').validate({
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
					password2 : {
						required : '<div class="alert alert-danger">确认密码不能为空</div>',
						pattern : '<div class="alert alert-danger">确认密码长度6～32</div>',
						conditional : '<div class="alert alert-danger">两次输入密码不一致</div>'
					}, 
					qq : {
						pattern : '<div class="alert alert-danger">您输入的QQ不合法</div>',
					},
					phoneno : {
						pattern : '<div class="alert alert-danger">您输入的手机号码不合法</div>'
					}, 
					email : {
						pattern : '<div class="alert alert-danger">您输入的Email不合法</div>'
					}
				},
				conditional : {
					password2 : function() {
						return $(this).val() == $('#inputPassword').val();
					}
				}
			});
	});
</script>
</body>
</html>
