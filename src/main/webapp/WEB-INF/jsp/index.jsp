<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Strona główna</title>
    <link rel="stylesheet" href="/resources/css/main.css"/>
</head>
<body>
<%@include file="fragments/header.jspf" %>
<section id="home" class="section">
    <h2><% out.print("Witaj w aplikacji pJeski. Proszę wybrać miasto aby wyszukać zwierzęta do adopcji.");%></h2>

    <form:form action="/animal/find-by-city" method="POST" modelAttribute="filterForm">
        Miasto: <select name="city">
        <c:forEach items="${allCities}" var="city">
            <option>${city}</option>
        </c:forEach>
    </select>
        <input type="submit" value="Szukaj!"/>
    </form:form>
</section>
<div id="footer">
    <%!private static int visitCount = 0;%>
    <h2>Ilość odwiedzin strony: <%= ++visitCount%>
    </h2>
    <%@include file="fragments/footer.jspf" %>
</div>
</body>
</html>