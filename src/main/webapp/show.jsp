<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/23
  Time: 15:44
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
    <link rel="stylesheet" href="css/show_style.css"></link>
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
                                <span class="nickname">${user.userName}</span>
                                <i class="fa fa-angle-up fa-1x" aria-hidden="true" id="dropdown"></i>
                            </a>
                            <div class="drop_down_block">
                                <div class="drop_down_menu">
                                    <a class="drop_down_item" href="javascript:">个人中心</a>
                                    <a class="drop_down_item" href="javascript:">订单管理</a>
                                    <a class="drop_down_item" href="javascript:">商品收藏</a>
                                    <a class="drop_down_item" href="javascript:">退出登录</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>




                <div class="always_show">
                    <a href="javascript:">帮助</a>
                    <a href="javascript:">在线客服</a>
                </div>

            </div>
        </div>
    </div>
    <div class="main_nav">
        <div class="init_main">
            <div class="main_row">
                <a href="javascript:" class="main_logo"></a>
                <div class="inner_main">
                    <div class="main_search">
                        <a href="javascript:">
                            <i class="iconfont icon-gouwuche icon_top"></i>
                        </a>
                        <div class="search_bar">
                            <div class="search_button">
                                <i class="iconfont icon-sousuo icon_top"></i>
                            </div>
                            <input type="text" maxlength="100" class="search_input">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="fixed_nav">
        <div class="row">
            <a href="javascript:" class="smalllogo"></a>
            <div class="inner_main">

                <ul class="nav_ul" id="nav_ul">
                    <li class="nav_li first active">
                        <a href="javascript:">首页</a>
                    </li>


                    <c:forEach var="parent_category" items="${category_map}">

                        <li class="nav_li">
                            <a href="javascript:">${parent_category.key.categoryName}</a>
                            <div class="nav_dropdown">
                                <div class="card_list">
                                    <ul class="card_item_list">


                                        <c:forEach items="${parent_category.value}" var="son_category">
                                            <li class="item">
                                                <a href="javascript:" class="url_nav_drop">
                                                    <i class="iconfont icon-gouwuche icon_nav_drop"></i>
                                                    <p class="title_nav_drop">${son_category.categoryName}</p>
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
                                    <a class="drop_down_item" href="javascript:">商品收藏</a>
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
    <div clsss="row" id="show_row">
        <div class="product_level">
            <a href="javascript:">首页</a>
            &nbsp; > &nbsp;
            <a href="javascript:">一级分类</a>
            &nbsp; > &nbsp;
            <a href="javascript:">二级分类</a>
            &nbsp; > &nbsp;
            ${goodInfo.goodsName}
        </div>

        <div class="product_show">
            <div class="product_show_left">
                <img src="images/defaultblue.png">
            </div>
            <div class="product_show_right">
                <div class="product_info_name">
                    <p class="product_name">${goodInfo.goodsName}</p>
                    <p class="product_brief">100%情怀</p>
                </div>

                <div class="product_price">
                    <div class="price_detail">
                        <span class="label">售价：</span>
                        <span class="rmb">￥</span>
                        <span class="product_current_price">${goodInfo.goodsPrice}</span>
                        <span class="product_origin_price">￥250.00</span>
                        <span class="clear"></span>
                    </div>

                    <div class="sale_info">
                        <span class="label">促销信息：</span>
                        <span class="sale_detail">满300减100</span>
                        <span class="sale_detail">满三免一</span>
                    </div>


                    <div class="service_info">
                        <span class="label">服务：</span>
                        <span class="service_detail">100% 正品保证</span>
                        <span class="service_detail">30 天无忧退换货</span>
                        <span class="service_detail">24 小时在线客服</span>
                    </div>

                    <div class="clear">
                    </div>

                </div>

                <div class="select_product">
                    <div class="product_num">
                        <span class="label">数量：</span>
                        <div class="num_selection">
                            <i class="iconfont icon-minus num_button"></i>
                            <input type="text" class="num_input" value="1">
                            <i class="iconfont icon-plus num_button"></i>
                        </div>
                    </div>
                    <div class="clear">
                    </div>
                </div>

                <div class="product_button">
                    <a href="javascript:" class="large_button purchase_button">立即购买</a>
                    <a href="javascript:" class="large_button add_button">加入购物车</a>
                    <a href="javascript:" class="small_button">
                        <i class="iconfont icon-shoucang"></i>
                        <p class="icon_description">收藏</p>
                    </a>
                </div>

            </div>
            <div class="clear">
            </div>
        </div>

        <div class="product_more">
            <div class="left">
                <div class="product_info_tab">
                                <span class="info_tab_item active" id="product_detail">
                                    商品详情
                                </span>
                    <span class="info_tab_item" id="product_review">
                                    评价
                                </span>
                </div>
                <div class="product_info_content">
                    <div class="product_intro">
                        <ul class="intro_list">

                            <li class="intro_item">
                                <span class="intro_label">面料</span>
                                <span class="intro_content">100%纯棉</span>
                            </li>

                            <li class="intro_item">
                                <span class="intro_label">产地</span>
                                <span class="intro_content">山东省青岛市</span>
                            </li>

                            <li class="intro_item">
                                <span class="intro_label">执行标准</span>
                                <span class="intro_content">GB/T22796-2009</span>
                            </li>

                            <li class="clear">
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="product_review">
                    <ul class="review_list">

                        <c:forEach items="${comments}" var="comment">
                            <li class="review_item first_review">
                                <div class="review_left">
                                    <img src="images/defaultblack.png">
                                    <div class="image_mask"></div>
                                </div>
                                <div class="review_right">
                                    <p>${comment.commentsContent}</p>
                                    <p class="review_time">${comment.userName}<pre>  </pre></p>
                                </div>
                                <div class="clear"></div>
                            </li>
                        </c:forEach>

                        <li class="review_item first_review">
                            <div class="review_left">
                                <img src="images/defaultblack.png">
                                <div class="image_mask"></div>
                            </div>
                            <div class="review_right">
                                <p>纯棉的，颜色很高大上，主要质地很好，收到就水洗了，洗完感觉更软了，很好！夏天盖着一定很舒服！</p>
                                <p class="review_time">2017-07-14 21:24</p>
                            </div>
                            <div class="clear"></div>
                        </li>

                        <li class="clear">
                        </li>
                    </ul>
                </div>
            </div>
            <div class="right">
                <div class="product_info_tab">
                    <p class="recommend_title">
                        商品推荐
                    </p>
                </div>
                <a href="javascript:" class="recommend_url first_recommend">
                    <div class="image_container">
                        <img src="images/defaultblack.png" class="product_img">
                    </div>
                    <p class="recommend_detail">测试商品</p>
                    <p class="recommend_price">￥150</p>
                </a>

                <a href="javascript:" class="recommend_url">
                    <div class="image_container">
                        <img src="images/defaultblack.png" class="product_img">
                    </div>
                    <p class="recommend_detail">测试商品</p>
                    <p class="recommend_price">￥150</p>
                </a>

                <a href="javascript:" class="recommend_url">
                    <div class="image_container">
                        <img src="images/defaultblack.png" class="product_img">
                    </div>
                    <p class="recommend_detail">测试商品</p>
                    <p class="recommend_price">￥150</p>
                </a>
            </div>
            <div class="clear">
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
<div class="max_tip">
    单品已达到上限
</div>
<div class="min_tip">
    本商品1件起售
</div>
<script src="js/top_bottom.js"></script>
<script src="js/all.js"></script>
<script>
    var max_product_num=${goodInfo.goodsQuantity};
    var min_product_num=1;
    var reg = new RegExp("^[0-9]*");

    $('.icon-minus').css('cursor','not-allowed');

    $('.small_button').mouseover(function(){
        $('.icon-shoucang').css('color','white');
        $('.icon_description').css('color','white');
        $(this).css('background-color','#15a8e0');
    });
    $('.small_button').mouseout(function(){
        $('.icon-shoucang').css('color','#15a8e0');
        $('.icon_description').css('color','#15a8e0');
        $(this).css('background-color','white');
    });
    $('.num_input').change(function(){
        $(this).val($(this).val().match(reg));

        if($(this).val()==max_product_num){
            $('.icon-plus').css('cursor','not-allowed');
        }
        else if($(this).val()>max_product_num){
            $('.icon-plus').css('cursor','not-allowed');
            $(this).val(max_product_num);
            product_num_max();
        }
        else if($(this).val()==min_product_num){
            $('.icon-minus').css('cursor','not-allowed');
        }
        else if($(this).val()<min_product_num){
            $('.icon-minus').css('cursor','not-allowed');
            $(this).val(min_product_num);
            product_num_min();
        }
        else{
            $('.icon-plus').css('cursor','pointer');
            $('.icon-minus').css('cursor','pointer');
        }
    });

    $('.icon-plus').click(function(){
        if($('.num_input').val()>=max_product_num){
            product_num_max();
            $('.icon-plus').css('cursor','not-allowed');
        }
        else{
            $('.num_input').val(parseInt($('.num_input').val())+1);
            if($('.num_input').val()>=max_product_num){
                $('.icon-plus').css('cursor','not-allowed');
            }
            if($('.num_input').val()!=min_product_num){
                $('.icon-minus').css('cursor','pointer');
            }
        }
    });


    $('.icon-minus').click(function(){
        if($('.num_input').val()<=min_product_num){
            product_num_min();
            $('.icon-minus').css('cursor','not-allowed');
        }
        else{
            $('.num_input').val(parseInt($('.num_input').val())-1);
            if($('.num_input').val()<=min_product_num){
                $('.icon-minus').css('cursor','not-allowed');
            }
            if($('.num_input').val()!=max_product_num){
                $('.icon-plus').css('cursor','pointer');
            }
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

    $('.product_img').mouseover(function(){
        $(this).animate({height:"165px"},550);
    });
    $('.product_img').mouseout(function(){
        $(this).animate({height:"160px"},300);
    });

    $('#product_detail').click(function(){
        $('.product_review').hide();
        $('.product_info_content').show();
        $('#product_detail').addClass('active');
        $('#product_review').removeClass('active');
        $('#product_detail').css('border-right','1px solid #e8e8e8');
    });

    $('#product_review').click(function(){
        $('.product_info_content').hide();
        $('.product_review').show();
        $('#product_review').addClass('active');
        $('#product_detail').removeClass('active');
        $('#product_detail').css('border-right','none');
    });
</script>
</body>
</html>
