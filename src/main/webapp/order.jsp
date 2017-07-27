<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/26
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>京西商城 - 智·享·生·活</title>
    <link rel="stylesheet" href="css/top_bottom_style.css"></link>
    <link rel="stylesheet" href="css/order_style.css"></link>
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
                            <a href="user_center.do?type=1">
                                <span class="nickname">${user.nickname}</span>
                                <i class="fa fa-angle-up fa-1x" aria-hidden="true" id="dropdown"></i>
                            </a>
                            <div class="drop_down_block">
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
    <div clsss="row" id="order_row">
        <div class="order_main">
            <!--地址管理-->
            <div class="user_address_selection">
                <div class="address_title">
                    收货信息
                </div>
                <div class="address_info">
                    <div class="address_left">
                        <p class="address_line line1">
                            <i class="iconfont icon-iconfontdizhi icon_location"></i>
                            <span class="edit_address">修改</span>
                        </p>
                        <p class="address_line">
                            <label>收 货 人：</label>
                            <span class="text" id="show_name">王</span>
                        </p>
                        <p class="address_line">
                            <label>联系方式：</label>
                            <span class="text" id="show_contact">10010</span>
                        </p>
                        <p class="address_line">
                            <label>联系地址：</label>
                            <span class="text" id="show_address">辽宁省沈阳市</span>
                        </p>
                    </div>
                    <div class="address_right">
                        <a href="javascript:" class="switch_address">切换地址</a>
                        <button class="new_address">新建地址</button>
                    </div>
                    <div class="clear">
                    </div>
                </div>
            </div>

            <div class="order_info_content">
                <div class="order_list">
                    <table class="order_item">
                        <tbody>

                        <tr class="head">
                            <td class="col1">商品信息</td>
                            <td class="col2"></td>
                            <td class="col3">单价</td>
                            <td class="col4">数量</td>
                            <td class="col5">小计</td>
                            <td class="col6">实付</td>
                        </tr>


                        <c:forEach items="${current_orders}" var="current_order">
                            <tr class="body">


                                <td class="col1">
                                    <c:if test="${!empty current_order.photo}">
                                        <img src="good_picture/${current_order.photo}" class="item_image">
                                    </c:if>
                                    <c:if test="${empty current_order.photo}">
                                        <img src="images/defaultblack.png" class="item_image">
                                    </c:if>
                                </td>
                                <td class="col2">
                                    <p class="item_name">
                                        ${current_order.goodsname}
                                    </p>
                                </td>
                                <td class="col3">
                                    <p class="item_single">
                                        ￥${current_order.reilGoodPrice}
                                    </p>
                                </td>
                                <td  class="col4">
                                    <p class="item_num">
                                        ${current_order.amount}
                                    </p>
                                </td>
                                <td class="col5">
                                    <p class="item_sum">
                                        ￥${current_order.orderprice}
                                    </p>
                                </td>
                                <td class="col6">
                                    <p class="item_real">
                                        ￥${current_order.orderprice}
                                    </p>
                                </td>
                            </tr>

                        </c:forEach>

                        </tbody>
                    </table>


                </div>
            </div>
            <div class="order_summary">
                <div class="left">

                </div>
                <div class="right">
                    <div class="line">
                        <label>商品合计：</label>
                        <span>￥${total_price}</span>
                    </div>
                    <div class="line">
                        <label>运费：</label>
                        <span>￥${express_price}</span>
                    </div>
                    <div class="line split"></div>
                    <div class="line">
                        <label>应付总额：</label>
                        <span class="sum_needed">￥${total_price}</span>
                    </div>
                    <div class="line">
                        <button class="pay_button">付款</button>
                    </div>
                </div>

            </div>
        </div>




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

<div class="edit_widgetcontainer">
    <div class="mask_widget"></div>
    <div class="address_widget">
        <i class="iconfont icon-shanchu1 close_form"></i>
        <form class="address_form">
            <div class="address_form_title">新建地址</div>
            <div class="address_form_item">
                <label class="detail_title">详细地址:</label>
                <textarea cols="75" rows="8" id="address_detail" name="address_detail" required="required"></textarea>
            </div>
            <div class="address_form_item">
                <div class="address_left">
                    <label>联系方式:</label>
                    <input type="text" name="address_contact" id="address_contact" required="required">
                </div>
                <div class="address_right">
                    <label>收货人:</label>
                    <input type="text" name="address_receiver_name" id="address_receiver_name" required="required">
                </div>
                <div class="clear">
                </div>
            </div>

            <div class="address_form_item form_button">
                <input type="submit" class="address_submit" value="保存">
                <a href="javascript:" class="cancel_button">取消</a>
            </div>

        </form>
    </div>
</div>

<div class="switch_widgetcontainer">
    <div class="mask_widget"></div>
    <div class="switch_widget">
        <i class="iconfont icon-shanchu1 close_form"></i>
        <div class="switch_title">选择地址</div>
        <div class="switch_list">

            <div class="switch_item active">
                <p class="address_line select_name">
                    <label>收 货 人：</label>
                    <span class="text">王</span>
                </p>
                <p class="address_line select_contact">
                    <label>联系方式：</label>
                    <span class="text">10010</span>
                </p>
                <p class="address_line select_address">
                    <label>联系地址：</label>
                    <span class="text">辽宁省沈阳市</span>
                </p>
            </div>

            <div class="switch_item">
                <p class="address_line select_name">
                    <label>收 货 人：</label>
                    <span class="text">吴</span>
                </p>
                <p class="address_line select_contact">
                    <label>联系方式：</label>
                    <span class="text">10086</span>
                </p>
                <p class="address_line select_address">
                    <label>联系地址：</label>
                    <span class="text">广东省汕头市</span>
                </p>
            </div>

        </div>

        <div class="form_button">
            <a href="javascript:" class="submit_button">确定</a>
            <a href="javascript:" class="cancel_button">取消</a>
        </div>


    </div>
</div>

<script src="js/top_bottom.js"></script>
<script src="js/all.js"></script>
<script>
    $('.new_address').click(function(){
        $('.address_form_title').text('新建地址');
        $('.edit_widgetcontainer').show();
        $('#address_detail').val('');
        $('#address_receiver_name').val('');
        $('#address_contact').val('');
    });

    $('.close_form').click(function(){
        $('.edit_widgetcontainer').hide();
        $('.switch_widgetcontainer').hide();
    });
    $('.cancel_button').click(function(){
        $('.edit_widgetcontainer').hide();
        $('.switch_widgetcontainer').hide();
    });

    $('.edit_address').click(function(){
        $('.address_form_title').text('编辑地址');
        $('#address_detail').val($('#show_address').html());
        $('#address_receiver_name').val($('#show_name').html());
        $('#address_contact').val($('#show_contact').html());
        $('.edit_widgetcontainer').show();
    });

    $('.switch_address').click(function(){
        $('.switch_widgetcontainer').show();
    });

    $('.switch_item').click(function(){
        $('.switch_item').removeClass('active');
        $(this).addClass('active');
    });

    $('.submit_button').click(function(){
        $('#show_name').html($(".switch_list .active .select_name .text").html());
        $('#show_contact').html($(".switch_list .active .select_contact .text").html());
        $('#show_address').html($(".switch_list .active .select_address .text").html());
        $('.switch_widgetcontainer').hide();
    });

    function submit_order(){

    }
</script>
</body>
</html>
