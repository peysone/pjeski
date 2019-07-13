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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Datepicker - Default functionality</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
    </head>
    <p>Data wizyty: <input type="text" id="datepicker"></p><br/>
    Id użytkownika:<a>${userId}</a> <br/>

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