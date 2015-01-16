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
	<title>招聘管理</title>
	<link href="<%=basePath %>/jquery-ui-1.11.2/jquery-ui.css" type="text/css" rel="stylesheet" />
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
       			<tr style="height:32px; line-height:32px;">
       				<td style="width:10%; padding-bottom:15px;">招聘单位：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" id="job_organnizer" name="organnizer" placeholder="招聘单位" />
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">职位名称：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" id="job_title" name="title" placeholder="职位名称" />
						 </div>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">职位分类：</td>
       				<td style="width:40%;">
       					<div class="form-group">
       						<select class="form-control" style="width:75%;" id="job_belong"  name="belong" >
       							<c:forEach items="${belongs}" var="belong">
       								<option value="${belong.jb_id}">${belong.jb_name}</option>
       							</c:forEach>
							</select>
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">工作类型：</td>
       				<td style="width:40%;">
       					<div class="form-group" >
       						<select class="form-control" style="width:75%;" id="job_type"  name="type" >
							  <option value="1">全职</option>
							  <option value="2">兼职</option>
							</select>
						 </div>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">工作区域：</td>
       				<td style="width:90%;" colspan="3">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:89%;" id="job_place"  name="place" placeholder="工作区域"  />
						 </div>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">工作待遇：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" id="job_salary"  name="salary" placeholder="工作待遇"  />
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">工作时间：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" id="job_datetime-work"  name="datetime-work" placeholder="工作时间"  />
						 </div>
					 </td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">招聘人数：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" id="job_number"  name="number" placeholder="招聘人数"  />
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">人数限制：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" id="job_number-limit"  name="number-limit" placeholder="人数限制"  />
						 </div>
					</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">联系电话：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" id="job_contact"  name="contact" placeholder="联系电话"  />
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">面试时间：</td>
       				<td style="width:40%;">
       					<div class="form-group" style="margin-top:-15px;">
				    		<input type="text" class="form-control" style="width:35%; display:block; float:left;" readonly="readonly" id="job_datetime-start"  name="datetime-start" placeholder="开始时间"  />
				    		<span style="display:block; float:left; width:15px; text-align:center;">~</span>
				    		<input type="text" class="form-control" style="width:35%;display:block; float:left;" readonly="readonly" id="job_datetime-end"  name="datetime-end" placeholder="结束时间"  />
				    		<br style="clean:both;" />
						 </div>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">面试地址：</td>
       				<td style="width:90%;" colspan="3">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:89%;" id="job_audition-place"  name="audition-place" placeholder="面试地址"  />
						 </div>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%; padding-bottom:15px;">工作详情：</td>
       				<td style="width:90%;" colspan="3">
       					<textarea rows="3" style="width:89%;resize:vertical;" name="content" id="job_content"></textarea>
       				</td>
       			</tr>
       		</table>
		  <button type="submit" class="btn btn-primary">发布</button>
		</form>
   		<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script> 
   		<script type="text/javascript" src="<%=basePath%>/jquery-ui-1.11.2/jquery-ui.js"></script> 
   		<script type="text/javascript">
   			$(function(){
   				CKEDITOR.replace('job_content', {
   					customConfig : '<%=basePath%>/ckeditor/job-edit-config.js' 
   				});
   				
   				$( "#job_datetime-start" ).datepicker({
   					inline: true
   				});
   				$( "#job_datetime-end" ).datepicker({
   					inline: true
   				});
   			});
   		</script>
         <table class="table table-striped">
         	<thead>
         		<tr>
         			<th style="width:40%;">标题</th>
         			<th style="width:15%;" class="text-center">职位</th>
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
	              			<td style="width:40%;">[${job.jt_name}]<a href="<%=basePath%>/zhaopin/${job.j_id}" target="_blank">${job.j_title}</a></td>
	              		</c:when>
	              		<c:when test="${job.j_type == '2'}">
	              			<td style="width:40%;">[${job.jt_name}]<a href="<%=basePath%>/jianzhi/${job.j_id}" target="_blank">${job.j_title}</a></td>
	              		</c:when>
	              	</c:choose>
                    
                    <td style="width:15%;" class="text-center">${job.jb_name}</td>
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