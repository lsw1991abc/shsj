<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>上传测试</title>
	<link rel="stylesheet" href="<%=basePath %>/uploadify/uploadify.css" type="text/css" />
	<script src="<%=basePath %>/uploadify/jquery.uploadify.js"></script>
	<script type="text/javascript">
	$(function() {
	    $("#file_upload").uploadify({
	        //开启调试
	        'debug' : false,
	        //是否自动上传
	        'auto':false,
	        //超时时间
	        'successTimeout':99999,
	        //附带值
	        /*
	        'formData':{
	            'userid':'用户id',
	            'username':'用户名',
	            'rnd':'加密密文'
	        },
	        */
	        //flash
	        'swf': "<%=basePath %>/uploadify/uploadify.swf",
	        'buttonText' : '选择文件',
	        'cancelImg':"<%=basePath %>/uploadify/uploadify-cancel.png",
	        //不执行默认的onSelect事件
	        //'overrideEvents' : ['onDialogClose'],
	        //文件选择后的容器ID
	        'queueID':'fileQueue',
	        //服务器端脚本使用的文件对象的名称 $_FILES个['upload']
	        'fileObjName':'file',
	        //上传处理程序
	        'uploader':'<%=basePath %>/upload/upload.json',
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
	        //上传文件的大小限制
	        'fileSizeLimit':'3MB',
	        //上传数量
	        'queueSizeLimit' : 5,
	        //每次更新上载的文件的进展
	        'onUploadProgress' : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
	             //有时候上传进度什么想自己个性化控制，可以利用这个方法
	             //使用方法见官方说明
	        },
	        //选择上传文件后调用
	        'onSelect' : function(file) {
	                  
	        },
	        //返回一个错误，选择文件的时候触发
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
	        //检测FLASH失败调用
	        'onFallback':function(){
	            alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
	        },
	        //上传到服务器，服务器返回相应信息到data里
	        'onUploadSuccess':function(file, data, response){
	        	var imgUrl = uploadCommon.getPath(data);
	        	console.log(imgUrl);
                $("#imgUrl").val(imgUrl);// 返回的图片路径保存起来
                $("#thumbImg").attr("src", IMAGE_FILE_PATH + imgUrl);// 更新logo显示
                /*uploadCommon.uploadImageBtnStyle("imgUrl");
                uploadCommon.initPreviewAfterUpload(data); // 新图片预览*/
	        }
	    });
	});
	</script>  
</head>

<body>
	<div>
        <%--用来作为文件队列区域--%>
        <div id="fileQueue"></div>
        <input id="file_upload" name="file_upload" type="file" multiple="true" />
        <p>
        	<a href="javascript:$('#file_upload').uploadify('upload');">上传</a>| 
            <a href="javascript:$('#file_upload').uploadify('cancel');">取消上传</a>| 
            <a href="javascript:$('#file_upload').uploadify('upload', '*');">上传所有</a>| 
            <a href="javascript:$('#file_upload').uploadify('cancel', '*');">取消所有上传</a>
        </p>
    </div>
</body>
</html>
