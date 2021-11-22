<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">
		<p>
			id: <input type="text" name="id" required>
		</p>
		
		<p>
			password: <input type="password" name="password" required>
		</p>
		<input type=submit value="login">
	</form>
</body>
</html>