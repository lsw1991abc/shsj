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
	<title>活动管理</title>
	<link href="<%=basePath %>/jquery-ui-1.11.2/jquery-ui.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="<%=basePath %>/uploadify/uploadify.css" type="text/css" />
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
		  		<tr style="height:32px; line-height:32px;">
       				<td style="width:10%; padding-bottom:15px;">标题：</td>
       				<td style="width:90%;" colspan="3">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:89%;" id="activit_title" name="title" placeholder="活动标题" />
						 </div>
       				</td>
       			</tr>
       			<tr style="height:32px; line-height:32px;">
       				<td style="width:10%; padding-bottom:15px;">主办单位：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:85%;" id="activit_organizer" name="organizer" placeholder="主办单位" />
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">活动策划：</td>
       				<td style="width:40%;">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:75%;" id="activit_plotter" name="plotter" placeholder="活动策划" />
						 </div>
       				</td>
       			</tr>
       			<tr style="height:32px; line-height:32px;">
       				<td style="width:10%; padding-bottom:15px;">参与人数：</td>
       				<td style="width:40%; padding-bottom:15px;">
       					<div class="input-group" style="width:85%;" >
				    		<input type="text" class="form-control" id="activit_number" name="number" placeholder="参与人数" />
				    		<div class="input-group-addon">人</div>
						 </div>
       				</td>
       				<td style="width:10%; padding-bottom:15px;">活动状态：</td>
       				<td style="width:40%;">
       					<div class="form-group">
       						<select class="form-control" style="width:75%;" id="activit_statu" name="statu">
       							<c:forEach items="${status }" var="statu">
       								<option value="${statu.as_id}">${statu.as_name}</option>
       							</c:forEach>
       						</select>
						 </div>
       				</td>
       			</tr>
       			<tr style="height:32px; line-height:32px;">
       				<td style="width:10%; padding-bottom:15px;">活动日期：</td>
       				<td style="width:90%;" colspan="3">
       					<div class="form-group">
				    		<input type="text" class="form-control" style="width:35%; display:block; float:left;" readonly="readonly" id="activit_datetime-start"  name="datetime-start" placeholder="开始时间"  />
				    		<span style="display:block; float:left; width:15px; text-align:center;">~</span>
				    		<input type="text" class="form-control" style="width:35%;display:block; float:left;" readonly="readonly" id="activit_datetime-end"  name="datetime-end" placeholder="结束时间"  />
				    		<br style="clean:both;" />
						 </div>
					 </td>
       			</tr>
       			<tr>
       				<td style="width:10%;">活动详情：</td>
       				<td style="width:90%;" colspan="3">
       					<textarea rows="3" style="resize:vertical;" name="content" id="activit_content"></textarea>
       				</td>
       			</tr>
       			<tr>
       				<td style="width:10%;">图片：</td>
       				<td style="width:90%;" colspan="3">
       					<div id="fileQueue" style="float:left; margin:10px 10px 10px 0; width:322px; height:242px; border:1px solid #000;">活动图片</div>
       					<p style="float:left;margin-top:100px; margin-left:30px;">
					        <input id="file_upload" name="file_upload" type="file" disabled="disabled"/>
					        <a href="javascript:$('#file_upload').uploadify('upload');">上传</a>| 
					        <a href="javascript:$('#file_upload').uploadify('cancel');">取消上传</a>
				        </p>
				        <input type="hidden" id="imgPath" name="imgPath" value="">
				        <br style="clear: both;" />
       				</td>
       			</tr>
       		</table>
		  <button type="submit" class="btn btn-primary">发布</button>
		</form>
		<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script> 
		<script type="text/javascript" src="<%=basePath%>/jquery-ui-1.11.2/jquery-ui.js"></script> 
		<script type="text/javascript" src="<%=basePath %>/uploadify/jquery.uploadify.js"></script>
   		<script type="text/javascript">
   			$(function(){
   				CKEDITOR.replace('activit_content', {
   					customConfig : '<%=basePath%>/ckeditor/job-edit-config.js' 
   				});
   				
   				$( "#activit_datetime-start" ).datepicker({
   					inline: true
   				});
   				$( "#activit_datetime-end" ).datepicker({
   					inline: true
   				});
   				
   				$("#file_upload").uploadify({
   			        'debug' : false,
   			        'auto':false,
   			     	'multi':false,
   			        'successTimeout':99999,
   			        /*
   			        'formData':{
   			            'userid':'用户id',
   			            'username':'用户名',
   			            'rnd':'加密密文'
   			        },
   			        */
   			        'swf': "<%=basePath %>/uploadify/uploadify.swf",
   			        'buttonText' : '选择文件',
   			        //不执行默认的onSelect事件
   			        //'overrideEvents' : ['onDialogClose'],
   			        'queueID':'fileQueue',
   			        'fileObjName':'file',
   			        'uploader':'<%=basePath %>/admin/huodong/img.json',
   			        //浏览按钮的背景图片路径
   			        //'buttonImage':'upbutton.gif',
   			        //浏览按钮的宽度
   			        'width':'100',
   			        //浏览按钮的高度
   			        'height':'32',
   			        //expressInstall.swf文件的路径。
   			        //'expressInstall':'expressInstall.swf',
   			        //在浏览窗口底部的文件类型下拉菜单中显示的文本
   			        //'fileTypeDesc':'支持的格式：',
   			        //允许上传的文件后缀
   			        'fileTypeExts':'*.jpg;*.jpeg;*.gif;*.png',
   			        'fileSizeLimit':'2MB',
   			        'queueSizeLimit' : 1,
   			        //每次更新上载的文件的进展
   			        'onUploadProgress' : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
   			             //有时候上传进度什么想自己个性化控制，可以利用这个方法
   			             //使用方法见官方说明
   			        },
   			        'onSelect' : function(file) {
   			       		//选择上传文件后调用
   			        },
   			        'onSelectError':function(file, errorCode, errorMsg){
   			            switch(errorCode) {
   			                case -100:
   			                    alert("上传的文件数量已经超出系统限制的"+$('#file_upload').uploadify('settings','queueSizeLimit')+"个文件！");
   			                    break;
   			                case -110:
   			                    alert("文件 ["+file.name+"] 大小超出系统限制的"+$('#file_upload').uploadify('settings','fileSizeLimit')+"大小！");
   			                    break;
   			                case -120:
   			                    alert("文件 ["+file.name+"] 大小异常！");
   			                    break;
   			                case -130:
   			                    alert("文件 ["+file.name+"] 类型不正确！");
   			                    break;
   			            }
   			        },
   			        'onFallback':function(){
   			            alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
   			        },
   			        'onUploadSuccess':function(file, data, response){
   			        	var result = JSON.parse(data);
   			        	var fileInfoDto = result.fileInfoDto;
   			        	
   			        	if(fileInfoDto.result == 'success') {
   			        		$("#imgPath").val(fileInfoDto.path);
   			        		var img = '<img src="<%=basePath %>' + fileInfoDto.path + '" style="height:240px; width:320px;" />';
   			        		$("#fileQueue").html(img);
   			        	} else {
   			        		alert("上传失败");
   			        	}
   			        }
   			    });
   			});
   		</script>
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