<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.ConnectionProvider" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
	<%
		try(Connection conn = ConnectionProvider.getConnection()){
			out.println("연결 성공");
		}catch(SQLException e){
			out.println("연결 실패");
		}
	%>
</body>
</html>