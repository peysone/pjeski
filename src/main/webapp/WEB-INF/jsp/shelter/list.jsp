<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <title>Shelter list</title>
</head>
<body>
<%@include file="../fragments/header.jspf"%>
<h2>Lista schronisk:</h2>

<c:if test="${empty shelters}">
    <h3>Nie znaleziono schroniska!</h3>
</c:if>



<c:forEach items="${shelters}" var="shelter">
    <br>
    <br>
    Nazwa schroniska: ${shelter.name} <br/>
    Adres: ${shelter.address} <br/>
    Kod pocztowy: ${shelter.postalCode} <br/>
    Miasto: ${shelter.city} <br/>
    Numer telefonu: ${shelter.telephone} <br/>
    Numer konta bankowego: ${shelter.accountNumber} <br/>
    <a href="/animal/create/${shelter.id}">Dodaj zwierzę</a>
    <br/><br/>

    <%--<c:forEach items="${shelter.animals}" var="animal">--%>
        <%--Schronisko: ${shelter.name}<br />--%>
        <%--Imię: ${animal.name}<br />--%>
        <%--Rodzaj: ${animal.animalType}<br />--%>
        <%--<a href="/animal/edit/${animal.id}">Edytuj zwierzę</a><br />--%>
    <%--</c:forEach>--%>

</c:forEach>
<%@include file="../fragments/footer.jspf"%>
</body>
</html>



