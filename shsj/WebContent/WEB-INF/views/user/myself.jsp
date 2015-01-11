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
        
        <div style="display:none" class="alert alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert">
        	<span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button><strong>修改成功</strong>
        </div>
	  	<table class="user-profile-content">
				<tr>
	  				<td style="width:12%;">用户名：</td>
		  			<td style="width:40%;">${myself.username}</td>
		  			<td style="width:12%;">昵称：</td>
		  			<td style="width:36%;">
			  			<div>
			  				<label class="sr-only" for="user-nickname">昵称</label>
			  				<input type="text" class="form-control" id="user-nickname" value="${myself.nickname}" style="width:90%" />
			 			</div>
			  		</td>
			  	</tr>
			 	<tr>
			  		<td>QQ：</td>
			  		<td>
				  		<div>
				  			<label class="sr-only" for="user-nickname">QQ</label>
				  			<input type="text" class="form-control" id="user-qq" value="${myself.qq}" style="width:80%" />
				  		</div>
				  	</td>
			  		<td>联系电话：</td>
			  		<td>
						<div>
							<label class="sr-only" for="user-nickname">联系电话</label>
							<input type="text" class="form-control" id="user-phoneno" value="${myself.phoneno}" style="width:90%" />
						</div>
					</td>
			  	</tr>
			  	<tr>
			  		<td>邮箱：</td>
			  		<td colspan="3">
			  			<div>
			  				<label class="sr-only" for="user-nickname">邮箱</label>
			  				<input type="email" class="form-control" id="user-email" value="${myself.email}" style="width:85%" />
			  			</div>
			  		</td>
			  	</tr>
			  	<tr>
			  		<td>个人描述：</td>
			  		<td colspan="3">
			  			<textarea class="form-control" rows="3" id="user-desc" style="width:85%; resize:vertical;">${myself.userDesc}</textarea>
			  		</td>
			  	</tr>
			  	<tr>
			  		<td>注册时间：</td>
			  		<td colspan="3">${fn:substring(myself.buildDate, 0, 19)}</td>
			  	</tr>
			  	<tr>
			  		<td colspan="4">
			  			<button type="button" class="btn btn-primary">保存</button>
			  		</td>
			  	</tr>
			</table>
        </div>
      </div>
  </div>
  <script type="text/javascript">
  	$('.user-profile-content tr').css({'height':'45px','line-height':'45px'}); 
  </script>
</body>
</html>
