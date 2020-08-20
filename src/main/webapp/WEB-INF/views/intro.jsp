<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="UTF-8">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Intro</title>

	<!-- Bootstrap core CSS -->
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/cover.css" rel="stylesheet">
    <style>
		.bd-placeholder-img {
		  font-size: 1.125rem;
		  text-anchor: middle;
		  -webkit-user-select: none;
		  -moz-user-select: none;
		  -ms-user-select: none;
		  user-select: none;
		}
		
		@media (min-width: 768px) {
		  .bd-placeholder-img-lg {
		    font-size: 3.5rem;
		  }
		}
		   
		#left{
			text-align: center;
			width: 50%;
			height: 100%;
			float: left;
		}
		
		#right{
			text-align: center;
			width: 50%;
			height: 100%;
			float: right;
		}
    </style>
  </head>
  <body class="text-center">
    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">itClips</h3>
    </div>
  </header>

  <main role="main" class="inner cover">
  	<div id="left">
  		<a href="creatorHome">
	  		<h1 class="cover-heading">Creator</h1>
		    <p class="lead">Creator 설명</p>
		    <p class="lead">
		      <a href="#" class="btn btn-lg btn-secondary">Go Creator Home</a>
		    </p>
  		</a>
  	</div>
	
	<div id="right">
		<a href="userHome">
			<h1 class="cover-heading">User</h1>
		    <p class="lead">User 설명</p>
		    <p class="lead">
		      <a href="userHome" class="btn btn-lg btn-secondary">Go User Home</a>
		    </p>
		</a>
	</div>
  </main>

  <footer class="mastfoot mt-auto">
    <div class="inner">
      <p>itClips. 2020.08 <a href="#">Go Admin Page</a>, by <a href="#">Go Github</a>.</p>
    </div>
  </footer>
</div>
</body>
</html>
