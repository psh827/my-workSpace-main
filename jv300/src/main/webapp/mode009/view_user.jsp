<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="wrap">
	   <div id="header">
	   		<jsp:include page="/incl/banner.jsp">
	   			<jsp:param name="subtitle" value='<%=URLEncoder.encode("mode007 : 자바빈즈", "UTF-8") %>' />
	   		</jsp:include>
	   </div>
	   <div class="menu">
		   <jsp:include page="/incl/menu.jsp">
		   		<jsp:param name="go" value='<%=URLEncoder.encode("유저정보보기") %>' /> 
		   	</jsp:include>
	   	</div>
	   	<form action="view_user.do" method="post">
	   		<p>아이디를 입력하세용</p>
	   		<input type="text" name="userId" required/>
	   	</form>
	   	<%@ include file="/incl/footer.jsp" %>
</div>
</body>
</html>