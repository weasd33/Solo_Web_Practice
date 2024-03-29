<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<%-- 2. 프런트 컨트롤러 적용 - 링크에 .do 붙임 --%>
	<jsp:include page="/Header.jsp" />
	<h1>회원목록</h1>
	<p>
		<a href='add.do'>신규 회원</a>
	</p>
	
	<c:forEach var="member" items="${members}"> 
	${member.no},
	<a href='update.do?no=${member.no}'>${member.name}</a>,
	${member.email},
	${member.createdDate}
	<a href='delete.do?no=${member.no}'>[삭제]</a><br>
	</c:forEach>
	
	<jsp:include page="/Tail.jsp" />
</body>
</html>