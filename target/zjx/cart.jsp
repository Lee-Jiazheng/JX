<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/27
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>京西商城 - 智·享·生·活</title>
    <link rel="stylesheet" href="css/top_bottom_style.css"></link>
    <link rel="stylesheet" href="css/cart_style.css"></link>
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


<div class="main" id="main">
    <div class="row" id="cart_row">
        <div class="empty_cart">
            <div class="empty_tip">
                <i class="iconfont icon-gouwuche empty_icon"></i>
                <p class="empty_word">您的购物车是空的，快去逛逛吧!</p>
                <a href="javascript:" class="empty_url">继续逛</a>
            </div>
        </div>
        <div class="cart_main">
            <form action="" method="post" name="myform">
                <table class="cart_table">

                    <tbody id="table_body">
                    <tr class="cart_head">
                        <td class="col1"></td>
                        <td class="col2">商品信息</td>
                        <td class="col3"></td>
                        <td class="col4">积分</td>
                        <td class="col5">单价</td>
                        <td class="col6">数量</td>
                        <td class="col7">小计</td>
                        <td class="col8">操作</td>
                    </tr>

                    <c:forEach items="${shop_cart_goods}" var="shop_cart_good" varStatus="status">
                        <tr class="cart_body <c:if test="${status.first}">first_cart_body</c:if>">
                            <td class="col1">
                                <input type="checkbox" class="checked_single">
                            </td>
                            <td class="col2">
                                <c:if test="${empty shop_cart_good.photo}">
                                    <img src="images/defaultblack.png" class="cart_image">
                                </c:if>
                                <c:if test="${!empty shop_cart_good.photo}">
                                    <img src="good_picture/${shop_cart_good.photo.photo}" class="cart_image">
                                </c:if>
                            </td>
                            <td class="col3">
                                <a href="javascript:" class="cart_item_url">${shop_cart_good.goodsname}</a>
                                <span style="display:none;" class="productId">${shop_cart_good.goodsid}</span>
                            </td>
                            <td class="col4">
                                <span class="shoppingpoint">

                                </span>
                            </td>
                            <td class="col5">
                                <span class="hidden_price">${shop_cart_good.goodsprice}</span>
                                ￥${shop_cart_good.goodsprice}
                            </td>
                            <td class="col6">
                                <i class="iconfont icon-minus num_button"></i>
                                <input type="text" class="num_input" value="${shop_cart_good.order_count}">
                                <i class="iconfont icon-plus num_button"></i>
                            </td>
                            <td class="col7">

                            </td>
                            <td class="col8">
                                <a href="javascript:" class="cart_item_delete">删除</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>

                </table>
            </form>
            <div class="cart_toolbar">
                <div class="operation_field">
                    <diV class="checkbox_field">
                        <input type="checkbox" id="checked_all">
                    </diV>
                    <span class="check_text">全选</span>
                    <a href="javascript:" class="delete_selected">批量删除</a>
                </div>

                <div class="button_field">
                    <a href="javascript:" class="place_order_url">下单</a>
                </div>

                <div class="price_field">
                    <div class="price_info">
                                <span class="origin_label">
                                    商品合计:
                                </span>
                        ￥
                        <span class="origin_price">
                                    0.00
                                </span>
                        <span class="preferential_label">
                                    活动优惠:
                                </span>
                        -￥
                        <span class="preferential_price">
                                    0.00
                                </span>
                        <span class="final_label">
                                    应付总额:
                                </span>
                        <span class="final_price_sign">
                                    ￥
                                </span>
                        <span class="final_price">
                                    0.00
                                </span>
                    </div>
                    <div class="free_ship_tip">
                        <a href="javascript:" class="free_ship_url">
                            再购¥<span class="free_remain">14.50</span>免邮 , 去凑单>
                        </a>
                    </div>
                </div>
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

<!--图片隐藏区域，用于JavaScript动态获取,src填写图片路径，alt填写链接地址-->
<div class="image_hidden" style="display:none;">
    <img src="images/1.png" alt="https://www.baidu.com/">
    <img src="images/2.png" alt="http://www.163.com/">
    <img src="images/3.png" alt="http://www.qq.com/">
</div>

<div class="toolbox">
    <div class="tool_item" id="return_top">
        <a href="javascript:" class="go_to_top">
            <i class="iconfont icon-fanhuidingbu icon_right"></i>
        </a>
    </div>
    <div class="tool_item">
        <a href="javascript:">
            <i class="iconfont icon-kefu1 icon_right"></i>
        </a>
    </div>
</div>

<div class="max_tip">
    单品已达到上限
</div>
<div class="min_tip">
    本商品1件起售
</div>

<script src="js/top_bottom.js"></script>
<script src="js/all.js"></script>

<script>
    function accMul(arg1,arg2)
    {
        var m=0,s1=arg1.toString(),s2=arg2.toString();

        try{m+=s1.split(".")[1].length}catch(e){}
        try{m+=s2.split(".")[1].length}catch(e){}
        return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
    }



    function emptyOrNot(){
        if($('.cart_body').length>0){
            $('.cart_main').show();
            $('.empty_cart').hide();
        }
        else{
            $('.empty_cart').show();
            $('.cart_main').hide();
        }

    }
    emptyOrNot();
    $(".cart_body .col7").each(function(){
        $(this).text("￥"+accMul($(this).parent().children().eq(4).children().eq(0).html(),$(this).parent().children().eq(5).children().eq(1).val()));
    });

    $(".cart_body .col4 .shoppingpoint").each(function(){
        $(this).text($(this).parent().parent().children().eq(6).html().split("￥")[1]);
    });

    $('#checked_all').click(function(){
        var oInput = document.getElementsByClassName("checked_single");
        for (var i = 0; i < oInput.length; i++) {
            oInput[i].checked = document.getElementById("checked_all").checked;
        }
        show_total_num();
    });
    $('.checked_single').click(function(){
        var isallchecked = true;
        var oInput = document.getElementsByClassName("checked_single");
        for (var i = 0; i < oInput.length; i++) {
            if (oInput[i].checked == false) {
                isallchecked = false;
                break;
            }
        }
        if (isallchecked == true) {
            document.getElementById("checked_all").checked = true;
        }
        else {
            document.getElementById("checked_all").checked = false;
        }
        show_total_num();
    });


    $('#table_body .cart_body .col8 .cart_item_delete').click(function(){
        var row = $(this).parent().parent().index();
        $('#table_body').children().eq(row).remove();
        show_total_num();
        emptyOrNot();
    });

    $(".delete_selected").click(function(){
        var oInput = document.getElementsByClassName("checked_single");
        var Index;
        for (var i = oInput.length - 1; i >= 0; i--) {
            if (oInput[i].checked == true) {
                $('#table_body').children().eq(i+1).remove();
            }
        }
        show_total_num();
        emptyOrNot();
    });

    function show_total_num(){
        var sumPrice=0;
        var oInput = document.getElementsByClassName("checked_single");
        var Index;
        for (var i = oInput.length - 1; i >= 0; i--) {
            var currentRow=$('#table_body').children().eq(i+1);
            if (oInput[i].checked == true) {
                sumPrice=sumPrice+accMul(currentRow.children().eq(4).children().eq(0).html(),currentRow.children().eq(5).children().eq(1).val());
            }
        }
        $('.origin_price').html(setZero(sumPrice));
        if(sumPrice>0){
            $('.final_price').html(setZero(sumPrice-$('.preferential_price').html()));
        }
        else{
            $('.final_price').html(setZero(0));
        }

        if(sumPrice>=88){
            $('.free_ship_tip').hide();
        }
        else{
            $('.free_ship_tip').show();
            $('.free_remain').html(setZero(88-$('.final_price').html()));
        }
    }


    show_total_num();


    function setZero(sumPrice){
        var sumString=sumPrice.toString().split(".");
        if(sumString.length>1){
            if(sumString[1].length<2){
                sumPrice=sumPrice.toString()+"0";
            }
            return sumPrice;
        }
        else{
            return sumPrice.toString()+".00";
        }
    }



    var max_product_num=50;
    var min_product_num=1;
    var reg = new RegExp("^[0-9]*");


    $('.icon-minus').css('cursor','not-allowed');

    $('.num_input').change(function(){
        $(this).val($(this).val().match(reg));

        if($(this).val()==max_product_num){
            $(this).parent().children().eq(2).css('cursor','not-allowed');
        }
        else if($(this).val()>max_product_num){
            $(this).parent().children().eq(2).css('cursor','not-allowed');
            $(this).val(max_product_num);
            product_num_max();
        }
        else if($(this).val()==min_product_num){
            $(this).parent().children().eq(0).css('cursor','not-allowed');
        }
        else if($(this).val()<min_product_num){
            $(this).parent().children().eq(0).css('cursor','not-allowed');
            $(this).val(min_product_num);
            product_num_min();
        }
        else{
            $(this).parent().children().eq(2).css('cursor','pointer');
            $(this).parent().children().eq(0).css('cursor','pointer');
        }
        var total=accMul($(this).parent().parent().children().eq(4).children().eq(0).html(),$(this).val());
        $(this).parent().parent().children().eq(6).html("￥"+total);
        $(this).parent().parent().children().eq(3).html(total.toString().split(".")[0]);
        show_total_num();
    });

    $('.icon-plus').click(function(){
        if($(this).parent().children().eq(1).val()>=max_product_num){
            product_num_max();
            $(this).css('cursor','not-allowed');
        }
        else{
            $(this).parent().children().eq(1).val(parseInt($(this).parent().children().eq(1).val())+1);
            if($(this).parent().children().eq(1).val()>=max_product_num){
                $(this).css('cursor','not-allowed');
            }

            if($(this).parent().children().eq(1).val()!=min_product_num){
                $(this).parent().children().eq(0).css('cursor','pointer');
            }var total=accMul($(this).parent().parent().children().eq(4).children().eq(0).html(),$(this).parent().children().eq(1).val());
            $(this).parent().parent().children().eq(6).html("￥"+total);
            $(this).parent().parent().children().eq(3).html(total.toString().split(".")[0]);
            show_total_num();
        }
    });


    $('.icon-minus').click(function(){
        if($(this).parent().children().eq(1).val()<=min_product_num){
            product_num_min();
            $(this).css('cursor','not-allowed');
        }
        else{
            $(this).parent().children().eq(1).val(parseInt($(this).parent().children().eq(1).val())-1);

            if($(this).parent().children().eq(1).val()<=min_product_num){
                $(this).css('cursor','not-allowed');
            }
            else{
                $(this).css('cursor','pointer');
            }
            if($(this).parent().children().eq(1).val()!=max_product_num){
                $(this).parent().children().eq(2).css('cursor','pointer');
            }
            var total=accMul($(this).parent().parent().children().eq(4).children().eq(0).html(),$(this).parent().children().eq(1).val());
            $(this).parent().parent().children().eq(6).html("￥"+total);
            $(this).parent().parent().children().eq(3).html(total.toString().split(".")[0]);
            show_total_num();
        }
    });

    function product_num_max(){
        $('.max_tip').show();
        $('.max_tip').animate({opacity:1},200,function(){
            $('.max_tip').delay(1700).animate({opacity:0},2000,function(){
                $('.max_tip').delay(2400).hide();
            });
        });
    };

    function product_num_min(){
        $('.min_tip').show();
        $('.min_tip').animate({opacity:1},200,function(){
            $('.min_tip').delay(1700).animate({opacity:0},2000,function(){
                $('.min_tip').delay(2400).hide();
            });
        });
    }

    $('.place_order_url').click(function(){
        if($('.final_price').html()!=0){
            var idsAndNums={};
            var jsonarray=new Array();
            var oInput = document.getElementsByClassName("checked_single");
            var Index;
            for (var i = oInput.length - 1; i >= 0; i--) {
                var currentRow=$('#table_body').children().eq(i+1);
                if (oInput[i].checked == true) {
                    var arr  =
                        {
                            "ID" : currentRow.children().eq(2).children().eq(1).html(),
                            "Num" : currentRow.children().eq(5).children().eq(1).val()
                        }
                    jsonarray.push(arr);
                }
            }
            console.log(jsonarray);
            console.log(JSON.stringify(jsonarray));
            var jsonstring = JSON.stringify(jsonarray);
            var uri = "process_shop_cart.do?shop_cart_json=" + jsonstring;
            location.href = uri;
        }
        else{
            alert("未选择商品");
            console.log("未选择商品");
        }


    });






</script>
</body>
</html>


