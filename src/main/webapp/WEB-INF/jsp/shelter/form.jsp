<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <title>Dodawanie schroniska</title>
</head>
<body>
<%@include file="../fragments/header.jspf"%>
<%--<%@include file="../fragments/menu.app" %>--%>
<h2>Formularz dodawania schroniska:</h2>
<%--@elvariable id="shelter" type="com.sda.javagda22.Pjeski.domain.model.Shelter"--%>

<form:form action="/shelter/create" method="POST" modelAttribute="shelter">
    Nazwa schroniska: <form:input path="name"/> <br />
    Adres: <form:input path="address"/> <br />
    Kod pocztowy: <form:input path="postalCode"/> <br />
    Miasto: <form:input path="city"/> <br />
    Numer telefonu: <form:input path="telephone"/> <br />
    Numer konta bankowego: <form:input path="accountNumber"/> <br />
    <input type="submit" value="Dodaj"/>
</form:form>
<%@include file="../fragments/footer.jspf"%>
</body>
</html>


