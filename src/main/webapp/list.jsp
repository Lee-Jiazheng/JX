<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/27
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>京西商城 - 智·享·生·活</title>
    <link rel="stylesheet" href="css/top_bottom_style.css"></link>
    <link rel="stylesheet" href="css/list_style.css"></link>
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


<div class="main" id="main">
    <div clsss="row" id="list_row">
        <div class="product_level">
            <a href="javascript:">首页</a>
            &nbsp; > &nbsp;
            一级分类
        </div>

        <div class="product_roll">
            <div class="roll_main">
                <button class="iconfont icon-zuo roll_button left">

                </button>
                <div class="image_field">
                    <a href="javascript:">
                        <img src="images/1.png" id="roll_images">
                    </a>
                </div>
                <button class="iconfont icon-you roll_button right">

                </button>

            </div>
        </div>

        <div class="product_show">
            <div class="product_selection">
                <div class="product_classify">
                    <label>分类：</label>
                    <div class="classify_url">
                        <a href="javascript:" class="active">子分类</a>
                        <a href="javascript:">子分类</a>
                        <a href="javascript:">子分类</a>
                        <a href="javascript:">子分类</a>

                    </div>
                    <div class="clear"></div>
                </div>

                <div class="product_sort">
                    <label>排序：</label>
                    <div class="sort_url">
                        <a href="javascript:">默认</a>
                        <a href="javascript:"  class="active" onclick="search_good(1)">
                            价格
                            <i class="iconfont icon-xiangshang icon-sort active"></i>
                        </a>
                        <a href="javascript:"onclick="search_good(2)" >
                            销量
                            <i class="iconfont icon-xiangxia icon-sort"></i>
                        </a>
                        <a href="javascript:" onclick="search_good(3)">
                            上架时间
                            <i class="iconfont icon-xiangxia icon-sort"></i>
                        </a>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>

            <div class="product_show_content">
                <ul class="product_list">

                    <c:forEach items="${result_goods}" var="result_good">
                        <li class="product_item">
                            <div class="item_photo">
                                <a class="item_photo_url" href="shop_content.do?shopID=${result_good.goodsid}">
                                    <c:if test="${empty result_good.photo.photo}">
                                        <img src="images/defaultblack.png" class="product_img">
                                    </c:if>
                                    <c:if test="${!empty result_good.photo}">
                                        <img src="good_picture/${result_good.photo.photo}" class="product_img">
                                    </c:if>
                                </a>
                            </div>
                            <div class="item_description">
                                <a href="shop_content.do?shopID=${result_good.goodsid}" >${result_good.goodsname}</a>
                                <p class="product_price">￥${result_good.goodsprice}</p>
                            </div>
                        </li>
                    </c:forEach>

                    <li class="clear"></li>
                </ul>
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


<script src="js/top_bottom.js"></script>
<script src="js/all.js"></script>
<script src="js/list.js"></script>

<script>
    /**    function search_good(query_type) {
        uri = 'search.do?query_goods_name='+$('#search_good_name').val()+'&query_type='+query_type;
        location.href=uri;
    }
     * **/

</script>
</body>
</html>