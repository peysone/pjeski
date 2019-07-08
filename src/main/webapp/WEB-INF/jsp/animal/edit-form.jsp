<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <title>Edit animal</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Edycja zwierzaka</h2>
<form:form action="/animal/edit/${animal.id}" method="POST" modelAttribute="animal">
    Id: <c:out value="${animal.id}"/> <br/>
    Numer identyfikacyjny: <form:input path="identificationNumber"/> <br/>
    Opis: <form:input path="description"/> <br/>
    Imię: <form:input path="name"/> <br/>
    Wiek: <form:input path="estimatedAge"/> <br/>
    Rodzaj: <form:select path="animalType">
    <option>PIES</option>
    <option>KOT</option>
    <option>INNE</option>
</form:select> <br/>
    Płeć: <form:select path="animalSex">
    <option>SAMIEC</option>
    <option>SAMICA</option>
    <option>MŁODE</option>
</form:select> <br/>
    Rasa: <form:input path="breed"/> <br/>
    Od kiedy w schronisku: <form:input path="dateSinceInShelter"/> <br/>
    Czy rasowy: <form:checkbox path="isPurebred"/> <br/>
    Czy do adopcji: <form:checkbox path="isAvailableToAdoption"/> <br/>
    Czy dostepny na spacer: <form:checkbox path="isAvailableForAWalk"/> <br/>
    Zdjęcię: <form:input path="pic"/> <br/>
    <form:hidden path="id" />
    <form:hidden path="shelter.id" />

    <input type="submit" value="Zapisz zmiany"/>
    <a href="/animal/list">Odrzuć zmiany</a>

    <%--    Robi to samo co <a href="/animal/list">Odrzuć zmiany</a> tylko ze jest jako button--%>
    <%--    <input type="button" value="Odrzuć zmiany"--%>
    <%--           onclick="window.location.href='/animal/list'"/>--%>
</form:form>
<%
    Date dNow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy");
    out.print("<h2 align=\"center\">" + ft.format(dNow) + "</h2>"); %>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>