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
<title>用户登录</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div style="border: 1px solid #DFDFDF;">
					<h2 class="text-center"
						style="background: #F9F9F9; margin: 0; height: 70px; line-height: 70px; border-bottom: 1px solid #E9E9E9;">用户登录</h2>
					<div style="width: 600px; margin: 50px auto;">
						<form class="form-horizontal" role="form"
							action="<%=basePath%>/login/login" method="post">
							<div class="form-group">
								<label for="inputUsername" class="col-md-2 control-label">用户名</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="inputUsername"
										placeholder="用户名" name="username" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-md-2 control-label">密码</label>
								<div class="col-md-10">
									<input type="password" class="form-control" id="inputPassword"
										placeholder="密码" name="password" />
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
</body>
</html>
