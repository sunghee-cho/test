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
%>
<H1> <%=input %> 님 환영해요</H1>

</body>
</html>