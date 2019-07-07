<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find shelters by city containing</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Szukaj schroniska według miasta:</h2>
<form:form action="/shelter/find-by-city" method="POST" modelAttribute="filterForm">
    Wybierz miasto: <form:input path="city"/><br/>
    <c:forEach items="${shelters}" var="shelter">
        <c:out value="${shelter.city}"/>
    </c:forEach>
    </select>

    <input type="submit" value="Szukaj"/>
</form:form>

<%@include file="../fragments/footer.jspf" %>
</body>
</html>