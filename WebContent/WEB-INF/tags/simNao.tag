<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="value" required="true" %>

<c:choose>
    <c:when test="${value == true}">
		SIM
    </c:when>
    <c:otherwise>
        N�O
    </c:otherwise>
</c:choose>