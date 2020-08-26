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
		<!-- owlCarousel 추가 -->
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<link rel="stylesheet" href="resources/owlcarousel/assets/owl.carousel.min.css">
		<link rel="stylesheet" href="resources/owlcarousel/assets/owl.theme.default.min.css">	
		<script src="resources/owlcarousel/owl.carousel.min.js"></script>

		<style>
			button {
				box-shadow: none;
			}
			
			#owl-demo .item{
	  			margin: 3px;
			}
			
			#owl-demo .item img{
			  display: block;
			  width: 20%;
			  height: auto;
			}
			
			.owl-carousel .owl-video-wrapper {
				height: 200px;
			}
			
		</style>
	</head>

	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="userHome" class="logo"><strong><span>itClips</span></strong></a>
									<!-- 로그인 닉네임 체크 -->
									<c:if test="${sessionScope.nickname ne null}">
										<span>${sessionScope.nickname}님 안녕하세요</span>
									</c:if>
							
									<!-- itClipsButton -->
									<!-- <section id="itClipsBtn" class="alt">
										<input type="button" value="itclips">
									</section> -->
									<!-- Search -->
									<section id="search" class="alt">
										<form method="post" action="#">
											<input type="text" name="query" id="query" placeholder="Search" />
										</form>
									</section>
								</header>
							
							<!-- Banner : Ajax -->
								<section>
									<header class="major">
										<h2>BoxOffice</h2>
									</header>
		
									<div id="boxOffice" class="carousel slide" data-ride="carousel" style="background-image:url('resources/images/pic01.jpg')">
									</div>
								</section>
								
							<!-- Section -->
								<section>
									<header class="major">
										<h2>YouTube</h2>
									</header>
								
									<div class="owl-carousel owl-theme">
									    <div class="item-video"><h4>1</h4><a class="owl-video" href="https://www.youtube.com/watch?v=Cc-zHL5nPD8"></a></div>
									    <div class="item-video"><h4>2</h4><a class="owl-video" href="https://www.youtube.com/watch?v=bxpdaG4wvWM"></a></div>
									    <div class="item-video"><h4>3</h4><a class="owl-video" href="https://www.youtube.com/watch?v=_r3X0d39Thk"></a></div>
									    <div class="item-video"><h4>4</h4><a class="owl-video" href="https://www.youtube.com/watch?v=ctZ2pgcavd0"></a></div>
									    <div class="item-video"><h4>5</h4><a class="owl-video" href="https://www.youtube.com/watch?v=tMqxWuFM0uk"></a></div>
									    <div class="item-video"><h4>6</h4><a class="owl-video" href="https://www.youtube.com/watch?v=RAcElO7MCTI"></a></div>
									    <div class="item-video"><h4>7</h4><a class="owl-video" href="https://www.youtube.com/watch?v=7r4CxOQvyPA"></a></div>
									    <div class="item-video"><h4>8</h4><a class="owl-video" href="https://www.youtube.com/watch?v=u15mJ9AiPqs"></a></div>
									    <div class="item-video"><h4>9</h4><a class="owl-video" href="https://www.youtube.com/watch?v=kk5mb5baMeQ"></a></div>
									    <div class="item-video"><h4>10</h4><a class="owl-video" href="https://www.youtube.com/watch?v=DCZ0locgYuM"></a></div>
									</div>
								</section>
							<!-- Section -->
								<section>
									<header class="major">
										<h2>Blog</h2>
									</header>
									<div class="posts">
										<article>
											<a href="#" class="image"><img src="resources/images/pic01.jpg" alt="" /></a>
											<h3>블로그1</h3>
											<p>블로그1에 대한 설명</p>
										</article>
										<article>
											<a href="#" class="image"><img src="resources/images/pic02.jpg" alt="" /></a>
											<h3>블로그2</h3>
											<p>블로그2에 대한 설명</p>
										</article>
										<article>
											<a href="#" class="image"><img src="resources/images/pic03.jpg" alt="" /></a>
											<h3>블로그3</h3>
											<p>블로그3에 대한 설명</p>
										</article>
										<article>
											<a href="#" class="image"><img src="resources/images/pic04.jpg" alt="" /></a>
											<h3>블로그4</h3>
											<p>블로그4에 대한 설명</p>
										</article>
										<article>
											<a href="#" class="image"><img src="resources/images/pic05.jpg" alt="" /></a>
											<h3>블로그5</h3>
											<p>블로그5에 대한 설명</p>
										</article>
										<article>
											<a href="#" class="image"><img src="resources/images/pic06.jpg" alt="" /></a>
											<h3>블로그6</h3>
											<p>블로그6에 대한 설명</p>
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
			<script src="resources/assets/js/browser.min.js"></script>
			<script src="resources/assets/js/breakpoints.min.js"></script>
			<script src="resources/assets/js/util.js"></script>
			<script src="resources/assets/js/main.js"></script>
			<!-- 
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
						 -->
			<script src="resources/js/sidebar.js"></script>
			
			<script>
			$(document).ready(function(){ 
				    // 로딩되기 시작할때
					$.ajax({
						url: "boxOfficeJSON",
						type: "GET",
						dataType: "JSON"
						
					}).done(function(data){
						//케러셀 시도
						var boxOfficeList = "<ol class='carousel-indicators'>";
						
						boxOfficeList += "<li data-target='#carouselExampleCaptions' data-slide-to='0' class='active'></li>";
						
						for(var i=1; i<data.length; i++){
							boxOfficeList += "<li data-target='#carouselExampleCaptions' data-slide-to='"+ i +"'></li>";
						}
					
						boxOfficeList += "</ol>";
						
						boxOfficeList += "<div class='carousel-inner'>";
						
						boxOfficeList += "<div class='carousel-item active'>";
						boxOfficeList += "<img src='" + data[0].src + "' alt='" + data[0].title +"의 포스터' style='max-width: 50%; height: auto;'/>";
						boxOfficeList += "<div class='carousel-caption d-none d-md-block'>";
						boxOfficeList += "<h5>"+data[0].title+"</h5></div></div>";
					
						for(var i=1; i<data.length; i++){
							boxOfficeList += "<div class='carousel-item'>";
							boxOfficeList += "<img src='" + data[i].src + "' alt='" + data[i].title +"의 포스터' style='max-width: 50%; height: auto;'/>";
							boxOfficeList += "<div class='carousel-caption d-none d-md-block'>";
							boxOfficeList += "<h5>"+data[i].title+"</h5></div></div>";
						}
						
						//버튼
						boxOfficeList += "<a class='carousel-control-prev' href='#carouselExampleCaptions' role='button' data-slide='prev'>";
						boxOfficeList += "<span class='carousel-control-prev-icon' aria-hidden='true'></span>";
						boxOfficeList += "<span class='sr-only'>Previous</span></a>";
						boxOfficeList += "<a class='carousel-control-next' href='#carouselExampleCaptions' role='button' data-slide='next'>";
						boxOfficeList += "<span class='carousel-control-next-icon' aria-hidden='true'></span>";
						boxOfficeList += "<span class='sr-only'>Next</span></a>";
						
						//<div class='carousel-inner'>을 닫아준다.
						boxOfficeList += "</div>"
						
						document.getElementById('boxOffice').innerHTML = boxOfficeList;
						
						//백업
						/* var boxOfficeList = "<div class='posts'>";
						
						for(var i = 0; i<data.length; i++){
							boxOfficeList += "<article><a href='" + data[i].movieId + "'>";
							boxOfficeList += "<img src='" + data[i].src + "' alt='" + data[i].title +"의 포스터' style='max-width: 50%; height: auto;'/></a>";
							boxOfficeList += "<p>" + data[i].title + "</p></article>";
						}
						
						boxOfficeList += "</div>";
						
						document.getElementById('boxOffice').innerHTML = boxOfficeList; */
						console.log(data);
					}).fail(function(err){
						console.log(err);
					});
				    
					$('.carousel').carousel();
					
					
				    
			});
			</script>
			<script>
				(function($) {$(document).ready(function(){
					var owl = $('.owl-carousel');
					owl.owlCarousel({
					    loop:true,
					    margin:10,
					    nav:true,
					    responsive:{
					        0:{
					            items:1
					        },
					        600:{
					            items:3
					        },
					        960:{
					            items:5
					        },
					        1200:{
					        	items:6
					        }
					    }
					});
					owl.on('mousewheel', '.owl-stage', function (e){
						if (e.deltaY>0) {
					        owl.trigger('next.owl');
					    } else {
					        owl.trigger('prev.owl');
					    }
					    e.preventDefault();
					});
				});
				})(jQuery);
			</script>
	</body>
</html>