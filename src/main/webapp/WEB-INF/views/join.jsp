<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE HTML>
<html>
<head>
	<title>회원가입</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="resources/assets/css/main.css" />
	<style>
		.blue_txt{color:#00f; font-weight: bold;}
		.red_txt{color:#f00; font-weight: bold;}
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
					<h2><a href="userHome" class="logo">itClips</a>&nbsp;&nbsp;회원가입</h2>
				</header>

				<!-- Content -->
				<section>
					<form method="post" action="#">
						<div class="row gtr-uniform">
						<!-- 아이디 -->
							<div class="col-2 col-12-small">
								<label for="id">아이디</label>
							</div>
							<div class="col-5 col-12-small">
								<input type="text" name="id" id="id" value="" placeholder="id" />
							</div>
							<div class="col-5 col-12-small">
								<p>아이디는 영문, 숫자 조합하여 4~20자 입력가능<br>
								(대소문자 구별, 한글/특수문자 사용불가)</p>
							</div>
							<!-- 아이디 중복 Ajax -->
							<div class="col-2"></div>
							<div class="col-10">
								<span id="idCheckMsg"></span>
								<input type="hidden" id="chk_id">
							</div>
						<!-- 비밀번호 -->
							<div class="col-2 col-12-small">
								<label for="pw">비밀번호</label>
							</div>
							<div class="col-5 col-12-small">
								<input type="password" name="pw" id="pw" placeholder="pw" />
							</div>
							<div class="col-5 col-12-small">
								<input type="password" name="pw_check" id="pw_check" placeholder="pw_check" />
							</div>
							<!-- 비밀번호 체크 javascript -->
							<div class="col-12">
								<span id="pwCheckMsg"></span>
							</div>
						<!-- 닉네임 -->
							<div class="col-2 col-12-small">
								<label for="id">닉네임</label>
							</div>
							<div class="col-5 col-12-small">
								<input type="text" name="nickname" id="nickname" placeholder="nickname" />
							</div>
							<div class="col-5 col-12-small">
								닉네임은 한글 최대 10글자, 영문 최대 20자 이내로 입력해 주세요.
							</div>
						<!-- 이메일 -->
							<div class="col-2 col-12-small">
								<label for="email">이메일</label>
							</div>
							<div class="col-5 col-12-small">
								<input type="text" name="email" id="email" placeholder="email"/>
							</div>
							<!-- 이메일 체크 javascript, 정규표현식 -->
							<div class="col-12">
								<span id="emailCheckMsg"></span>
							</div>
						<!-- 생년월일 -->
							<div class="col-2 col-12-small">
								<label for="birthday">생년월일</label>
							</div>
							<div class="col-5 col-12-small">
								<input type="text" name="birthday" id="birthday" placeholder="birthday"/>
							</div>
							<!-- 생년월일 체크 javascript, 정규표현식 -->
							<div class="col-12">
								<span id="birthdayCheckMsg"></span>
							</div>
						<!-- 성별 -->
							<div class="col-2 col-12-small">
								<label for="gender">성별</label>
							</div>
							<div class="col-2 col-12-small">
								<input type="radio" id="male" name="gender" checked>
								<label for="male">남성</label>
							</div>
							<div class="col-2 col-12-small">
								<input type="radio" id="female" name="gender">
								<label for="female">여성</label>
							</div>
							
							<div class="col-12"></div>
							
						<!-- 취향 선택 -->
							<!-- 취향 테이블에서 가져와서 뿌려주기 : 
							CategoryTable, CategoryVO, CategoryDAO, category.xml -->
							<div class="box col-12">
								<c:if test="${!empty clist}">
									<c:forEach items="${clist}" var="c">
										<span class="col-2">
											<input type="checkbox" id="${c.getCategory_high()}" value="${c.getCategory_high()}">
											<label for="${c.getCategory_high()}">${c.getCategory_high()}</label>
										</span>
									</c:forEach>
								</c:if>
							</div>
							
							
						<!-- 이용약관 체크 -->
							
						<!-- 설명 -->
							<div class="box col-12">
								<p>
									- 비회원도 itClips 영상들을 보실 수 있습니다.<br>
									- 자신의 동영상을 올리고 싶다면 크리에이터로 가입하세요.
								</p>
							</div>
							
							<!-- 다음 단계로 -->
							<div class="col-12">
								<ul class="actions">
									<li><input type="button" value="크리에이터로 가입" class="primary" /></li>
									<li><input type="button" value="사용자로 가입" class="primary" /></li>
									<li><input type="button" value="취소" /></li>
								</ul>
							</div>
							
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script src="resources/assets/js/jquery.min.js"></script>
	<script src="resources/assets/js/browser.min.js"></script>
	<script src="resources/assets/js/breakpoints.min.js"></script>
	<script src="resources/assets/js/util.js"></script>
	<script src="resources/assets/js/main.js"></script>
	<script>
		/* //취향 리스트 가져오기
		$(document).ready(function(){
			$.ajax({
				url: "getCategoryList",
				type: "POST",
				dataType: "JSON"
				
			}).done(function(data){
				$("#categoryList").html(data.categoryList);
			}).fail(function(err){
				console.log(err);
			}); 
		}); */

		$(function(){
			//아이디가 id인 요소에서 입력된 문자가 4자 이상 입력 시
			//서버에 비동기식 호출을 수행한다.
			$("#id").bind("keyup", function(){
				//id에 입력된 자원 가져오기
				//var id = $("#s_id").val();
				var id = $(this).val();
				
				//글자 수에 따른 if문
				if(id.length >= 4){
					//비동기식 통신을 수행
					if(id.length > 20){
						alert("아이디는 영문, 숫자 조합하여 4~20자 입력가능합니다.");
					}
					$.ajax({
						url: "checkId",
						type: "POST",
						data: "id="+encodeURIComponent(id),
						dataType: "JSON"
						
					}).done(function(data){
						$("#idCheckMsg").html(data.res);
						$("#chk_id").val(data.chk);
					}).fail(function(err){
						console.log(err);
					});
				}else{
					//아이디가 msg인 요소의 내용을 지워야한다.(초기화한다)
					$("#idCheckMsg").html("");
				}
			});
		});
	</script>
	</body>
</html>