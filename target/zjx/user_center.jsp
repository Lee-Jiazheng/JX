<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.neusoft.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/23
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>京西商城 - 智·享·生·活</title>
    <link rel="stylesheet" href="css/top_bottom_style.css"></link>
    <link rel="stylesheet" href="css/user_center.css"></link>
    <script src="js/jquery-3.2.1.min.js"></script>


</head>
<body>
<div class="header" id="top">
    <div class="top_nav">
        <div class="top_row">
            <img src="images/slogan.png">
            <div class="right">
                <c:if test="${empty user}">
                    <div class="before_login">
                        <a href="login.jsp">登录</a>
                        <a href="register.jsp">注册</a>
                    </div>
                </c:if>

                <c:if test="${!empty user}">
                    <div class="after_login">
                        <div class="user_center" onmouseover="rotate_arrow(0)" onmouseout="reset_arrow(0)">
                            <a href="javascript:">
                                <span class="nickname">${user.nickname}</span>
                                <i class="fa fa-angle-up fa-1x" aria-hidden="true" id="dropdown"></i>
                            </a>
                            <div class="drop_down_block">
                                <div class="drop_down_menu">
                                    <a class="drop_down_item" href="user_center.do?type=1">个人中心</a>
                                    <a class="drop_down_item" href="user_center.do?type=2">订单管理</a>
                                    <a class="drop_down_item" href="log_out.do">退出登录</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
                <div class="always_show">
                    <a href="javascript:">帮助</a>
                    <a href="chat.jsp" target="_blank">在线客服</a>
                </div>

            </div>
        </div>
    </div>
    <div class="main_nav">
        <div class="init_main">
            <div class="main_row">
                <a href="index.do" class="main_logo"></a>
                <div class="inner_main">
                    <div class="main_search">
                        <a href="entry_shopcart.do">
                            <i class="iconfont icon-gouwuche icon_top"></i>
                        </a>
                        <div class="search_bar">
                            <div class="search_button">
                                <a href="javascript:" onclick="search_good(0);">
                                    <i class="iconfont icon-sousuo icon_top"></i>
                                </a>
                            </div>
                            <input type="text" maxlength="100" class="search_input" id="search_good_name" value="${query_goods_name}">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="fixed_nav">
        <div class="row">
            <a href="index.do" class="smalllogo"></a>
            <div class="inner_main">

                <ul class="nav_ul" id="nav_ul">
                    <li class="nav_li first active">
                        <a href="index.do">首页</a>
                    </li>
                    <c:forEach var="parent_category" items="${category_map}">

                        <li class="nav_li">
                            <a href="javascript:">${parent_category.key.categoryname}</a>
                            <div class="nav_dropdown">
                                <div class="card_list">
                                    <ul class="card_item_list">


                                        <c:forEach items="${parent_category.value}" var="son_category">
                                            <li class="item">
                                                <a href="entry_detail_list.do?categoryId=${son_category.categoryid}" class="url_nav_drop">
                                                    <i class="iconfont ${son_category.categoryimg} icon_nav_drop"></i>
                                                    <p class="title_nav_drop">${son_category.categoryname}</p>
                                                </a>
                                            </li>
                                        </c:forEach>


                                    </ul>
                                </div>
                            </div>
                        </li>


                    </c:forEach>




                </ul>



                <div class="user_info">
                    <c:if test="${empty user}">
                        <div class="before_login_s">
                            <a href="login.jsp">登录</a>
                            <a href="register.jsp">注册</a>
                        </div>
                    </c:if>
                    <c:if test="${!empty user}">
                        <div class="after_login_s" onmouseover="rotate_arrow(1)" onmouseout="reset_arrow(1)">
                            <div class="user_center_s">
                                <a href="user_center.do">
                                    <i class="iconfont icon-wode icon_top"></i>
                                </a>
                                <div class="drop_down_block_s">
                                    <div class="drop_down_menu">
                                        <a class="drop_down_item" href="user_center.do?type=1">个人中心</a>
                                        <a class="drop_down_item" href="user_center.do?type=2">订单管理</a>
                                        <a class="drop_down_item" href="user_center.do?type=4">商品收藏</a>
                                        <a class="drop_down_item" href="log_out.do">退出登录</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <div class="always_show_s">
                        <a href="entry_shopcart.do">
                            <i class="iconfont icon-gouwuche icon_top"></i>
                        </a>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>


<div class="main">
    <div clsss="row" id="user_row">
        <div class="user_left">
            <div class="user_detail">
                <a class="user_icon" href="javascript:">
                    <c:if test="${!empty user.userphoto}">
                        <img src="avatar/${user.userphoto}">
                    </c:if>
                    <c:if test="${empty user.userphoto}">
                        <img src="images/defaultblack.png">
                    </c:if>

                </a>
                <p class="user_nickname">
                    ${user.nickname}
                </p>
                <a class="user_level" href="javascript:">
                    普通会员
                </a>
            </div>
            <div class="user_menu">
                <a class="user_menu_link <c:if test="${param.type==1 || (empty param.type)}">active</c:if>" href="user_center.do?type=1">
                    个人信息
                </a>
                <a class="user_menu_link <c:if test="${param.type==2}">active</c:if>" href="user_center.do?type=2">
                    订单管理
                </a>
                <a class="user_menu_link <c:if test="${param.type==3}">active</c:if>" href="user_center.do?type=3">
                    地址管理
                </a>
                <%--
                    <a class="user_menu_link <c:if test="${param.type==4}">active</c:if>" href="user_center.do?type=4">
                        商品收藏
                    </a>
                --%>
                <a class="user_menu_link <c:if test="${param.type==5}">active</c:if>" href="user_center.do?type=5">
                    账号安全
                </a>
            </div>
        </div>
        <div class="user_main">


            <c:if test="${param.type==1 || (empty param.type)}">
                <!--个人信息-->
                <div id="user_info_manage">
                    <div class="user_info_tab">
                                <span class="info_tab_item active">
                                    基本资料
                                </span>
                    </div>
                    <div class="user_info_content">
                        <form class="user_info_form" action="alter_user_info.do">
                            <div class="user_info_item">
                                <label class="item_intro">
                                    用户&nbsp;ID
                                </label>
                                <div class="item_detail">
                                        ${user.userid}
                                </div>
                            </div>

                            <div class="user_info_item">
                                <label class="item_intro">
                                    用户名
                                </label>
                                <div class="item_detail">
                                        ${user.nickname}
                                </div>
                            </div>


                            <div class="user_info_item">
                                <label class="item_intro">
                                    注册时间
                                </label>
                                <%
                                    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    String date = ft.format(((User)request.getSession().getAttribute("user")).getCreatetime());%>
                                <div class="item_detail">
                                    <%=date%>
                                </div>
                            </div>

                            <div class="user_info_item">
                                <label class="item_intro">
                                    真实姓名
                                </label>
                                <div class="item_detail">
                                    <input type="text" value="${user.realname}" name="real_name">
                                </div>
                            </div>

                            <div class="user_info_item">
                                <label class="item_intro">
                                    手机
                                </label>
                                <div class="item_detail">
                                    <input type="text" value="${user.phone}" name="phone">
                                </div>
                            </div>

                            <div class="user_info_item">
                                <label class="item_intro">
                                    电子邮箱
                                </label>
                                <div class="item_detail">
                                    <input type="text" value="${user.email}" name = "email">
                                </div>
                            </div>

                            <div class="user_info_item">
                                <input type="submit" value="保存" class="save_button">
                            </div>

                        </form>
                    </div>
                </div>
            </c:if>

            <c:if test="${param.type==2}">
                <!--订单管理-->
                <div id="user_orders_manage">
                    <div class="user_info_tab">
                                <span class="info_tab_item active">
                                    全部订单
                                </span>
                            <%--
                                     <span class="info_tab_item">
                                        待付款
                                    </span>

                            <span class="info_tab_item">
                                        待发货
                                    </span>

                            <span class="info_tab_item">
                                        已发货
                                    </span>


                            <span class="info_tab_item">
                                        待评价
                                    </span>

                            --%>


                    </div>




                    <div class="user_info_content">
                        <div class="order_list">



                            <c:forEach items="${user_orders}" var="order">

                                <table class="order_item">
                                    <tbody>
                                    <tr class="head first">
                                        <th colspan="7">
                                                    <span>
                                                        下单时间：<fmt:formatDate value="${order.ordertime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                                    </span>
                                            <span>
                                                        订单号：${order.orderid}
                                                    </span>
                                        </th>
                                    </tr>

                                    <tr class="head">
                                        <th class="head_large">
                                                    <span>
                                                        商品信息
                                                    </span>
                                        </th>

                                        <th class="head_small">
                                                    <span>
                                                        单价
                                                    </span>
                                        </th>

                                        <th  class="head_small">
                                                    <span>
                                                        数量
                                                    </span>
                                        </th>

                                        <th class="head_small">
                                                    <span>
                                                        小计
                                                    </span>
                                        </th>

                                        <th class="head_medium">
                                                    <span>
                                                        总计
                                                    </span>
                                        </th>


                                        <th class="head_medium">
                                                    <span>
                                                        订单状态
                                                    </span>
                                        </th>


                                        <th class="head_medium">
                                                    <span>
                                                        订单操作
                                                    </span>
                                        </th>

                                    </tr>

                                    <tr class="body">
                                        <td colspan="4">
                                            <div class="good_detail">
                                                <div class="good_name">
                                                    <a href="javascript:">
                                                        <c:if test="${!empty order.photo}">
                                                            <img src="good_picture/${order.photo}" class="good_image">
                                                        </c:if>
                                                        <c:if test="${empty order.photo}">
                                                            <img src="images/defaultblack.png" class="good_image">
                                                        </c:if>
                                                    </a>
                                                    <a class="good_info" href="javascript:pay">
                                                            ${order.goodsname}
                                                    </a>
                                                </div>

                                                <div class="good_num">
                                                    ￥${order.reilGoodPrice}
                                                </div>

                                                <div class="good_num">
                                                        ${order.amount}
                                                </div>

                                                <div class="good_num good_sum">
                                                    ￥${order.orderprice}
                                                </div>
                                            </div>

                                        </td>

                                        <td>
                                            <div class="good_total good_sum">
                                                ￥${order.orderprice}
                                            </div>

                                        </td>

                                        <td>
                                            <div class="good_total">
                                                <a href="javascript:">${order.orderStatus}</a>
                                            </div>
                                        </td>

                                        <td>
                                            <div class="good_total">
                                                    <%--<a href="javascript:" class="good_total_link">订单详情</a>--%>

                                                <a href="javascript:" class="good_total_link">查看物流</a>


                                                <c:if test="${order.iscommented}">
                                                    <span>${order.commentContent}</span>
                                                </c:if>
                                                <c:if test="${order.orderStatus == \"已完成\"}">
                                                    <c:if test="${!order.iscommented}">
                                                        <a href="entry_comment.do?orderID=${order.orderid}" class="good_total_link">订单评价</a>
                                                    </c:if>
                                                </c:if>

                                            </div>
                                        </td>


                                    </tr>
                                    </tbody>
                                </table>
                            </c:forEach>



                        </div>
                    </div>
                </div>
            </c:if>

            <c:if test="${param.type==3}">
                <!--地址管理-->
                <div id="user_address_manage">
                    <div class="user_info_tab">
                                <span class="info_tab_item active">
                                    地址管理
                                </span>
                    </div>
                    <div class="user_info_content">
                        <a href="javascript:" class="new_address">+新建收货地址</a>
                        <table class="order_item address_list_item">
                            <tbody>

                            <tr class="head">
                                <th class="head_medium">
                                                    <span>
                                                        收货人
                                                    </span>
                                </th>

                                <th class="head_large">
                                                    <span>
                                                        详细地址
                                                    </span>
                                </th>

                                <th  class="head_medium_lager">
                                                    <span>
                                                        联系方式
                                                    </span>
                                </th>

                                <th class="head_medium_lager">
                                                    <span>
                                                        操作
                                                    </span>
                                </th>

                                <th class="head_medium_lager">
                                                    <span>
                                                        &nbsp;
                                                    </span>
                                </th>

                            </tr>


                            <c:if test="${!empty addresses}">
                                <c:forEach items="${addresses}" var="address">
                                    <tr class="address_info">
                                    <td>${address.contactname}</td>
                                    <td>${address.addressname}</td>
                                    <td>${address.phonenum}</td>

                                    <td>
                                        <a href="javascript:" class="address_link address_first add_address">编辑</a>
                                        <a href="del_address.do?addressid=${address.addressid}" class="address_link">删除</a>
                                        <span style="display: none" class="address_id">${address.addressid}</span>
                                    </td>

                                    <c:if test="${address.isdefault == true}">
                                        <td>
                                            <a href="javascript:" class="address_default">默认地址</a>
                                        </td>
                                    </c:if>
                                    <c:if test="${!address.isdefault}">
                                        <td>
                                            <a href="javascript:" class="address_link">设为默认地址</a>
                                        </td>
                                    </c:if>
                                </c:forEach>
                                </tr>
                            </c:if>

                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>

            <c:if test="${param.type==4}">
                <!--商品收藏-->
                <%--
                                   <div id="user_favorite">
                    <div class="user_info_tab">
                                <span class="info_tab_item active">
                                    商品收藏
                                </span>
                    </div>
                    <div class="user_info_content">
                        <ul class="favorite_list">
                            <li class="favorite_item">
                                <div class="product_info">
                                    <div class="button_field">
                                        <a href="javascript:" class="addtional_button">
                                            <i class="iconfont icon-gouwuche button_icon"></i>
                                        </a>
                                        <a href="javascript:" class="addtional_button">
                                            <i class="iconfont icon-shanchu2 button_icon"></i>
                                        </a>
                                    </div>

                                    <div class="product_image">
                                        <a href="javascript:">
                                            <img src="images/defaultblue.png" class="product_img">
                                        </a>
                                    </div>

                                    <div class="product_description">
                                        <a href="javascript:" class="product_name">测试商品测试商品测试商品测试商品测试商品</a>
                                        <p class="product_price">￥150</p>
                                    </div>
                                </div>
                            </li>


                            <li class="favorite_item">
                                <div class="product_info">
                                    <div class="button_field">
                                        <a href="javascript:" class="addtional_button">
                                            <i class="iconfont icon-gouwuche button_icon"></i>
                                        </a>
                                        <a href="javascript:" class="addtional_button">
                                            <i class="iconfont icon-shanchu2 button_icon"></i>
                                        </a>
                                    </div>

                                    <div class="product_image">
                                        <a href="javascript:">
                                            <img src="images/defaultblue.png" class="product_img">
                                        </a>
                                    </div>

                                    <div class="product_description">
                                        <a href="javascript:" class="product_name">测试商品测试商品测试商品测试商品测试商品</a>
                                        <p class="product_price">￥150</p>
                                    </div>
                                </div>
                            </li>








                            <li class="clear">
                            </li>
                        </ul>
                    </div>
                </div>
                --%>

            </c:if>

            <c:if test="${param.type==5}">
                <!--账号安全-->
                <div id="user_security">
                    <div class="user_info_tab">
                                <span class="info_tab_item active">
                                    账号安全
                                </span>
                    </div>
                    <div class="user_info_content">
                        <div class="user_info_form set_width">
                            <div class="user_info_item set_bottom">
                                <label class="item_intro">
                                    您的账号
                                </label>
                                <div class="item_detail">
                                        ${user.nickname}
                                </div>
                            </div>

                            <div class="user_info_item">
                                <label class="item_intro">
                                    登录密码
                                </label>
                                <div class="item_detail security_info">
                                    建议您定期更换密码，设置安全性高的密码可以使帐号更安全
                                    <a href="javascript:" class="password_link">修改</a>
                                </div>

                            </div>


                            <div class="user_info_item">
                                <label class="item_intro">
                                    绑定手机
                                </label>
                                <div class="item_detail security_info">
                                    当前绑定手机号为：${user.phone}，若手机丢失或停用，请及时更换
                                    <a href="javascript:">更换</a>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </c:if>

        </div>
        <div class="clear">
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
<script src="js/top_bottom.js"></script>
<script src="js/all.js"></script>

<div class="widgetcontainer">
    <div class="mask_widget"></div>
    <div class="address_widget">
        <i class="iconfont icon-shanchu1 close_form"></i>
        <form class="address_form" action="add_address.do">
            <div class="address_form_title">新建地址</div>
            <div class="address_form_item">
                <label class="detail_title">详细地址:</label>
                <textarea cols="75" rows="8" id="address_detail" name="addressname" required="required"></textarea>
            </div>
            <div class="address_form_item">
                <div class="address_left">
                    <label>联系方式:</label>
                    <input type="text" id="address_contact" required="required" name="phonenum">
                </div>
                <div class="address_right">
                    <label>收货人:</label>
                    <input type="text" id="address_receiver_name" required="required" name="contactname">
                </div>
                <div class="clear">
                </div>
            </div>

            <div class="address_form_item form_button">
                <input type="submit" class="address_submit" value="保存">
                <a href="javascript:" class="cancel_button">取消</a>
            </div>
            <input type="hidden" name="addressid" class="address_input" val="0">
            <input type="hidden" name="state" class="address_state" val="new_address">
        </form>
    </div>
</div>


<div class="icon_widgetcontainer">
    <div class="mask_widget"></div>
    <div class="icon_widget">
        <i class="iconfont icon-shanchu1 close_form"></i>
        <form class="icon_form" action="user_avatar.do" method="post" enctype="multipart/form-data">
            <div class="icon_form_title">设置头像</div>

            <div class="icon_form_item">
                <div class="icon_main">
                    <a href="javascript:" class="file_box">
                        <p class="file_tip">点击此处上传图片</p>

                        <input type="file" name="user_image" required="required" class="file_input" accept="image/*">
                    </a>
                    <p>支持JPEG/JPG/PNG</p>
                    <p class="filename"></p>
                </div>
                <div class="clear">
                </div>
            </div>

            <div class="icon_form_item form_button">
                <input type="submit" class="icon_submit" value="保存">
                <a href="javascript:" class="cancel_button">取消</a>
            </div>

        </form>
    </div>
</div>


<div class="password_widgetcontainer">
    <div class="mask_widget"></div>
    <div class="password_widget">
        <i class="iconfont icon-shanchu1 close_form"></i>
        <form class="password_form" action="alter_password.do">
            <div class="password_form_title">修改密码</div>

            <div class="password_form_item">
                <label>原密码:</label>
                <input type="password" required="required" name="password" id="origin_password">
                <div class="clear"></div>
            </div>

            <div class="password_form_item">
                <label>新密码:</label>
                <input type="password" required="required" name="newpassword" id="new_password">
                <div class="clear"></div>
            </div>

            <div class="password_form_item">
                <label>重复密码:</label>
                <input type="password" required="required" id="new_repeat_password">
                <div class="clear"></div>
            </div>

            <div class="password_form_item form_button">
                <input type="submit" class="password_submit" value="保存">
                <a href="javascript:" class="cancel_button">取消</a>
            </div>

        </form>
    </div>
</div>


<script src="js/user_center.js"></script>
<script>
    $('.password_form').submit(function () {
        form = $(this);
        if($('#new_password').val() == $('#new_repeat_password').val() && $('#origin_password').val() == '${user.password}'){
            form.submit();
            return true;
        }else{
            alert("请检查密码输入。");
        }
        return false;
    });
</script>
</body>
</html>