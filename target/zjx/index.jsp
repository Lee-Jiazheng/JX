<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${empty popProduct}">
<c:redirect url="index.do">
</c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>京西商城 - 智·享·生·活</title>
    <link rel="stylesheet" href="css/top_bottom_style.css"></link>
    <link rel="stylesheet" href="css/index_main_style.css"></link>
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

<div class="product_roll">
    <div class="roll_main">
        <button class="iconfont icon-zuo roll_button left"></button>
        <div class="image_field">
            <a href="javascript:">
                <img src="images/1.png" id="roll_images">
            </a>
        </div>
        <button class="iconfont icon-you roll_button right"></button>
    </div>
</div>

<div class="main" id="main">
    <div class="row" id="index_row">
        <div class="index_item">
            <div class="index_item_title">新品推荐</div>
            <div class="index_item_title_description">周一周四上新，为你寻觅世间好物</div>
            <div class="index_item_more">
                <a href="javascript:">更多新品></a>
            </div>

            <div class="index_new_content">
                <ul class="index_new_list">
                    <div class="new_list_main">
                        <button class="iconfont icon-zuo new_button left"></button>
                        <div class="new_list_content">
                            <div class="new_item_collection">

                                <c:forEach items="${newProduct}" var="product">
                                    <li class="new_item">
                                        <div class="new_item_main">
                                            <div class="new_item_image_container">
                                                <a href="shop_content.do?shopID=${product.goodsid}" class="new_item_url">
                                                    <c:if test="${product.photo == null}">
                                                        <img src="images/defaultblack.png" class="new_item_image">
                                                    </c:if>
                                                    <c:if test="${product.photo != null}">
                                                        <img src="good_picture/${product.photo}" class="new_item_image">
                                                    </c:if>

                                                </a>
                                            </div>
                                            <div class="new_item_desription">
                                                <a href="shop_content.do?shopID=${product.goodsid}" class="new_item_name">${product.goodsname}</a>
                                                <p class="new_item_price">￥${product.goodsprice}</p>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>


                            </div>
                        </div>
                        <button class="iconfont icon-you new_button right"></button>
                    </div>
                </ul>
            </div>
        </div>
    </div>

    <div id="index_recommend">
        <div class="index_item">
            <div class="index_item_title">人气推荐</div>
            <div class="index_item_title_description">人气单品一应俱全</div>
            <div class="index_item_more">
                <a href="javascript:">更多推荐></a>
            </div>
        </div>
        <div class="index_item recommend_content">


            <div class="left_recommend">
                <c:forEach items="${popProduct}" var="product" varStatus="status">
                    <c:if test="${status.first}">
                        <div class="recommend_item">
                            <a href="shop_content.do?shopID=${product.goodsid}" class="recommend_url">
                                <c:if test="${product.photo == null}">
                                    <img src="images/defaultblue.png" class="recommend_image large_recommend">
                                </c:if>
                                <c:if test="${product.photo != null}">
                                    <img src="good_picture/${product.photo}" class="recommend_image large_recommend">
                                </c:if>
                            </a>
                            <a href="shop_content.do?shopID=${product.goodsid}" class="recommend_name" id="large_commend">${product.goodsname}</a>
                            <p class="recommend_price">￥${product.goodsprice}</p>
                        </div>
                    </c:if>
                </c:forEach>

            </div>


            <div class="right_recommend">
                <c:forEach items="${popProduct}" var="product" varStatus="status">
                    <c:if test="${!status.first}">
                        <div class="recommend_item">
                            <a href="shop_content.do?shopID=${product.goodsid}" class="recommend_url">
                                <c:if test="${product.photo == null}">
                                    <img src="images/defaultblue.png" class="recommend_image small_recommend">
                                </c:if>
                                <c:if test="${product.photo != null}">
                                    <img src="good_picture/${product.photo}" class="recommend_image small_recommend">
                                </c:if>
                            </a>
                            <a href="shop_content.do?shopID=${product.goodsid}" class="recommend_name">${product.goodsname}</a>
                            <p class="recommend_price">￥${product.goodsprice}</p>
                        </div>
                    </c:if>
                </c:forEach>

            </div>
        </div>
    </div>

    <%--
        <div class="row" id="sort_row">
        <div class="index_item">
            <div class="index_item_title">食品酒水</div>
            <div class="index_item_more">
                <a href="javascript:">查看更多></a>
            </div>
            <div class="index_sort_banner">
                <img src="images/1.png">
            </div>
            <div class="index_sort_content">
                <div class="index_sort_item">
                    <a href="javascript:" class="sort_item_url">
                        <img src="images/defaultblue.png" class="sort_item_image">
                    </a>
                    <a href="javascript:" class="sort_item_name">测试</a>
                    <p class="sort_item_price">￥1999</p>
                </div>

                <div class="index_sort_item">
                    <a href="javascript:" class="sort_item_url">
                        <img src="images/defaultblue.png" class="sort_item_image">
                    </a>
                    <a href="javascript:" class="sort_item_name">测试</a>
                    <p class="sort_item_price">￥1999</p>
                </div>

                <div class="index_sort_item">
                    <a href="javascript:" class="sort_item_url">
                        <img src="images/defaultblue.png" class="sort_item_image">
                    </a>
                    <a href="javascript:" class="sort_item_name">测试</a>
                    <p class="sort_item_price">￥1999</p>
                </div>

                <div class="index_sort_item">
                    <a href="javascript:" class="sort_item_url">
                        <img src="images/defaultblue.png" class="sort_item_image">
                    </a>
                    <a href="javascript:" class="sort_item_name">测试</a>
                    <p class="sort_item_price">￥1999</p>
                </div>


                <div class="index_sort_item">
                    <a href="javascript:" class="sort_item_url">
                        <img src="images/defaultblue.png" class="sort_item_image">
                    </a>
                    <a href="javascript:" class="sort_item_name">测试</a>
                    <p class="sort_item_price">￥1999</p>
                </div>

            </div>

        </div>
    </div>

    <div class="row" id="sort_row">
        <div class="index_item">
            <div class="index_item_title">日用洗护</div>
            <div class="index_item_more">
                <a href="javascript:">查看更多></a>
            </div>
            <div class="index_sort_banner">
                <img src="images/2.png">
            </div>
            <div class="index_sort_content">
                <div class="index_sort_item">
                    <a href="javascript:" class="sort_item_url">
                        <img src="images/defaultblue.png" class="sort_item_image">
                    </a>
                    <a href="javascript:" class="sort_item_name">测试</a>
                    <p class="sort_item_price">￥1999</p>
                </div>

                <div class="index_sort_item">
                    <a href="javascript:" class="sort_item_url">
                        <img src="images/defaultblue.png" class="sort_item_image">
                    </a>
                    <a href="javascript:" class="sort_item_name">测试</a>
                    <p class="sort_item_price">￥1999</p>
                </div>

                <div class="index_sort_item">
                    <a href="javascript:" class="sort_item_url">
                        <img src="images/defaultblue.png" class="sort_item_image">
                    </a>
                    <a href="javascript:" class="sort_item_name">测试</a>
                    <p class="sort_item_price">￥1999</p>
                </div>

                <div class="index_sort_item">
                    <a href="javascript:" class="sort_item_url">
                        <img src="images/defaultblue.png" class="sort_item_image">
                    </a>
                    <a href="javascript:" class="sort_item_name">测试</a>
                    <p class="sort_item_price">￥1999</p>
                </div>


                <div class="index_sort_item">
                    <a href="javascript:" class="sort_item_url">
                        <img src="images/defaultblue.png" class="sort_item_image">
                    </a>
                    <a href="javascript:" class="sort_item_name">测试</a>
                    <p class="sort_item_price">￥1999</p>
                </div>

            </div>

        </div>
    </div>



    --%>

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
        <a href="chat.jsp" target="_blank">
            <i class="iconfont icon-kefu1 icon_right"></i>
        </a>
    </div>
</div>


<script src="js/top_bottom.js"></script>
<script src="js/all.js"></script>
<script src="js/list.js"></script>
<script>
    if($('.new_item').length>4){
        $('.new_list_main .new_button').show();
    }

    $('.new_list_main .icon-you').click(function(){
        if($('.new_item_collection').children().length>4){
            $('.new_item_collection').css('transform','translateX(-1060px)');
        }
    });

    $('.new_list_main .icon-zuo').click(function(){
        $('.new_item_collection').css('transform','translateX(0)');
    });


    $('.new_item_image').mouseover(function(){
        $(this).animate({height:"257px"},100);
    });

    $('.new_item_image').mouseout(function(){
        $(this).animate({height:"255px"},100);
    });

    $('.large_recommend').mouseover(function(){
        $(this).animate({height:"330px"},100);
        console.log("OK");
    });

    $('.large_recommend').mouseout(function(){
        $(this).animate({height:"325px"},100);
    });


    $('.small_recommend').mouseover(function(){
        $(this).animate({height:"183px"},100);
    });

    $('.small_recommend').mouseout(function(){
        $(this).animate({height:"180px"},100);
    });

    $('.sort_item_image').mouseover(function(){
        $(this).animate({height:"163px"},100);
    });

    $('.sort_item_image').mouseout(function(){
        $(this).animate({height:"160px"},100);
    });

</script>
</body>
</html>