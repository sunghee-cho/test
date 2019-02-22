<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="edu.R.RTest2, vo.StudentVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
H1 {color : blue; background-color: aqua;}
h1, h3 {text-align: center;}
</style>
</head>
<body>
<% 
request.setCharacterEncoding("utf-8");
String input = request.getParameter("input"); 
RTest2 r2 = new RTest2();
StudentVO stu = r2.test3(input); 
%>
<H1> <%=input %> 님의 성적</H1>
<h3><%= "국어="+stu.getKor()%></h3>
<h3><%= "영어="+stu.getEng()%></h3>
<h3><%= "수학="+stu.getMat()%></h3>
<h3><%= "총점="+stu.getTotal()%></h3>
<h3><%= "평균="+stu.getAvg()%></h3>


</body>
</html>