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
<h2>Find animals by city</h2>
<form:form action="/animal/find-by-city" method="POST" modelAttribute="filterForm">


    Miasto: <select name="city">
    <c:forEach items="${allCities}" var="city">
        <option>${city}</option>
    </c:forEach>
</select><br/>
    <input type="submit" value="Find all!"/>
</form:form>
</body>
</html>