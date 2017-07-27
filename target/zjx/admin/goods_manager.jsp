<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/26
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${goods}" var="good">
    <c:if test="${empty good.photo}">
        <img src="/images/defaultblue.png">
    </c:if>
    <c:if test="${!empty good.photo}">
        <img src="/good_picture/${good.photo.photo}">
    </c:if>
    <h1>${good.goodsid}</h1>
    <h3>${good.goodsname}</h3>
    <h3>${good.goodsprice}</h3>
    <h3>${good.goodsquantity}</h3>
    <h3>${good.goodsdescription}</h3>
    <h3>${good.goodscreatetime}</h3>
    <a href="delete_good?goodId=${good.goodsid}"><b>删除</b></a>

</c:forEach>
</body>
</html>
