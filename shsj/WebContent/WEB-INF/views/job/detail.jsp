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
	<title>${job.j_title}</title>
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="${type}"]').addClass('active');
</script>
  <div class="container">
    <div class="row">
    	<div class="col-md-10">
        	<div style="border:1px solid #DFDFDF;">
            	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 全职/兼职工作 &gt; 招聘详情</h6>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">${job.j_title}</h5>
            		<table class="job-detail">
            			<tr>
            				<td style="width:10%;">招聘单位：</td>
            				<td style="width:90%;">${job.j_organizer}</td>
            			</tr>
            		</table>
            	</div>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">招聘简介</h5>
            		<table class="job-detail">
            			<tr>
            				<td style="width:10%;">职位类型：</td>
            				<td style="width:40%;">${job.jb_name}</td>
            				<td style="width:10%;">工作区域：</td>
            				<td style="width:40%;">${job.j_work_place}</td>
            			</tr>
            			<tr>
            				<td style="width:10%;">工作待遇：</td>
            				<td style="width:40%;">${job.j_salary}${job.j_salary_type}</td>
            				<td style="width:10%;">工作时间：</td>
            				<td style="width:40%;">${job.j_work_time}</td>
            			</tr>
            			<tr>
            				<td style="width:10%;">招聘人数：</td>
            				<td style="width:40%;">${job.j_number}人</td>
            				<td style="width:10%;">人数限制：</td>
            				<td style="width:40%;">${job.j_number_limit}人</td>
            			</tr>
            			<tr>
            				<td style="width:10%;">已报名：</td>
            				<td style="width:40%;">${job.j_number_ready}人</td>
            				<td style="width:10%;">结束时间：</td>
            				<td style="width:40%;">${fn:substring(job.j_datetime_end, 0, 10)}</td>
            			</tr>
            		</table>
            	</div>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">联系方式</h5>
            		<table class="job-detail">
            			<tr>
            				<td style="width:10%;">联系电话：</td>
            				<td style="width:40%;">${job.j_contact}</td>
            				<td style="width:10%;">面试时间：</td>
            				<td style="width:40%;">${job.j_audition_time}</td>
            			</tr>
            			<tr>
            				<td style="width:10%;">面试地址：</td>
            				<td style="width:90%;" colspan="3">${job.j_audition_place}</td>
            			</tr>
            		</table>
            	</div>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">工作详情</h5>
            		<div class="job-detail">
            			${job.j_content}
            		</div>
            	</div>
            	<!-- 
            	<div class="row text-center" style="margin:0; height:60px; line-height:55px; border:1px solid #EFEFEF; border-left:none; border-right:none;">
            		<button type="button" class="btn btn-primary">我要报名</button>
            		&nbsp;&nbsp;&nbsp;&nbsp;
            		<button type="button" class="btn btn-success">收藏职位</button>
            	</div>
            	<div class="row">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">职友评论</h5>
            		<div class="job-detail">
            			<form role="form" action="#" method="post">
	            			<p>打分：
	            				<label class="radio-inline"><input type="radio" name="optionsRadios" id="optionsRadios1" value="1">1分</label>
	            				<label class="radio-inline"><input type="radio" name="optionsRadios" id="optionsRadios2" value="2">2分</label>
	            				<label class="radio-inline"><input type="radio" name="optionsRadios" id="optionsRadios3" value="3">3分</label>
	            				<label class="radio-inline"><input type="radio" name="optionsRadios" id="optionsRadios4" value="4">4分</label>
	            				<label class="radio-inline"><input type="radio" name="optionsRadios" id="optionsRadios5" value="5">5分</label>
	            			</p>
	            			<textarea class="form-control" rows="3">请输入留言内容</textarea>
	            			<button type="button" class="btn btn-info" style="margin:15px 0 0 15px;">提交分数</button>
            			</form>
            		</div>
            	</div>
            	 -->
            	<style type="text/css">
	      			.job-detail{ width:85%; margin:20px auto;}
	      			.job-detail tr{ height:45px; line-hight:45px;}
	      			.job-detail p{text-indent:32px; line-height:24px;}
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
