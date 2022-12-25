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
        <div class="flex flex-row min-h-screen max-h-fit bg-dark-700">
            <div class="flex flex-col m-2 pt-2 pb-6 pl-3 pr-6 h-fit rounded-lg bg-dark-400">
                <h1 class="text-light-100 text-2xl ">
                    Categories:
                </h1>
                <algebra:CategoryView contextPath="${pageContext.request.contextPath}" />
            </div>

            <div class="flex flex-row h-fit flex-wrap flex-grow justify-evenly">
                <algebra:CatalogProductView price="599.99" title="This is title" imageLink="IMG_8221"/>
                <algebra:CatalogProductView price="599.99" title="This is title" imageLink="IMG_8221"/>
                <algebra:CatalogProductView price="599.99" title="This is title" imageLink="IMG_8221"/>
                <algebra:CatalogProductView price="599.99" title="This is title" imageLink="IMG_8221"/>
                <algebra:CatalogProductView price="599.99" title="This is title" imageLink="IMG_8221"/>
                <algebra:CatalogProductView price="599.99" title="This is title" imageLink="IMG_8221"/>
                <algebra:CatalogProductView price="599.99" title="This is title" imageLink="IMG_8221"/>
                <algebra:CatalogProductView price="599.99" title="This is title" imageLink="IMG_8221"/>
                <algebra:CatalogProductView price="599.99" title="This is title" imageLink="IMG_8221"/>
            </div>
        </div>
    </body>
</html>
