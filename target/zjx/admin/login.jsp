<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>豪泰酒店-会员登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/css/index_manage.css">
	<script src="/js/jquery-3.2.1.min.js"></script>
	<style>
	body{
		background-image:url(/images/background1.jpg);
	}
	a{
		color:#333333;
		text-decoration:none;
		margin:0 10px;
	}
	a:hover{
		text-decoration:underline;
		font-weight:bold;
	}
	</style>
  </head>
  <body>
    <div id="content">
        	<div class="content-layout">
            	<div class="login-box-wrap">
                	<div class="login-box">
                    	<form  name="EmployeeLogin" method="post"
    							action="/admin/login.do">
                        	<div class="login-title">
                                	会员登录
                            </div>
                            <div class="field">
                            	<label for="TPL_username">
                                  	<i class="iconfont" title="用户名">&#xe601;</i>
                                </label>
                               	<input type="text" name="adminName" id="UserName" class="login-text" placeholder="身份证号">
                             </div>

                             <div class="field">
                              	<label for="TPL_password">
                                  	<i class="iconfont" title="密码">&#xe604;</i>
                                </label>
                                <input type="password" name="adminPassword" id="Password" class="login-text" placeholder="密码">
                             </div>
                              
                             <div class="submit">
                             	<input type="hidden" name="role" value="guest">
                               	<input type="submit" id="submitbutton" value="登录">
                              </div>
                          </form>
                          <a href="Register.jsp">注册</a> | <a href="javascript:">忘记密码</a> | <a href="/hotel/index.jsp">返回首页</a>
              		</div>
            			
            	</div>
        	</div>
    	</div>
    	<script>
    	 $("form").submit(function () {
	          	if ($("#UserName").val() == '' || $("#Password").val() == '') { 
	         		alert("用户名或密码不能为空！");
	         		$("#UserName").focus();
	          		return false; 
	          	}
	          	//else_1
	         	else {
	              $.ajax({
	                  url: '/hotel/servlet/VarifyUser',       //处理测试页面,注意返回内容，成功返回OK
	                  type:"POST",
	                  dataType: 'text',
	                  data: $("form").serialize(),
	                  success: function (msg) {
	                      msg = msg.replace(/rn/g, '');
	                      if (msg == "ok") { window.location.href = "/hotel/index.jsp"; }
	                      else {
	                          alert("用户名或密码错误");
	                          $("#UserName").val("");
	                          $("#Password").val("");
	                          $("#UserName").focus();
	                          return;
	                      }
	                  }
	              });
	          	}//else_1
	          
          	return false;////////////////要阻止表单提交
     	 });
    	</script>
  </body>
</html>
