<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <title>회원가입 step2</title>
    <link rel="stylesheet" href="./css/normalize.css">
    <link rel="stylesheet" href="./css/default.css">
    <link rel="stylesheet" href="./css/style.css">
    <script type="text/javascript" src="./js/prefix.js"></script>
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/common.js"></script>
  </head>
  <body>
  <div id="wrapper">
   <div id="header">
   		<jsp:include page="/incl/banner.jsp">
   			<jsp:param name="subtitle" value="mode007 : Java Beans and include" />
   		</jsp:include>
   </div>
   <div id="content-wrapper">
   		<h3>회원가입</h3>
   </div>
   <div id="footer">
   		<%@ include file="/incl/footer.jsp" %>
   </div>
  </div>
  </body>
</html>
