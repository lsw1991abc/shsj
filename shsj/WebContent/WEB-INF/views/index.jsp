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
	<title>首页</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="1"]').addClass('active');
</script>
  <div class="container">
    <div class="row">
      <div class="col-md-4"> <a href="#"><img src="<%=basePath %>/images/201310151381836463832.jpg" style="height:100px; width:100%;" class="img-responsive" alt="Responsive image" /></a> </div>
      <div class="col-md-4"> <a href="#"><img src="<%=basePath %>/images/201310151381836483557.gif" style="height:100px; width:100%;" class="img-responsive" alt="Responsive image" /></a> </div>
      <div class="col-md-4"> <a href="#"><img src="<%=basePath %>/images/201310151381836503996.jpg" style="height:100px; width:100%;" class="img-responsive" alt="Responsive image" /></a> </div>
    </div>
    <br />
    <div class="row">
      <div class="col-md-3">
        <div style="border:1px solid #D5D5D5;">
          <h5 style="background:url('<%=basePath %>/images/title.png') left -35px repeat-x; margin:0; height:33px; line-height:28px;"><a href="<%=basePath %>/gonggao" style="float:right; margin-right:15px; color:#666666;">更多&gt;&gt;</a></h5>
          <div style="padding:0 10px; height:227px;">
          	
            <h4 style="height:30px; line-height:30px; width:100%; overflow:hidden;"><a href="<%=basePath%>/gonggao/${notices[0].nId}" target="_blank" style="color:#F00;" title="${notices[0].nTitle}">${notices[0].nTitle}</a></h4>
            <ul class="list-unstyled zngg" style="">
              <c:forEach items="${notices}" var="notice" begin="1" step="1" end="6">
              	<li><a href="<%=basePath%>/gonggao/${notice.nId}" target="_blank" title="${notice.nTitle}">${notice.nTitle}</a></li>
              </c:forEach>  
            </ul>
            <style type="text/css">
				.zngg li{ width:191px; height:30px; overflow:hidden; line-height:30px; text-indent:15px; background:url('<%=basePath%>/images/syimgs.png') left -190px no-repeat; }
				.zngg li>a{ color:#333;}
            </style>
          </div>
        </div>
      </div>
      <div class="col-md-6" style="padding:0; height:272px">
      	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
              </ol>
            
              <div class="carousel-inner" role="listbox">
                <div class="item index_pic active">
                  <img src="<%=basePath %>/images/201310161381888095176.jpg" title="image" style="width:100%; height:100%;" class="img-responsive" alt="Responsive image" /> 
                  <div class="carousel-caption">
                    aaaa
                  </div>
                </div>
                <div class="item index_pic">
                  <img src="<%=basePath %>/images/201310161381888095176.jpg" title="image" style="width:100%; height:100%;" class="img-responsive" alt="Responsive image" /> 
                  <div class="carousel-caption">
                    ddddd
                  </div>
                </div>
                <div class="item index_pic">
                  <img src="<%=basePath %>/images/201310161381888095176.jpg" title="image" style="width:100%; height:100%;" class="img-responsive" alt="Responsive image" /> 
                  <div class="carousel-caption">
                    ddddd
                  </div>
                </div>
              </div>
            <style type="text/css">
				.carousel-inner, .carousel-inner .index_pic{ height:272px;}
            </style>
              <!-- Controls -->
              <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">上一页</span>
              </a>
              <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">下一页</span>
              </a>
            </div>
      </div>
      <div class="col-md-3" style="">
        <div style="border:1px solid #BF4D00;">
          <h5 style="background:url('<%=basePath %>/images/title.png') -1px -71px repeat-x; margin:0; text-indent:35px; height:33px; line-height:28px; color:#FFF;">会员中心</h5>
          <div style="height:237px;" class="text-center"> <br />
			<c:choose>
				<c:when test="${myself != null}">
					<div style="padding: 0 8px; height: 142px;"
						class="index-login-panel">
						<h4>大学生社会实践服务中心</h4>
						<p>登录用户：${myself.userAccount }</p>
						<button type="button" class="btn btn-warning" onclick="javascript:location.href='<%=basePath%>/user'">用户中心</button>
						&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-default" onclick="javascript:location.href='<%=basePath%>/login/logout'">退出</button>
						<ul class="list-inline" style="margin-top: 25px;">
							<li><a href="#">忘记密码</a></li>
							<li><a href="<%=basePath%>/user/rizhi">我的日志</a></li>
							<li><a href="<%=basePath%>/user/jianli">我的简历</a></li>
							<li><a href="<%=basePath%>/user/ziliao">个人资料</a></li>
							<li><a href="<%=basePath%>/user/xgmm">修改密码</a></li>
							<li><a href="<%=basePath%>/login/logout">退出登录</a></li>
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<div style="padding: 0 8px; height: 142px; margin-top:-13px;" class="index-login-panel">
						<form class="form-inline" role="form" action="<%=basePath%>/login/login" method="post">
							<div class="form-group" style="margin-bottom: 10px;">
								<label class="sr-only" for="inputUsername">用户名</label> 
								<input type="text" class="form-control" id="inputUsername"
										name="username" placeholder="用户名" style="width: 200px;" />
							</div>
							<div class="form-group" style="margin-bottom: 10px;">
								<label class="sr-only" for="inputPassword">密码</label> 
								<input type="password" class="form-control" id="inputPassword"
										name="password" placeholder="密码" style="width: 200px;" />
							</div>
							<div class="form-group" style="margin-bottom: 10px;">
								<label class="sr-only" for="inputPassword">验证码</label> 
								<input type="text" class="form-control" id="inputVerifyCode" name="verifyCode"
										placeholder="验证码长度4" style="width: 200px;" />
								<img id="verifycode" src="#" alt="验证码" title="点击刷新" style="cursor:pointer;"/>
							</div>
							<script type="text/javascript">
								$("#verifycode").click(function() {
									var timeNow = new Date().getTime();
								    this.src="<%=basePath%>/login/verifyCode?time="+timeNow;
								});
								$("#verifycode").click();
							</script>
							<button type="submit" class="btn btn-warning">登录</button>
							&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-default" onclick="javascript:location.href='<%=basePath%>/login/register';">注册</button>
						</form>
					</div>
				</c:otherwise>
			</c:choose>
		   </div>
        </div>
      </div>
    </div>
    <br />
    <div class="row">
      <div class="col-md-8">
        <div style="border:1px solid #0099CC;">
          <h5 style="background:url('<%=basePath %>/images/title.png') -1px -1px repeat-x; margin:0; text-indent:35px; height:33px; line-height:28px; color:#FFF;">兼职推荐<a href="<%=basePath %>/jianzhi" style="float:right; margin-right:15px; color:#fff;">更多&gt;&gt;</a></h5>
          <div style="margin:5px; height:356px; overflow:hidden;">
            <table class="table table-striped">
              <thead>
              	<tr>
	              	<th style="width:35%">主题</th>
	              	<th style="width:15%" class="text-center">职位</th>
	              	<th style="width:15%" class="text-center">待遇</th>
	              	<th style="width:15%" class="text-center">工作区域</th>
	              	<th style="width:20%" class="text-center">面试时间</th>
              	</tr>
              </thead>
              <tbody>
              	<c:forEach items="${partTimes}" var="partTime" begin="0" step="1">
	                <tr>
	                  <td><a href="<%=basePath %>/jianzhi/${partTime.job.jId}" target="_blank">${partTime.job.jTitle}</a></td>
	                  <td class="text-center">${partTime.jobBelong.jbName}</td>
	                  <td class="text-center">${partTime.job.jSalary}${job.job.jSalaryType}</td>
	                  <td class="text-center">${partTime.job.jWorkPlace}</td>
	                  <td class="text-center">${partTime.job.jAuditionTime}</td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <div class="col-md-4">
      	<div style="border:1px solid #0099CC;">
      		<h5 style="background:url('<%=basePath %>/images/title.png') -1px -1px repeat-x; margin:0; text-indent:35px; height:33px; line-height:23px; color:#FFF;">校友日志<a href="<%=basePath %>/rizhi" style="float:right; margin-right:15px; color:#fff;">更多&gt;&gt;</a></h5>
            <ul class="list-unstyled xyrz" style=" margin:0 15px; background:url('<%=basePath %>/images/syimgs.png') 0px -468px no-repeat; height:261px; overflow:hidden;">
              <c:forEach items="${dailies}" var="daily" begin="0" step="1">
	              <li><a href="<%=basePath %>/rizhi/${daily.nId}" target="_blank">${daily.nTitle}</a></li>
              </c:forEach>
            </ul>
            <style type="text/css">
				.xyrz li{ width:261px; overflow:hidden; text-indent:20px; height:26px; line-height:18px;}
            </style>
        </div>
        <a href="#" style=" display:block; margin-top:10px; width:100%; height:95px;">
        	<img src="<%=basePath %>/images/201310151381836644237.jpg" style="width:100%; height:100%;" class="img-responsive" alt="会员使用手册" title="会员使用手册" />
        </a>
      </div>
    </div>
    <br />
    <div class="row">
      <div class="col-md-8">
        <div style="border:1px solid #6A0035;">
          <h5 style="background:url('<%=basePath %>/images/title.png') -1px -106px repeat-x; margin:0; text-indent:35px; height:33px; line-height:28px; color:#FFF;">全职招聘<a href="<%=basePath %>/zhaopin" style="float:right; margin-right:15px; color:#fff;">更多&gt;&gt;</a></h5>
          <div style="margin:5px; height:356px; overflow:hidden;">
            <table class="table table-striped">
              <thead>
              	<tr>
	              	<th style="width:35%">主题</th>
	              	<th style="width:15%" class="text-center">职位</th>
	              	<th style="width:15%" class="text-center">待遇</th>
	              	<th style="width:15%" class="text-center">工作区域</th>
	              	<th style="width:20%" class="text-center">面试时间</th>
              	</tr>
              </thead>
              <tbody>
                <c:forEach items="${jobs}" var="job" begin="0" step="1">
	                <tr>
	                  <td><a href="<%=basePath %>/zhaopin/${job.job.jId}" target="_blank">${job.job.jTitle}</a></td>
	                  <td class="text-center">${job.jobBelong.jbName}</td>
	                  <td class="text-center">${job.job.jSalary}${job.job.jSalaryType}</td>
	                  <td class="text-center">${job.job.jWorkPlace}</td>
	                  <td class="text-center">${job.job.jAuditionTime}</td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <div class="col-md-4">
      	<div style="border:1px solid #6A0035;">
      		<h5 style="background:url('<%=basePath %>/images/title.png') -1px -106px repeat-x; margin:0; text-indent:35px; height:33px; line-height:28px; color:#FFF;">求职宝典<a href="<%=basePath%>/baodian" style="float:right; margin-right:15px; color:#fff;">更多&gt;&gt;</a></h5>
            <ul class="list-unstyled qzbd" style=" margin:0 15px; height:366px; overflow:hidden; ">
              <c:forEach items="${treasures}" var="treasure" begin="0" step="1">
              	<li><a href="<%=basePath%>/baodian/${treasure.nId}" target="_blank" title="${treasure.nTitle}">${treasure.nTitle}</a></li>
              </c:forEach>     
            </ul>
            <style type="text/css">
				.qzbd li{ height:30px; width:261px; overflow:hidden; line-height:30px; text-indent:15px; background:url('<%=basePath %>/images/syimgs.png') left -190px no-repeat;}
            </style>
        </div>        
      </div>
    </div>
    <br />
    <div class="row">
      <div class="col-md-12">
      	<div style="border:1px solid #669900;">
        	<h5 style=" height:33px; text-indent:35px; line-height:28px; margin:0; background:url('<%=basePath %>/images/title.png') -1px -141px repeat-x; color:#fff;">活动案例<a href="<%=basePath %>/huodong" style="float:right; margin-right:15px; color:#fff;">更多&gt;&gt;</a></h5>
            <ul class="list-inline hdal" style="margin:15px 10px 5px;">
              <c:forEach items="${activits}" var="activit" begin="0" step="1" end="6">
            	<li class="text-center" >
                	<a href="<%=basePath %>/huodong/${activit.aId}" target="_blank">
                		<img src="<%=basePath %>/${activit.aPic}" title="${activit.aTitle}" class="img-responsive" style="height:80px; width:110px;" />
                	</a>
                    <label><a href="<%=basePath %>/huodong/${activit.aId}" target="_blank">${fn:substring(activit.aTitle, 0, 8)}</a></label>
                </li>
               </c:forEach>
            </ul>
            <style type="text/css">
				.hdal li{ padding:0 10px;}
            </style>
        </div>
      </div>     
    </div>
  </div>
</body>
</html>
