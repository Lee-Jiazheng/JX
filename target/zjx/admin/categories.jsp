<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty admin_user}">
    <c:redirect url="/index.do">
    </c:redirect>
</c:if>
<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/29
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="/css/shop.css" type="text/css" rel="stylesheet" />
    <link href="/css/Sellerber.css" type="text/css"  rel="stylesheet" />
    <link href="/css/bkg_ui.css" type="text/css"  rel="stylesheet" />
    <link href="/font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
    <script src="/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
    <script type="text/javascript" src="/js/jquery.cookie.js"></script>
    <script src="/js/shopFrame.js" type="text/javascript"></script>
    <script src="/js/Sellerber.js" type="text/javascript"></script>
    <script src="/js/layer/layer.js" type="text/javascript"></script>
    <script src="/js/jquery.dataTables.min.js"></script>
    <script src="/js/jquery.dataTables.bootstrap.js"></script>

    <!--[if lt IE 9]>
    <script src="js/html5shiv.js" type="text/javascript"></script>
    <script src="js/respond.min.js"></script>
    <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
    <![endif]-->
    <title>产品列表</title>
</head>
<body>
<form action="/admin/add_category.do">
<input name="categoryname" type="text" placeholder="类别名称">
    <label>是否为父类：</label>   <input name="parentflag" type="checkbox" >
<input name="parentid" type="text" placeholder="父类别" value="0">
<input name="categoryimg" type="text" placeholder="类别标签">
<input class="btn button_btn bg-deep-blue" type="submit" onclick=""><i class="fa fa-trash-o"></i>&nbsp;添加分类</input>

</form>
<script>
</script>
<div class="margin" id="page_style" style="left: 0px;max-height: 600px;overflow: auto; margin-bottom: 30px;">

    <!--列表展示-->
    <div class="list_Exhibition margin-sx">
        <table class="table table_list table_striped table-bordered" id="sample-table">
            <thead>
            <tr>
                <th width="100">类别编号</th>
                <th>类别名称</th>
                <th width="120">父类别</th>
                <th width="100">类别标签</th>
                <th width="220">操作</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${categories}" var="category">
                <tr role="row" class="odd">
                    <td class="sorting_1">${category.categoryid}</td>
                    <td>${category.categoryname}</td>

                        <c:if test="${category.parentflag}">
                            <td>-
                            </td>
                            <td>-
                            </td>
                        </c:if>
                    <c:if test="${!category.parentflag}">
                        <td>${category.parentid}
                        </td>
                        <td>${category.categoryimg}
                        </td>
                    </c:if>
                    <td><a href="javascript:ovid()" onclick="picture_edit(this," 123")"="" class="btn bg-deep-blue operation_btn">修改</a>
                        <a href="/admin/del_category?categoryID=${category.categoryid}" onclick="picture_del(this," 10001")"="" class="btn btn-danger operation_btn">删除</a>
                    </td></tr>

            </c:forEach>


            <tr>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<div class="add_Carousel_figure" id="add_Carousel_figure" style=" display:none">
    <table class="table table_list table_striped table-bordered">
        <thead>
        <tr>
            <th width="30"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
            <th  width="50">排序</th>
            <th width="100">图片</th>
            <th>尺寸</th>
            <th>大小</th>
            <th>上传时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td width="30"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
            <td>1</td>
            <td><img src="../products/ad.jpg"  width="100px" height="80px"/></td>
            <td>450x470</td>
            <td>234KB</td>
            <td>2016-08-21</td>
            <td>
                <a href="javascript:ovid()">删除</a>
                <a href="javascript:ovid()">修改</a>
            </td>
        </tr>
        <tr>
            <td width="30"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
            <td>2</td>
            <td><img src="../products/p_55.jpg"  width="100px" height="80px"/></td>
            <td>450x470</td>
            <td>234KB</td>
            <td>2016-08-21</td>
            <td>
                <a href="javascript:ovid()">删除</a>
                <a href="javascript:ovid()">修改</a>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="list_carousel" id="Upload">
        <div class="title_name"><i></i>添加轮播图</div>
        <button type="button" class="add_Upload bg-deep-blue" id="add_Upload" onclick="add_Upload()"><i class="fa  fa-plus"></i></button>
        <div class="images_Upload clearfix margin-bottom" id="images_Upload">
            <span class="Upload_img"><input name="" type="file" /></span>
            <a href="javascript:ovid()" class="operating delete_Upload" onclick="delete_Upload(this.id)"><i class="fa fa-remove"></i></a>
            <a href="javascript:ovid()" class="operating" title="预览" onclick="preview_img(this.id)"><i class="fa  fa-image"></i></a>
        </div>
    </div>
</div>
</body>
</html>
