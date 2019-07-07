<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Strona główna</title>
    <link rel="stylesheet" href="/resources/css/main.css"/>
</head>
<body>
<%@include file="fragments/header.jspf" %>
<section id="home" class="section">
    <h2><% out.print("Witaj w aplikacji pJeski. Proszę wybrać miasto aby wyszukać zwierzęta do adopcji.");%></h2>



    <%!
        private int visitCount = 0;
    %>
    <h2>Ilosc odwiedzin strony: <%= ++visitCount%>
    </h2><br>
    </form>
</section>
<div id="footer">
<%@include file="fragments/footer.jspf" %>
</div>
</body>
</html>