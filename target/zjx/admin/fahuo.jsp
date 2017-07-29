<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty admin_user}">
    <c:redirect url="/index.do">
    </c:redirect>
</c:if>
<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/26
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/shop.css" type="text/css" rel="stylesheet" />
    <link href="/css/Sellerber.css" type="text/css"  rel="stylesheet" />
    <link href="/css/bkg_ui.css" type="text/css"  rel="stylesheet" />
    <link href="/font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
    <title>Title</title>
</head>
<body>
<div class="margin" id="page_style" style="left: 0px;max-height: 600px;overflow: auto;  margin-bottom: 30px;">
    <!--列表展示-->
    <div class="list_Exhibition margin-sx">
        <table class="table table_list table_striped table-bordered" id="sample-table">
            <thead>
            <tr>
                <th width="120">订单号</th>
                <th width="200">购买物品</th>
                <th width="100">购买人</th>
                <th width="150">购买时间</th>
                <th width="50">订单价格</th>
                <th width="150">配送地点</th>
                <th width="50">操作</th>
            </tr>
            </thead>
            <tbody>


                    <c:forEach var="good_order" items="${good_orders}">
                        <tr role="row" class="odd">
                            <td class="sorting_1">${good_order.orderid}</td>
                            <td>${good_order.goodsname}</td>
                            <td>${good_order.nickname}</td>
                            <td>${good_order.ordertime}</td>
                            <td>${good_order.orderprice}</td>
                            <td>${good_order.addressname}</td>
                            <td>
                            <c:if test="${!good_order.orderfinished}">
                                <a class="btn bg-deep-blue operation_btn" href="fahuo.do?orderid=${good_order.orderid}">发货</a>
                            </c:if>
                                <a href="delete_order.do?orderid=${good_order.orderid}"  class="btn btn-danger operation_btn">删除</a>
                            </td>

                        </tr>

                    </c:forEach>


            <tr>
            </tr>
            </tbody>
        </table>
    </div>
</div>



</body>
</html>
