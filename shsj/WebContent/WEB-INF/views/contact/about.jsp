<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>首页</title>
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="help"]').addClass('active');
</script>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
      	<div style="border:1px solid #DFDFDF;">
        	<h2 class="text-center" style="background:#F9F9F9; margin:0; height:70px; line-height:70px;">关于我们</h2>
            <p class="text-center" style="background:#F5F5F5; border:1px solid #E9E9E9; border-left:none; border-right:none; height:25px; line-height:25px; color:#333;">作者:admin     来源:本站     点击:680     发布时间:2013-09-21 15:30:10</p>
            <div class="lead gywm_content" style="padding:15px 20px;">
            	<p>大学生社会实践服务中心成立于2009年，前身大学生信息港，公司位于成都市锦江区菱安路130号。为在校大学生提供生活咨询、娱乐信息﹑职业规划、职业培训与社会实践等服务的专业网站，以帮助大学生、服务企业、奉献社会为理念，凭借对高校人文理念的深层次认知，依托高校市场联动营销网络平台的优势，将企业的品牌、文化、产品与校园化活动、和谐社会进行完美结合，打造精英团队。为企业提供营销策划、人力资源输送、市场培育、品牌传输及品牌推广等营销服务；</p>
                <p>现有固定学生会员5万多人（98%是在校大学生），并且正在以50-100人/天的增长速度递增.我们的目标是五年之内打造中国最有影响力的集团公司。</p>
                <p>崭新的世纪，非凡的挑战，我们脚踏实地，一点一滴努力到最好，服务为您，我们的荣耀，您的要求，我们的承诺，您的满意，我们的追求，我们愿与您携手共创明日的辉煌</p>
                <p>全国服务网络
　　我们将在全国二十多个大、中城市建立分站，通过完备的制度管理体系、优质的人性化服务，全国各地的会员可以非常放心、便捷地享受到“全心全意”的服务。在不久的将来，我们的网络将覆盖到全国各地。 </p>
            </div>
            <style type="text/css">
				.gywm_content p{  text-indent:32px;}
            </style>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
