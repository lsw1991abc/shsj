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
	<title>用户中心</title>
	<link href="<%=basePath%>/style/bootstrap/bootstrap-switch.min.css" type="text/css" rel="stylesheet" />
</head>

<body>
            <div class="user-cp-item user-resume">
               <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">我的简历</h3>
                  </div>
                  <div class="panel-body">
<form class="form-horizontal" id="resume-form" role="form" action="<%=basePath%>/user/jianli/update" method="post">
        	<c:if test="${msg eq 'success'}">
					<div class="alert alert-success" role="alert">修改成功</div>
				</c:if>
				<c:if test="${msg eq 'error'}">
					<div class="alert alert-danger" role="alert">修改失败</div>
				</c:if>
				<div id="name-description"></div>
				<div id="age-description"></div>
				<div id="height-description"></div>
				<div id="weight-description"></div>
				<div id="college-description"></div>
				<div id="major-description"></div>
								<table class="user-resume-content">
									<tr>
										<td style="width: 10%;">姓名：</td>
										<td style="width: 40%;">
											<div>
												<label class="sr-only" for="resume-name">姓名</label> 
												<input type="text" id="resume-name" class="form-control" value="${resume.r_name}" style="width: 80%"
															data-required="true" data-pattern="^\w{2,32}$" name="name"
															data-describedby="name-description" data-description="name"  placeholder="长度2～32"  />
											</div>
										</td>
										<td style="width: 10%;">简历状态：</td>
										<td style="width: 40%;">
											<c:if test="${resume.r_show == 0 }">隐藏</c:if>
											<c:if test="${resume.r_show == 1 }">显示</c:if>
										</td>
									</tr>
									<tr>
										<td>性别：</td>
										<td>
											<div>
												<label class="radio-inline"> 
													<input type="radio" name="sex" value="1" style="height: 37px;"<c:if test="${resume.r_sex == 1 }">checked="checked" </c:if>> 男
												</label> 
												<label class="radio-inline"> 
													<input type="radio" name="sex" value="0" style="height: 37px;"<c:if test="${resume.r_sex == 0 }">checked="checked" </c:if>> 女
												</label>
											</div>
										</td>
										<td>年龄：</td>
										<td><input type="text" class="form-control" id="resume-age" value="${resume.r_age}" style="width: 40%"
															data-pattern="^([0-9]|[0-9]{2}|100)$" name="age"
															data-describedby="age-description" data-description="age"  placeholder="年龄范围：1～100"  /></td>
									</tr>
									<tr>
										<td>身高：</td>
										<td>
											<div class="input-group" style="width: 60%">
												<input type="text" class="form-control" id="resume-height" value="${resume.r_height}" 
															data-pattern="^[0-9]{3}.[0-9]{1}$" name="height"
															data-describedby="height-description" data-description="height"  placeholder="范围0～999，格式：175.0" />
												<div class="input-group-addon">cm</div>
											</div>
										</td>
										<td>体重：</td>
										<td>
											<div class="input-group" style="width: 60%">
												<input type="text" class="form-control" id="resume-weight" value="${resume.r_weight}" 
															data-pattern="^[0-9]{2,3}.[0-9]{1}$" name="weight"
															data-describedby="weight-description" data-description="weight"  placeholder="范围10~999，格式：55.0" />
												<div class="input-group-addon">kg</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>学校：</td>
										<td>
											<div>
												<label class="sr-only" for="resume-college">学校</label> 
												<input type="text" class="form-control" id="resume-college" value="${resume.r_college}" style="width: 80%"
															data-pattern="^\w{0,40}$" name="college"
															data-describedby="college-description" data-description="college"  placeholder="长度0~40"  />
											</div>
										</td>
										<td>专业：</td>
										<td>
											<div>
												<label class="sr-only" for="resume-major">专业</label> 
												<input type="text" class="form-control" id="resume-major" value="${resume.r_major}" style="width: 80%"
															data-pattern="^\w{0,40}$" name="major"
															data-describedby="major-description" data-description="major"  placeholder="长度0~40"  />
											</div>
										</td>
									</tr>
									<tr>
										<td>社会经历：</td>
										<td colspan="3">
											<textarea class="form-control" rows="3" id="resume-experience" name="experience" style="width: 80%; resize: vertical;">${resume.r_experience}</textarea>
										</td>
									</tr>
									<tr>
										<td>个人评价：</td>
										<td colspan="3">
											<textarea class="form-control" rows="3" id="resume-desc" name="desc" style="width: 80%; resize: vertical;">${resume.r_profile}</textarea>
										</td>
									</tr>
									<tr>
										<td>是否显示：</td>
										<td>
											<input type="checkbox" id="resume-show"  data-conditional="isShow" <c:if test="${resume.r_show == 1 }">checked="checked" </c:if> />
											<input type="hidden" id="resume-show-value" name="show" />
										</td>
										<td>更新时间：</td>
										<td>${fn:substring(resume.r_datetime_update, 0, 19)}</td>
									</tr>
									<tr>
										<td colspan="4"><button type="submit" class="btn btn-primary">保存</button></td>
									</tr>
								</table>
</form>
							</div>
                </div>
            </div>
<script type="text/javascript" src="<%=basePath%>/script/bootstrap/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/jquery/jquery-validate.js"></script>
<script type="text/javascript">
	$(function() {
		$('.user-resume-content tr').css({'height':'45px','line-height':'45px'});
		$("#resume-show").bootstrapSwitch();
		$('#resume-form').validate({
				onKeyup : true,
				eachValidField : function() {
					$(this).closest('div').removeClass('has-error').addClass('has-success');
				},
				eachInvalidField : function() {
					$(this).closest('div').removeClass('has-success').addClass('has-error');
				},
				description : {
					name : {
						required : '<div class="alert alert-danger">姓名不能为空</div>',
						pattern : '<div class="alert alert-danger">姓名长度2～32</div>'
					},
					age : {
						pattern : '<div class="alert alert-danger">年龄不合法</div>'
					}, 
					height : {
						pattern : '<div class="alert alert-danger">身高不合法</div>'
					}, 
					weight : {
						pattern : '<div class="alert alert-danger">体重不合法</div>'
					},
					college : {
						pattern : '<div class="alert alert-danger">学校名称不合法</div>'
					}, 
					major : {
						pattern : '<div class="alert alert-danger">专业不合法</div>'
					}
				},
				conditional : {
					isShow : function() {
						if($("#resume-show").is(':checked')) {
							$("#resume-show-value").val(1);
						} else {
							$("#resume-show-value").val(0);
						}
						return true;
					}
				}
			});
	});
</script>
</body>
</html>
