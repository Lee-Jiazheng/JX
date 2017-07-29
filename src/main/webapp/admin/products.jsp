<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty admin_user}">
    <c:redirect url="/index.do">
    </c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<div class="margin" id="page_style" style="left: 0px;max-height: 600px;overflow: auto;">
    <div class="operation clearfix">
        <button class="btn button_btn btn-danger" type="button" onclick=""><i class="fa fa-trash-o"></i>&nbsp;删除</button>
        <span class="submenu"><a href="add_product.jsp" name="add_product.html" class="btn button_btn bg-deep-blue" title="添加产品"><i class="fa  fa-edit"></i>&nbsp;添加产品</a></span>
        <div class="search  clearfix">
            <label class="label_name">商品搜索：</label><input name="" type="text"  class="form-control col-xs-6"/><button class="btn button_btn bg-deep-blue " onclick=""  type="button"><i class="fa  fa-search"></i>&nbsp;搜索</button>

        </div>
    </div>
    <!--列表展示-->
    <div class="list_Exhibition margin-sx">
        <table class="table table_list table_striped table-bordered" id="sample-table">
            <thead>
            <tr>
                <th width="100">产品编号</th>
                <th>产品名称</th>
                <th width="120">产品现价</th>
                <th width="100">分类</th>
                <th width="100">数量</th>
                <th width="150">添加日期</th>
                <th width="220">操作</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${goods}" var="good">
                <tr role="row" class="odd">
                    <td class="sorting_1">${good.goodsid}</td>
                    <td>${good.goodsname}</td>
                    <td>${good.goodsprice}</td>
                    <td>促销化妆品</td>
                    <td>${good.goodsquantity}</td>
                    <td>${good.goodscreatetime}</td>
                    <td><a href="javascript:ovid()" onclick="picture_edit(this," 123")"="" class="btn bg-deep-blue operation_btn">修改</a>
                        <a href="/admin/del_goods.do?good_id=${good.goodsid}" onclick="picture_del(this," 10001")"="" class="btn btn-danger operation_btn">删除</a>
                        <a href="comment_manager.do?goodsid=${good.goodsid}" class="btn bg-deep-blue operation_btn">评价</a>
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
<script type="text/javascript">
    //设置框架
    $(function() {
        $("#page_style").frame({
            float : 'left',
            menu_nav:'.operation',
            color_btn:'.skin_select',
        });
    });
    $(document).ready(function(){
        var spotMax = 8;
        if($('#add_Carousel_figure .table tbody tr').size() >= spotMax) {$(obj).hide();}
        $("#add_Upload").on('click',function(){
            var cid =$('.images_Upload').each(function(i){ $(this).attr('id',"Uimages_Upload_"+i)});
            addSpot(this, spotMax, cid);
        });
    });
    function addSpot(obj, sm ,sid) {
        $("#Upload").append("<div class='images_Upload clearfix margin-bottom' id='"+sid+"'>"+
            "<span class='Upload_img'><input name='' type='file' /></span>"+
            "<a href='javascript:ovid()' class='operating delete_Upload'><i class='fa fa-remove'></i></a>"+
            "<a href='javascript:ovid()' class='operating' onclick='preview_img(this.id)'><i class='fa  fa-image'></i></a>"+
            "</div>&nbsp;")
            .find(".delete_Upload").click(function(){
            if($('div.images_Upload').size()==1){
                layer.msg('请至少保留一张图片!',{icon:0,time:1000});
            }
            else{
                $(this).parent().remove();
                $('#add_Upload').show();
            }

        });
        if($('.delete_Upload').size() >= sm) {$(obj).hide();layer.msg('当前为最大图片添加量!',{icon:0,time:1000});}}



    /***********图片查看**********/
    function picture_img(ojb,id){
        layer.open({
            type: 1,
            title: '产品轮播图',
            maxmin: true,
            shadeClose:false, //点击遮罩关闭层
            area : ['800px' , '400px'],
            content:$('#add_Carousel_figure'),
            btn:['提交','取消'],
        });
    }
    /*产品-删除*/
    function picture_del(obj,id){
        layer.confirm('确认要删除吗？',{icon:0,},function(index){
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }



    /*********滚动事件*********/
    $("#page_style").niceScroll({
        cursorcolor:"#888888",
        cursoropacitymax:1,
        touchbehavior:false,
        cursorwidth:"5px",
        cursorborder:"0",
        cursorborderradius:"5px"
    });


</script>
