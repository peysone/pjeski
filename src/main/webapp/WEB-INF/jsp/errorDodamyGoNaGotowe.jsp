<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="/resources/css/main.css"/>
</head>
<body>
<%@include file="./fragments/header.jspf" %>
<center>
    <h1>
        <div><span style="color:#ff0000;">C</span><span style="color:#ff4000;">o</span><span
                style="color:#ff7f00;">ś</span><span
                style="color:#ffbf00;"> </span><span style="color:#ffff00;">s</span><span
                style="color:#00ff00;">i</span><span style="color:#00ff80;">ę</span><span
                style="color:#00ffff;"> </span><span style="color:#0080ff;">z</span><span
                style="color:#0000ff;">j</span><span style="color:#4600ff;">e</span><span
                style="color:#8b00ff;">b</span><span style="color:#ff0000;">a</span><span
                style="color:#ff4000;">ł</span><span style="color:#ff7f00;">o</span></div>
    </h1>
    <img src="<c:url value="../../../resources/static/images/crying.jpg"/>"/>

</center>
<%@include file="./fragments/footer.jspf" %>
</body>
</html>