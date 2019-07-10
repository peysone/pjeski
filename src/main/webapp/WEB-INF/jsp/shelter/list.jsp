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
        <a><b>Nazwa schroniska:</b></a> ${shelter.name} <br/>
        <a><b>Adres:</b></a> ${shelter.address} <br/>
        <a><b>Kod pocztowy: </b></a>${shelter.postalCode} <br/>
        <a><b>Miasto:</b></a> ${shelter.city} <br/>
        <a><b> Numer telefonu:</b></a> ${shelter.telephone} <br/>
        <a><b> Numer konta bankowego:</b></a> ${shelter.accountNumber} <br/>
        <a href="/animal/create/${shelter.id}">Dodaj zwierzę</a>
        <br/><br/>
        <a><b>Zwierzaki w schronisku:</b></a><br/>
        <c:if test="${empty shelter.animals}">
            <a style="font-size:16px"><b>Brak zwierząt w schronisku.</b></a>
        </c:if>
        <c:forEach items="${shelter.animals}" var="animal">
            ${animal.animalType} ${animal.name}<br/>
        </c:forEach>
        <br/>
    </c:forEach>
</section>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>



