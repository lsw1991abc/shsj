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
	<title>公告管理</title>
</head>

<body>

 <div class="col-md-10">
   	<div class="panel panel-default">
       <div class="panel-heading">
         <h3 class="panel-title">公告管理</h3>
       </div>
       <div class="panel-body">
       	<form role="form" action="<%=basePath%>/admin/gonggao/save" method="post" id="notice-form">
       		<div id="title-description"></div>
		  <div class="form-group">
		    <label for="notice-title">标题</label>
		    <input type="text" class="form-control" id="notice-title" name="title" placeholder="标题长度1～50"
		    			data-required="true" data-pattern="^([\u4E00-\u9FA5]|\w){1,50}$"
						data-describedby="title-description" data-description="title"   />
		  </div>
		  <div class="form-group">
		    <label for="notice-content">内容</label>
		    <textarea class="form-control" rows="3" style="resize:vertical;" id="notice-content" name="content"></textarea>
		  </div>
		  <button type="submit" class="btn btn-primary">发布</button>
		</form>
		
		<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script>  
		<script type="text/javascript">
			$(function() {
				CKEDITOR.replace('notice-content', {
					customConfig : '<%=basePath%>/ckeditor/daily-edit-config.js' 
				});
				
				$('#notice-form').validate({
					onKeyup : true,
					eachValidField : function() {
						$(this).closest('div').removeClass('has-error').addClass('has-success');
					},
					eachInvalidField : function() {
						$(this).closest('div').removeClass('has-success').addClass('has-error');
					},
					description : {
						title : {
							required : '<div class="alert alert-danger">标题不能为空</div>',
							pattern : '<div class="alert alert-danger">标题长度1～50</div>'
						}
					}
				});
			});
		</script>
         <table class="table table-striped">
         	<thead>
         		<tr>
         			<th style="width:70%;">标题</th>
         			<th style="width:15%;" class="text-center">时间</th>
         			<th style="width:15%;" class="text-center">操作</th>
         		</tr>
         	</thead>
         	<tbody>
	            <c:forEach var="notice" items="${notices}">
	              <tr>
                    <td style="width:70%;"><a href="<%=basePath%>/gonggao/${notice.n_id}" target="_blank">${notice.n_title}</a></td>
                    <td style="width:15%;" class="text-center">${fn:substring(notice.n_datetime_build, 0, 19)}</td>
                    <td style="width:15%;" class="text-center"><a href="<%=basePath%>/admin/gonggao/delete/${notice.n_id}">删除</a></td>
                  </tr>
	            </c:forEach>
	            </tbody>
              </table>
              <div class="text-center">
              	<nav>
                    <ul class="pager">
                      <li><a href="<%=basePath%>/admin/gonggao/?page=1">首页</a></li>
                        <li><a href="<%=basePath%>/admin/gonggao/?page=${navigator.prePageNo}">上一页</a></li>
                        <li><a href="<%=basePath%>/admin/gonggao/?page=${navigator.nextPageNo}">下一页</a></li>
                        <li><a href="<%=basePath%>/admin/gonggao/?page=${navigator.pageCount}">末页</a></li>
                        <li>&nbsp;当前 ${navigator.nowPageNo}/${navigator.pageCount} 页&nbsp;&nbsp;每页${navigator.pageSize}条&nbsp;&nbsp;共${navigator.count}条</li>
                    </ul>
                  </nav>
              </div>
       </div>
     </div>
 </div> 
</body>
</html>