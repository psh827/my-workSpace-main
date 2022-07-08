<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>My page!</h3>
	<a href='<c:url value="/mode010/logout" />'>로그아웃</a>
	<a href='<c:url value="/mode010/update" />'>업데이트</a><br>
	<label>Last Access Time : </label> ${lastAccessTime}
</body>
</html>