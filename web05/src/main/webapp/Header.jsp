<%@page import="spms.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="session" class="spms.vo.Member" />
<div style="background-color: #00008b; color: #ffffff; height: 20px; padding: 5px;">
	SPMS(Simple Project Management System)
	<%
	if (member.getEmail() != null) { // 로그인을 했을 경우 정보가 보임
    %>
	<span style="float: right;"> <%=member.getName()%> 
	<a style="color: white;" href="<%=request.getContextPath()%>/auth/logout">로그아웃</a>
	</span>
	<%}	%>
</div>