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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>我的日志</title>
	<link href="<%=basePath%>/style/bootstrap/bootstrap-switch.min.css" type="text/css" rel="stylesheet" />
</head>

<body>
<div class="user-cp-item user-daily">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">我的日志</h3>
      </div>
      <div class="panel-body">
        <p><a href="<%=basePath%>/user/rizhi/edit">新日志</a></p>
</div>       
<div class="panel-body panel-body-ul">
	<ul class="list-unstyled">
		<li style="font-weight:bolder;">
			<span style="width:70%;">标题</span>
			<span style="width:15%;" class="text-center">时间</span>
			<span style="width:15%;" class="text-center">操作</span>
		</li>
		<c:forEach items="${dailies }" var="daily" begin="0">
			<li id="daily-li-${daily.d_id}">
				<span style="width:70%;"><a href="<%=basePath%>/rizhi/${daily.d_id}" target="_blank">${daily.d_title}</a></span>
				<span style="width:15%;" class="text-center">${fn:substring(daily.d_datetime_build, 0, 10)}</span>
				<span style="width:15%;" class="text-center"><a href="<%=basePath%>/user/rizhi/edit?id=${daily.d_id}">编辑</a> | <a href="javascript:delDaily(this, '${daily.d_id}');">删除</a></span>
			</li>
		</c:forEach>
	</ul>
	<div class="text-center">
		<nav>
			<ul class="pager">
				<li><a href="<%=basePath%>/user/rizhi/?page=1">首页</a></li>
				<li><a href="<%=basePath%>/user/rizhi/?page=${navigator.prePageNo}">上一页</a></li>
				<li><a href="<%=basePath%>/user/rizhi/?page=${navigator.nextPageNo}">下一页</a></li>
				<li><a href="<%=basePath%>/user/rizhi/?page=${navigator.pageCount}">末页</a></li>
				<li>&nbsp;当前 ${navigator.nowPageNo}/${navigator.pageCount} 页&nbsp;&nbsp; 每页${navigator.pageSize}条&nbsp;&nbsp;共${navigator.count}条</li>
			</ul>
		</nav>
	</div>
</div>
            </div>
        </div>
        <style type="text/css">
			.user-daily .panel-body-ul>ul>li{ height:42px; line-height:42px; border-bottom:1px solid #CCC;}
			.user-daily .panel-body-ul>ul>li span{display:block;float:left}
		</style>
  <script type="text/javascript">
  /*
   * 删除日志
   */
  function delDaily(element, id) {
	var li = $("#daily-li-" + id)
	$(li).css("background", "#CCC");
	$.post('<%=basePath%>/user/rizhi/del.json', {id:id}, function(data) {
		if(data.result == "success") {
			$(li).slideUp();
  		} else {
  			alert("删除失败");
  			$(li).css("background", "#FFF");
  		}
	});
  }
  </script>
</body>
</html>
