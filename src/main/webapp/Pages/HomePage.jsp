<%@ page import="hr.algebra.viewModel.PageType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="algebra" uri="https://algebra.hr/web-shop" %>

<html>
    <head>
        <title>Home</title>
        <link href="${pageContext.request.contextPath}/Styles/output.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/Styles/CustomStyleSheet.css" rel="stylesheet" />
    </head>
    <body>
        <algebra:NavigationHeader activePage="<%= PageType.Home %>" />
        <div class="flex flex-row min-h-screen max-h-fit">
            <algebra:CategoryView />
            <div class="flex flex-wrap flex-grow justify-evenly bg-green-500">
                <algebra:CatalogProductView price="599.99" title="This is title" imageLink="file:///D:/_ucenje/6_semestar/javaWeb/ProjectFrontEnd/images/IMG_8221.JPG"/>
            </div>
        </div>
    </body>
</html>
