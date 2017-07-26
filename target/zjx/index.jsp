<%@page import="com.neusoft.model.Goods" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link href="css/myCart.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="js/myCart.js"></script>
    <style type="text/css">
        body {
            margin: 0px;
            padding: 0px;
            font-size: 12px;
            line-height: 20px;
            color: #333;
        }

        ul, li, ol, h1, dl, dd {
            list-style: none;
            margin: 0px;
            padding: 0px;
        }

        a {
            color: #1965b3;
            text-decoration: none;
        }

        a:hover {
            color: #CD590C;
            text-decoration: underline;
        }

        img {
            border: 0px;
            vertical-align: middle;
        }

        #header {
            height: 40px;
            margin: 10px auto 10px auto;
            width: 800px;
            clear: both;
        }

        #nav {
            margin: 10px auto 10px auto;
            width: 800px;
            clear: both;
        }

        #navlist {
            width: 800px;
            margin: 0px auto 0px auto;
            height: 23px;
        }

        #navlist li {
            float: left;
            height: 23px;
            line-height: 26px;
        }

        .navlist_red_left {
            background-image: url(../images/taobao_bg.png);
            background-repeat: no-repeat;
            background-position: -12px -92px;
            width: 3px;
        }

        .navlist_red {
            background-color: #ff6600;
            text-align: center;
            font-size: 14px;
            font-weight: bold;
            color: #FFF;
            width: 130px;
        }

        .navlist_red_arrow {
            background-color: #ff6600;
            background-image: url(../images/taobao_bg.png);
            background-repeat: no-repeat;
            background-position: 0px 0px;
            width: 13px;
        }

        .navlist_gray {
            background-color: #e4e4e4;
            text-align: center;
            font-size: 14px;
            font-weight: bold;
            width: 150px;
        }

        .navlist_gray_arrow {
            background-color: #e4e4e4;
            background-image: url(/images/taobao_bg.png);
            background-repeat: no-repeat;
            background-position: 0px 0px;
            width: 13px;
        }

        .navlist_gray_right {
            background-image: url(/images/taobao_bg.png);
            background-repeat: no-repeat;
            background-position: -12px -138px;
            width: 3px;
        }

        #content {
            width: 800px;
            margin: 10px auto 5px auto;
            clear: both;
        }

        .title_1 {
            text-align: center;
            width: 50px;
        }

        .title_2 {
            text-align: center;
        }

        .title_3 {
            text-align: center;
            width: 80px;
        }

        .title_4 {
            text-align: center;
            width: 80px;
        }

        .title_5 {
            text-align: center;
            width: 100px;
        }

        .title_6 {
            text-align: center;
            width: 80px;
        }

        .title_7 {
            text-align: center;
            width: 60px;
        }

        .line {
            background-color: #a7cbff;
            height: 3px;
        }

        .shopInfo {
            padding-left: 10px;
            height: 35px;
            vertical-align: bottom;
        }

        .num_input {
            border: solid 1px #666;
            width: 25px;
            height: 15px;
            text-align: center;
        }

        .cart_td_1, .cart_td_2, .cart_td_3, .cart_td_4, .cart_td_5, .cart_td_6, .cart_td_7, .cart_td_8 {
            background-color: #e2f2ff;
            border-bottom: solid 1px #d1ecff;
            border-top: solid 1px #d1ecff;
            text-align: center;
            padding: 5px;
        }

        .cart_td_1, .cart_td_3, .cart_td_4, .cart_td_5, .cart_td_6, .cart_td_7 {
            border-right: solid 1px #FFF;
        }

        .cart_td_3 {
            text-align: left;
        }

        .cart_td_4 {
            font-weight: bold;
        }

        .cart_td_7 {
            font-weight: bold;
            color: #fe6400;
            font-size: 14px;
        }

        .hand {
            cursor: pointer;
        }

        .shopend {
            text-align: right;
            padding-right: 10px;
            padding-bottom: 10px;
        }

        .yellow {
            font-weight: bold;
            color: #fe6400;
            font-size: 18px;
            line-height: 40px;
        }
    </style>
    <script language="javascript">
        function deletegoods(obj) {
            var rowIndex = obj.parentNode.parentNode.rowIndex;
            var table = document.getElementById("table");
            table.deleteRow(rowIndex);
        }

        // JavaScript Document


        /*改变所购商品的数量*/
        function changeNum(numId, flag) {/*numId表示对应商品数量的文本框ID，flag表示是增加还是减少商品数量*/
            var numId = document.getElementById(numId);
            if (flag == "minus") {/*减少商品数量*/
                if (numId.value <= 1) {
                    alert("宝贝数量必须是大于0");
                    return false;
                }
                else {
                    numId.value = parseInt(numId.value) - 1;
                    productCount();
                }
            }
            else {/*flag为add，增加商品数量*/
                numId.value = parseInt(numId.value) + 1;
                productCount();
            }
        }

        /*自动计算商品的总金额、总共节省的金额和积分*/
        function productCount() {
            var total = 0;      //商品金额总计
            var integral = 0;   //可获商品积分

            var point;      //每一行商品的单品积分
            var price;     //每一行商品的单价
            var number;    //每一行商品的数量
            var subtotal;  //每一行商品的小计

            /*访问ID为shopping表格中所有的行数*/
            var myTableTr = document.getElementById("shopping").getElementsByTagName("tr");
            if (myTableTr.length > 0) {
                for (var i = 1; i < myTableTr.length; i++) {/*从1开始，第一行的标题不计算*/
                    if (myTableTr[i].getElementsByTagName("td").length > 2) { //最后一行不计算
                        point = myTableTr[i].getElementsByTagName("td")[3].innerHTML;
                        price = myTableTr[i].getElementsByTagName("td")[4].innerHTML;
                        number = myTableTr[i].getElementsByTagName("td")[5].getElementsByTagName("input")[0].value;
                        integral += point * number;
                        total += price * number;
                        myTableTr[i].getElementsByTagName("td")[6].innerHTML = price * number;
                    }
                }
                document.getElementById("total").innerHTML = total;
                document.getElementById("integral").innerHTML = integral;

            }
        }

        window.onload = productCount;

        /*复选框全选或全不选效果*/
        function selectAll() {
            var oInput = document.getElementsByName("cartCheckBox");
            for (var i = 0; i < oInput.length; i++) {
                oInput[i].checked = document.getElementById("allCheckBox").checked;
            }
        }

        /*根据单个复选框的选择情况确定全选复选框是否被选中*/
        function selectSingle() {
            var k = 0;
            var oInput = document.getElementsByName("cartCheckBox");
            for (var i = 0; i < oInput.length; i++) {
                if (oInput[i].checked == false) {
                    k = 1;
                    break;
                }
            }
            if (k == 0) {
                document.getElementById("allCheckBox").checked = true;
            }
            else {
                document.getElementById("allCheckBox").checked = false;
            }
        }

        /*删除单行商品*/
        function deleteRow(rowId) {
            var Index = document.getElementById(rowId).rowIndex; //获取当前行的索引号
            document.getElementById("shopping").deleteRow(Index);
            document.getElementById("shopping").deleteRow(Index - 1);
            productCount();
        }

        /*删除选中行的商品*/
        function deleteSelectRow() {
            var oInput = document.getElementsByName("cartCheckBox");
            var Index;
            for (var i = oInput.length - 1; i >= 0; i--) {
                if (oInput[i].checked == true) {
                    Index = document.getElementById(oInput[i].value).rowIndex;
                    /*获取选中行的索引号*/
                    document.getElementById("shopping").deleteRow(Index);
                    document.getElementById("shopping").deleteRow(Index - 1);
                }
            }
            productCount();
        }

    </script>
</head>
<body>
<p>
    <c:if test="${!empty user}">
            <%
            //如果已登录，读取购物车中的数据，放到cookie中
            ArrayList<String[]> list = new ArrayList<String[]>();
            list.add(new String[]{"1", "https://ww1.sinaimg.cn/thumbnail/005LWWStly1fhw40ettetj30jg0i3q3z.jpg", "商品1", "www.baidu.com", "100"});
            list.add(new String[]{"2", "https://ww1.sinaimg.cn/thumbnail/005LWWStly1fhw40ettetj30jg0i3q3z.jpg", "商品2", "www.baidu.com", "200"});

            List<Goods> goodsList =
                    (List<Goods>)request.getSession().getAttribute("goodsList");

            int times = 1 * 24 * 60 * 60;
            int i = 0;
            for (Goods goods:goodsList) {
                i++;
                Cookie cookie = new Cookie("item_id_" + i,
                        String.valueOf(goods.getGoodsid()));
                cookie.setMaxAge(times);
                response.addCookie(cookie);
                cookie = new Cookie("item_img_" + i, goods.getGoodsdescription());
                cookie.setMaxAge(times);
                response.addCookie(cookie);
                cookie = new Cookie("item_title_" + i, goods.getGoodsname());
                cookie.setMaxAge(times);
                response.addCookie(cookie);
                cookie = new Cookie("item_URL_" + i, String.valueOf(goods.getGoodsid()));
                cookie.setMaxAge(times);
                response.addCookie(cookie);
                cookie = new Cookie("item_price_" + i,
                        String.valueOf(goods.getGoodsprice()));
                cookie.setMaxAge(times);
                response.addCookie(cookie);

            }
        %>
    </c:if>

        <%
            //获取cookie

            Cookie[] cookies = request.getCookies();

            if (cookies != null && cookies.length > 5) {
                ArrayList<String[]> goodslists = new ArrayList<String[]>();
                int i = 1;
                for (int j = 0; j < cookies.length / 5; j++) {
                    String[] strings = new String[5];
                    for (int k = 0; k < strings.length; k++) {
                        strings[k] = java.net.URLDecoder.decode(cookies[i++].getValue(), "UTF-8");
                    }
                    goodslists.add(strings);
                }
                pageContext.setAttribute("goodslist", goodslists);
            }
        %>


<div id="header"><img src="images/taobao_logo.gif" alt="logo"/></div>
<div id="nav">您的位置：<a href="#">首页</a> > 购物车</div>


<div id="content">
    <table width="100%" border="0" cellspacing="0" cellpadding="0"
           id="shopping">
        <form action="" method="post" name="myform">
            <tr>
                <td class="title_1"><input id="allCheckBox" type="checkbox"
                                           value="" onclick="selectAll()"/>全选
                </td>
                <td class="title_2" colspan="2">店铺宝贝</td>
                <td class="title_3">获积分</td>
                <td class="title_4">单价（元）</td>
                <td class="title_5">数量</td>
                <td class="title_6">小计（元）</td>
                <td class="title_7">操作</td>
            </tr>
            <tr>
                <td colspan="8" class="line"></td>
            </tr>


            <c:forEach items="${goodslists}" var="goods">
                <tr id="${goods[0]}">
                    <td class="cart_td_1"><input name="cartCheckBox"
                                                 type="checkbox"
                                                 value="product4"
                                                 onclick="selectSingle()"/></td>
                    <------
                    1：checkbox
                    2：图片
                    3：名称+url
                    4：积分
                    5：单价
                    6：数量
                    7：小计金额
                    8：删除按钮
                    ------->
                    <td class="cart_td_2"><img src="${goods[1]}"
                                               alt="shopping"/></td>
                    <td class="cart_td_3"><a
                            href="${goods[2]}">${goods[2]}</a><br/>
                    </td>
                    <td class="cart_td_4">12</td>
                    <td class="cart_td_5">${goods[4]}</td>
                    <td class="cart_td_6"><img src="images/taobao_minus.jpg"
                                               alt="minus"
                                               onclick="changeNum('num_${goods[0]}','minus')"
                                               class="hand"/> <input
                            id="num_${goods[0]}" type="text" value="2"
                            class="num_input"
                            readonly="readonly"/> <img
                            src="images/taobao_adding.jpg"
                            alt="add"
                            onclick="changeNum('num_${goods[0]}','add')"
                            class="hand"/></td>
                    <td class="cart_td_7"></td>
                    <td class="cart_td_8"><a
                            href="javascript:deleteRow('${goods[0]}');">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3"><a href="javascript:deleteSelectRow()"><img
                        src="images/taobao_del.jpg" alt="delete"/></a></td>
                <td colspan="5" class="shopend">商品总价（不含运费）：<label id="total"
                                                                  class="yellow"></label>
                    元<br/> 可获积分 <label class="yellow" id="integral"></label>
                    点<br/>
                    <input name=" " type="image" src="images/taobao_subtn.jpg"/>
                </td>
            </tr>
        </form>
    </table>
    <div style="text-align:center;">
    </div>
</div>
<p></p>
</body>
</html>