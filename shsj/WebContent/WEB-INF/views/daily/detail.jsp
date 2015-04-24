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
	<title>${daily.notice.nTitle}</title>
</head>

<body>
  <div class="container">
    <div class="row">
    	<div class="col-md-10">
      	  <div style="border:1px solid #DFDFDF;">
      	  	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 校友日志 &gt; 日志详情</h6>
        	<h2 class="text-center" style="background:#F9F9F9; margin:0; height:70px; line-height:70px;">${daily.notice.nTitle}</h2>
            <p class="text-center" style="background:#F5F5F5; border:1px solid #E9E9E9; border-left:none; border-right:none; height:25px; line-height:25px; color:#333;">
            作者:${daily.user.userNickname}&nbsp;&nbsp;
            点击:${daily.noticeCount}次&nbsp;&nbsp;
            发布时间:${fn:substring(daily.notice.nDatetimeBuild, 0, 19)}</p>
            <div class="lead daily_content" style="padding:15px 20px;">
            	${daily.notice.nDesc}
            </div>
          </div>
        </div>
        <div class="col-md-2">
        	<img src="<%=basePath%>/images/201309211379756723136.jpg" class="img-responsive" style="width:100%; height:auto;" />
        </div>
    </div>
  </div>
</body>
</html>
