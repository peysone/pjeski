<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
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
    Imię: <form:input path="name"/> <br/>
    Wiek: <form:input path="estimatedAge"/> <br/>
    Rodzaj: <form:select path="animalType">
    <option>PIES</option>
    <option>KOT</option>
    <option>INNE</option>
</form:select>
    <br>
    Płeć: <form:select path="animalSex">
    <option>SAMIEC</option>
    <option>SAMICA</option>
    <option>MŁODE</option>
</form:select>
    <br>
    Od kiedy w schronisku: <form:input path="dateSinceInShelter"/> <br/>
    <br/> <%--zamiast gatunek -> rodzaj, bo lepiej brzmi--%>
    Czy rasowy: <form:checkbox path="isPurebred"/> <br/>
    Rasa: <form:input path="breed"/> <br/>

    Opis: <form:input path="description"/> <br/>
    Zdjęcie: <form:input path="pic"/><br/>
    Czy do adopcji: <form:checkbox path="isAvalaibleToAdoption"/> <br/>
    Czy dostepny na spacer: <form:checkbox path="isAvailabraForAWalk"/> <br/>


    <%--dodawanie obrazka czysty html--%>
    <%--<form action="..." enctype="multipart/form-data">--%>
    <%--<input type="file" name="nazwa" accept="image/jpeg,image/gif">--%>
    <%--</form>--%>
    <input type="submit" value="Dodaj"/>

</form:form>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>