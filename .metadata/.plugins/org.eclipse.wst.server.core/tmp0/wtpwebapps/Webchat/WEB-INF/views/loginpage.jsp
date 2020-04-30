<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Webchat</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link href="favicon.ico" rel="shortcut icon" />
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style=" background: url(https://cdn.jsdelivr.net/gh/Ac1d-0-0/blog_img/static_files/img/index.png) no-repeat center center fixed; background-size: 100%;">

 
 
    <div class="modal-dialog" style="margin-top: 10%;">
        <div class="modal-content">
            <div class="modal-header">
 
                <h4 class="modal-title text-center" id="myModalLabel">登录</h4>
            </div>
            <form method="post" action="/Webchat/user/login" enctype="application/x-www-form-urlencoded">
            <div class="modal-body" id = "model-body">
            
                <div class="form-group">
 					
                    <input id="id" type="text" required="required" name="UserID" class="form-control"placeholder="用户名" autocomplete="off">
                </div>
                <div class="form-group">
 
                    <input id="pass" type="password" required="required" name="Password" class="form-control" placeholder="密码" autocomplete="off">
                </div>
            
            </div>
            <div class="modal-footer">
                <div class="form-group">
                    <button id="login" type="button" class="btn btn-primary form-control">登录</button>
                </div>
                <div class="form-group">
                    <button id = "register" type="button" class="btn btn-default form-control">注册</button>
                </div>
 
            </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
	
	<script type="text/javascript">
		 $("#login").click(function () {
					var id=document.getElementById("id");
					var pass=document.getElementById("pass");
					alert("hello");
		            $.ajax({
		                type: "POST",
		                url: "/Webchat/user/login",
		                data: {
		                    UserID: id,
		                    pass: pass,
		                },
		                success: function (data) {
		                    if (data == "false") {
		                        alert("用户名或密码错误");
		                    }
		                }
		            });
		        });
		$("#register").click(function () {
							var id=document.getElementById("id");
							var pass=document.getElementById("pass");
							alert("hi");
		           $.ajax({
		               type: "POST",
		               url: "/Webchat/user/register",
		               data: {
		                   UserID: id,
		                   pass: pass,
		               },
		               success: function (data) {
		                   if (data == "false") {
		                       alert("注册失败，请重试");
		                   }
		               }
		           });
		       });	

	</script>
	
</body>
</html>