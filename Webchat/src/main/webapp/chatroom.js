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
       		  		msgToDisplay.innerHTML='<div class="message-item"><div class="message-avatar"><figure class="avatar"><img src="/Webchat/dist/media/img/avator.jpg" class="rounded-circle" alt="image"></figure><div><h5>'+toname+'</h5><div class="time">'+time.toLocaleString()+'<i class="ti-double-check text-info"></i></div></div></div><div class="message-content">'+content+'</div></div>';
//            	 	var msgToDisplay = document.createElement('p');
//            	 	msgToDisplay.innerHTML='<span>'+time.toLocaleString()+'</span></br>[' + fromname + "] : " + content;
            	 	container.append(msgToDisplay);
            	 }
             if($("#myid").val()==toid)
            	 {
            	 	//消息提醒
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
  	 	  var container=$(".messages");
  	 	  var msgToDisplay=document.createElement('dev');
  	 	  msgToDisplay.innerHTML='<div class="message-item"><div class="message-avatar"><figure class="avatar"><img src="/Webchat/dist/media/img/avator.jpg" class="rounded-circle" alt="image"></figure><div><h5>'+myname.value+'</h5><div class="time">'+time.toLocaleString()+'<i class="ti-double-check text-info"></i></div></div></div><div class="message-content">'+message.value+'</div></div>'
//	  	  msgToDisplay.innerHTML='<div class="message-item outgoing-message"><div class="message-avatar"><figure class="avatar"><img src="/Webchat/dist/media/img/avator.jpg" class="rounded-circle" alt="image"></figure><div><h5>'+myname.value+'</h5><div class="time">'+time.toLocaleString()+'<i class="ti-double-check text-info"></i></div></div></div><div class="message-content">'+message.value+'</div></div>';
//  	 	  var msgToDisplay=document.createElement('p');
//  	 	  msgToDisplay.innerHTML='<span>'+time.toLocaleString()+'</span></br>[' + myname.value + "] : " + message.value;
  	 	  container.append(msgToDisplay);
  	 	  $("#MSG").trigger("create"); 
  	 	  $("#usermessage").val("");
	 } 
}

var chats = {
		  chat: document.querySelectorAll('li.list-group-item'),
		  };

chats.chat.forEach(function (f) {
	  f.addEventListener('mousedown', function () {
//		  		var msg= $(".messages");
		  		var msg=document.getElementById("MSG");
		  		msg.innerHTML="";
		  		var toname=document.getElementById("");
		   		var id=f.id;
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