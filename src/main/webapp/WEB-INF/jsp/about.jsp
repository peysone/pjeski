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
<center><h1>Dzielni twórcy strony:</h1>
    <ul class="cadre">
        <li>
            <div>
                <a style="font-size: 44px">dodiedogg</a><br/>
                <img src="/resources/images/dodiedogg.jpg" alt="dodiedogg" width="100%"/><br/>
                <a style=" font-size: 22px">Analityk i markieter</a>
            </div>
        </li>
        <li>
            <div>
                <a style="font-size: 44px">KSzuca</a><br/>
                <img src="/resources/images/KSzuca.jpg" alt="KSzuca" width="100%"/><br/>
                <a style=" font-size: 22px">Coś robiła</a>
            </div>
        </li>
        <li>
            <div>
                <a style="font-size: 44px">peysone</a><br/>
                <img src="/resources/images/peysone.jpg" alt="peysone" width="100%"/><br/>
                <a style=" font-size: 22px">Specjalista od gita</a>
            </div>
        </li>
        <li>
            <div>
                <a style="font-size: 44px">PMushy</a><br/>
                <img src="/resources/images/PMushy.jpg" alt="PMushy" width="100%"/><br/>
                <a style="font-size: 22px">Wsparcie mentalne</a>
            </div>
        </li>
    </ul>
</center>
<%@include file="fragments/footer.jspf" %>
</body>
</html>