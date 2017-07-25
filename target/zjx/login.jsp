<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/22
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>京西商城 - 智·享·生·活</title>
    <link rel="stylesheet" href="css/top_bottom_style.css"></link>
    <link rel="stylesheet" href="css/login_style.css"></link>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="header">
    <div class="fixed_nav" id="fixed">
        <div class="row">
            <a href="javascript:" class="smalllogo"></a>
            <div class="inner_main">

                <ul class="nav_ul" id="nav_ul">
                    <li class="nav_li first active">
                        <a href="javascript:">首页</a>
                    </li>
                    <li class="nav_li">
                        <a href="javascript:">食品酒水</a>
                    </li>
                    <li class="nav_li">
                        <a href="javascript:">日用洗护</a>
                    </li>
                    <li class="nav_li">
                        <a href="javascript:">家电数码</a>
                    </li>
                    <li class="nav_li">
                        <a href="javascript:">服装箱包</a>
                    </li>
                    <li class="nav_li">
                        <a href="javascript:">美妆健康</a>
                    </li>
                    <li class="nav_li">
                        <a href="javascript:">图书音像</a>
                    </li>
                    <li class="nav_li">
                        <a href="javascript:">玩具母婴</a>
                    </li>

                </ul>
                <div class="user_info">
                    <div class="before_login_s">
                        <a href="javascript:">登录</a>
                        <a href="javascript:">注册</a>
                    </div>
                    <div class="after_login_s" onmouseover="rotate_arrow(1)" onmouseout="reset_arrow(1)">
                        <div class="user_center_s">
                            <a href="javascript:">
                                <i class="iconfont icon-wode icon_top"></i>
                            </a>
                            <div class="drop_down_block_s">
                                <div class="drop_down_menu">
                                    <a class="drop_down_item" href="javascript:">个人中心</a>
                                    <a class="drop_down_item" href="javascript:">订单管理</a>
                                    <a class="drop_down_item" href="javascript:">收藏夹</a>
                                    <a class="drop_down_item" href="javascript:">退出登录</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="always_show_s">
                        <a href="javascript:">
                            <i class="iconfont icon-gouwuche icon_top"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="main">
    <div clsss="row" id="login_row">
        <div class="login_box">
            <div class="form">
                <p class="login_title">用户登录</p>

                <form action="user_login.do" method="post">
                    <div class="inputfield">
                        <div class="input_icon">
                            <i class="iconfont icon-wode icon_login"></i>
                        </div>
                        <div class="input_field">
                            <input type="text" name="nickname">
                        </div>
                        <div class="clear">
                        </div>
                    </div>
                    <div class="inputfield">
                        <div class="input_icon">
                            <i class="iconfont icon-yanzhengma3 icon_login"></i>
                        </div>
                        <div class="input_field">
                            <input type="password" name="password">
                        </div>
                        <div class="clear">
                        </div>
                    </div>
                    <input type="submit" value="登录">
                </form>
                <a href="javascript:" class="login_url">忘记密码</a> |
                <a href="javascript:" class="login_url">新用户注册</a>
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
    $(".fixed_nav").attr('id',"fixed");
    $(".smalllogo").show();
    $(".nav_li").css('padding','6px 25px 0');
    $(".first").css('margin-left','165px');
    $(".user_info").css('display',"block");
</script>
</body>
</html>
