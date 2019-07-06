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
    Wiek: <form:input path="estimatedAge"/> <br/>
    Rodzaj: <form:select path="animalType">
    <option>PIES</option>
    <option>KOT</option>
    <option>INNE</option>
</form:select> <br/>
    Rasa: <form:input path="breed"/> <br/>
    Od kiedy w schronisku: <form:input path="dateSinceInShelter"/> <br/>
    <form:hidden path="id"/>
    <input type="submit" value="Zapisz zmiany"/>
    <a href="/animal/list">Odrzuć zmiany</a>

<%--    Robi to samo co <a href="/animal/list">Odrzuć zmiany</a> tylko ze jest jako button--%>
    <%--    <input type="button" value="Odrzuć zmiany"--%>
    <%--           onclick="window.location.href='/animal/list'"/>--%>
</form:form>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>