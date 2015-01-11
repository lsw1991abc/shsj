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
	<script type="text/javascript" src="<%=basePath%>/script/bootstrap/bootstrap-switch.min.js"></script>
</head>

<body>
            <div class="user-cp-item user-resume">
               <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">我的简历</h3>
                  </div>
                  <div class="panel-body">

								<div style="display: none" class="alert alert-dismissible" role="alert">
									<button type="button" class="close" data-dismiss="alert">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<strong>修改成功</strong>
								</div>
								<table class="user-resume-content">
									<tr>
										<td style="width: 10%;">姓名：</td>
										<td style="width: 40%;">
											<div>
												<label class="sr-only" for="resume-name">姓名</label> 
												<input type="text" class="form-control" id="resume-name" value="${resume.r_name}" style="width: 80%" />
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
													<input type="radio" name="resume-sex" value="1" style="height: 37px;"<c:if test="${resume.r_sex == 1 }">checked="checked" </c:if>> 男
												</label> 
												<label class="radio-inline"> 
													<input type="radio" name="resume-sex" value="0" style="height: 37px;"<c:if test="${resume.r_sex == 0 }">checked="checked" </c:if>> 女
												</label>
											</div>
										</td>
										<td>年龄：</td>
										<td><input type="text" class="form-control"
											id="resume-age" value="${resume.r_age}" style="width: 40%" /></td>
									</tr>
									<tr>
										<td>身高：</td>
										<td>
											<div class="input-group" style="width: 60%">
												<input type="text" class="form-control" id="resume-height"
													value="${resume.r_height}" />
												<div class="input-group-addon">cm</div>
											</div>
										</td>
										<td>体重：</td>
										<td>
											<div class="input-group" style="width: 60%">
												<input type="text" class="form-control" id="resume-weight"
													value="${resume.r_weight}" />
												<div class="input-group-addon">kg</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>学校：</td>
										<td>
											<div>
												<label class="sr-only" for="resume-college">学校</label> <input
													type="text" class="form-control" id="resume-college"
													value="${resume.r_college}" style="width: 80%" />
											</div>
										</td>
										<td>专业：</td>
										<td>
											<div>
												<label class="sr-only" for="resume-major">专业</label> <input
													type="text" class="form-control" id="resume-major"
													value="${resume.r_major}" style="width: 80%" />
											</div>
										</td>
									</tr>
									<tr>
										<td>社会经历：</td>
										<td colspan="3"><textarea class="form-control" rows="3"
												id="resume-experience" style="width: 80%; resize: vertical;">${resume.r_experience}</textarea></td>
									</tr>
									<tr>
										<td>个人评价：</td>
										<td colspan="3"><textarea class="form-control" rows="3"
												id="resume-desc" style="width: 80%; resize: vertical;">${resume.r_profile}</textarea></td>
									</tr>
									<tr>
										<td>是否显示：</td>
										<td>
											<input type="checkbox" id="resume-show" <c:if test="${resume.r_show == 1 }">checked="checked" </c:if> />
										</td>
										<td>更新时间：</td>
										<td>${fn:substring(resume.r_datetime_update, 0, 19)}</td>
									</tr>
									<tr>
										<td colspan="4"><button type="button"
												class="btn btn-primary">保存</button></td>
									</tr>
								</table>

							</div>
                </div>
            </div>
<script type="text/javascript">
$('.user-resume-content tr').css({'height':'45px','line-height':'45px'});
$("#resume-show").bootstrapSwitch();
</script>
</body>
</html>
