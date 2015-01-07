<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<title>${resume.r_name}的个人简历</title>
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="resume"]').addClass('active');
</script>
  <div class="container">
    <div class="row">
    	<div class="col-md-10">
        	<div style="border:1px solid #DFDFDF;">
            	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 会员简历 &gt; 简历详情</h6>
            	<h3 class="text-left" style="margin:0; height:70px; line-height:70px; text-indent:30px; font-weight:bolder; border-bottom:1px solid #EFEFEF;">${resume.r_name} 的简历</h3>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">基本资料</h5>
            		<table class="resume-detail">
            			<tr>
            				<td style="width:10%;">姓名：</td>
            				<td style="width:20%;">${resume.r_name}</td>
            				<td style="width:10%;">性别：</td>
            				<td style="width:30%;">${resume.r_sex}</td>
            				<td rowspan="4" style="width:30%">
            					<img src="<%=basePath%>/images/resume/${resume.r_pic}" class="img-responsive" style="width:100%; height:180px;" />
            				</td>
            			</tr>
            			<tr>
            				<td>年龄：</td>
            				<td>${resume.r_age}人</td>
            				<td>学校：</td>
            				<td>${resume.r_college}</td>
            			</tr>
            			<tr>
            				<td>专业：</td>
            				<td>${resume.r_major}人</td>
            				<td>入学：</td>
            				<td>${resume.r_entrance}</td>
            			</tr>
            			<tr>
            				<td>身高：</td>
            				<td>${resume.r_height}人</td>
            				<td>体重：</td>
            				<td>${resume.r_weight}</td>
            			</tr>
            		</table>
            	</div>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">联系方式</h5>
            		<table class="resume-detail">
            			<tr>
            				<td style="width:10%;">QQ：</td>
            				<td style="width:40%;">${resume.r_qq}</td>
            				<td style="width:10%;">电话：</td>
            				<td style="width:40%;">${resume.r_phoneno}</td>
            			</tr>
            			<tr>
            				<td>邮箱：</td>
            				<td colspan="3">${resume.r_email}</td>
            			</tr>
            		</table>
            	</div>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">个人简介</h5>
            		<div class="resume-detail">
            			${resume.r_profile}
            		</div>
            	</div>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">工作经历</h5>
            		<div class="resume-detail">
            			${resume.r_experience}
            		</div>
            	</div>
            	<style type="text/css">
           			.resume-detail{ width:85%; margin:20px auto;}
           			.resume-detail tr{ height:45px; line-hight:45px;}
           			.resume-detail p{text-indent:32px; line-height:24px;}
           		</style>
            </div>
        </div>
        <div class="col-md-2">
        	<img src="<%=basePath%>/images/201309211379756723136.jpg" class="img-responsive" style="width:100%; height:auto;" />
        </div>
    </div>
  </div>
</body>
</html>
