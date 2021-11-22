<%@ tag body-content="scriptless" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true" %>
<%
	HttpSession httpSession = request.getSession();
	if(httpSession!=null && httpSession.getAttribute("user")!=null){
%>
<jsp:doBody/>
<%} %>