<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
<title><s:message code="menu.adminPage"/></title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2><s:message code="menu.adminPage"/></h2>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <li><a href="/users/1">Użytkownicy</a>&nbsp;&nbsp;</li>
 </sec:authorize>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>