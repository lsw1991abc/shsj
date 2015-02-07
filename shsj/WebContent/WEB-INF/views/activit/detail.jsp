<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>${activit.a_title}</title>
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="avtivit"]').addClass('active');
</script>
  <div class="container">
    <div class="row">
    	<div class="col-md-10">
        	<div style="border:1px solid #DFDFDF;">
            	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 活动案例 &gt; 活动详情</h6>
            	<h3 class="text-left" style="margin:0; height:70px; line-height:70px; text-indent:30px; font-weight:bolder; border-bottom:1px solid #EFEFEF;">主题：${activit.a_title}</h3>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">活动简介</h5>
            		<table class="activit-detail">
            			<tr>
            				<td style="width:10%;">主办单位：</td>
            				<td style="width:20%;">${activit.a_organizer}</td>
            				<td style="width:10%;">活动策划：</td>
            				<td style="width:30%;">${activit.a_plotter}</td>
            				<td rowspan="3" style="width:30%">
            					<img src="<%=basePath%>/${activit.a_pic}" class="img-responsive" style="width:100%; height:135px;" />
            				</td>
            			</tr>
            			<tr>
            				<td>参与人数：</td>
            				<td>${activit.a_number}人</td>
            				<td>活动状态：</td>
            				<td>${activit.as_name}</td>
            			</tr>
            			<tr>
            				<td>活动日期：</td>
            				<td colspan="3">${activit.a_datetime_start} 至 ${activit.a_datetime_end}</td>
            			</tr>
            		</table>
            	</div>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">活动详情</h5>
            		<div class="activit-detail">
            			${activit.a_desc}
            		</div>
            		
            	</div>
            	<style type="text/css">
           			.activit-detail{ width:85%; margin:20px auto;}
           			.activit-detail tr{ height:45px; line-hight:45px;}
           			.activit-detail p{line-height:24px;}
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
