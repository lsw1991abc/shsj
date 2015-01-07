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
	<title>用户中心</title>
	<link href="<%=basePath%>/style/bootstrap/bootstrap-switch.min.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>/script/bootstrap/bootstrap-switch.min.js"></script>
</head>

<body>
<div class="container">
  	<div class="row">
    	<div class="col-md-12">
        	<h3>欢迎来到大学生社会实践中心&nbsp;&nbsp;&nbsp;&nbsp;<small>当前登录用户名：${myself.nickname}</small></h3>
        </div>
    </div>
    <div class="row">
      <div class="col-md-2">
        <ul class="list-unstyled user-menu">
        	<li><a href="javascript:openPanel(0, 'cp');">控制面板</a></li>
            <li><a href="javascript:openPanel(1, 'daily');">我的日志</a></li>
            <li><a href="javascript:openPanel(2, 'resume');">我的简历</a></li> 
            <li><a href="javascript:openPanel(3, 'profile');">个人资料</a></li>
            <li><a href="javascript:openPanel(4, 'password');">修改密码</a></li>
            <c:if test="${myself.issys==1}">
            	<li><a href="<%=basePath%>/admin/" target="_blank">后台管理</a></li>
            </c:if>
            <li><a href="javascript:openPanel(5, 'exit');">退出</a></li>
        </ul>
        <style type="text/css">
			.user-menu{ border-right:1px solid #006699; text-indent:27px;}
			.user-menu li{ height:40px; line-height:40px; font-size:15px;}
			.user-menu li.active{ border:1px solid #006699; border-right:1px solid #FFF; text-indent:30px; margin:-1px}
        </style>
      </div>
      <div class="col-md-10">
      	<div class="user-cp">
            <div class="user-cp-item user-contral-panel">
              	<div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">控制面板</h3>
                  </div>
                  <div class="panel-body">
                    Panel content
                  </div>
                </div>
            </div>
            <div class="user-cp-item user-daily">
                <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">我的日志</h3>
                  </div>
                  <div class="panel-body">
                    <p><a href="<%=basePath%>/user/rizhi/edit">新日志</a></p>
                  </div>       
                  <div class="panel-body panel-body-ul">
                  </div>
                </div>
            </div>
            <style type="text/css">
            	.user-daily .panel-body-ul>ul>li{ height:42px; line-height:42px; border-bottom:1px solid #CCC;}
            	.user-daily .panel-body-ul>ul>li span{display:block;float:left}
            </style>
            <div class="user-cp-item user-resume">
               <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">我的简历</h3>
                  </div>
                  <div class="panel-body"></div>
                </div>
            </div>
            <div class="user-cp-item user-profile">
                <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">个人资料</h3>
                  </div>
                  <div class="panel-body"></div>
                </div>
            </div>
            <div class="user-cp-item user-password">
               <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">修改密码</h3>
                  </div>
                  <div class="panel-body"> 
                  	<div style="display:none" class="alert alert-dismissible" role="alert">
                  		<button type="button" class="close" data-dismiss="alert">
                  			<span aria-hidden="true">&times;</span>
                  			<span class="sr-only">Close</span>
                  		</button>
                  		<strong>修改成功</strong>
                  	</div>                    
                    <div class="form-group">
                      <label for="inputPassword_old">原始密码：</label>
                      <input type="password" class="form-control" id="inputPassword_old" placeholder="原始密码">
                    </div>
                    <div class="form-group">
                      <label for="inputPassword_new">新密码：</label>
                      <input type="password" class="form-control" id="inputPassword_new" placeholder="新密码">
                    </div>
                    <div class="form-group">
                      <label for="inputPassword_new2">确认密码：</label>
                      <input type="password" class="form-control" id="inputPassword_new2" placeholder="确认密码">
                    </div>                         
                    <button type="button" class="btn btn-primary" onclick="changePassword(this);">提交修改</button>                     
                  </div>
                </div>
            </div>
            <div class="user-cp-item user-password">
                <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">退出</h3>
                  </div>
                  <div class="panel-body text-center">
                  		<h3>您确定要退出吗？</h3>
						<button type="button" class="btn btn-danger" onclick="javascript:location.href='<%=basePath%>/login/logout';">确定退出</button>                 
                  </div>
                </div>
            </div>
        </div>
         <style type="text/css">
		   .user-cp-item{ width:100%;display:none;}
		 </style>
      </div> 
    </div>
  </div>
  <script type="text/javascript">
  var loadTr = '<tr><td><img src="<%=basePath%>/images/loading.gif" /><span style="height: 32px;line-height: 32px;margin-left: 10px;">正在加载...</span></td></tr>';

  $('.user-menu>li').eq(0).addClass('active');
  $('.user-cp>.user-cp-item').eq(0).show();

  function openPanel(index, element) {
  	$('.user-menu>li').removeClass('active').eq(index).addClass('active');
  	$('.user-cp>.user-cp-item').slideUp('fast').eq(index).slideDown('fast');
  	if('cp' == element) {
  		
  	} else if('daily' == element) {
  		$('.user-daily table tbody').html(loadTr);
  		initDailyList(1, 10);
  	} else if('resume' == element) {
  		$('.user-resume .panel-body').html(loadTr);
  		initResume();
  	} else if('message' == element) {
  		
  	} else if('profile' == element) {
  		$('.user-profile .panel-body').html(loadTr);
  		initProfile();
  	}
  }	

  function initDailyList(pageNo, pageSize) {
  	$.get('<%=basePath%>/user/rizhi.json',{page:pageNo, pageSize:pageSize}, function(data) {
  		var list = data.daillyListDto.dailies;
  		var str = "<ul class=\"list-unstyled\"><li><span style=\"width:70%;\">标题</span><span style=\"width:15%;\" class=\"text-center\">时间</span><span style=\"width:15%;\" class=\"text-center\">操作</span></li>";
  		for (var i = 0; i < list.length; i++) {
  			str += "<li id=\"daily-li-"+list[i].d_id+"\">"
  					+"<span style=\"width:70%;\">"
  						+"<a href='<%=basePath%>/rizhi/"+list[i].d_id+"' target='_blank'>"+list[i].d_title+"</a>"
  					+"</span>"
  					+"<span style=\"width:15%;\" class=\"text-center\">"+DateFormater.getDate(list[i].d_datetime_build)+"</span>"
  					+"<span style=\"width:15%;\" class=\"text-center\">"
  						+"<a href=\"<%=basePath%>/user/rizhi/edit?id="+list[i].d_id+"\">编辑</a> | <a href=\"javascript:delDaily(this, \'"+list[i].d_id+"\');\">删除</a>"
  					+"</span>"
  				+"</li>";
  		}
  		str += "</ul>";
  		var navigator = data.daillyListDto.navigator;
  		str += "<div class=\"text-center\"><nav>"
  				+"<ul class=\"pager\">"
  					+"<li><a href=\"javascript:initDailyList(1, 10);\">首页</a></li>"
					+"<li><a href=\"javascript:initDailyList("+navigator.prePageNo+", 10);\">上一页</a></li>"
					+"<li><a href=\"javascript:initDailyList("+navigator.nextPageNo+", 10);\">下一页</a></li>"
					+"<li><a href=\"javascript:initDailyList("+navigator.pageCount+", 10);\">末页</a></li>"
					+"<li>&nbsp;当前 "+navigator.nowPageNo+"/"+navigator.pageCount+" 页&nbsp;&nbsp;"
					+"每页"+navigator.pageSize+"条&nbsp;&nbsp;共"+navigator.count+"条</li>"
				+"</ul>"
				+"</nav></div>"
  		$('.user-daily .panel-body-ul').html(str);
  		$('.user-daily .panel-body-ul li:first').css("font-weight","bolder");
  		
  	});
  } 
  
  function delDaily(element, id) {
	//用户删除功能	
	var li = $("#daily-li-" + id)
	$(li).css("background", "#CCC");
	$.post('<%=basePath%>/user/rizhi/del.json', {id:id}, function(data) {
		if(data.result == "success") {
			$(li).slideUp();
  		} else {
  			alert("删除失败");
  			$(li).css("background", "#FFF");
  		}
	});
  }
  
  function initResume() {
  	$.get('<%=basePath%>/user/jianli.json', function(data) {
  		var str = '<div style="display:none" class="alert alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button><strong>修改成功</strong></div>';
	  	var list = data;
	  	str += "<table class=\"user-resume-content\">"
		  		+"<tr>"
		  			+"<td style=\"width:10%;\">姓名：</td>"
		  			+"<td style=\"width:40%;\">"
			  			+"<div>"
			  				+"<label class=\"sr-only\" for=\"resume-name\">姓名</label>"
			  				+"<input type=\"text\" class=\"form-control\" id=\"resume-name\" value=\"" + data.r_name + "\" style=\"width:80%\" />"
			 			+"</div>"
		  			+ "</td>"
		  			+"<td style=\"width:10%;\">简历状态：</td>"
		  			+"<td style=\"width:40%;\" id=\"resume-show-lable\">隐藏</td>"
		  		+"</tr>"
		  		+"<tr>"
		  			+"<td>性别：</td>"
		  			+"<td>"
			  			+"<div>"
			  				+"<label class=\"radio-inline\">"
			  				+"<input type=\"radio\" name=\"resume-sex\" id=\"resume-sex-1\" value=\"1\" style=\"height:37px;\"> 男"
			  				+"</label>"
			  				+"<label class=\"radio-inline\">"
			  				+"<input type=\"radio\" name=\"resume-sex\" id=\"resume-sex-0\" value=\"0\" style=\"height:37px;\"> 女"
			  				+"</label>"
			 			+"</div>"
					+ "</td>"
			  		+"<td>年龄：</td>"
			  		+"<td><input type=\"text\" class=\"form-control\" id=\"resume-age\" value=\"" + data.r_age + "\" style=\"width:40%\" /></td>"
		  		+"</tr>"
		  		+"<tr>"
			  		+"<td>身高：</td>"
			  		+"<td>"
				  		+"<div class=\"input-group\" style=\"width:40%\">"
			  				+"<input type=\"text\" class=\"form-control\" id=\"resume-height\" value=\"" + data.r_height + "\" />"
				        	+"<div class=\"input-group-addon\">cm</div>"
				        +"</div>"
	 			 	+"</td>"
			  		+"<td>体重：</td>"
			  		+"<td>"
				  		+"<div class=\"input-group\" style=\"width:40%\">"
			  				+"<input type=\"text\" class=\"form-control\" id=\"resume-weight\" value=\"" + data.r_weight + "\" />"
				        	+"<div class=\"input-group-addon\">kg</div>"
				        +"</div>"
		 			+"</td>"
		  		+"</tr>"
		  		+"<tr>"
			  		+"<td>学校：</td>"
			  		+"<td>"
			  			+"<div>"
	  						+"<label class=\"sr-only\" for=\"resume-college\">学校</label>"
	  						+"<input type=\"text\" class=\"form-control\" id=\"resume-college\" value=\"" + data.r_college  + "\" style=\"width:80%\" />"
	 					+"</div>"
	 				+ "</td>"
			  		+"<td>专业：</td>"
			  		+"<td>"
			  			+"<div>"
	  						+"<label class=\"sr-only\" for=\"resume-major\">专业</label>"
	  						+"<input type=\"text\" class=\"form-control\" id=\"resume-major\" value=\"" + data.r_major + "\" style=\"width:80%\" />"
	 					+"</div>"
	 				+ "</td>"
		  		+"</tr>"
		  		+"<tr>"
			  		+"<td>社会经历：</td>"
			  		+"<td colspan=\"3\"><textarea class=\"form-control\" rows=\"3\" id=\"resume-experience\" style=\"width:80%; resize: vertical;\">" + data.r_experience + "</textarea></td>"
		  		+"</tr>"
		  		+"<tr>"
			  		+"<td>个人评价：</td>"
			  		+"<td colspan=\"3\"><textarea class=\"form-control\" rows=\"3\" id=\"resume-desc\" style=\"width:80%; resize: vertical;\">" + data.r_profile + "</textarea></td>"
		  		+"</tr>"
		  		+"<tr>"
			  		+"<td>是否显示：</td>"
			  		+"<td>"
		  				+"<input type=\"checkbox\" id=\"resume-show\" checked=\"checked\" />"
			  		+"</td>"
			  		+"<td>更新时间：</td>"
			  		+"<td>" + DateFormater.getDateTime(data.r_datetime_update) + "</td>"
		  		+"</tr>"
		  		+"<tr>"
			  		+"<td colspan=\"4\"><button type=\"button\" class=\"btn btn-primary\" onclick=\"changeResume(this, '" + data.u_id + "');\">保存</button></td>"
		  		+"</tr>"
	  		+"</table>";
		  	$('.user-resume .panel-body').html(str);
			$('.user-resume-content').css('width','100%');
			$('.user-resume-content tr').css({'height':'45px','line-height':'45px'});
			
			if(data.r_sex == 0) {
				$("#resume-sex-0").attr("checked", "checked");
			} else {
				$("#resume-sex-1").attr("checked", "checked");
			}
			
			$("#resume-show").bootstrapSwitch();
			if(data.r_show == 0){
				$("#resume-show").click();
				$("#resume-show-lable").html("隐藏");
			} else {
				$("#resume-show-lable").html("显示");
			}
  	});
  } 
  
  function initMessageList(pageNo, pageSize) {
  	$.get('<%=basePath%>/user/rizhi.json', function(data) {
  		var list = data.daillyDto.dailies;
  		var str = "";
  		for (var i = 0; i < list.length; i++) {
  			str += "<tr>"
  				+ "<td><a href='<%=basePath%>/rizhi/"+list[i].d_id+"' target='_blank'>"+list[i].d_title+"</a></td>"
  				+ "<td class='text-center'>"+list[i].d_datetime_build+"</td>"
  				+ "<td class='text-center'><a href=\"javascript:del(\'daily\', \'id\');\">删除</a></td>"
  				+ "</tr>"
  		}
  		$('.user-daily table tbody').html(str);
  	});
  } 
  
  function initProfile() {
	  $.get('<%=basePath%>/user/ziliao.json', function(data) {
		var str = '<div style="display:none" class="alert alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button><strong>修改成功</strong></div>';
	  	var list = data;
	  	str += "<table class=\"user-profile-content\">"
				+"<tr>"
	  				+"<td style=\"width:10%;\">用户名：</td>"
		  			+"<td style=\"width:40%;\">" + data.username + "</td>"
		  			+"<td style=\"width:10%;\">昵称：</td>"
		  			+"<td style=\"width:40%;\">"
			  			+"<div>"
			  				+"<label class=\"sr-only\" for=\"user-nickname\">昵称</label>"
			  				+"<input type=\"text\" class=\"form-control\" id=\"user-nickname\" value=\"" + data.nickname + "\" style=\"width:80%\" />"
			 			+"</div>"
			  		+"</td>"
			  	+"</tr>"
			 	+"<tr>"
			  		+"<td>QQ：</td>"
			  		+"<td>"
				  		+"<div>"
				  			+"<label class=\"sr-only\" for=\"user-nickname\">QQ</label>"
				  			+"<input type=\"text\" class=\"form-control\" id=\"user-qq\" value=\"" + data.qq + "\" style=\"width:80%\" />"
				  		+"</div>"
				  	+"</td>"
			  		+"<td>联系电话：</td>"
			  		+"<td>"
						+"<div>"
							+"<label class=\"sr-only\" for=\"user-nickname\">联系电话</label>"
							+"<input type=\"text\" class=\"form-control\" id=\"user-phoneno\" value=\"" + data.phoneno + "\" style=\"width:80%\" />"
						+"</div>"
					+"</td>"
			  	+"</tr>"
			  	+"<tr>"
			  		+"<td>邮箱：</td>"
			  		+"<td colspan=\"3\">"
			  			+"<div>"
			  				+"<label class=\"sr-only\" for=\"user-nickname\">邮箱</label>"
			  				+"<input type=\"email\" class=\"form-control\" id=\"user-email\" value=\"" + data.email + "\" style=\"width:80%\" />"
			  			+"</div>"
			  		+"</td>"
			  	+"</tr>"
			  	+"<tr>"
			  		+"<td>个人描述：</td>"
			  		+"<td colspan=\"3\"><textarea class=\"form-control\" rows=\"3\" id=\"user-desc\" style=\"width:80%; resize:vertical;\">" + data.userDesc + "</textarea></td>"
			  	+"</tr>"
			  	+"<tr>"
			  		+"<td>注册时间：</td>"
			  		+"<td colspan=\"3\">" + DateFormater.getDateTime(data.buildDate) + "</td>"
			  	+"</tr>"
			  	+"<tr>"
			  		+"<td colspan=\"4\"><button type=\"button\" class=\"btn btn-primary\" onclick=\"changeProfile(this ,'" + data.userId + "', '" + data.username + "');\">保存</button></td>"
			  	+"</tr>"
			+"</table>";
			$('.user-profile .panel-body').html(str);
			$('.user-profile-content').css('width','100%');
			$('.user-profile-content tr').css({'height':'45px','line-height':'45px'});
	  });
	  
  } 
  
  function changePassword(btn) {
	  var oldPasswd = $("#inputPassword_old").val();
	  var newPasswd1 = $("#inputPassword_new").val();
	  var newPasswd2 = $("#inputPassword_new2").val();
	  $(btn).html("修改中...").attr("disabled", "disabled");
	  $.post("<%=basePath%>/user/passwd.json", {
		  oldPasswd:oldPasswd,
		  newPasswd1:newPasswd1,
		  newPasswd2:newPasswd2	  		
	  	}, function(data) {
	  		if(data.result == "success") {
	  			$('.user-password .panel-body>div.alert>strong').html("修改成功");
	  			$('.user-password .panel-body>div.alert').addClass('alert-success');
	  		} else {
	  			$('.user-password .panel-body>div.alert>strong').html("修改失败");
	  			$('.user-password .panel-body>div.alert').addClass('alert-warning');
	  		}
	  		$('.user-password .panel-body>div.alert').slideDown("fast");
	  		$(btn).html("提交修改").removeAttr("disabled");
	  		$("#inputPassword_old").val("");
	  	  	$("#inputPassword_new").val("");
	  	  	$("#inputPassword_new2").val("");
		});
  }
  
  function changeResume(btn, userId) {
	  var name = $("#resume-name").val();
	  var sex = $("input[name='resume-sex']").val();
	  var age = $("#resume-age").val();
	  var height = $("#resume-height").val();
	  var weight = $("#resume-weight").val();
	  var college = $("#resume-college").val();
	  var major = $("#resume-major").val();
	  var experience = $("#resume-experience").val();
	  var desc = $("#resume-desc").val();
	  var show = $("#resume-show").is(":checked") ? 1 : 0;
	  $(btn).html("保存中...").attr("disabled", "disabled");
	  $.post("<%=basePath%>/user/jianli/update.json", {
		  	userId:userId,
	  		name:name, 
	  		sex:sex,
	  		age:age, 
	  		height:height, 
	  		weight:weight, 
	  		college:college, 
	  		major:major,
	  		experience:experience,
	  		desc:desc,
	  		show:show
	  	}, function(data) {
	  		if(data.result == "success") {
	  			$('.user-resume .panel-body>div>strong').html("修改成功");
	  			$('.user-resume .panel-body>div').addClass('alert-success');
	  		} else {
	  			$('.user-resume .panel-body>div>strong').html("修改失败");
	  			$('.user-resume .panel-body>div').addClass('alert-warning');
	  		}
	  		$('.user-resume .panel-body>div').slideDown("fast");
	  		$(btn).html("保存").removeAttr("disabled");
		});
  }
  
  function changeProfile(btn, userId, username) {
	  var nickname = $('#user-nickname').val(); 
	  var qq = $('#user-qq').val();
	  var phoneno = $('#user-phoneno').val();
	  var email = $('#user-email').val();
	  var userDesc = $('#user-desc').val();
	  $(btn).html("保存中...").attr("disabled", "disabled");
	  $.post("<%=basePath%>/user/ziliao/update.json", {
		  		userId:userId, 
		  		username:username,
		  		nickname:nickname, 
		  		qq:qq, 
		  		phoneno:phoneno, 
		  		email:email, 
		  		userDesc:userDesc
		  	}, function(data) {
		  		if(data.result == "success") {
		  			$('.user-profile .panel-body>div>strong').html("修改成功");
		  			$('.user-profile .panel-body>div').addClass('alert-success');
		  		} else {
		  			$('.user-profile .panel-body>div>strong').html("修改失败");
		  			$('.user-profile .panel-body>div').addClass('alert-warning');
		  		}
		  		$('.user-profile .panel-body>div').slideDown("fast");
		  		$(btn).html("保存").removeAttr("disabled");
	  		});
  }
  </script>
</body>
</html>
