<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Edit animal</title>
</head>
<body>
<h2>Edycja zwierzaka</h2>
<%@include file="../fragments/header.jspf" %>
<form:form action="/animal/edit/${animal.id}" method="POST" modelAttribute="animal">
    Id: <c:out value="${animal.id}"/> <br/>
    Imię: <form:input path="name"/> <br/>
    Wiek: <form:input path="age"/> <br/>
    Gatunek: <form:input path="type"/> <br/>
    Rasa: <form:input path="breed"/> <br/>
    Od kiedy w schronisku: <form:input path="dateSinceInShelter"/> <br/>
    <form:hidden path="id"/>
    <input type="submit" value="Zapisz zmiany"/>
    <input type="reset" value="Odrzuć zmiany"/>
</form:form>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>