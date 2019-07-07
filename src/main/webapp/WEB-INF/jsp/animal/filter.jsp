<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find animals by...</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<h2>Filtruj zwierzęta po:</h2>
<form:form action="/animal/filter-by-type" method="POST" modelAttribute="filterForm">
    rodzaju: <form:select path="animalType">
    <option>PIES</option>
    <option>KOT</option>
    <option>INNE</option>
</form:select> <br/>
    <input type="submit" value="Szukaj!"/>
</form:form>

<%@include file="../fragments/footer.jspf" %>
</body>
</html>