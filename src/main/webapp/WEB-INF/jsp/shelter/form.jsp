<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Shelter creator</title>
</head>
<body>
<h2>Formularz dodawania schroniska:</h2>
<form:form action="/shelter/create" method="POST" modelAttribute="shelter">
    Nazwa schroniska: <form:input path="name"/> <br />
    Adres: <form:input path="address"/> <br />
    Kod pocztowy: <form:input path="postalCode"/> <br />
    Miasto: <form:input path="city"/> <br />
    Telephone: <form:input path="telephone"/> <br />
    Numer konta bankowego: <form:input path="accountNumber"/> <br />
    <input type="submit" value="Dodaj"/>
</form:form>
</body>
</html>



