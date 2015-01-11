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
	<title>会员简历</title>
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="resume"]').addClass('active');
</script>
  <div class="container">
    <div class="row">
    	<div class="col-md-10">
        	<div style="border:1px solid #DFDFDF;">
            	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 会员简历</h6>
                <ul class="list-unstyled resumes" style="margin:7px 15px;">
                	<c:forEach var="resume" items="${resumes}" step="1">
	                  <li>
                         <div class="row" style="margin:0 0 8px;">
                        	<div class="col-md-3" style="padding:5px; border:1px solid #DFDFDF;">
                            	<img src="<%=basePath%>/images/resume/${resume.r_pic}" style="height:130px; width:190px;" class="img-responsive" alt="img" />
                            </div>
                            <div class="col-md-9 resume_item">
                            	<h4><a href="<%=basePath%>/rencai/${resume.r_id}" target="_blank">${resume.r_name}</a>&nbsp;<span>性别:${resume.r_sex}</span>&nbsp;<span>学校:${resume.r_college}</span>&nbsp;<span>专业:${resume.r_major}</span>&nbsp;<span>入学:${resume.r_entrance}年</span></h4>
                                <div class="lead hdal_item_content">${resume.r_profile}</div>
                                <p style="height:28px; line-height:28px; margin:0;">更新时间：${fn:substring(resume.r_datetime_update, 0, 10)}&nbsp;&nbsp;人气值: ${resume.r_hot} 次</p>
                            </div>
                        </div>
                      </li>
                    </c:forEach>
                </ul>
                <style type="text/css">
					.resumes li{border-bottom:1px dashed #DFDFDF; margin:8px 0 0;}
					.resumes .resume_item span{ font-size:13px;}
					.resumes .resume_item_content{ text-indent:30px; height:65px; margin-bottom:5px;}
                </style>
                <div class="text-center">
                	<nav>
                      <ul class="pager">
                      	<li><a href="<%=basePath%>/rencai/?page=1">首页</a></li>
                        <li><a href="<%=basePath%>/rencai/?page=${navigator.prePageNo}">上一页</a></li>
                        <li><a href="<%=basePath%>/rencai/?page=${navigator.nextPageNo}">下一页</a></li>
                        <li><a href="<%=basePath%>/rencai/?page=${navigator.pageCount}">末页</a></li>
                        <li>&nbsp;当前 ${navigator.nowPageNo}/${navigator.pageCount} 页&nbsp;&nbsp;每页${navigator.pageSize}条&nbsp;&nbsp;共${navigator.count}条</li>
                      </ul>
                    </nav>
                </div>
            </div>
        </div>
        <div class="col-md-2">
        	<img src="<%=basePath%>/images/201309211379756723136.jpg" class="img-responsive" style="width:100%; height:auto;" />
        </div>
    </div>
  </div>
</body>
</html>
