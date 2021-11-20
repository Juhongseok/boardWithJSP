<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="join.do" method="post">
		<p>
			id:<br/>
			<input type="text" name="id">
		</p>
		<p>
			password:<br/>
			<input type="password" name="password">
		</p>
		<p>
			address:<br/>
			<input type="text" name="address">
		</p>
		<p>
			<input type="hidden" name="role" value="user">
		</p>
		<input type="submit" value="가입">
	</form>
</body>
</html>