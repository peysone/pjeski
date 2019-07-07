<%@ page import="com.sda.javagda22.Pjeski.service.ShelterService" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find animals by city containing</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Szukaj zwierząt według miasta:</h2>
<form:form action="/animal/find-by-city" method="POST" modelAttribute="filterForm">
    Miasto: <select name="city">
    <c:forEach items="${allCities}" var="city">
        <option>${city}</option>
    </c:forEach>
</select><br/>
    <input type="submit" value="Szukaj!"/>
</form:form>
<br />
<h2>lub</h2>
<br />
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