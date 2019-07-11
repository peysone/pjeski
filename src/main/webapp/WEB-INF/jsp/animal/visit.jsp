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
    <title>Animal creator</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Formularz umawiania wizyty:</h2>

<form:form action="/animal/visit/${animalId}" method="POST" modelAttribute="visit">
    Opis: <form:input path="description"/> <br/>
    Data wizyty: <form:input path="date"/> <br/>
<%--    Id użytkownika: <form:input path="user.id"/> <br/>--%>

    <form:hidden path="animal.id"/>
        <form:hidden path="user.id"/>

    <input type="submit" value="Dodaj"/>
</form:form>
<%
    Date dNow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy");
    out.print("<h2 align=\"center\">" + ft.format(dNow) + "</h2>"); %>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>