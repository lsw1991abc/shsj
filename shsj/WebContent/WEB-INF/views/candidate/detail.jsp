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
	<title>${candidate.c_title}</title>
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="candidate"]').addClass('active');
</script>
  <div class="container">
    <div class="row">
    	<div class="col-md-10">
        	<div style="border:1px solid #DFDFDF;">
            	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 会员求职 &gt; 求职详情</h6>
            	<div class="row" style="border-bottom:1px solid #EFEFEF; margin:0 0 20px;">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">${candidate.c_title}</h5>
            		<h6 style="margin:15px 0; text-indent:30px;"><span>${fn:substring(candidate.c_datetime_build, 0, 19)}</span>&nbsp;&nbsp;--&nbsp;&nbsp;<span>${candidate.c_builder}</span></h6>
            		<div class="candidate-detail">
            			${candidate.c_desc}
            		</div>
            	</div>
            	<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">历史回复</h5>
            	<ul class="list-unstyled candidate-comment" style="">
	              <li>
	              	<h6 style="margin:15px 0; text-indent:30px;">type -- time</h6>
            		<div class="candidate-detail">
            			请输入留言内容
            		</div>
				  </li>
	              <li>
	              	<h6 style="margin:15px 0; text-indent:30px;">type -- time</h6>
            		<div class="candidate-detail">
            			请输入留言内容
            		</div>
				  </li>
				  <li>
	              	<h6 style="margin:15px 0; text-indent:30px;">type -- time</h6>
            		<div class="candidate-detail">
            			请输入留言内容
            		</div>
				  </li>
	            </ul>
            	<div class="row" style="margin:0;">
            		<h5 style="margin:15px 0; text-indent:30px; font-weight:bolder;">回复</h5>
            		<div class="candidate-detail">
            			<form role="form" action="#" method="post">
	            			<textarea class="form-control" rows="3">请输入留言内容</textarea>
	            			<button type="button" class="btn btn-info" style="margin:15px 0 0 15px;">提交留言</button>
            			</form>
            		</div>
            	</div>
            	<style type="text/css">
	      			.candidate-detail{ width:90%; margin:10px auto 20px; text-indent:32px; line-height:24px;}
	      			.candidate-comment{ width:95%; margin:0 auto;}
	      			.candidate-comment li{ border-bottom:1px solid #DFDFDF;}
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
