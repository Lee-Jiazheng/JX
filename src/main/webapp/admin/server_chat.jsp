<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/27
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty admin_user}">
    <c:redirect url="/index.do">
    </c:redirect>
</c:if>
<html>
<head>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/js/mqttws31.js"></script>
    <link type="text/css" rel="stylesheet" href="/css/chat_style.css">
    <script type="text/javascript">

        var client;
        var current_chat_client;
        var clientID = 'admin_chat';   //session获取登录用户的用户编号
        var all_users = new Array();
        var message_record = [[]];
        var all_users = ["admin_chat"];

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
                        append_msg(msgObj.from, msgObj.body, msgObj.time, msgObj.avatar, false);
                    }else{
                        var find = false;
                        for(var i = 0; i < all_users.length; ++i){
                            if(all_users[i].user_name == msgObj.from){find = true;break;}
                        }
                        if(find == false) {
                            var user = {"user_name":msgObj.from, "avatar": msgObj.avatar};
                            all_users.push(user);
                            message_record.push(new Array());
                            add_user(msgObj.from, msgObj.avatar);
                        }
                    }
                    var i=0;
                    for(;i<all_users.length; ++i)
                        if(all_users[i].user_name == msgObj.from)
                            break;

                    var temp_mes={"from":msgObj.from, "time": getNowFormatDate(), "content":msgObj.body};

                    message_record[i].push(temp_mes);
                }
            };

        }

        $(function($) {
            connect();
        });

        function sendMsg() {
            if(!current_chat_client){
                alert("发送失败，请选择一个用户");
                return;}
            var msg={};
            msg.from = clientID;
            msg.to = current_chat_client;
            msg.body = $('#message').val();
            msg.time = getNowFormatDate();
            send_message = new Messaging.Message(JSON.stringify(msg));
            send_message.destinationName = "topic";
            client.send(send_message);
            var temp_mes={"from":msg.from, "time": getNowFormatDate(), "content":msg.body};
            var i=0;
            for(;i<all_users.length; ++i)
                if(all_users[i].user_name == msg.to)
                    break;

            var temp_mes={"from":msg.from, "time": msg.time, "content":msg.body};

            message_record[i].push(temp_mes);
            append_msg(clientID, msg.body, msg.time, "admin.jpg", true);
        }

        function append_msg(user, msg, chat_time, avatar, clear){
            var htmlData = '<div class="msg_item fn-clear">'
                + '   <div class="uface"><img src=\"/avatar/'+ avatar + '\" width="40" height="40"  alt=""/></div>'
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

        function add_user(user_name, avatar) {
            var htmlData = ' <li class="fn-clear" onclick="change_current_user(\'' + user_name + '\')"><span><img src=\"/avatars/'+ avatar +'\" width="30" height="30"  alt=""/></span><em>'
                + user_name + '</em><small class="online" title="在线"></small></li>';

            $("#all_user_check").append(htmlData);
        }

        function change_current_user(user_name) {
            var i = 0;
            for(; i < all_users.length; ++i){
                if(all_users[i].user_name == user_name)
                    break;
            }
            current_chat_client = user_name;
            clear_message_box();
            for(var j = 0; j < message_record[i].length; ++j){
                append_msg(user_name, message_record[i][j].content, message_record[i][j].time, all_users[i].avatar, true);
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
        <div class="logo"><img src="/images/logoword.png" width="190" height="60"  alt=""/></div>
        <div class="uinfo fn-clear">
            <div class="uface"><img src="/avatar/admin.jpg" width="40" height="40"  alt=""/></div>
            <div class="uname">
                管理员客服
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
                <li class="fn-clear selected" ><em>所有用户</em></li>

            </ul>
        </div>
    </div>
</div>


</body>
</html>
