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
	<title>用户中心</title>
</head>

<body>

 <div class="col-md-10">
   	<div class="panel panel-default">
       <div class="panel-heading">
         <h3 class="panel-title">招聘管理</h3>
       </div>
       <div class="panel-body">
       	<form role="form" action="<%=basePath%>/admin/zhaopin/save" method="post">
       		<table style="width: 100%;" class="form-table">
       			<tr>
       				<td style="width:10%;">招聘单位：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="organnizer" /></td>
       				<td style="width:10%;">职位名称：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="title" /></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">职位分类：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="belong" /></td>
       				<td style="width:10%;">工作类型：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="type" placeholder="1全职 2兼职"/></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">工作区域：</td>
       				<td style="width:90%;" colspan="3"><input type="text" style="width:75%;" name="place" /></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">工作待遇：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="salary" /></td>
       				<td style="width:10%;">工作时间：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="datetime-work" /></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">招聘人数：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="number" /></td>
       				<td style="width:10%;">人数限制：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="number-limit" /></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">联系电话：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="contact" /></td>
       				<td style="width:10%;">面试时间：</td>
       				<td style="width:40%;"><input type="text" id="datetime-start" name="datetime-start" />至<input type="text"  id="datetime-end" name="datetime-end" /></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">面试地址：</td>
       				<td style="width:90%;" colspan="3"><input type="text" style="width:75%;" name="audition-place" /></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">工作详情：</td>
       				<td style="width:90%;" colspan="3"><textarea rows="3" style="width:75%;resize:vertical;" name="content"></textarea></td>
       			</tr>
       		</table>
       		<style type="text/css">
       			.form-table tr{ height:32px; line-height:32px;}
       			.form-table tr input{ height:30px; line-height:30px;}
       		</style>
       		<script type="text/javascript">
       			$("#datetime-start").datetimepicker({
       			    format: 'yyyy-mm-dd'
       			});
       			$("#datetime-end").datetimepicker({
       			    format: 'yyyy-mm-dd'
       			});
       		</script>
		  <button type="submit" class="btn btn-default">发布</button>
		</form>
         <table class="table table-striped">
         	<thead>
         		<tr>
         			<th style="width:40%;">标题</th>
         			<th style="width:15%;" class="text-center">类型</th>
         			<th style="width:15%;" class="text-center">地点</th>
         			<th style="width:15%;" class="text-center">时间</th>
         			<th style="width:15%;" class="text-center">操作</th>
         		</tr>
         	</thead>
         	<tbody>
	            <c:forEach var="job" items="${jobs}">
	              <tr>
	              	<c:choose>
	              		<c:when test="${job.j_type == '1' || job.j_type == '3'}">
	              			<td style="width:40%;">[${job.j_type}]<a href="<%=basePath%>/zhaopin/${job.j_id}" target="_blank">${job.j_title}</a></td>
	              		</c:when>
	              		<c:when test="${job.j_type == '2'}">
	              			<td style="width:40%;">[${job.j_type}]<a href="<%=basePath%>/jianzhi/${job.j_id}" target="_blank">${job.j_title}</a></td>
	              		</c:when>
	              	</c:choose>
                    
                    <td style="width:15%;" class="text-center">${job.j_belong}</td>
                    <td style="width:15%;" class="text-center">${job.j_work_place}</td>
                    <td style="width:15%;" class="text-center">${fn:substring(job.j_datetime_build, 0, 10)}</td>
                    <td style="width:15%;" class="text-center"><a href="<%=basePath%>/admin/zhaopin/delete/${job.j_id}">删除</a></td>
                  </tr>
	            </c:forEach>
	            </tbody>
              </table>
              <div class="text-center">
              	<nav>
                    <ul class="pager">
                      <li><a href="<%=basePath%>/admin/zhaopin/?page=1">首页</a></li>
                        <li><a href="<%=basePath%>/admin/zhaopin/?page=${navigator.prePageNo}">上一页</a></li>
                        <li><a href="<%=basePath%>/admin/zhaopin/?page=${navigator.nextPageNo}">下一页</a></li>
                        <li><a href="<%=basePath%>/admin/zhaopin/?page=${navigator.pageCount}">末页</a></li>
                        <li>&nbsp;当前 ${navigator.nowPageNo}/${navigator.pageCount} 页&nbsp;&nbsp;每页${navigator.pageSize}条&nbsp;&nbsp;共${navigator.count}条</li>
                    </ul>
                  </nav>
              </div>
       </div>
     </div>
 </div> 
</body>
</html>