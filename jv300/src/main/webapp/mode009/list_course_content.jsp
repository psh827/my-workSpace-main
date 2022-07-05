<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.blank{margin-left: 20px;}
</style>
</head>
<body>
<div id="wrapper">
<form action="list_content.do" method="get">
	<c:forEach var="text" items="${goList}">
		${text}
		<br>
	</c:forEach>
	
	
</form>
</div>
</body>
</html>