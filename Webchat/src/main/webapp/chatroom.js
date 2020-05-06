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
             var time = new Date();
             
             if(($("#toid").val()==fromid)&&($("#myid").val()==toid))//对接收端进行检查
            	 {
            	 	var container=$(".messages");
            	 	var msgToDisplay=document.createElement('dev');
            	 	msgToDisplay.innerHTML='<div class="message-item"><div class="message-avatar"><figure class="avatar"><img src="/Webchat/dist/media/img/avator.jpg" class="rounded-circle" alt="image"></figure><div><h5>'+fromname+'</h5><div class="time">'+time.toLocaleString()+'<i class="ti-double-check text-info"></i></div></div></div><div class="message-content">'+content+'</div></div>'
            	 	container.append(msgToDisplay);
            	 }
             if($("#toid").val()=="99999"){
            	 	var container=$(".messages");
            	 	var msgToDisplay=document.createElement('dev');
            	 	msgToDisplay.innerHTML='<div class="message-item"><div class="message-avatar"><figure class="avatar"><img src="/Webchat/dist/media/img/avator.jpg" class="rounded-circle" alt="image"></figure><div><h5>'+fromname+'</h5><div class="time">'+time.toLocaleString()+'<i class="ti-double-check text-info"></i></div></div></div><div class="message-content">'+content+'</div></div>'
            	 	container.append(msgToDisplay);   	 
             }
		 })
	 });
}




function sendMessage()
{
	 var message = document.getElementById("usermessage");
	 var friendid = document.getElementById("toid");
	 var myid = document.getElementById("myid");
	 var myname=document.getElementById("myname");
	 var time = new Date();
	 var messageform = {'MessageContent':message.value,'Messageto':friendid.value,'Messagefrom':myid.value};
	 if(message.value!=''){
		 stompClient.send("/app/chat/message",{contentType:'application/json'},JSON.stringify(messageform));
		  if(friendid.value!="99999"){
			  var container=$(".messages");
			  var msgToDisplay=document.createElement('dev');
			  msgToDisplay.innerHTML='<div class="message-item"><div class="message-avatar"><figure class="avatar"><img src="/Webchat/dist/media/img/avator.jpg" class="rounded-circle" alt="image"></figure><div><h5>'+myname.value+'</h5><div class="time">'+time.toLocaleString()+'<i class="ti-double-check text-info"></i></div></div></div><div class="message-content">'+message.value+'</div></div>'
			  container.append(msgToDisplay);
		  }
		  $("#usermessage").val("");
		  
	 } 
}

var chats = {
		  chat: document.querySelectorAll('li.list-group-item'),
		  };

chats.chat.forEach(function (f) {
	  f.addEventListener('mousedown', function () {
		  		var msg=document.getElementById("MSG");		  		
		   		var id=f.id;
		   		msg.innerHTML='';
		   		$.ajax({
	                type: "POST",
	                url: "/Webchat/user/chatpage",
	                data: {
	                    ToID:id,
	                },
	                success: function (data) {
	                	$("#toid").val(id);
						alert("开始聊天!");
						$("#toid").val(id);
	                }
	            });
		  });
		});


$("body").keydown(function() {
    if (event.keyCode == "13") {
    	sendMessage();
    }
});
