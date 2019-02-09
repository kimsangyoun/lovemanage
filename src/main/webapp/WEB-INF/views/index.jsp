<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<sec:authorize access="!hasRole('ROLE_USER')">
<p> is Log-In</p>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
<p> is Log-Out</p>
</sec:authorize>
USER ID : <sec:authentication property="name"/><br/>
<a href="${pageContext.request.contextPath}/home/index.do">sss</a>
</body>
</html>