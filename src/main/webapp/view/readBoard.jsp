<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>번호</td>
			<td>${board.id}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.userName}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${board.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><u:pre value="${board.content}"/></td>
		</tr>
		<tr>
			<td colspan="2">
			<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}"/>
			<a href="listBoard.do?pageNo=${pageNo}">[목록 보기]</a>
			<c:if test="${user.id == board.userName}">
				<a href="modify.do?no=${board.id}">[게시글 수정]</a>
				<a href="#" onClick="deleteById(${board.id})">[게시글 삭제]</a>
			</c:if>
		</tr>
	</table>
</body>
<script>
	function deleteById(boardId){
		$.ajax({
			type: "POST",
			url:"/board/delete.do",
			data: {boardId: boardId}
		}).done(function(data){
			if(data==="delete"){
				location.href="listBoard.do"
			}else if(data==="not delete"){
				alert("삭제실패");
			}
		});
	}
</script>
</html>