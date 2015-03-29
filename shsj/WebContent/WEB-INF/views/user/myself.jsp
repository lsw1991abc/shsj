<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
	<title>个人资料</title>
</head>

<body>
<div class="user-cp-item user-profile">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">个人资料</h3>
        </div>
        <div class="panel-body">
        <form class="form-horizontal" id="myself-form" role="form" action="<%=basePath%>/user/ziliao/update" method="post">
        	<c:if test="${msg eq 'success'}">
					<div class="alert alert-success" role="alert">修改成功</div>
				</c:if>
				<c:if test="${msg eq 'error'}">
					<div class="alert alert-danger" role="alert">修改失败</div>
				</c:if>
				<div id="nickname-description"></div>
				<div id="qq-description"></div>
				<div id="phoneno-description"></div>
				<div id="email-description"></div>
	  		<table class="user-profile-content">
				<tr style="height:45px;">
	  				<td style="width:12%;">用户名：</td>
		  			<td style="width:40%;">${myself.username}</td>
		  			<td style="width:12%;">昵称：</td>
		  			<td style="width:36%;">
			  			<div>
			  				<label class="sr-only" for="user-nickname">昵称</label>
			  				<input type="text" class="form-control" style="width:90%"
			  						id="user-nickname" name="nickname" value="${myself.nickname}" 
	 								data-pattern="^[a-z0-9A-Z_]{1,32}$" placeholder="长度1～32" 
									data-describedby="nickname-description" data-description="nickname" />
			 			</div>
			  		</td>
			  	</tr>
			 	<tr style="height:45px;">
			  		<td>QQ：</td>
			  		<td>
				  		<div>
				  			<label class="sr-only" for="user-nickname">QQ</label>
				  			<input type="text" class="form-control" id="qq" value="${myself.qq}" style="width:80%" 
										placeholder="长度5～12" name="qq" data-pattern="^[1-9][0-9]{4,11}$"
										data-describedby="qq-description" data-description="qq" />
				  		</div>
				  	</td>
			  		<td>联系电话：</td>
			  		<td>
						<div>
							<label class="sr-only" for="user-nickname">联系电话</label>
							<input type="text" class="form-control" id="inputPhoneno" value="${myself.phoneno}" style="width:90%"
										placeholder="长度11" name="phoneno" 
										data-pattern="^[1][3-8][0-9]{9}$" data-describedby="phoneno-description" data-description="phoneno"  />
						</div>
					</td>
			  	</tr>
			  	<tr style="height:45px;">
			  		<td>邮箱：</td>
			  		<td colspan="3">
			  			<div>
			  				<label class="sr-only" for="user-nickname">邮箱</label>
			  				<input type="text" class="form-control" id="inputEmail" value="${myself.email}" style="width:96%"
										placeholder="示例:username@shsj.com" name="email" data-pattern="^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"
										data-describedby="email-description" data-description="email"  />
			  			</div>
			  		</td>
			  	</tr>
			  	<tr>
			  		<td>个人描述：</td>
			  		<td colspan="3">
			  			<textarea class="form-control" rows="3" id="user-desc" style="width:96%; resize:vertical;" name="userDesc">${myself.userDesc}</textarea>
			  		</td>
			  	</tr>
			  	<tr style="height:45px;">
			  		<td>注册时间：</td>
			  		<td colspan="3">${fn:substring(myself.buildDate, 0, 19)}</td>
			  	</tr>
			  	<tr style="height:45px;">
			  		<td colspan="4">
			  			<button type="submit" class="btn btn-primary">保存</button>
			  		</td>
			  	</tr>
			</table>
			</form>
        </div>
      </div>
  </div>
<script type="text/javascript" src="<%=basePath%>/script/jquery/jquery-validate.js"></script>
<script type="text/javascript">
$(function() {
	$('#myself-form').validate({
		onKeyup : true,
		eachValidField : function() {
			$(this).closest('div').removeClass('has-error').addClass('has-success');
		},
		eachInvalidField : function() {
			$(this).closest('div').removeClass('has-success').addClass('has-error');
		},
		description : {
			nickname : {
				pattern : '<div class="alert alert-danger">用户名长度1～32</div>'
			},
			qq : {
				pattern : '<div class="alert alert-danger">您输入的QQ不合法</div>'
			},
			phoneno : {
				pattern : '<div class="alert alert-danger">您输入的手机号码不合法</div>'
			}, 
			email : {
				pattern : '<div class="alert alert-danger">您输入的Email不合法</div>'
			}
		}
	});
});
</script>
</body>
</html>
