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
         <h3 class="panel-title">活动管理</h3>
       </div>
       <div class="panel-body">
       	<form role="form" action="<%=basePath%>/admin/huodong/save" method="post">
		  <table style="width: 100%;" class="form-table">
		  		<tr>
       				<td style="width:10%;">标题：</td>
       				<td style="width:90%;" colspan="3"><input type="text" style="width:75%;" name="title" /></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">主办单位：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="organizer" /></td>
       				<td style="width:10%;">活动策划：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="plotter" /></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">参与人数：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="number" /></td>
       				<td style="width:10%;">活动状态：</td>
       				<td style="width:40%;"><input type="text" style="width:75%;" name="statu" /></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">活动日期：</td>
       				<td style="width:90%;" colspan="3"><input type="text" id="datetime-start" name="datetime-start" />至<input type="text" id="datetime-end" name="datetime-end" /></td>
       			</tr>
       			<tr>
       				<td style="width:10%;">活动详情：</td>
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
         			<th style="width:55%;">标题</th>
         			<th style="width:15%;" class="text-center">开始时间</th>
         			<th style="width:15%;" class="text-center">结束时间</th>
         			<th style="width:15%;" class="text-center">操作</th>
         		</tr>
         	</thead>
         	<tbody>
	            <c:forEach var="activit" items="${activits}">
	              <tr>
                    <td style="width:55%;"><a href="<%=basePath%>/huodong/${activit.a_id}" target="_blank">${activit.a_title}</a></td>
                    <td style="width:15%;" class="text-center">${fn:substring(activit.a_datetime_start, 0, 10)}</td>
                    <td style="width:15%;" class="text-center">${fn:substring(activit.a_datetime_end, 0, 10)}</td>
                    <td style="width:15%;" class="text-center"><a href="<%=basePath%>/admin/huodong/delete/${activit.a_id}">删除</a></td>
                  </tr>
	            </c:forEach>
	            </tbody>
              </table>
              <div class="text-center">
              	<nav>
                    <ul class="pager">
                      <li><a href="<%=basePath%>/admin/huodong/?page=1">首页</a></li>
                        <li><a href="<%=basePath%>/admin/huodong/?page=${navigator.prePageNo}">上一页</a></li>
                        <li><a href="<%=basePath%>/admin/huodong/?page=${navigator.nextPageNo}">下一页</a></li>
                        <li><a href="<%=basePath%>/admin/huodong/?page=${navigator.pageCount}">末页</a></li>
                        <li>&nbsp;当前 ${navigator.nowPageNo}/${navigator.pageCount} 页&nbsp;&nbsp;每页${navigator.pageSize}条&nbsp;&nbsp;共${navigator.count}条</li>
                    </ul>
                  </nav>
              </div>
       </div>
     </div>
 </div> 
</body>
</html>