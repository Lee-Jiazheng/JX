<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="margin" id="page_style" style="left: 0px;max-height: 600px;overflow: auto;">
    <!--列表展示-->
    <div class="list_Exhibition margin-sx">
        <table class="table table_list table_striped table-bordered" id="sample-table">
            <thead>
            <tr>
                <th width="120">评论ID</th>
                <th width="200">评论内容</th>
                <th width="100">评价人</th>
                <th width="150">评价日期</th>
                <th width="50">操作</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="good_comments" items="${good_comments_map}">
                <c:if test="${param.goodsid == good_comments.key.goodsid}">
                    <h1>${good_comments.key.goodsname}<a href="javascript:history.back(-1)" class="btn bg-deep-blue operation_btn" style="margin-left:15px;font-size:12px;">返回</a></h1>

                    <c:forEach var="comments" items="${good_comments.value}">
                        <tr role="row" class="odd">
                            <td class="sorting_1">${comments.commentsid}</td>
                            <td>${comments.commentscontent}</td>
                            <td>${comments.commentsbuyer}</td>
                            <td>${comments.commentstime}</td>
                            <td>
                                <a href="javascript:history.back(-1)" class="btn bg-deep-blue operation_btn">返回</a>
                                <a href="delete_comment.do?&commentsid=${comments.commentsid}" class="btn btn-danger operation_btn">删除</a>
                            </td>
                        </tr>

                    </c:forEach>
                </c:if>
            </c:forEach>


            <tr>
            </tr>
            </tbody>
        </table>
    </div>
</div>



</body>
</html>
