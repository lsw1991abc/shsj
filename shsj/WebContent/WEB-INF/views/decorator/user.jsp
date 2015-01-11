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
<link rel="shortcut icon" href="<%=basePath %>/images/favicon.ico" />
<title><sitemesh:write property="title">首页</sitemesh:write> - 大学生社会实践</title>
<link rel="stylesheet" href="<%=basePath %>/style/bootstrap/bootstrap.min.css" type="text/css" />
<script src="<%=basePath %>/script/jquery-1.11.1.js"></script>
<script src="<%=basePath %>/script/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/lssrc/dateFormater.lssrc.js"></script>
<sitemesh:write property="head" />
</head>

<body>
<div class="page_top" style=" height:30px; line-height:30px; min-width:998px; background:url('<%=basePath %>/images/syimgs.png') 0px 0px repeat-x; margin-bottom:10px;">
  <div class="container">
    <div class="row">
      <div class="col-md-3">欢迎访问大学生社会实践服务中心</div>
      <div class="col-md-3"><script type="text/javascript">document.write(DateFormater.getHeadDateTime());</script></div>
      <div class="col-md-2"></div>
      <div class="col-md-4 text-right">
      	<c:choose>
      		<c:when test="${myself != null }">
		      	<a href="<%=basePath%>/user">个人中心</a>&nbsp;
		      	<a href="<%=basePath%>/login/logout">退出</a>&nbsp;
      		</c:when>
      		<c:otherwise>
		      	<a href="<%=basePath%>/login/">登陆</a>&nbsp;
		      	<a href="<%=basePath%>/login/register">注册</a>&nbsp;
	      	</c:otherwise>
      	</c:choose>
      	<a href="#">收藏本站</a>&nbsp;
      	<a href="#">设为主页</a>
      </div>
    </div>
  </div>
</div>
<div class="header">
  <div class="container">
    <div class="row" style="margin-bottom:10px;">
      <div class="col-md-3">logo</div>
      <div class="col-md-9"> <img src="<%=basePath %>/images/201408271409108212749.jpg" style="width:100%; height:95px;" class="img-responsive" alt="Responsive image"  /> </div>
    </div>
    <ul class="nav nav-tabs header-nav" role="tablist" style="margin-bottom:10px; background:url('<%=basePath %>/images/syimgs.png') 0px -30px repeat-x; padding:0 20px;">
      <li role="presentation" data-menu-id="index" class="active"><a href="<%=basePath %>/">首页</a></li>
      <li role="presentation" data-menu-id="parttime"><a href="<%=basePath %>/jianzhi">兼职工作</a></li>
      <li role="presentation" data-menu-id="job"><a href="<%=basePath %>/zhaopin">全职工作</a></li>
      <li role="presentation" data-menu-id="resume"><a href="<%=basePath %>/rencai">会员简历</a></li>
      <!-- <li role="presentation" data-menu-id="candidate"><a href="<%=basePath %>/qiuzhi">会员求职</a></li> -->
      <li role="presentation" data-menu-id="avtivit"><a href="<%=basePath %>/huodong">活动案例</a></li>
      <li role="presentation" data-menu-id="help"><a href="<%=basePath %>/help/gywm">关于我们</a></li>
    </ul>
    <style type="text/css">
		.nav>li>a{ color:#fff;}
		.nav>li>a:hover{ color:#333;}
		.nav>li>a:focus{ color:#333;}
    </style>
  </div>
</div>
<div class="body">
  <div class="container">
  	<div class="row">
    	<div class="col-md-12">
        	<h3>欢迎来到大学生社会实践中心&nbsp;&nbsp;&nbsp;&nbsp;<small>当前登录用户名：${myself.nickname}</small></h3>
        </div>
    </div>
    <div class="row">
      <div class="col-md-2">
        <ul class="list-unstyled user-menu">
        	<li><a href="<%=basePath%>/user">控制面板</a></li>
            <li><a href="<%=basePath%>/user/rizhi">我的日志</a></li>
            <li><a href="<%=basePath%>/user/jianli">我的简历</a></li> 
            <li><a href="<%=basePath%>/user/ziliao">个人资料</a></li>
            <li><a href="<%=basePath%>/user/xgmm">修改密码</a></li>
            <c:if test="${myself.issys==1}">
            	<li><a href="<%=basePath%>/admin/" target="_blank">后台管理</a></li>
            </c:if>
            <li><a href="<%=basePath%>/user/logout">退出</a></li>
        </ul>
        <style type="text/css">
			.user-menu{ border-right:1px solid #006699; text-indent:27px;}
			.user-menu li{ height:40px; line-height:40px; font-size:15px;}
			.user-menu li.active{ border:1px solid #006699; border-right:1px solid #FFF; text-indent:30px; margin:-1px}
        </style>
      </div>
      <div class="col-md-10">
      		<sitemesh:write property="body" />
      </div> 
    </div>
  </div>
</div>
<div class="footer">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
      	<h4 style="font-weight:bolder; border-top:5px solid #BFD8F2; padding-top:5px;" >友情链接</h4>
      	<ul class="list-inline">
          <li><a href="#">联系方式</a></li>
          <li><a href="#">法律问题</a></li>
          <li><a href="#">关于我们</a></li>
          <li><a href="#">联系我们</a></li>
        </ul>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12 text-center">
      	<ul class="list-inline" style="border-top:1px dashed #CCCCCC; padding-top:10px;">
          <li><a href="#">联系方式</a></li>
          <li><a href="#">法律问题</a></li>
          <li><a href="#">关于我们</a></li>
          <li><a href="#">联系我们</a></li>
        </ul>
        <p>Copyright &copy; 2014-2015 SHSJ Corporation, All Rights Reserved 鲁ICP备13014029号</p>
      </div>
    </div>
  </div>
</div>
</body>
</html>
