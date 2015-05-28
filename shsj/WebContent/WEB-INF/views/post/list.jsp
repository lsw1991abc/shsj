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
	<title>召集令</title>
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="5"]').addClass('active');
</script>
<div class="container">
	<div class="row">
  	<div class="col-md-10">
      	<div style="border:1px solid #DFDFDF;">
          	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">
          		位置：首页 &gt; 召集令
          	</h6>
            <h4 style="text-indent:30px;">[推广链接] <a href="http://www.baidu.com" target="_blank">百度</a></h4>
          	<table class="table table-striped" style="text-indent:10px; border-bottom:1px solid #DDDDDD; margin-bottom:0;">
	            <c:forEach var="notice" items="${notices}">
	              <tr>
                    <td style="width:80%;"><a href="<%=basePath%>/tieba/${notice.nId}" target="_blank">${notice.nTitle}</a></td>
                    <td style="width:15%;">${fn:substring(notice.nDatetimeBuild, 0, 10)}</td>
                  </tr>
	            </c:forEach>
              </table>
              <div class="text-center">
              	<nav>
                    <ul class="pager">
                      <li><a href="<%=basePath%>/tieba/?page=${navigator.firstPage}">首页</a></li>
                        <li><a href="<%=basePath%>/tieba/?page=${navigator.prePage}">上一页</a></li>
                        <li><a href="<%=basePath%>/tieba/?page=${navigator.nextPage}">下一页</a></li>
                        <li><a href="<%=basePath%>/tieba/?page=${navigator.lastPage}">末页</a></li>
                        <li>
                        	&nbsp;当前 ${navigator.nowPage}/${navigator.pageCount} 页&nbsp;
                        	&nbsp;每页${navigator.pageSize}条&nbsp;
                        	&nbsp;共${navigator.count}条
                        </li>
                    </ul>
                  </nav>
              </div>
              <hr />
              <h4 style="margin-left:15px;">发布召集令</h4>
              <div>
              	<form class="form-inline" action="<%=basePath %>/tieba/save"  role="form" method="post">
				  <div class="form-group" style="margin:15px;">
				    <label for="title" class="col-sm-2 control-label">标题</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="title" name="title" placeholder="标题长度2～50">
				    </div>
				  </div>
				  <div class="form-group" style="margin:15px;">
				    <label for="content" class="col-sm-2 control-label">内容</label>
				    <div class="col-sm-10">
				      <textarea class="form-control" rows="3"  name="content"></textarea>
				    </div>
				  </div>
				  <div class="form-group" style="margin:15px;">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-default">发布</button>
				    </div>
				  </div>
				</form>
			  </div>
          </div>
      </div>
      <div class="col-md-2"><img src="<%=basePath%>/images/201309211379756723136.jpg" class="img-responsive" style="width:100%; height:auto;" /></div>
  </div>
</div>
</body>
</html>
