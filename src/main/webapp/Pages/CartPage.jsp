<%@ page import="hr.algebra.viewModel.PageType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="algebra" uri="https://algebra.hr/web-shop" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Cart</title>
        <link href="${pageContext.request.contextPath}/Styles/output.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/Styles/CustomStyleSheet.css" rel="stylesheet"/>
    </head>
    <body>
        <algebra:NavigationHeader activePage="<%= PageType.Cart %>"/>
        <div class="flex flex-row justify-center min-h-screen max-h-fit bg-dark-700">
            <div class="flex flex-col max-w-6xl h-fit m-2 rounded-lg pt-2 pr-4 pb-2 pl-4 bg-dark-400">
                <c:forEach items="${sessionScope.cart}" var="cartItem">
                    <algebra:CartItem
                            id="${cartItem.id}"
                            numberOfItems="${cartItem.quantity}"
                            itemPrice="${cartItem.product.price}"
                            title="${cartItem.product.title}"
                            imageName="${cartItem.product.imageName}" />
                </c:forEach>
            </div>
        </div>
    </body>
</html>
