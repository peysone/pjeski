<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <title>Visit list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<section id="home" class="section">
    <h2>Lista wizyt:</h2>
    <c:if test="${empty visits}">
        <h3>Nie znaleziono zwierzaka!</h3>
    </c:if>
    <c:forEach items="${visits}" var="visit">
        <a><b>Id wizyty: </b></a>${visit.id} <br/>
        <a><b>Id zwierzaka: </b></a>${visit.animal.id} <br/>
        <a><b>Id użytkownika: </b></a>${visit.user.id} <br/>
        <a><b>Opis: </b></a>${visit.description} <br/>
        <a><b>Data:</b></a> ${visit.date}<br/>
        <br/>
    </c:forEach>
</section>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>