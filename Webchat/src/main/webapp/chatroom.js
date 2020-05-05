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
			 var fromid = json.messagefrom;
			 var toid = json.messageto;
			 var fromname = json.fromName;
			 var toname = json.toName;
             var time = new Date(json.sendTime);
             if(($("#toid").val()==fromid)&&($("#myid").val()==toid))//对接收端进行检查
            	 {
            	 	alert("message");
            	 }
		 })
	 });
}

function sendMessage()
{
	 var message = document.getElementById("usermessage");
	 var friendid = document.getElementById("toid");
	 var myid = document.getElementById("myid");
	 var messageform = {'MessageContent':message.value,'Messageto':friendid.value,'Messagefrom':myid.value};
	 stompClient.send("/app/chat/message",{contentType:'application/json'},JSON.stringify(messageform));
}

var chats = {
		  chat: document.querySelectorAll('li.list-group-item'),
		  };

chats.chat.forEach(function (f) {
	  f.addEventListener('mousedown', function () {
		   		var id=f.id;
		   		$.ajax({
	                type: "POST",
	                url: "/Webchat/user/chatpage",
	                data: {
	                    ToID:id,
	                },
	                success: function (data) {
						alert("开始聊天");
						$("#toid").val(id);
	                }
	            });
		  });
		});