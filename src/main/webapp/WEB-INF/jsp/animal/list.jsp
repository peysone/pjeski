<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <title>Animal list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<section id="home" class="section">
    <h2>Lista zwierzaków:</h2>
    <c:if test="${empty animals}">
        <h3>Nie znaleziono zwierzaka!</h3>
    </c:if>
    <%--Teoretycznie można to wyrzucić bo do wyboru są tylko miasta z listy schronisk--%>
    <%--<c:if test="${empty shelters}">--%>
    <%--<h3>Nie znaleziono zwierząt w danym mieście!</h3>--%>
    <%--</c:if>--%>

    <div id="container_kafelka">


    <c:forEach items="${animals}" var="animal">
        <div class="kafelka">


        <a><b>${animal.animalType} ${animal.name} </b></a><br/>
        <a><b>Wiek: </b></a>${animal.estimatedAge} <br/>
        <a><b> Płeć: </b></a>${animal.animalSex} <br>
            <c:if test="${empty animal.photos}">
                <a style="font-size:16px"><b>.</b></a>
            </c:if>
            <c:forEach var="photoDTO" items="${animal.photos}">
                <a>${photoDTO.animal.id}</a>
                <a>${photoDTO.photoId}</a>
                <%--dla każdego zdjęcia pobierz wartość photoDTO i wyświetl nazwę
                a ma być wyświetl tylko pierwszą nazwę--%>

                <a><img src="<c:url value="/resources/photos/thumbnails/${firstPhoto}"/>"/></a><br/>

                <%--<img src="/resources/photos/thumbnails/${photoDTO.fileName}"> <br/>--%>
            </c:forEach>

        <%--<a><b> Zdjęcie: </b></a><img src="/photos/${animal.photos.get(0)}" height="300" width="300"> <br/>--%>
            <a><b>Ilość zdjęć:</b></a>${animal.photos.size()}
        <%--<img src="/resources/photos/thumbnails/${photoDTO.fileName}"/>--%>
        <a><b> Opis: </b></a>${animal.description} <br/>
        <a><b> Rasa: </b></a>${animal.breed} <br/>
        <a><b> Schronisko:</b></a> ${animal.shelter.name}<br/>
        <a><b> Miasto: </b></a>${animal.shelter.city}<br/>
        <a><b> Do adopcji: </b></a>${animal.isAvailableToAdoption ? 'Tak' : 'Nie'}<br/>
        <a><b> Na spacer:</b></a> ${animal.isAvailableForAWalk ? 'Tak' : 'Nie'}<br/>
        <a href="/animal/visit/${animal.id}">Umów wizytę</a><br/>
        <sec:authorize access = "hasRole('ADMIN')">
        <a href="/animal/edit/${animal.id}">Edycja zwierzaka</a>
        <a href="/animal/delete/${animal.id}">Usun zwierzaka</a>
        </sec:authorize>
        <%--${shelter.animals.size()}--%>
        <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
            <input type="hidden" name="cmd" value="_s-xclick" />
            <input type="hidden" name="hosted_button_id" value="ZGSZZ82JYVZGJ" />
            <input type="image" src="https://www.paypalobjects.com/pl_PL/PL/i/btn/btn_donateCC_LG.gif" border="0" name="submit" title="PayPal - The safer, easier way to pay online!" alt="Przekaż darowiznę za pomocą przycisku PayPal" />
            <img alt="" border="0" src="https://www.paypal.com/pl_PL/i/scr/pixel.gif" width="1" height="1" />
        </form>

        </div>



    </c:forEach>


        <div style="clear: both">
            <table width="1000" border="0" cellpadding="6" cellspacing="0" bgcolor="#ffddcc" align="center">
                <tr>
                    <td width="300" align="left">
                        <s:message code="info.page"/> ${currentPage} <s:message code="info.from"/> ${totalPages}
                    </td>
                    <td align="right">

                        <c:if test="${currentPage > 1}">
                            <input type="button"
                                   onclick="window.location.href='${pageContext.request.contextPath}/animal/list/${currentPage - 1}'"
                                   value="<s:message code="link.poprzedni"/>"/>&nbsp;&nbsp;
                        </c:if>

                        <c:if test="${currentPage < totalPages}">
                            <input type="button"
                                   onclick="window.location.href='${pageContext.request.contextPath}/animal/list/${currentPage + 1}'"
                                   value="<s:message code="link.nastepny"/>"/>
                        </c:if>

                    </td>
                </tr>
            </table>

        </div>
    </div>

</section>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>