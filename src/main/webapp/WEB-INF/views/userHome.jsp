<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE HTML>
<html>
	<head>
		<title>UserHome</title>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="resources/assets/css/main.css"/>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="userHome" class="logo"><strong><h2>itClips</h2></strong></a>
									<!-- itClipsButton -->
									<section id="itClipsBtn" class="alt">
										<input type="button" value="itclips">
									</section>
									<!-- Search -->
									<section id="search" class="alt">
										<form method="post" action="#">
											<input type="text" name="query" id="query" placeholder="Search" />
										</form>
									</section>
								</header>
							
							<!-- 로그인 닉네임 체크 -->
								<br>
								<c:if test="${sessionScope.nickname ne null}">
									<h4>${sessionScope.nickname}님 안녕하세요</h4>
								</c:if>
							
							<!-- Section -->
								<section>
									<header class="major">
										<h2>hotClips</h2>
									</header>
									<div class="posts">
										<article>
											<a href="#" class="image"><img src="resources/images/pic01.jpg" alt="" /></a>
											<h3>영상1</h3>
											<p>영상1에 대한 설명</p>
										</article>
										<article>
											<a href="#" class="image"><img src="resources/images/pic02.jpg" alt="" /></a>
											<h3>영상2</h3>
											<p>영상2에 대한 설명</p>
										</article>
										<article>
											<a href="#" class="image"><img src="resources/images/pic03.jpg" alt="" /></a>
											<h3>영상3</h3>
											<p>영상3에 대한 설명</p>
										</article>
										<article>
											<a href="#" class="image"><img src="resources/images/pic04.jpg" alt="" /></a>
											<h3>영상4</h3>
											<p>영상4에 대한 설명</p>
										</article>
										<article>
											<a href="#" class="image"><img src="resources/images/pic05.jpg" alt="" /></a>
											<h3>영상5</h3>
											<p>영상5에 대한 설명</p>
										</article>
										<article>
											<a href="#" class="image"><img src="resources/images/pic06.jpg" alt="" /></a>
											<h3>영상6</h3>
											<p>영상6에 대한 설명</p>
										</article>
									</div>
								</section>
								
								<!-- Section -->
								<section>
									<header class="major">
										<h2>Category</h2>
									</header>
									<div class="features">
										<article>
											<span class="icon fa-gem"></span>
											<div class="content">
												<h3>카테고리1</h3>
											</div>
										</article>
										<article>
											<span class="icon solid fa-paper-plane"></span>
											<div class="content">
												<h3>카테고리2</h3>
											</div>
										</article>
										<article>
											<span class="icon solid fa-rocket"></span>
											<div class="content">
												<h3>카테고리3</h3>
											</div>
										</article>
										<article>
											<span class="icon solid fa-signal"></span>
											<div class="content">
												<h3>카테고리4</h3>
											</div>
										</article>
									</div>
								</section>
						</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">

							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Quick Menu</h2>
									</header>
									<ul>
										<li><a href="" class="icon solid fa-home">&nbsp;&nbsp;Home</a></li>
										<li>
											<c:choose>
												<c:when test="${sessionScope.nickname eq null}">
													<a href="javascript:modal(0)" class="icon solid fa-sign-in-alt" data-toggle="modal" data-target="#loginModal">&nbsp;&nbsp;Login</a>
												</c:when>
												<c:when test="${sessionScope.nickname ne null}">
													<a href="logout" class="icon solid fa-sign-out-alt">&nbsp;&nbsp;Logout</a>
												</c:when>
											</c:choose>
										</li>
										<li><a href="myPage" class="icon solid fa-user-cog">&nbsp;&nbsp;MyPage</a></li>
										<li><a href="javascript:modal(1)" class="icon solid fa-bell" data-toggle="modal" data-target="#alertModal">&nbsp;&nbsp;Alert</a></li>
										<li><a href="javascript:modal(2)" class="icon solid fa-share-alt" data-toggle="modal" data-target="#shareModal">&nbsp;&nbsp;Share</a></li>
										<li><a href="support" class="icon solid fa-question-circle">&nbsp;&nbsp;Support</a></li>
									</ul>
								</nav>

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; itClips. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
								</footer>
						</div>
					</div>
			</div>

			<!-- Modal -->
			<!-- loginModal -->
			<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">Login</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="height: auto; box-shadow: inset 0 0 0 0px;">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      	<form id="login_form">
						<div class="form-group">
						    <label for="userId">ID</label>
						    <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요">
					  	</div>
					  	
					  	<div class="form-group">
						    <label for="userPw">PW</label>
						    <input type="password" class="form-control" id="pw" name="pw" placeholder="패스워드를 입력하세요">
					  	</div>
					  	
					  	<div class="form-group form-check">
						    <input type="checkbox" class="form-check-input" id="rememberIdCheck">
						    <label class="form-check-label" for="rememberIdCheck">Remember id</label>
					  	</div>
					  	
					  	<div id="result">로그인 실패 시 출력 영역</div>
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="button" data-dismiss="modal" onclick="goJoinPage()">Join</button>
			        <button type="button" class="button" data-dismiss="modal">아이디/비밀번호 찾기</button>
			        <button type="button" class="button primary" id="loginBtn">Login</button>
			      </div>
			    </div>
			  </div>
			</div>		

			<!-- alertModal -->
			<div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-labelledby="alertModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">알림메시지</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="height: auto; box-shadow: inset 0 0 0 0px;">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      	<!--문의 결과-->
					<article>
						문의결과입니다.
					</article>
					
					<!--신고 결과-->
					<article>
						신고결과입니다.
					</article>
					
					<!--새로운 공지-->
					<article>
						공지사항입니다.
					</article>
			      </div>
			    </div>
			  </div>
			</div>

			<!-- ShareModal2 -->
			<div class="modal fade" id="shareModal" tabindex="-1" role="dialog" aria-labelledby="shareModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">공유</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="height: auto; box-shadow: inset 0 0 0 0px;">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
					<div class="input-group mb-3">
					  <input type="text" class="form-control" value="http://localhost:8080/itClips/userHome">
					  <div class="input-group-append">
					    <button class="button" type="button" id="button-addon2">복사</button>
					  </div>
					</div>
			      </div>
			    </div>
			  </div>
			</div>
						
			<!-- Scripts -->
			<script src="resources/assets/js/jquery.min.js"></script>
			<script src="resources/assets/js/browser.min.js"></script>
			<script src="resources/assets/js/breakpoints.min.js"></script>
			<script src="resources/assets/js/util.js"></script>
			<script src="resources/assets/js/main.js"></script>
			
			<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
			
			<script src="resources/js/sidebar.js"></script>

	</body>
</html>