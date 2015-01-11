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
	<link href="<%=basePath%>/style/bootstrap/bootstrap-switch.min.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<div class="user-cp-item user-password">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">修改密码</h3>
			</div>
			<div class="panel-body">
				<div style="display: none" class="alert alert-dismissible"
				role="alert">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
				</button>
				<strong>修改成功</strong>
			</div>
			<div class="form-group">
				<label for="inputPassword_old">原始密码：</label> <input type="password"
					class="form-control" id="inputPassword_old" placeholder="原始密码">
			</div>
			<div class="form-group">
				<label for="inputPassword_new">新密码：</label> <input type="password"
					class="form-control" id="inputPassword_new" placeholder="新密码">
			</div>
			<div class="form-group">
				<label for="inputPassword_new2">确认密码：</label> <input
					type="password" class="form-control" id="inputPassword_new2"
					placeholder="确认密码">
			</div>
			<button type="button" class="btn btn-primary"
				onclick="changePassword(this);">提交修改</button>
		</div>
	</div>
</div>
<script type="text/javascript">
  function changePassword(btn) {
	  var oldPasswd = $("#inputPassword_old").val();
	  var newPasswd1 = $("#inputPassword_new").val();
	  var newPasswd2 = $("#inputPassword_new2").val();
	  $(btn).html("修改中...").attr("disabled", "disabled");
	  $.post("<%=basePath%>
		/user/passwd.json", {
				oldPasswd : oldPasswd,
				newPasswd1 : newPasswd1,
				newPasswd2 : newPasswd2
			}, function(data) {
				if (data.result == "success") {
					$('.user-password .panel-body>div.alert>strong').html(
							"修改成功");
					$('.user-password .panel-body>div.alert').addClass(
							'alert-success');
				} else {
					$('.user-password .panel-body>div.alert>strong').html(
							"修改失败");
					$('.user-password .panel-body>div.alert').addClass(
							'alert-warning');
				}
				$('.user-password .panel-body>div.alert').slideDown("fast");
				$(btn).html("提交修改").removeAttr("disabled");
				$("#inputPassword_old").val("");
				$("#inputPassword_new").val("");
				$("#inputPassword_new2").val("");
			});
		}
	</script>
</body>
</html>
