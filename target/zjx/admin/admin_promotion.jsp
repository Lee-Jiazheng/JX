<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="css/shop.css" type="text/css" rel="stylesheet"/>
    <link href="css/Sellerber.css" type="text/css" rel="stylesheet"/>
    <link href="css/bkg_ui.css" type="text/css" rel="stylesheet"/>
    <link href="font/css/font-awesome.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="css/summernote/summernote.css" rel="stylesheet"
          type="text/css"/>
    <link href="css/summernote/summernote-bs3.css" rel="stylesheet"
          type="text/css"/>
    <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script src="js/shopFrame.js" type="text/javascript"></script>
    <script src="js/Sellerber.js" type="text/javascript"></script>
    <script src="js/layer/layer.js" type="text/javascript"></script>
    <script src="js/laydate/laydate.js" type="text/javascript"></script>
    <script src="js/jquery-ui-1.10.4.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/beautifyhtml.js" type="text/javascript"></script>
    <meta charset="utf-8">
    <title>京西商城 - 智·享·生·活</title>
    <link rel="stylesheet" href="css/top_bottom_style.css"></link>
    <link rel="stylesheet" href="css/comment_style.css"></link>
    <script src="js/jquery-3.2.1.min.js"></script>

</head>
<style>
    .droppable-active {
        background-color: #ffe !important;
    }

    .tools a {
        cursor: pointer;
        font-size: 80%;
    }

    .form-body .col-md-6,
    .form-body .col-md-12 {
        min-height: 400px;
    }

    .draggable {
        cursor: move;
    }

    .modal-body textarea {
        width: 100%;
    }

    .tools a {
        margin: 0px 5px;
        color: #1D9FC0
    }

    .ibox-content .alert {
        margin-top: 0px;
    }
</style>
<body class="gray-bg">
<form action="admin_promotion.do">
<div class="margin" id="page_style">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-5">
                <div class="ibox float-e-margins">
                    <div class="ibox-title"><h5>添加活动</h5></div>
                    <div class="ibox-content">
                        <form role="form" class="form-horizontal m-t">
                            <div class="form-group draggable">
                                <label class="col-sm-3 label_nameedit ">活动名称：</label>
                                <div class="col-sm-9">
                                    <input type="text" name="promotionname"
                                           class="form-control" placeholder="">
                                    <span class="help-block">如“双十一”</span>
                                </div>
                            </div>
                            <div class="form-group draggable">
                                <label class="col-sm-3 label_nameedit ">活动描述：</label>
                                <div class="col-sm-9">
                                    <textarea name="promotioncontent" cols=""
                                              rows=""></textarea>
                                    <span class="help-block m-b-none">请输入活动描述</span>
                                </div>
                            </div>
                            <div class="form-group draggable">
                                <label class="col-sm-3 label_nameedit ">优惠门槛：</label>
                                <div class="col-sm-9">
                                    <input type="text" name="promotionthreshold"
                                           class="form-control" placeholder="">
                                    <span class="help-block">如“300”</span>
                                </div>
                            </div>
                            <div class="form-group draggable">
                                <label class="col-sm-3 label_nameedit ">优惠力度：</label>
                                <div class="col-sm-9">
                                    <input type="text" name="promotiondeduction"
                                           class="form-control" placeholder="">
                                    <span class="help-block">如“100”</span>
                                </div>
                            </div>
                            <div class="form-group draggable">
                                <label class="col-sm-3 label_nameedit ">时间段：</label>
                                <div class="col-sm-9">
                                    <span class="laydate-icon" id="start"
                                          style="width:150px;height:30px; line-height:30px; float:left"></span>
                                    <span style=" float:left; margin:0px 5px; color:#666; line-height:32px;">至</span>
                                    <span class="laydate-icon" id="end"
                                          style="width:150px;height:30px; line-height:30px; float:left"></span>
                                </div>
                                <script>
                                    var start = {
                                        elem: '#start',
                                        format: 'YYYY/MM/DD ',
                                        min: laydate.now(), //设定最小日期为当前日期
                                        max: '2099-06-16 23:59:59', //最大日期
                                        istime: true,
                                        istoday: false,
                                        choose: function (datas) {
                                            end.min = datas; //开始日选好后，重置结束日的最小日期
                                            end.start = datas //将结束日的初始值设定为开始日
                                        }
                                    };
                                    var end = {
                                        elem: '#end',
                                        format: 'YYYY/MM/DD',
                                        min: laydate.now(),
                                        max: '2099-06-16 23:59:59',
                                        istime: true,
                                        istoday: false,
                                        choose: function (datas) {
                                            start.max = datas; //结束日选好后，重置开始日的最大日期
                                        }
                                    };
                                    laydate(start);
                                    laydate(end);
                                </script>
                            </div>
                            <div class="form-group draggable">
                                <label class="col-sm-3 label_nameedit ">优惠类别：</label>
                                <div class="col-sm-9">
                                    <select class="form-control"
                                            style=" width:200px" name="">
                                        <option>全部商品</option>
                                        <option>指定类别</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group draggable">
                                <label class="col-sm-3 label_nameedit ">宣传图片：</label>
                                <div class="col-sm-9">
                                    <div class="line">
                                <span class="span">
                                <input name="" type="text" id="viewfile"
                                       onmouseout="document.getElementById('upload').style.display='none';"
                                       class="inputstyle form-control"/>
                                </span>
                                        <label for="unload"
                                               onmouseover="document.getElementById('upload').style.display='block';"
                                               class="file1">浏览...</label>
                                        <input type="file"
                                               onchange="document.getElementById('viewfile').value=this.value;this.style.display='none';"
                                               class="file" id="upload"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group draggable">
                                <label class="col-sm-3 label_nameedit">复选框：</label>

                                <div class="col-sm-9">
                                    <label class="checkbox-inline"><input
                                            type="checkbox" class="ace"><span
                                            class="lbl">复选框名称</span></label>
                                    <label class="checkbox-inline"><input
                                            type="checkbox" class="ace"><span
                                            class="lbl">复选框名称</span></label>
                                    <label class="checkbox-inline"><input
                                            type="checkbox" class="ace"><span
                                            class="lbl">复选框名称</span></label>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group draggable">
                                <div class="Button_operation">
                                    <button class="btn button_btn bg-deep-blue"
                                            type="submit">保存内容
                                    </button>
                                    <button class="btn button_btn bg-gray"
                                            type="submit">取消
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>

