<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- input 파라미터 stu2.jsp 전송
stu2.jsp: RTest2클래스 test3메소드 호출
 실행 결과 브라우저 출력--%>
 <form action="stu2.jsp" method="post">
  <input type=text name="input">
  <input type=submit value="전송" >
 </form>
</body>
</html>



