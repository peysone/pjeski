<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <title>Shelter list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<section id="home" class="section">
    <h2>Lista schronisk:</h2>
    <c:if test="${empty shelters}">
        <h3>Nie znaleziono schroniska!</h3>
    </c:if>
    <c:forEach items="${shelters}" var="shelter">
    <b> <a href="/shelter/animals/${shelter.id}">Schronisko ${shelter.name}<a/><b/><br/>
        <a><b>Miasto:</b></a> ${shelter.city} <br/>
        <a><b> Numer telefonu:</b></a> ${shelter.telephone} <br/>
        <a><b>Zwierzaki w schronisku:</b></a> ${shelter.animals.size()}<br/>
        <br/>
        </c:forEach>
</section>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>



