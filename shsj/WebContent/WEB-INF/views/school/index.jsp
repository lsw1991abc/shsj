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
	<title>站内公告</title>
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="7"]').addClass('active');
</script>
<div class="container">
	<div class="row">
  	<div class="col-md-6">
      	<div style="border:1px solid #DFDFDF;">
          	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">
          		站内公告
          		<span style="float:right; margin-right:15px;"><a href="<%=basePath%>/gonggao">更多&gt;&gt;</a></span>
          	</h6>
          	<table class="table table-striped" style="text-indent:10px; border-bottom:1px solid #DDDDDD; margin-bottom:0;">
	            <c:forEach var="notice" items="${notices}">
	              <tr>
                    <td style="width:75%;"><a href="<%=basePath%>/gonggao/${notice.nId}" target="_blank">${notice.nTitle}</a></td>
                    <td style="width:25%;">${fn:substring(notice.nDatetimeBuild, 0, 10)}</td>
                  </tr>
	            </c:forEach>
              </table>
          </div>
      </div>
      <div class="col-md-6">
      	<div style="border:1px solid #DFDFDF;">
          	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">
          		求职宝典
          		<span style="float:right; margin-right:15px;"><a href="<%=basePath%>/baodian">更多&gt;&gt;</a></span>
          	</h6>
          	<table class="table table-striped" style="text-indent:10px; border-bottom:1px solid #DDDDDD; margin-bottom:0;">
	            <c:forEach var="notice" items="${notices}">
	              <tr>
                    <td style="width:75%;"><a href="<%=basePath%>/gonggao/${notice.nId}" target="_blank">${notice.nTitle}</a></td>
                    <td style="width:25%;">${fn:substring(notice.nDatetimeBuild, 0, 10)}</td>
                  </tr>
	            </c:forEach>
              </table>
          </div>
	  </div>
  </div>
  <br />
  <div class="row">
  	<div class="col-md-12">
      	<div style="border:1px solid #DFDFDF;">
          	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">校内快捷链接</h6>
				          	<ul class="list-inline hdal" style="margin:15px 10px 5px;">
				              <c:forEach items="${sites}" var="site" begin="0" step="1" end="6">
				            	<li class="text-center" >
				                	<a href="<%=basePath %>/${site.lUrl}" target="${site.lTarget}" title="${site.lName}">
				                		${site.lName}
				                	</a>
				                </li>
				               </c:forEach>
				            </ul>
				            <style type="text/css">
								.hdal li{ padding:0 10px;}
				            </style>
          </div>
      </div>
  </div>
</div>
</body>
</html>
