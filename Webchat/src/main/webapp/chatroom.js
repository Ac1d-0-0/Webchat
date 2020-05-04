var socket = new SockJS("/Webchat/websocket");
var stompClient = Stomp.over(socket);
$(function () {
    connect();
    $("#send").click(function(){
    	sendMessage();
    });
})

function connect()
{
	 stompClient.connect();
}

function sendMessage()
{
	 var message = document.getElementById("usermessage");
	 var friendid = 111;
	 var messageform = {'MessageContent':message.value,'Messageto':friendid};
	 stompClient.send("/app/chat/message",{contentType:'application/json'},JSON.stringify(messageform));
}