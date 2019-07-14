<%@ page import="com.sda.javagda22.Pjeski.service.ShelterService" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find animals by city containing</title>
    <link rel="stylesheet" href="/resources/css/main.css"/>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<section id="home" class="section">
<h2>Szukaj zwierząt według rodzaju:</h2>
<form:form action="/animal/filter-by-type" method="POST" modelAttribute="filterForm">
    Rodzaj: <form:select path="animalType"> <br />
    <option>PIES</option>
    <option>KOT</option>
    <option>INNE</option>
    <input type="submit" value="Szukaj!"/>
</form:select>

</form:form>




</body>
</html>