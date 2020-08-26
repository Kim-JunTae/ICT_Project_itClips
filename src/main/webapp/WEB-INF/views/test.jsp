<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>owlCarousel Test</title>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="resources/owlcarousel/assets/owl.carousel.min.css">
<link rel="stylesheet" href="resources/owlcarousel/assets/owl.theme.default.min.css">	
<script src="resources/owlcarousel/owl.carousel.min.js"></script>


<script>
$(document).ready(function(){
	$('.owl-carousel').owlCarousel({
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
	        1000:{
	            items:5
	        }
	    }
	});
});

</script>
</head>
<body>
	<div class="owl-carousel owl-theme">
	    <div class="item"><h4>1</h4></div>
	    <div class="item"><h4>2</h4></div>
	    <div class="item"><h4>3</h4></div>
	    <div class="item"><h4>4</h4></div>
	    <div class="item"><h4>5</h4></div>
	    <div class="item"><h4>6</h4></div>
	    <div class="item"><h4>7</h4></div>
	    <div class="item"><h4>8</h4></div>
	    <div class="item"><h4>9</h4></div>
	    <div class="item"><h4>10</h4></div>
	    <div class="item"><h4>11</h4></div>
	    <div class="item"><h4>12</h4></div>
	</div>
</body>
</html>