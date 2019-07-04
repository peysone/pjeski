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
<%--<a href="name.jsp">NAME exception bo samo name http://localhost:8080/name.jsp</a><br>--%>
<%--<a href="name.jsp?name=">NAME exception link bez parametru name http://localhost:8080/name.jsp?name=</a><br>--%>
<%--<a href="name.jsp?name=janusz">NAME z prawidłowym linkiem (ale z mala pierwszą literą) http://localhost:8080/name.jsp?=janusz</a><br>--%>
<%--<a href="counter.jsp">licznik odsłon strony.jsp</a><br>--%>
<%--<a href="predefined2.jsp">ćwiczenie pedefined.jsp bez print.out</a>--%>

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