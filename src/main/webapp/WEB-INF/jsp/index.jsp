<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Strona główna</title>
    <link rel="stylesheet" href="/resources/css/main.css"/>
</head>
<body>
<%@include file="fragments/header.jspf" %>
<section id="home" class="section">
    <h2><% out.print("Witaj w aplikacji pJeski kompane s.p. z o.o.  - co chcesz zrobić?");%></h2>

    <%!
        private int visitCount = 0;
    %>
    <h2>Ilosc odwiedzin strony: <%= ++visitCount%>
    </h2><br>
    </form>
</section>
<%@include file="fragments/footer.jspf" %>
</body>
</html>