<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<title>${notice.notice.nTitle}</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<script type="text/javascript">
$('.header-nav li').removeClass('active');
$('.header-nav li[data-menu-id="5"]').addClass('active');
</script>
  <div class="container">
    <div class="row">
    	<div class="col-md-10">
      	  <div style="border:1px solid #DFDFDF;">
      	  	<h6 style="margin:0; height:32px; line-height:32px; border-bottom:1px solid #DFDFDF; text-indent:20px;">位置：首页 &gt; 站内公告 &gt; 公告详情</h6>
        	<h2 class="text-center" style="background:#F9F9F9; margin:0; height:40px; line-height:40px;">${notice.notice.nTitle}</h2>
            <p class="text-center" style="background:#F5F5F5; border:1px solid #E9E9E9; border-left:none; border-right:none; height:25px; line-height:25px; color:#333;">
            	作者:${notice.user.userNickname}&nbsp;&nbsp;
            	点击:${notice.noticeCount}次&nbsp;&nbsp;
            	发布时间:${fn:substring(notice.notice.nDatetimeBuild, 0, 19)}</p>
            <div class="lead notice_content" style="padding:15px 20px;">
            	${notice.notice.nDesc}
            </div>
            <hr />
            	<h4 style="margin:0 15px 10px;">最新评论</h4>
	          <div style="padding:0 15px;" id="comments"></div>
              <hr />
              <div>
				  <div class="form-group" style="margin:15px;">
				    <label for="content" class="col-sm-2 control-label">回复</label>
				    <div class="col-sm-10">
				    <input type="hidden" name="nid" value="${notice.notice.nId}" id="comment-notice-id" />
				      <textarea class="form-control" rows="3" id="comment-notice-content" style="resize: none;"></textarea>
				    </div>
				  </div>
				  <div class="form-group" style="margin:15px;">
				    <div class="col-sm-offset-2 col-sm-10">
				    	<c:choose>
				      		<c:when test="${myself != null }">
						      	<button type="button" class="btn btn-default" id="comment-notice-btn">回复</button>
				      		</c:when>
				      		<c:otherwise>
				      			您还未<a href="<%=basePath%>/login/">登陆</a>，不能发表评论。
					      	</c:otherwise>
				      	</c:choose>
				    </div>
				  </div>
			  </div>
          </div>
        </div>
        <div class="col-md-2">
        	<img src="<%=basePath%>/images/201309211379756723136.jpg" class="img-responsive" style="width:100%; height:auto;" />
        </div>
    </div>
  </div>
  			<script type="text/javascript">
  				//获取评论
	  			function getComments(page) {
	  				var noticeId = $("#comment-notice-id").val();
					var url = "<%=basePath%>/tieba/" + noticeId + "/comment.json";
					$.getJSON(url, {"id":noticeId, "page":page, "pageSize":"5"}, function(data) {
						var dataJson = eval(data);
						var navigator = dataJson.navigator;
						var list = dataJson.noticeComments;
						var comments = "";
						for (var i = 0; i < list.length; i++) {
							comments+= '<div class="panel panel-default comment-item">' + 
													'<div class="panel-body">' + list[i].noticeComment.ncContent + '</div>' + 
													'<div class="panel-footer">' + 
														'由 ' + list[i].user.userNickname + ' 于 ' + list[i].noticeComment.ncDatetime + ' 评论' + 
													'</div>' + 
												'</div>';
						}
						comments +='<div class="text-center">' + 
									              	 '<nav>' + 
									                    '<ul class="pager">' + 
									                        '<li><a href="javascript:getComments(' + navigator.firstPage + ');">首页</a></li> ' + 
									                        '<li><a href="javascript:getComments(' + navigator.prePage + ');">上一页</a></li> ' + 
									                        '<li><a href="javascript:getComments(' + navigator.nextPage + ');">下一页</a></li> ' + 
									                        '<li><a href="javascript:getComments(' + navigator.lastPage + ');">末页</a></li> ' + 
									                        '<li>' + 
									                        	'&nbsp;当前 ' + navigator.nowPage + '/ ' + navigator.pageCount + ' 页&nbsp;' + 
									                        	'&nbsp;每页' + navigator.pageSize + '条&nbsp;' + 
									                        	'&nbsp;共' + navigator.count + '条' + 
									                        '</li>' + 
									                    '</ul>' + 
									                  '</nav>' + 
								              '</div>';
						$("#comments").html(comments);
					});
	  			}
  				//评论按钮
	  			function btnSubmit() {
	  				$("#comment-notice-btn").bind("click", function() {
	  					var id = $.trim($("#comment-notice-id").val());
	  					var content = $.trim($("#comment-notice-content").val());
	  					var url = "<%=basePath%>/tieba/id/comment/save.json";
	  					$("#comment-notice-btn").attr("disabled", true).val("提交中...");
	  					$.post(url, {"id":id, "content":content}, function(data) {
	  						var dataJson = eval(data);
							if(dataJson.message == "success") {
								var commnet =  '<div class="panel panel-default">' + 
																'<div class="panel-body">' + content + '</div>' + 
																'<div class="panel-footer">刚刚</div>' + 
															'</div>';
								if($("#comments>.comment-item").length>=5) {
									$("#comments>.comment-item").last().remove();
								}
								$(commnet).prependTo("#comments");
								$("#comment-notice-content").val("");
								$("#comment-notice-btn").attr("disabled", false).val("评论");
							} else {
								alert("评论失败");
							}
	  					});
	  				});
	  			}
				$(function() {
					getComments(1); 
					btnSubmit();
				});
			</script>
</body>
</html>
