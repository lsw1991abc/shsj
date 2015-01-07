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
	<title>编辑日志</title>
</head>

<body>
  <div class="container">
    <div class="row">
    	<div class="col-md-10">
      	  <div style="border:1px solid #DFDFDF;">
      	  	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 校友日志 &gt; 日志编辑</h6>
      	  	<div style="display:none" class="alert alert-dismissible" role="alert" id="alertMsg">
           		<button type="button" class="close" data-dismiss="alert">
           			<span aria-hidden="true">&times;</span>
           			<span class="sr-only">Close</span>
           		</button>
           		<strong>修改成功</strong>
           	</div> 
                  	
      	  	<div class="form-group">
		      <div class="input-group" style="margin:10px 20px;">
		        <div class="input-group-addon">标题</div>
		        <input type="email" class="form-control" id="daily_title" placeholder="标题" value="${daily.d_title}" />
		      </div>
		    </div>
            <div class="lead daily_content" style="padding:15px 20px;">
            	<textarea class="form-control" rows="3" style="resize:vertical;" id="daily_content">${daily.d_content}</textarea>
            </div>
            <p class="text-center"><button type="button" class="btn btn-primary" onclick="saveOrUpdate(this, '${daily.d_id}');">保存</button></p>
            <style type="text/css">
				.daily_content p{  text-indent:32px;}
            </style>
            <script type="text/javascript">
            function saveOrUpdate(btn ,id) {
            	var title = $.trim($("#daily_title").val());
            	var content = $.trim($("#daily_content").val());
            	$(btn).html("保存中...").attr("disabled", "disabled");
           		$.post("<%=basePath%>/user/rizhi/save.json", {id:id, title:title, content:content}, function(data) {
           			console.log(data);
           			if(data.result == "success") {
        	  			$('#alertMsg>strong').html("保存成功");
        	  			$('#alertMsg').addClass('alert-success');
        	  		} else {
        	  			$('#alertMsg>strong').html("保存失败");
        	  			$('#alertMsg').addClass('alert-warning');
        	  		}
        	  		$('#alertMsg').slideDown("fast");
        	  		$(btn).html("保存").removeAttr("disabled");
           		});
            }
            </script>
          </div>
        </div>
        <div class="col-md-2">
        	<img src="<%=basePath%>/images/201309211379756723136.jpg" class="img-responsive" style="width:100%; height:auto;" />
        </div>
    </div>
  </div>
</body>
</html>
