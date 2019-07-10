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
    <title>Animal list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Lista zwierzaków:</h2>
<c:if test="${empty animals}">
    <h3>Nie znaleziono zwierzaka!</h3>
</c:if>
<%--Teoretycznie można to wyrzucić bo do wyboru są tylko miasta z listy schronisk--%>
<%--<c:if test="${empty shelters}">--%>
<%--<h3>Nie znaleziono zwierząt w danym mieście!</h3>--%>
<%--</c:if>--%>

<c:forEach items="${animals}" var="animal">
    <a><b>${animal.animalType} ${animal.name} </b></a><br/>
    <a><b>Wiek: </b></a>${animal.estimatedAge} <br/>
    <a><b> Płeć: </b></a>${animal.animalSex} <br/>
    <a><b> Opis: </b></a>${animal.description} <br/>
    <a><b> Rasa: </b></a>${animal.breed} <br/>
    <a><b> Schronisko:</b></a> ${animal.shelter.name}<br/>
    <a><b> Miasto: </b></a>${animal.shelter.city}<br/>
    <a><b> Do adopcji: </b></a>${animal.isAvailableToAdoption} <br/>
    <a><b> Na spacer:</b></a> ${animal.isAvailableForAWalk}<br/>
    <a href="/animal/edit/${animal.id}">Edycja zwierzaka</a>
    <a href="/animal/delete/${animal.id}">Usun zwierzaka</a>
    <br><br>
</c:forEach>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>