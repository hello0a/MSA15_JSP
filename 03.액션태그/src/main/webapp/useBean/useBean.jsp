<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>액션태그 - useBean</title>
</head>
<body>
	<%-- person 이란 이름으로 Person 객체 생성 --%>
	<%-- Person person = new Person(); --%>
	<%-- 대신하여 아래 useBean으로 객체 생성한 것 --%>
	<%-- 컴파일이 안되는 경우 (아무리 봐도 코드가 똑같았음) 
		1. 프로젝트 우클릭 - Refresh 
		2. 재실행
		3. clean --%>
	<jsp:useBean id="person" class="beans.Person"></jsp:useBean>
	
	<%-- 표현문으로 자바 코드를 사용하여 겟터호출 --%>
	<h3>이름 : <%= person.getName() %></h3>
	<h3>나이 : <%= person.getAge() %></h3>
	<hr>
	
	<%-- getProperty 액션 사용하여 겟터호출 
		즉, 위 아래 동일 --%>
	<h3>이름 : <jsp:getProperty property="name" name="person"/> </h3>
	<h3>나이 : <jsp:getProperty property="age" name="person"/> </h3>
	
	<%
		person.setName("김조은");
		person.setAge(30);
	%>
	
	<jsp:setProperty property="name" name="person" value="김조은"/>
	<jsp:setProperty property="age" name="person" value="35"/>
	
	<h3>이름 : <jsp:getProperty property="name" name="person"/></h3>
	<h3>나이 : <jsp:getProperty property="age" name="person"/></h3>
	<hr>
</body>
</html>