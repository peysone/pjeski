<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find shelters by city containing</title>
</head>
<body>
<%@include file="../fragments/header.jspf"%>
<h2>Szukaj schroniska według miasta:</h2>
<form:form action="/shelter/find-by-city" method="POST" modelAttribute="filterForm">
    Miasto: <form:input path="city"/><br/>
    <input type="submit" value="Szukaj"/>
</form:form>
<%@include file="../fragments/footer.jspf"%>
</body>
</html>