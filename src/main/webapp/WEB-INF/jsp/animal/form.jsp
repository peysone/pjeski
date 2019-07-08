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
<h2>Formularz dodawania zwierzaka:</h2>
<p>oczywiście najpierw musimy dodać schronisko więc w menu nie powinno być tak że od razu widać dodaj zwierzaka <br>
    chyba że najpierw sprawdzi czy już jest schronisko - rozumiem że to menu jest tylko dla nas żeby sprawdzić czy
    wszystko działą</p>
<%--@elvariable id="animal" type="com.sda.javagda22.Pjeski.domain.model.animal.Animal"--%>
<form:form action="/animal/create/${shelterId}" method="POST" modelAttribute="animal">
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
    Od kiedy w schronisku: <form:input path="dateSinceInShelter"/><br/>
    Czy rasowy: <form:checkbox path="isPurebred"/> <br/>
    Czy do adopcji: <form:checkbox path="isAvailableToAdoption"/> <br/>
    Czy dostepny na spacer: <form:checkbox path="isAvailableForAWalk"/> <br/>
    <form:hidden path="id"/>
    <form:hidden path="shelter.id"/>
    <%--dodawanie obrazka czysty html--%>
    <%--<form action="..." enctype="multipart/form-data">--%>
    <%--<input type="file" name="nazwa" accept="image/jpeg,image/gif">--%>
    <%--</form>--%>
    <input type="submit" value="Dodaj"/>
</form:form>
<%
    Date dNow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy");
    out.print("<h2 align=\"center\">" + ft.format(dNow) + "</h2>"); %>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>