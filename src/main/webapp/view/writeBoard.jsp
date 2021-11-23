<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="writeBoard.do" method="post">
		제목:<input type="text" name="title" required><br/>
		내용:<br/>
		<textarea rows="5" cols="30" name="content"></textarea>
		<input type="submit" value="새글 작성">
	</form>
</body>
</html>