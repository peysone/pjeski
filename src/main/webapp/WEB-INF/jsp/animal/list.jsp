<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<%--Teoretycznie można to wyrzucić bo do wyboru są tylko miasta z listy schronisk--%>
<%--<c:if test="${empty shelters}">--%>
    <%--<h3>Nie znaleziono zwierząt w danym mieście!</h3>--%>
<%--</c:if>--%>

<c:forEach items="${animals}" var="animal">
    ${animal.animalType} ${animal.name} <br/>
    Wiek: ${animal.estimatedAge} <br/>
    Płeć: ${animal.animalSex} <br/>
    Opis: ${animal.description} <br/>
    Rasa: ${animal.breed} <br/>
    Schronisko: ${animal.shelter.name}<br />
    Miasto: ${animal.shelter.city}<br/>
    Do adopcji: ${animal.isAvailableToAdoption} <br/>
    Na spacer: ${animal.isAvailableForAWalk}<br />
    <a href="/animal/edit/${animal.id}">Edycja zwierzaka</a>
    <a href="/animal/delete/${animal.id}">Usun zwierzaka</a>
    <br><br>
</c:forEach>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>