<%@ page import="com.neusoft.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/16
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<head>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/mqttws31.js"></script>
    <link type="text/css" rel="stylesheet" href="css/chat_style.css">
    <script type="text/javascript">
        var client;
        var current_chat_client;
        var avatar = ${user.userphoto};
        var clientID = ${user.nickname};   //session获取登录用户的用户编号
        var all_users = new Array();
        var message_record = [[]];
        var all_users = [];


        function connect() {
            //clientID=$('#clientID').val();
            client = new Messaging.Client('127.0.0.1', 61614, clientID);

            client.onConnectionLost = function(){
                //$('#message').append('连接已断开');
                alert('连接已断开');
            };

            client.connect({onSuccess: function(){
                alert('连接成功');
                client.subscribe("topic");
            }});

            client.onMessageArrived = function (message) {
                var msgObj = jQuery.parseJSON(message.payloadString);
                //添加新消息
                //$('#message').append(msgObj.from + ':' + msgObj.body + '</br>');
                if(msgObj.to == clientID){
                    if(msgObj.from == current_chat_client){
                        append_msg(msgObj.from, msgObj.body, msgObj.time);
                    }else{
                        var find = false;
                        for(var i = 0; i < all_users.length; ++i){
                            if(all_users[i] == msgObj.from){find = true;break;}
                        }
                        if(find == false) {
                            all_users.push(msgObj.from);
                            message_record.push(new Array())
                            add_user(msgObj.from)
                        }
                    }
                    var i=0;
                    for(;i<all_users.length; ++i)
                        if(all_users[i] == msgObj.from)
                            break;
                    var msg = {"user_name": msgObj.from, "content":msgObj.body, "time":msgObj.time};
                    message_record[i].push(msg);
                }
            };

        }

        $(function($) {
            connect();

        });

        function sendMsg() {
            var msg={};
            msg.from = clientID;
            msg.to = 'admin_chat';
            msg.body = $('#message').val();
            msg.avatar = avatar;
            msg.time = getNowFormatDate();
            send_message = new Messaging.Message(JSON.stringify(msg));
            send_message.destinationName = "topic";
            client.send(send_message);
            var msg_temp = {"from":clientID, "content":msg.body, "time":msg.time};
            message_record.push(msg_temp);
            append_msg(clientID, msg.body, msg.time, true);
        }

        function append_msg(user, msg, chat_time, clear){
            var htmlData = '<div class="msg_item fn-clear">'
                + '   <div class="uface"><img src="avatar/admin.jpg width="40" height="40"  alt=""/></div>'
                + '   <div class="item_right">'
                + '     <div class="msg own">' + msg + '</div>'
                + '     <div class="name_time">' + user + ' · ' + chat_time + '</div>'
                + '   </div>'
                + '</div>';

            $("#message_box").append(htmlData);
            $('#message_box').scrollTop($("#message_box")[0].scrollHeight + 20);
            if(clear == true)
                $("#message").val('');

        }

        $("#message").keydown(function(event){
            var e = window.event || event;
            var k = e.keyCode || e.which || e.charCode;
            //按下ctrl+enter发送消息
            if((event.ctrlKey && (k == 13 || k == 10) )){
                sendMsg();
            }
        });

        function add_user(user_name) {
            var htmlData = ' <li class="fn-clear" onclick="change_current_user(\'' + user_name + '\')"><span><img src="images/hetu.jpg" width="30" height="30"  alt=""/></span><em>'
                + user_name + '</em><small class="online" title="在线"></small></li>';

            $("#all_user_check").append(htmlData);
        }

        function change_current_user(user_name) {
            var i = 0;
            for(; i < all_users.length; ++i){
                if(all_users[i] == user_name)
                    break;
            }
            current_chat_client = user_name;
            clear_message_box();
            for(var j = 0; j < message_record[i].length; ++j){
                append_msg(message_record[i][j].user_name, message_record[i][j].content, message_record[i][j].time, true);
            }
        }

        function clear_message_box() {
            $('#message_box').html("");
        }

        function getNowFormatDate() {
            var date = new Date();
            var seperator1 = "-";
            var seperator2 = ":";
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
                + " " + date.getHours() + seperator2 + date.getMinutes()
                + seperator2 + date.getSeconds();
            return currentdate;
        }

    </script>
    <title>chat-test</title>

</head>
<body>

<div class="chatbox">
    <div class="chat_top fn-clear">
        <div class="logo"><img src="images/logo.png" width="190" height="60"  alt=""/></div>
        <div class="uinfo fn-clear">
            <div class="uface"><img src="images/hetu.jpg" width="40" height="40"  alt=""/></div>
            <div class="uname">
                ${user.nickname}  <i class="fontico down"></i>
                <ul class="managerbox">
                    <li><a href="#"><i class="fontico lock"></i>修改密码</a></li>
                    <li><a href="#"><i class="fontico logout"></i>退出登录</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="chat_message fn-clear">
        <div class="chat_left">
            <div class="message_box" id="message_box">

            </div>
            <div class="write_box">
                <textarea id="message" name="message" class="write_area" placeholder="说点啥吧..."></textarea>
                <input type="hidden" name="fromname" id="fromname" value="河图" />
                <input type="hidden" name="to_uid" id="to_uid" value="0">
                <div class="facebox fn-clear">
                    <div class="expression"></div>
                    <div class="chat_type" id="chat_type">群聊</div>
                    <button name="" class="sub_but" onclick="sendMsg();">发 送</button>
                </div>
            </div>
        </div>
        <div class="chat_right">
            <ul class="user_list" title="双击用户私聊" id = "all_user_check">
                <li class="fn-clear selected" ><em>客服</em></li>

            </ul>
        </div>
    </div>
</div>


</body>
</html>

