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
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:wb=“http://open.weibo.com/wb” lang="zh-CN">
<head>
<title>微博</title>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="8"]').addClass('active');
</script>
	<div class="container">
		<div class="row">
			<div class="col-md-12" style="text-align:center;">
					<wb:topic uid="2719209924" topmid="z8ClGsZa8" column="y" border="y" title="%E5%BE%AE%E5%8D%9A%E8%AF%9D%E9%A2%98%E5%A2%99" width="821" height="1190" tags="%E5%A5%BD%E7%94%A8%E5%90%97" language="zh_cn" version="base" appkey="5ADrkj" footbar="y" filter="n" ></wb:topic>
			</div>
		</div>
	</div>
</body>
</html>
