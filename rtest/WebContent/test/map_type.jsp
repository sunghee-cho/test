<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서울왕오빠픽</title>

<!-- <link rel="stylesheet" href="/mvc/codingBooster/css/bootstrap.css">
<link rel="stylesheet" href="/mvc/codingBooster/css/codingBooster.css">
<link rel="shortcut icon" href="/mvc/codingBooster/images/favicon.ico">
<link rel="icon" href="/mvc/codingBooster/images/favicon.ico">
 -->
<style>
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: underline;}
 
 .contents-main {
	position: relative;
	padding: 30px;
	width: 100%;
	background-color: #ffffff;
	box-sizing: border-box;
}
</style>

</head>
<body>
		<div class="sidenav">
			<nav id="nav-floating" style="position: fixed;">
				<h3>업종</h3>
				<ul>
					<a href="#" onclick="getImage(1);">
						<li><p>베이커리</p></li>
					</a>
					<a href="#" onclick="getImage(2);">
						<li><p>편의점</p></li>
					</a>
					<a href="#" onclick="getImage(3);">
						<li><p>패스트푸드</p></li>
					</a>
					<a href="#" onclick="getImage(4);">
						<li><p>카페</p></li>
					</a>
				</ul>
			</nav>
		</div>
		<div class="contents-main" id="image_main">aaaa</div>
	</div>
		<footer style="background-color: #292823; color: #ffffff">
		<div class="container" id="container">
			<br>
			<div class="row">
				<div class="col-sm-2" style="text-align: left;">
					<h5>Copyright &copy; 2019.</h5>
					<h5>서울왕오빠들.</h5>
					<h5>All rights reserved.</h5>
				</div>
				<div class="col-sm-4">
					<h4>소개란</h4>
					<p>
						서울<b>왕</b>오빠<b>픽</b>
					</p>
					<p></p>
				</div>
				<div class="col-sm-2">
					<h4 style="text-align: center;">내비게이션</h4>
					<div class="list-group">
						<a href="#" class="list-group-item">소개</a>
						<a href="#" class="list-group-item">테스트</a> 
						<a href="#" class="list-group-item">코딩</a>
					</div>
				</div>
				<div class="col-sm-2">
					<h4 style="text-align: center">사이트</h4>
					<div class="list-group">
						<a href="#" class=" list-group-item">사이트</a> 
						<a href="#" class="list-group-item">사이트</a> 
						<a href="#" class="list-group-item">사이트</a>
					</div>
				</div>
				<div class="col-sm-2">
					<h4 style="text-align: center;">
						by 멀티캠퍼스
					</h4>
				</div>
			</div>
		</div>
	</footer>
	<script>
		function getImage(menu_num){
			if (window.XMLHttpRequest) {
				var xmlhttp = new XMLHttpRequest();
			} else { 
				var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.open("GET", "map_type_img.jsp?menu_num="+ menu_num, true);
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					alert(xmlhttp.responseText);
					document.getElementById("image_main").innerHTML = xmlhttp.responseText;
				}
			}
			xmlhttp.send();
		}
		getImage(1);
	</script>
</body>
</html>