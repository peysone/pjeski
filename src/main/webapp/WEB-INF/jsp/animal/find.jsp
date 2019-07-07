<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find animals by city containing</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Szukaj zwierząt według miast</h2>
<form:form action="/animal/find-by-city" method="POST" modelAttribute="filterForm">
    Miasto: <form:input path="city"/><br/>
    <input type="submit" value="Find all!"/>
</form:form>
</body>
</html>