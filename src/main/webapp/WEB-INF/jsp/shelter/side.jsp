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
    <form:form action="/animals/${shelterId}" method="POST" modelAttribute="shelter">
        <h2>Schronisko ${shelter.name}</h2>
        <a><b>Miasto:</b></a> ${shelter.city} <br/>
        <a><b>Adres:</b></a> ${shelter.address}<br/>
        <a><b>Kod pocztowy:</b></a> ${shelter.postalCode}<br/>
        <a><b>Numer telefonu:</b></a> ${shelter.telephone} <br/>
        <br/>
        <c:if test="${empty animals}">
            <h3>Nie znaleziono zwierząt!</h3>
        </c:if>
        <c:forEach items="${animals}" var="animal">
            <a><b>${animal.animalType} ${animal.name}</b></a><br/>
            <a><b>Opis:</b></a> ${animal.description} <br/>
            <a><b>Do adopcji:</b></a> ${animal.isAvailableToAdoption ? 'Tak' : 'Nie'} <br/>
            <a><b>Na spacer:</b></a> ${animal.isAvailableForAWalk ? 'Tak': 'Nie'}<br/>
            <a href="/animal/visit/${animal.id}">Umów wizytę</a><br/>
            <br/>
        </c:forEach>
    </form:form>
</section>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>



