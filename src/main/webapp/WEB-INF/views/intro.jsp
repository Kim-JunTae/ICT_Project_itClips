<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Intro</title>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="resources/css/main.css"/>
	</head>
	<body class="is-preload">
		<div id="wrapper">
			<div id="bg"></div>
			<div id="overlay"></div>
			<div id="main">

				<!-- Header -->
				<header id="header">
					<h1><a href="#">itClips</a></h1>
					<p>Movie Platform &nbsp;&bull;&nbsp; ICT_TEAM 1 &nbsp;&bull;&nbsp; KimJunTae, JungHyunJin</p>
					<nav>
						<ul>
							<li><a href="#" class="icon solid fa-icons"><span class="label">Creator</span></a></li>
							<li><a href="userHome" class="icon solid fa-video"><span class="label">User</span></a></li>
						</ul>
					</nav>
				</header>

				<!-- Footer -->
				<footer id="footer">
					<span class="copyright">&copy; itClips. 2020.08 <a href="#">Go Admin Page</a></span>
					<a href="https://github.com/Kim-JunTae/ICT_Project_itClips" class="icon brands fa-github"><span class="label">Github</span></a>
				</footer>

			</div>
		</div>
		<script>
			window.onload = function() { document.body.classList.remove('is-preload'); }
			window.ontouchmove = function() { return false; }
			window.onorientationchange = function() { document.body.scrollTop = 0; }
		</script>
	</body>
</html>