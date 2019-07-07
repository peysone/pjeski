<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Lato', sans-serif;
            font-size: 20px;
        }
    </style>

</head>
<body>

<h2><% out.print("Witaj w aplikacji pJeski - co chcesz zrobić?");%></h2>
<a href="/shelter/create">Dodaj schronisko</a><br>

<a href="/shelter/find-by-city">Szukaj schroniska</a>
<%--<form:select path="phone" items="${phonesMap}"/>--%>


<%!
    private int visitCount = 0;
%>
<h2>Ilosc odwiedzin strony: <%= ++visitCount%></h2><br><br>
<form action="...">
    <select name="nazwa">
        <option>Tu wpisz pierwszą możliwość</option>
        <option>Tu wpisz drugą możliwość</option>

    </select>
</form>
<%@include file="fragments/footer.jspf"%>
</body>
</html>