<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="showInfo.do" method="post">
		id: <input type="text" name="id" value="${user.id}"><br/>
		password: <input type="text" name="password" value="${user.password}"><br/>
		address: <input type="text" name="address" value="${user.address}"><br/>
		<input type="submit" value="회원정보 수정">
	</form>
	<input type="button" value="뒤로가기" onclick="history.back(-1)">
</body>
</html>
