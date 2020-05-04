<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Slek - Chat and Discussion Platform</title>
    <!-- Favicon -->
    <link rel="icon" href="/Webchat/dist/media/img/favicon.png" type="image/png">
    <!-- Bundle Styles -->
    <link rel="stylesheet" href="/Webchat/vendor/bundle.css">
    <link rel="stylesheet" href="/Webchat/vendor/enjoyhint/enjoyhint.css">
    <!-- App styles -->
    <link rel="stylesheet" href="/Webchat/dist/css/app.min.css">
</head>
<body>

<!-- page loading -->
<div class="page-loading"></div>
<!-- ./ page loading -->


<!-- add friends modal -->
<div class="modal fade" id="addFriends" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-zoom" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <i data-feather="user-plus" class="mr-2"></i> Add Friends
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="ti-close"></i>
                </button>
            </div>
            <div class="modal-body">
                <div class="alert alert-info">Send invitations to friends.</div>
                <form>
                    <div class="form-group">
                        <label for="emails" class="col-form-label">Email addresses</label>
                        <input type="email" class="form-control" id="emails">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="invite">Submit</button>
            </div>
        </div>
    </div>
</div>
<!-- ./ add friends modal -->



<!-- layout -->
<div class="layout">

    <!-- navigation -->
    <nav class="navigation">
        <div class="nav-group">
            <ul>
                <li class="logo">
                    <a href="#">
                        <svg version="1.1" xmlns="http://www.w3.org/2000/svg"
                             xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                             width="612px" height="612px" viewBox="0 0 612 612"
                             style="enable-background:new 0 0 612 612;" xml:space="preserve">
                            <g>
                                <g id="_x32__26_">
                                    <g>
                                    <path d="M401.625,325.125h-191.25c-10.557,0-19.125,8.568-19.125,19.125s8.568,19.125,19.125,19.125h191.25
                                    c10.557,0,19.125-8.568,19.125-19.125S412.182,325.125,401.625,325.125z M439.875,210.375h-267.75
                                    c-10.557,0-19.125,8.568-19.125,19.125s8.568,19.125,19.125,19.125h267.75c10.557,0,19.125-8.568,19.125-19.125
                                    S450.432,210.375,439.875,210.375z M306,0C137.012,0,0,119.875,0,267.75c0,84.514,44.848,159.751,114.75,208.826V612
                                    l134.047-81.339c18.552,3.061,37.638,4.839,57.203,4.839c169.008,0,306-119.875,306-267.75C612,119.875,475.008,0,306,0z
                                    M306,497.25c-22.338,0-43.911-2.601-64.643-7.019l-90.041,54.123l1.205-88.701C83.5,414.133,38.25,345.513,38.25,267.75
                                    c0-126.741,119.875-229.5,267.75-229.5c147.875,0,267.75,102.759,267.75,229.5S453.875,497.25,306,497.25z"/>
                                    </g>
                                </g>
                            </g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                        </svg>
                    </a>
                </li>
                <li>
                    <a class="active" data-navigation-target="chats" href="#" data-toggle="tooltip" title="Chats"
                       data-placement="right">
                        <span class="badge badge-warning"></span>
                        <i data-feather="message-circle"></i>
                    </a>
                </li>
                <li>
                    <a data-navigation-target="friends" href="#" data-toggle="tooltip"
                       title="Friends" data-placement="right">
                        <span class="badge badge-danger"></span>
                        <i data-feather="user"></i>
                    </a>
                </li>

                <li>
                    <a href="#" class="dark-light-switcher" data-toggle="tooltip" title="Dark mode"
                       data-placement="right">
                        <i data-feather="moon"></i>
                    </a>
                </li>
                <li data-toggle="tooltip" title="User menu" data-placement="right">
                    <a href="./loginpage" data-toggle="dropdown">
                        <figure class="avatar">
                            <img src="/Webchat/dist/media/img/avator.jpg" class="rounded-circle" alt="image">
                        </figure>
                    </a>
                    <div class="dropdown-menu">
                        <a href="./loginpage" class="dropdown-item text-danger">Logout</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <!-- ./ navigation -->

    <!-- content -->
    <div class="content">

        <!-- sidebar group -->
        <div class="sidebar-group">

            <!-- Chats sidebar -->
            <div id="chats" class="sidebar active">
                <header>
                    <span>Chats</span>
                    <ul class="list-inline">
                        <li class="list-inline-item">
                            <a class="btn btn-outline-light" data-toggle="tooltip" title="New chat" href="#"
                               data-navigation-target="friends">
                                <i data-feather="plus-circle"></i>
                            </a>
                        </li>
                        <li class="list-inline-item d-xl-none d-inline">
                            <a href="#" class="btn btn-outline-light text-danger sidebar-close">
                                <i data-feather="x"></i>
                            </a>
                        </li>
                    </ul>
                </header>
                <form>
                    <input type="text" class="form-control" placeholder="Search chats">
                </form>
                <div class="sidebar-body">
                    <ul class="list-group list-group-flush">
						<c:forEach items="${friendslist}" var="f">
                        <li class="list-group-item">
							<figure class="avatar avatar-state-success">
							    <img src="/Webchat/dist/media/img/avator.jpg" class="rounded-circle" alt="image">
							</figure>
                            <div class="users-list-body">
                                <div>
                                    <h5 class="text-primary">${f}</h5>
                                    <p> </p>
                                </div>
                                <div class="users-list-action">
                                    <small class="text-primary"> </small>
                                </div>
                            </div>
                        </li>
						</c:forEach>
                    </ul>
                </div>
            </div>
            <!-- ./ Chats sidebar -->

            <!-- Friends sidebar -->
            <div id="friends" class="sidebar">
                <header>
                    <span>Friends</span>
                    <ul class="list-inline">
                        <li class="list-inline-item" data-toggle="tooltip" title="Add friends">
                            <a class="btn btn-outline-light" href="#" data-toggle="modal" data-target="#addFriends">
                                <i data-feather="user-plus"></i>
                            </a>
                        </li>
                        <li class="list-inline-item d-xl-none d-inline">
                            <a href="#" class="btn btn-outline-light text-danger sidebar-close">
                                <i data-feather="x"></i>
                            </a>
                        </li>
                    </ul>
                </header>
                <form>
                    <input type="text" class="form-control" placeholder="Search friends">
                </form>
                <div class="sidebar-body">
                    <ul class="list-group list-group-flush">
						<c:forEach items="${friendslist}" var="f">
                        <li class="list-group-item" data-navigation-target="chats">
                            <div>
                                <figure class="avatar">
                                    <img src="/Webchat/dist/media/img/avator.jpg" class="rounded-circle" alt="image">
                                </figure>
                            </div>
                            <div class="users-list-body">
                                <div>
                                    <h5>${f}</h5>
                                    <p> </p>
                                </div>
                                <div class="users-list-action">
                                    <div class="action-toggle">
                                        <div class="dropdown">
                                            <a data-toggle="dropdown" href="#">
                                                <i data-feather="more-horizontal"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">New chat</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
						</c:forEach>
                    </ul>
                </div>
            </div>
            <!-- ./ Friends sidebar -->

            

        </div>
        <!-- ./ sidebar group -->

        <!-- chat -->
        <div class="chat">

            <div class="chat-body"> <!-- .no-message -->
                <div class="messages">
					<c:forEach items="${messagelist}" var="m">
                    <div class="${m.messagetype}">
                        <div class="message-avatar">
                            <figure class="avatar">
                                <img src="/Webchat/dist/media/img/avator.jpg" class="rounded-circle" alt="image">
                            </figure>
                            <div>
                                <h5>${m.name}</h5>
                                <div class="time">${m.time} <i class="ti-double-check text-info"></i></div>
                            </div>
                        </div>
                        <div class="message-content">
                            ${m.message}
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
            <div class="chat-footer">
                <form>
                	<input type="hidden" id="myid" value="${id}"/>
                    <input type="text" class="form-control" id="usermessage" placeholder="Write a message.">
                    <div class="form-buttons">
                        <button class="btn btn-primary" type="button" id="send">
                            <i data-feather="send"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <!-- ./ chat -->

    </div>
    <!-- ./ content -->

</div>
<!-- ./ layout -->

<!-- Bundle -->
<script src="https://www.jq22.com/jquery/jquery-3.3.1.js"></script>
<script src="/Webchat/vendor/bundle.js"></script>
<script src="/Webchat/vendor/feather.min.js"></script>
<script src="/Webchat/vendor/enjoyhint/enjoyhint.min.js"></script>

<!-- App scripts -->
<script src="/Webchat/dist/js/app.min.js"></script>

<!-- Examples -->


<!--sockJS cdn-->
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<!--stomp cdn-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<script type="application/javascript">
	 $("#invite").click(function () {
						var femail=document.getElementById("emails").value;

			            $.ajax({
			                type: "POST",
			                url: "/Webchat/user/addfriend",
			                data: {
			                    FriendEmail: femail,
								
			                },
			                success: function (data) {
								if (data=="1")
									alert("添加成功");
								else if (data=="0")
									alert("添加失败");
								else if (data=="5")
									alert("用户名不存在，请重新输入");
								else if (data=="4")
									alert("请勿重复添加好友！")
									
			                }
			            });
			        });
			 
</script>
<script src="../chatroom.js"></script>
</body>
</html>