<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Animal list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Lista zwierzaków:</h2>
<c:forEach items="${animals}" var="animal">
    Imię: ${animal.name} <br/>
    Wiek: ${animal.estimatedAge} <br/>
    Opis: ${animal.description} <br/>
    Gatunek: ${animal.animalType} <br/>
    Rasa: ${animal.breed} <br/>
    Do adopcji: ${animal.isAvalaibleToAdoption} <br/>

    <br><br>
</c:forEach>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>