<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Animal list</title>
</head>
<body>
<jsp:include page="../fragments/header.jspf"/>
<h2>Lista zwierzaków:</h2>
<c:forEach items="${animals}" var="animal">
    Imię: ${animal.name} <br />
    Wiek: ${animal.age} <br />
    Rodzaj: ${animal.type} <br /> <%--gatunek -> rodzaj--%>
    Rasa: ${animal.breed} <br />
    <br/><br/>
</c:forEach>
<jsp:include page="../fragments/footer.jspf"/>
</body>
</html>