<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/22
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>京西商城 - 智·享·生·活</title>
    <link rel="stylesheet" href="css/top_bottom_style.css"></link>
    <link rel="stylesheet" href="css/reg_style.css"></link>
    <script src="js/jquery-3.2.1.min.js"></script>
    <style>
        #reg_row .reg_box{
            width:450px!important;
        }
        .reg_field .reg_input input{
            width: 70%!important;
        }
    </style>
    <script>
        function test() {
            <c:if test="${!empty reg_info}">
                alert("${reg_info}");
            </c:if>
        }
        test();
    </script>
</head>
<body>
<div class="header">
    <div class="fixed_nav">
        <div class="row reg_nav">
            <a href="index.do" class="smalllogo_reg"></a>
            <div class="reg_nav_left">
                欢迎注册
            </div>
            <div class="reg_nav_right">
                已有账号？
                <a href="login.jsp">请登录</a>
            </div>
        </div>
    </div>
</div>


<div class="main">
    <div clsss="row" id="reg_row">
        <div class="reg_box">
            <div class="form">

                <form action="user_register.do" method="post">
                    <div class="reg_field">
                        <div class="reg_label">
                            <label>用户名</label>
                        </div>
                        <div class="reg_input">
                            <input type="text" id="nickname" name="nickname">
                            <span class="nickName_tip">用户名已存在</span>
                        </div>
                        <div class="clear">
                        </div>
                    </div>

                    <div class="reg_field">
                        <div class="reg_label">
                            <label>真实姓名</label>
                        </div>
                        <div class="reg_input">
                            <input type="text" name="realname">
                        </div>
                        <div class="clear">
                        </div>
                    </div>

                    <div class="reg_field">
                        <div class="reg_label">
                            <label>密码</label>
                        </div>
                        <div class="reg_input">
                            <input type="password" id="pass" name="password">
                        </div>
                        <div class="clear">
                        </div>
                    </div>

                    <div class="reg_field">
                        <div class="reg_label">
                            <label>确认密码</label>
                        </div>
                        <div class="reg_input">
                            <input type="password" id="repeatPass">
                            <span class="repeat_tip">两次密码不同</span>
                        </div>
                        <div class="clear">
                        </div>
                    </div>

                    <div class="reg_field">
                        <div class="reg_label">
                            <label>手机号</label>
                        </div>
                        <div class="reg_input">
                            <input type="text" name="phone">
                        </div>
                        <div class="clear">
                        </div>
                    </div>

                    <div class="reg_field">
                        <div class="reg_label">
                            <label>电子邮箱</label>
                        </div>
                        <div class="reg_input">
                            <input type="text" name="email">
                        </div>
                        <div class="clear">
                        </div>
                    </div>

                    <input type="submit" value="注册">
                </form>

            </div>
        </div>
    </div>
</div>


<div class="footer">
    <div class="footer_top">
        <div class="row">
            <div class="intro_list">
                <ul class="clearfix">
                    <li>
                        <i class="iconfont icon-shouquanzhengpin icon_bottom"></i>
                        <p class="icon_info">100% 正品保证</p>
                    </li>
                    <li>
                        <i class="iconfont icon-wuyoushouhou icon_bottom"></i>
                        <p class="icon_info">30 天无忧退换货</p>
                    </li>
                    <li>
                        <i class="iconfont icon-kefu1 icon_bottom"></i>
                        <p class="icon_info">24 小时在线客服</p>
                    </li>
                    <li>
                        <i class="iconfont icon-baoyou icon_bottom"></i>
                        <p class="icon_info">全场满 88 包邮</p>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer_bottom">
        <div class="row">
            <ul class="clearfix">
                <li class="left_bottom">
                    <a href="javascript:" class="logo_bottom">&nbsp;</a>
                </li>
                <li class="right_bottom">
                    <p class="bottom_title">关于我们</p>
                    <p class="bottom_content">
                        <a href="javascript:">公司介绍</a> &nbsp;|&nbsp;
                        <a href="javascript:">联系我们</a> &nbsp;|&nbsp;
                        <a href="javascript:">客户服务</a> &nbsp;|&nbsp;
                        <a href="javascript:">支付方式</a> &nbsp;|&nbsp;
                        <a href="javascript:">配送服务</a> &nbsp;|&nbsp;
                        <a href="javascript:">退货流程</a> &nbsp;|&nbsp;
                        <a href="javascript:">常见问题</a>
                    </p>
                    <p class="bottom_content">京西公司 版权所有 &copy;2017</p>
                </li>
            </ul>
        </div>
    </div>
</div>
<script>
    $('#nickName').change(function(){
        $.get("verify_nick_name.do?nickname="+$('#nickName').val(), function (responsetext) {
            if(responsetext == "ok"){
                $('.nickName_tip').hide();
            }else{
                $('.nickName_tip').show();
            }
        });
    });
    $('#nickName').focus(function(){
        $('.nickName_tip').hide();
    });
    $('#repeatPass').change(function(){
        if($('#repeatPass').val() != $('#pass').val()){
            $('.repeat_tip').show();
        }else{
            $('.repeat_tip').hide();
        }
    });
    $('#repeatPass').focus(function(){
        $('.repeat_tip').hide();
    });
</script>
</body>
</html>