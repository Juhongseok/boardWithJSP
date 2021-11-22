<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<u:notLogin>
		<a href="join.do">회원가입</a>
		<a href="login.do">로그인</a>
	</u:notLogin>
	
	<u:isLogin>
		${user.id}님 안녕하세요<br/>
		<a href="logout.do">로그아웃</a>
		<a href="showInfo.do">회원정보</a>
	</u:isLogin>
</body>
</html>