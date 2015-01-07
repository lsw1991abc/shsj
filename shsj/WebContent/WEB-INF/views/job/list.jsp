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
	<title>全职/兼职工作</title>
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
          	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 全职/兼职工作</h6>
            <h4 style="text-indent:30px;">[推广链接] <a href="http://www.lssrc.com" target="_blank">www.lssrc.com</a></h4>
          	<table class="table table-striped" style="text-indent:10px; border-bottom:1px solid #DDDDDD; margin-bottom:0;">
	            <c:forEach var="job" items="${jobs}">
	              <tr>
                    <td><input type="checkbox" /></td>
                    <c:choose>
                    	<c:when test="${type=='job'}">
                    		<td style="width:485px;">[${job.j_type}]<a href="<%=basePath%>/zhaopin/${job.j_id}" target="_blank">${job.j_title}</a></td>
                    	</c:when>
                    	<c:when test="${type=='parttime'}">
                    		<td style="width:485px;">[${job.j_type}]<a href="<%=basePath%>/jianzhi/${job.j_id}" target="_blank">${job.j_title}</a></td>
                    	</c:when>
                    </c:choose>
                    
                    <td>${job.j_belong}</td>
                    <td>${job.j_work_place}</td>
                    <td>${fn:substring(job.j_datetime_build, 0, 10)}</td>
                  </tr>
	            </c:forEach>
              </table>
              <div class="text-center">
              	<nav>
                    <ul class="pager">
                      <li><a href="<%=basePath%>/${controller}/?page=1">首页</a></li>
                        <li><a href="<%=basePath%>/${controller}/?page=${navigator.prePageNo}">上一页</a></li>
                        <li><a href="<%=basePath%>/${controller}/?page=${navigator.nextPageNo}">下一页</a></li>
                        <li><a href="<%=basePath%>/${controller}/?page=${navigator.pageCount}">末页</a></li>
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
