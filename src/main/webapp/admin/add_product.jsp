<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/27
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="../css/shop.css" type="text/css" rel="stylesheet" />
    <link href="../css/Sellerber.css" type="text/css" rel="stylesheet" />
    <link href="../css/bkg_ui.css" type="text/css" rel="stylesheet" />
    <link href="../font/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <script src="../js/jquery-1.9.1.min.js" type="text/javascript" ></script>
    <script src="../js/Sellerber.js" type="text/javascript"></script>
    <script src="../js/jquery.dataTables.min.js"></script>
    <script src="../js/jquery.dataTables.bootstrap.js"></script>
    <script src="../js/layer/layer.js" type="text/javascript"></script>
    <script src="../js/laydate/laydate.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js" type="text/javascript"></script>
    <script src="js/respond.min.js"></script>
    <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
    <![endif]-->
    <title>添加产品</title>
</head>

<body>

<form action="/add_goods.do" method="post" enctype="multipart/form-data" style="margin-bottom: 30px;">
    商品名称：<input type="text" name="goodsname"><br/>


    商品分类：<select id="fathercategory">
    <c:forEach var="parent_category" items="${category_map}">
        <option value="${parent_category.key.categoryid}">${parent_category.key.categoryname}</option>
    </c:forEach>
</select>

    <c:forEach var="parent_category" items="${category_map}">
        <div class="sonsof${parent_category.key.categoryid} subclass" style="display: none;">
            <select class="soncategory">
                <c:forEach items="${parent_category.value}" var="son_category">
                    <option value="${son_category.categoryid}">${son_category.categoryname}</option>
                </c:forEach>
            </select>
        </div>
        </br>
    </c:forEach>



    商品价格：<input type="text" name="goodsprice"><br/>
    商品数量：<input type="text" name="goodsquantity"><br/>
    商品图片：<input type="file" name="goods_image"><br/>
    <input type="hidden" name="categoryid" id="subcategory">
    <input type="submit" value="提交商品信息"/>
</form>

<di class="margin" style="max-height: 600px;overflow: auto;">
    <form action="add_goods.do" method="post" enctype="multipart/form-data">
        <div class="add_style">
            <ul>
                <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>标题名称：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input name="goodsname" type="text"  class="col-xs-6"/></div></li>
                <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>简单描述：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input name="goodsdescription" type="text" class="col-xs-4"/></div></li>
                <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>关&nbsp;键&nbsp;字：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input name="goodskeywords" type="text" class="col-xs-4"/><em class="Prompt"> 请用","分隔关键字</em></div></li>
                <li class="clearfix">
                    <label class="label_name col-xs-1"><i>*</i>产品分类：&nbsp;&nbsp;</label>
                    <div class="Add_content col-xs-11">
                        <select id="fathercategory">
                            <c:forEach var="parent_category" items="${category_map}">
                                <option value="${parent_category.key.categoryid}">${parent_category.key.categoryname}</option>
                            </c:forEach>
                        </select>

                        <c:forEach var="parent_category" items="${category_map}">
                            <div class="sonsof${parent_category.key.categoryid} subclass" style="display: none;">
                                <select class="soncategory">
                                    <c:forEach items="${parent_category.value}" var="son_category">
                                        <option value="${son_category.categoryid}">${son_category.categoryname}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            </br>
                        </c:forEach>
                    </div>
                </li>
                <li class="clearfix">
                    <div class="col-xs-4">
                        <label class="label_name col-xs-3"><i>*</i>商品现价：&nbsp;&nbsp;</label>
                        <div class="Add_content col-xs-9">
                            <input name="goodsprice" type="text"  class="col-xs-7"/><em class="Prompt">元</em>
                        </div>
                    </div>
                    <div class="col-xs-4">
                        <label class="label_name col-xs-3"><i>*</i>商品数量：&nbsp;&nbsp;</label>
                        <div class="Add_content col-xs-9">
                            <input name="goodsquantity" type="text"  class="col-xs-7"/><em class="Prompt">件</em>
                        </div>
                    </div>
                </li>
                <li class="clearfix">
                    <label class="label_name col-xs-1"><i>*</i>产品图片：&nbsp;&nbsp;</label>
                    <div class="Add_content col-xs-11" id="Upload">
                        <div class="images_Upload clearfix margin-bottom" id="images_Upload">
                            <span class="Upload_img"><input name="goods_image" type="file" /></span>
                        </div>
                        <button type="button" class="add_Upload bg-deep-blue" id="add_Upload" onclick="add_Upload()"><i class="fa  fa-plus"></i></button>
                    </div>
                </li>

            </ul>
            <div class="Button_operation btn_width">
                <input class="btn button_btn bg-deep-blue" type="submit">保存并提交</input>
                <a class="btn button_btn bg-gray" href="products.jsp">取消添加</a>
            </div>
        </div>
    </form>


    </div>

    <script>

        $('.subclass').hide();
        $('#subcategory').val($('.subclass').children().eq(0).children('option:selected').val());
        console.log($('.subclass').children().eq(0).children('option:selected').val());
        console.log($('#subcategory').val());
        $('#fathercategory').change(function(){
            $('.subclass').hide();
            var f=$('#fathercategory').children('option:selected').val();
            console.log('f:'+f);
            $('.sonsof'+f).show();
            $('#subcategory').val($('.sonsof'+f).children().eq(0).val());
            console.log($('#subcategory').val());
        });
        $('.soncategory').change(function(){
            $('#subcategory').val($(this).children('option:selected').val());
            console.log($('#subcategory').val());
        });
    </script>

</body>
</html>
<!--复文本编辑框-->
<script type="text/javascript" charset="utf-8" src="js/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="js/utf8-jsp/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script>
    $(function(){
        var ue = UE.getEditor('editor');
    });
    $(document).ready(function(){
        var spotMax = 8;
        if($('div.images_Upload').size() >= spotMax) {$(obj).hide();}
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
    /*checkbox激发事件*/
    $('#checkbox').on('click',function(){
        if($('input[name="checkbox"]').prop("checked")){
            $('.Date_selection ').css('display','block');
        }
        else{

            $('.Date_selection').css('display','none');
        }
    });
    function add_category(){
        $(".add_category_style").toggle();

    }
    /******时间设置*******/
    var start = {
        elem: '#start',
        format: 'YYYY/MM/DD hh:mm:ss',
        min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16 23:59:59', //最大日期
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#end',
        format: 'YYYY/MM/DD hh:mm:ss',
        min: laydate.now(),
        max: '2099-06-16 23:59:59',
        istime: true,
        istoday: false,
        choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);
    /*********滚动事件*********/
    $("body").niceScroll({
        cursorcolor:"#888888",
        cursoropacitymax:1,
        touchbehavior:false,
        cursorwidth:"5px",
        cursorborder:"0",
        cursorborderradius:"5px"
    });

</script>
