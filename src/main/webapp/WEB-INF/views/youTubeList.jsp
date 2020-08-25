<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouTube 목록</title>
<style>
	table {
		width: 900px;
	}
	
	table th, table>tbody>tr>td {
		border : 1px solid black;
		padding: 4px;
		text-align: center;
	}
	
	table caption {
		text-indent: -9999px;
	}
	
	table thead>tr:first-child>th{
		border: 0px;
	}
	
	#add_win{
		width: 300px;
		border: 1px solid black;
		background-color : #ffffff;
		position: absolute;
		top: 40px;
		left:120px;
		padding: 10px;
		display:none;
	}
	
	#add_win input[type=text]{
		width: 90px;
		padding: 3px;
		margin-bottom: 5px;
	}
	
	#detail{
		display: none;
	}
	
	#f_img{
		width: 300px;
		height: 200px;
	}
</style>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>
<body>
	<header>
		<h1>YouTube 목록</h1>
	</header>
	<hr>
	<article>
		<table>
			<caption>Youtube 목록 테이블</caption>
			<thead>
				<tr>
					<th>thumbnail</th>
					<th>title</th>
					<th>description</th>
					<th>publishedAt</th>
					<th>channelId</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${videoList ne null}">
				<c:forEach items="${videoList}" var="video" varStatus="st">
				<tr>
					<th><img src="${video.thumbnail}"></th>
					<th>${video.title}</th>
					<th>${video.description}</th>
					<th>${video.publishedAt}</th>	
					<th><iframe src="http://www.youtube.com/watch?v=${video.channelId}"></iframe></th>	
				</tr>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
	</article>

<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


</body>
</html>