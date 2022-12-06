<%@ page import="hr.algebra.viewModel.PageType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="algebra" uri="https://algebra.hr/web-shop" %>

<html>
    <head>
        <title>Profile</title>
        <link href="${pageContext.request.contextPath}/Styles/output.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/Styles/CustomStyleSheet.css" rel="stylesheet" />
    </head>
    <body>
        <algebra:NavigationHeader activePage="<%= PageType.Profile %>" />
        <h1>Profile</h1>
    </body>
</html>
