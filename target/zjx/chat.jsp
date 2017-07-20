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
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mqttws31.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/chat_style.css">
    <script type="text/javascript">
        var client;
        var clientID = '${user.nickName}';   //session获取登录用户的用户编号
        var all_users = [];
        function lostConnection() {
            //$('#message').append('连接已经断开！');
            alert('连接已经断开');
            <%
            List<User> users = (List<User>)request.getAttribute("chat_users");
            for(int i = 0; i < users.size(); ++i){%>
                all_users.push('<%=(String)users.get(i).getNickName()%>');
            <%}%>
            <%=request.getAttribute("userName")%>
        }

        function successConnection() {
            //$('#message').append('连接成功' + '</br>');
            alert('连接成功');
            client.subscribe("topic");
        }
        
        function newMessageProcess(message) {
            var msgObj = jQuery.parseJSON(message.payloadString);
            //添加新消息
            //$('#message').append(msgObj.from + ':' + msgObj.body + '</br>');
            if(msgObj.to == clientID){

                append_msg(msgObj.from, msgObj.body);
            }
        }

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
                append_msg(msgObj.from, msgObj.body, false);
            };

        }

        $(function($) {
            connect();
        });

        function sendMsg() {
            var msg={};
            msg.from = clientID;
            msg.to = '1';
            msg.body = $('#message').val();
            send_message = new Messaging.Message(JSON.stringify(msg));
            send_message.destinationName = "topic";
            client.send(send_message);
            append_msg(clientID, msg.body, true);
            alertss('fasong' + send_message);
        }

        function append_msg(user, msg, clear){
            var htmlData = '<div class="msg_item fn-clear">'
                + '   <div class="uface"><img src="images/hetu.jpg" width="40" height="40"  alt=""/></div>'
                + '   <div class="item_right">'
                + '     <div class="msg own">' + msg + '</div>'
                + '     <div class="name_time">' + user + ' · 30秒前</div>'
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
                河图<i class="fontico down"></i>
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
                <div class="msg_item fn-clear">
                    <div class="uface"><img src="images/53f44283a4347.jpg" width="40" height="40"  alt=""/></div>
                    <div class="item_right">
                        <div class="msg">近日，TIOBE发布了2014年9月的编程语言排行榜，Java、C++跌至历史最低点，前三名则没有变化，依旧是C、Java、Objective-C。</div>
                        <div class="name_time">猫猫 · 3分钟前</div>
                    </div>
                </div>

                <div class="msg_item fn-clear">
                    <div class="uface"><img src="images/53f442834079a.jpg" width="40" height="40"  alt=""/></div>
                    <div class="item_right">
                        <div class="msg">(Visual) FoxPro, 4th Dimension/4D, Alice, APL, Arc, Automator, Awk, Bash, bc, Bourne shell, C++CLI, CFML, cg, CL (OS/400), Clean, Clojure, Emacs Lisp, Factor, Forth, Hack, Icon, Inform, Io, Ioke, J, JScript.NET, LabVIEW, LiveCode, M4, Magic, Max/MSP, Modula-2, Moto, NATURAL, OCaml, OpenCL, Oz, PILOT, Programming Without Coding Technology, Prolog, Pure Data, Q, RPG (OS/400), S, Smalltalk, SPARK, Standard ML, TOM, VBScript, Z shell</div>
                        <div class="name_time">白猫 · 1分钟前</div>
                    </div>
                </div>

                <div class="msg_item fn-clear">
                    <div class="uface"><img src="images/hetu.jpg" width="40" height="40"  alt=""/></div>
                    <div class="item_right">
                        <div class="msg own">那个统计表也不能说明一切</div>
                        <div class="name_time">河图 · 30秒前</div>
                    </div>
                </div>
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
            <ul class="user_list" title="双击用户私聊">
                <li class="fn-clear selected"><em>所有用户</em></li>

                <c:forEach items="${chat_users}" var="chat_user" varStatus="index_object">
                    <li class="fn-clear" data-id="${index_object.index+1}"><span><img src="images/hetu.jpg" width="30" height="30"  alt=""/></span><em>${chat_user.nickName}</em><small class="online" title="在线"></small></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<button onclick="connect();">连接</button>

</body>
</html>
