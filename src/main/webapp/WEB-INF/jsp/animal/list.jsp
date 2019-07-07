<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/resources/css/div.css" />
    <%--<spring:url value="/resources/css/div.css" var="divCss" />--%>
    <%--<link href="${pageContext.request.contextPath}/resources/css/div.css" rel="stylesheet" type="text/css">--%>
    <title>Animal list</title>
</head>
<body>
<jsp:include page="../fragments/header.jspf"/>
<h2>Lista zwierzaków:</h2>

<div class="div1">

    <c:forEach items="${animals}" var="animal">
        Imię: ${animal.name} <br />
        Wiek: ${animal.estimateAge} <br />
        Gatunek: ${animal.animalType} <br />
        Rasa: ${animal.breed} <br />
        <br/><br/>
    </c:forEach>

</div>
<jsp:include page="../fragments/footer.jspf"/>
</body>
</html>