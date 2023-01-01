<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="hr.algebra.viewModel.PageType" %>
<%@ taglib prefix="algebra" uri="https://algebra.hr/web-shop" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login history</title>
    <link href="${pageContext.request.contextPath}/Styles/output.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/Styles/CustomStyleSheet.css" rel="stylesheet"/>
</head>
<body>
<algebra:NavigationHeader activePage="<%= PageType.LoginHistory %>"/>

<div class="flex flex-col justify-start items-center min-h-screen max-h-fit w-screen bg-dark-700">
    <div class="flex flex-wrap flex-col justify-center w-fit h-fit  rounded-lg bg-dark-400">
        <c:forEach items="${sessionScope.loginRecords}" var="record">
            <algebra:LoginHistoryItem
                    fullName="${record.user.firstName} ${record.user.lastName}"
                    ipAddress="${record.ipAddress}"
                    date="${record.loggedInAt}"/>
        </c:forEach>
    </div>
</div>
</body>
</html>
