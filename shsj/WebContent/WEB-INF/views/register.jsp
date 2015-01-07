<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
<title>用户注册</title>
<script type="text/javascript" src="<%=basePath%>/script/jquery/jquery-validate.js"></script>
<script type="text/javascript">
$(function() {
	$('#register-form').validate({
		onKeyup : true,
		sendForm : false,
		eachValidField : function() {
			$(this).closest('div').removeClass('has-error').addClass('has-success');
		},
		eachInvalidField : function() {

			$(this).closest('div').removeClass('has-success').addClass('has-error');
		},
		description : {
			qq : {
				required : '<div class="alert alert-danger">Required</div>',
				pattern : '<div class="alert alert-danger">Pattern</div>',
				conditional : '<div class="alert alert-danger">Conditional</div>',
				valid : '<div class="alert alert-success">Valid</div>'
			}
		}
	});
});
</script>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div style="border: 1px solid #DFDFDF;">
					<h2 class="text-center"
						style="background: #F9F9F9; margin: 0; height: 70px; line-height: 70px; border-bottom: 1px solid #E9E9E9;">用户注册</h2>
					<div style="width: 600px; margin: 35px auto;">
						<form class="form-horizontal" id="register-form" role="form">
							<!--</form>action="<%=basePath%>/login/reg" method="post"-->
							<div class="form-group">
								<label for="inputUsername" class="col-md-2 control-label">用户名<span
									style="color: #f00;">*</span></label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="inputUsername"
										placeholder="用户名" name="username" maxlength="32" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-md-2 control-label">密码<span
									style="color: #f00;">*</span></label>
								<div class="col-md-10">
									<input type="password" class="form-control" id="inputPassword"
										placeholder="密码" name="password" maxlength="32" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword2" class="col-md-2 control-label">确认密码<span
									style="color: #f00;">*</span></label>
								<div class="col-md-10">
									<input type="password" class="form-control" id="inputPassword2"
										placeholder="确认密码" name="password2" max="32" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputQQ" class="col-md-2 control-label">QQ帐号</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="qq" placeholder="QQ帐号" 
									name="qq" data-required="true" data-pattern="^[0-9]+$" minlength="5" 
									data-describedby="qq-description" data-description="qq" />
									<div id="qq-description"></div>
								</div>
								
							</div>
							<div class="form-group">
								<label for="inputPhoneno" class="col-md-2 control-label">手机号码</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="inputPhoneno" placeholder="手机号码" name="phoneno" max="11" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-md-2 control-label">邮箱地址</label>
								<div class="col-md-10">
									<input type="email" class="form-control" id="inputEmail"
										placeholder="邮箱地址" name="email" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-offset-2 col-md-10">
									<button type="submit" class="btn btn-primary">注册</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 已有帐号，<a
										href="<%=basePath%>/login/">登录&gt;&gt;</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
