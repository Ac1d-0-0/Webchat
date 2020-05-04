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
	 stompClient.connect({},function(frame){
		 stompClient.subscribe("/topic/chat/message",function(message){
			 var json = JSON.parse(message.body);
			 var content = json.messageContent;
			 var from = json.messagefrom;
			 var to = json.messageto;
			 var time = json.sendTime;
		 })
	 });
}

function sendMessage()
{
	 var message = document.getElementById("usermessage");
	 var friendid = 111;
	 var myid = document.getElementById("myid");
	 var messageform = {'MessageContent':message.value,'Messageto':friendid,'Messagefrom':myid.value};
	 stompClient.send("/app/chat/message",{contentType:'application/json'},JSON.stringify(messageform));
}