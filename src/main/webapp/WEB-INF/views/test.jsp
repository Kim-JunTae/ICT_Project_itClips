<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script> 
	$(document).ready(function() { 

		
		$.getJSON("boxofficeJSON", function(data) {
			
			console.log(data.boxOfficeResult);
			
			var list = data.boxOfficeResult.dailyBoxOfficeList;
			
			console.log(list);
			
			
			
		});
	}); 
</script>

</head>
<body>

<h1>result : ${result.name}</h1>
<h1>name : ${name}</h1>
</body>
</html>