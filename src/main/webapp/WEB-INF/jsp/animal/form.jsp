<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Animal creator</title>
</head>
<body>

<%@include file="../fragments/header.jspf"%>
<h2>Formularz dodawania zwierzaka:</h2>
<p>oczywiście najpierw musimy dodać schronisko więc w menu nie powinno być tak że od razu widać dodaj zwierzaka <br>
chyba że najpierw sprawdzi czy już jest schronisko - rozumiem że to menu jest tylko dla nas żeby sprawdzić czy wszystko działą</p>
<%--@elvariable id="animal" type="com.sda.javagda22.Pjeski.domain.model.Animal"--%>
<form:form action="/animal/create/${shelterId}" method="POST" modelAttribute="animal">
    Imię: <form:input path="name"/> <br />
    Wiek: <form:input path="estimateAge"/> <br />
    Rodzaj: <form:input path="animalType"/> <br/> <%--zamiast gatunek -> rodzaj, bo lepiej brzmi--%>
    Rasa: <form:input path="breed"/> <br />
    Od kiedy w schronisku: <form:input path="dateSinceInShelter"/> <br />
    <input type="submit" value="Dodaj"/>
</form:form>
<%@include file="../fragments/footer.jspf"%>
</body>
</html>