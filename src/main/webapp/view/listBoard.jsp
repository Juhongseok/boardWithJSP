<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${result.hasNoList()}">
            	<tr>
            		<td colspan=4>게시글이 없습니다.</td>
            	</tr>
            </c:if>
            <c:forEach var="list" items="${result.content}">
            	<tr>
            		<td>${list.id}</td>
            		<td>${list.title}</td>
            		<td>${list.userName}</td>
            		<td>${list.readCount}</td>
            	</tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <c:if test="${result.hasList()}">
            	<tr>
            		<td colspan=4>
						<c:if test="${result.startPage > 5}">
							<a href="#">[이전]</a>
						</c:if>
						<c:forEach var="pageNo" begin="${result.startPage}" end="${result.endPage}">
							<a href="#">[${pageNo}]</a>
						</c:forEach>
						<c:if test="${result.endPage < result.totalPage}">
							<a href="#">[다음]</a>
						</c:if>
					</td>
            	</tr>
            </c:if>
        </tfoot>
	</table>
</body>
</html>