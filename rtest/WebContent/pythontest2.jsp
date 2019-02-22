<%@ page language="java" 
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제목입니다.</title>
</head>
<body>

<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
%>
<h1> <%=name%> 회원님 환영합니다. </h1>
<h3> 게시판, 쇼핑 메뉴를 사용할 수 있습니다.</h3>
<h1> 감사합니다. </h1>
<p> 파이썬 테스트 중입니다. <br> 
<div style="color:red"> <%= request.getMethod()%></div> </p>
<a href="http://www.multicampus.co.kr" id="mul">멀티홈가기</a>
<h1> <a href="myplot.html" id="plot"> 그래프보러가기 </a></h1>


</body>
</html>






