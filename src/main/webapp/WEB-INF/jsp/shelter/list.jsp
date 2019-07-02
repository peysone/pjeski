<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Shelter list</title>
</head>
<body>
<jsp:include page="../fragments/header.jspf"/>
<h2>Lista schronisk:</h2>
<c:forEach items="${shelters}" var="shelter">
    Nazwa schroniska: ${shelter.name} <br />
    Adres: ${shelter.address} <br />
    Kod pocztowy: ${shelter.postalCode} <br />
    Miasto: ${shelter.city} <br />
    Numer telefonu: ${shelter.telephone} <br />
    Numer konta bankowego: ${shelter.accountNumber} <br />
    <br/><br/>
</c:forEach>
<jsp:include page="../fragments/footer.jspf"/>
</body>
</html>
