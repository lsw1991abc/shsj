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
	<title>活动案例</title>
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
            	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 活动案例</h6>
                <ul class="list-unstyled hdal" style="margin:7px 15px;">
                	<c:forEach var="activit" items="${activits}" step="1">
	                    <li>
	                    	<div class="row" style="margin:0 0 8px;">
	                        	<div class="col-md-3" style="padding:5px; border:1px solid #DFDFDF;">
	                            	<img src="<%=basePath%>/${activit.a_pic}" style="height:130px; width:190px;" class="img-responsive" alt="img" />
	                            </div>
	                            <div class="col-md-9">
	                            	<h4><a href="<%=basePath%>/huodong/${activit.a_id}" target="_blank">${activit.a_title}</a></h4>
	                                <div class="lead hdal_item_content">${fn:substring(activit.a_desc, 0, 30) }</div>
	                                <p style="height:28px; line-height:28px; margin:0;">活动时间：${activit.a_datetime_start} 至 ${activit.a_datetime_end}</p>
	                            </div>
	                        </div>
	                    </li>
                    </c:forEach>
                </ul>
                <style type="text/css">
					.hdal li{border-bottom:1px dashed #DFDFDF; margin:8px 0 0;}
					.hdal .hdal_item_content{ text-indent:30px; height:65px; margin-bottom:5px;}
                </style>
                <div class="text-center">
                	<nav>
                      <ul class="pager">
                      	<li><a href="<%=basePath%>/huodong/?page=1">首页</a></li>
                        <li><a href="<%=basePath%>/huodong/?page=${navigator.prePageNo}">上一页</a></li>
                        <li><a href="<%=basePath%>/huodong/?page=${navigator.nextPageNo}">下一页</a></li>
                        <li><a href="<%=basePath%>/huodong/?page=${navigator.pageCount}">末页</a></li>
                        <li>&nbsp;当前 ${navigator.nowPageNo}/${navigator.pageCount} 页&nbsp;&nbsp;每页${navigator.pageSize}条&nbsp;&nbsp;共${navigator.count}条</li>
                      </ul>
                    </nav>
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
