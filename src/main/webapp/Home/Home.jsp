<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="https://algebra.hr/jwp" prefix="jwp" %>--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
  <H1>This is Home page</H1>
    <h2>How are you</h2>

<%--    <jwp:test name="Pero" />--%>

    <c:if test="${Ime != null}">
        <h1>Test he 2</h1>
    </c:if>

    <c:forEach var="item" items="${list}" begin="0" step="1" >
        <h1> ${item} </h1>
    </c:forEach>
</body>
</html>
