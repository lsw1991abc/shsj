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
	<title>百宝箱</title>
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="6"]').addClass('active');
</script>
  <div class="container">
	<div class="row">
  	<div class="col-md-10 baoxiang-panel">
      	  <div style="border:1px solid #DFDFDF; margin-bottom:10px; padding:10px;">
            <a href="#kuaidi">收寄快递</a>&nbsp;<a href="#dingcan">订餐热线</a>
          </div>
          <div style="border:1px solid #DFDFDF; margin-bottom:10px;">
            <h4 style="text-indent:30px;"><a name="kuaidi">收寄快递</a></h4>
            <ul class="clearfix">
            	<li>顺丰速运：****-********</li>
            	<li>顺丰速运：****-********</li>
            	<li>顺丰速运：****-********</li>
            	<li>顺丰速运：****-********</li>
            	<li>顺丰速运：****-********</li>
            </ul>
          </div>
          <div style="border:1px solid #DFDFDF; margin-bottom:10px;">
            <h4 style="text-indent:30px;"><a name="dingcan">订餐热线</a></h4>
            <ul class="clearfix">
            	<li>顺丰速运：****-********</li>
            	<li>顺丰速运：****-********</li>
            	<li>顺丰速运：****-********</li>
            	<li>顺丰速运：****-********</li>
            	<li>顺丰速运：****-********</li>
            </ul>
          </div>
      </div>
      <style type="text/css">
      	.baoxiang-panel li{float:left; width:50%; height:30px; line-height:30px;}
      </style>
      <div class="col-md-2"><img src="<%=basePath%>/images/201309211379756723136.jpg" class="img-responsive" style="width:100%; height:auto;" /></div>
  </div>
</div>
</body>
</html>
