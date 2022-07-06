<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLDecoder" %>
<button type="button" onclick="location.href='viewUser.jsp'"><%=URLDecoder.decode(request.getParameter("go")) %></button>

