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
	<title>求职宝典</title>
</head>

<body>
  <div class="container">
	<div class="row">
  	<div class="col-md-10">
      	<div style="border:1px solid #DFDFDF;">
          	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 求职宝典</h6>
            <h4 style="text-indent:30px;">[推广链接] <a href="http://www.lssrc.com" target="_blank">www.lssrc.com</a></h4>
          	<table class="table table-striped" style="text-indent:10px; border-bottom:1px solid #DDDDDD; margin-bottom:0;">
	            <c:forEach var="treasure" items="${treasures}">
	              <tr>
                    <td style="width:5%;"><input type="checkbox" /></td>
                    <td style="width:80%;"><a href="<%=basePath%>/baodian/${treasure.t_id}" target="_blank">${treasure.t_title}</a>&nbsp;&nbsp;<span class="label label-danger">NEW</span></td>
                    <td style="width:15%;">${fn:substring(treasure.t_build_date, 0, 10)}</td>
                  </tr>
	            </c:forEach>
              </table>
              <div class="text-center">
              	<nav>
                    <ul class="pager">
                      <li><a href="<%=basePath%>/zhaopin/?page=1">首页</a></li>
                        <li><a href="<%=basePath%>/zhaopin/?page=${navigator.prePageNo}">上一页</a></li>
                        <li><a href="<%=basePath%>/zhaopin/?page=${navigator.nextPageNo}">下一页</a></li>
                        <li><a href="<%=basePath%>/zhaopin/?page=${navigator.pageCount}">末页</a></li>
                        <li>&nbsp;当前 ${navigator.nowPageNo}/${navigator.pageCount} 页&nbsp;&nbsp;每页${navigator.pageSize}条&nbsp;&nbsp;共${navigator.count}条</li>
                    </ul>
                  </nav>
              </div>
          </div>
      </div>
      <div class="col-md-2"><img src="<%=basePath%>/images/201309211379756723136.jpg" class="img-responsive" style="width:100%; height:auto;" /></div>
  </div>
</div>
</body>
</html>
