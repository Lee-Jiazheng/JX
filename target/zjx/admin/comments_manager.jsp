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
    <title>Title</title>
</head>
<body>
<c:forEach var="good_comments" items="${good_comments_map}">
    <h1>${good_comments.key.goodsname}</h1>
    <c:forEach var="comments" items="${good_comments.value}">
        <h2>${comments.commentscontent}</h2>
        <h2>${comments.commentsbuyer}</h2>
        <a href="delete_comment.do?&commentsid=${comments.commentsid}"><b>删除</b></a>
    </c:forEach>

</c:forEach>
</body>
</html>
