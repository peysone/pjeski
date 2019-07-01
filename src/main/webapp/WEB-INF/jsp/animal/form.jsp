<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Animal creator</title>
</head>
<body>
<jsp:include page="../fragments/header.jspf"/>
<h2>Formularz dodawania zwierzaka:</h2>
<form:form action="/animal/create" method="POST" modelAttribute="animal">
    Imię: <form:input path="name"/> <br />
    Wiek: <form:input path="age"/> <br />
    Gatunek: <form:input path="type"/> <br/>
    Rasa: <form:input path="breed"/> <br />
    Od kiedy w schronisku: <form:input path="dateSinceInShelter"/> <br />
    <input type="submit" value="Dodaj"/>
</form:form>
<jsp:include page="../fragments/footer.jspf"/>
</body>
</html>