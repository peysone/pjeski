<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html><html>

<head>
    <meta charset="UTF-8">
    <title>Animal creator</title>
</head>
<body>
<h2>Dodaj zwierzę:</h2>

<%--@elvariable id="animal" type=""--%>
<form:form action="/animal/create" method="POST" modelAttribute="animal">
    Imię: <form:input path="name"/> <br />
    Wiek: <form:input path="age"/> <br />
    Rasa: <form:input path="breed"/> <br />
    Od kiedy w schronisku: <form:input path="dateSinceInShelter"/> <br />

    <input type="submit" value="Dodaj"/>
</form:form>
</body>
</html>




