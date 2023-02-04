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
        <form method="get" action="${pageContext.request.contextPath}/checkout">
            <div class="flex flex-row justify-center min-h-screen max-h-fit bg-dark-700">
                <div class="flex flex-col w-6xl h-fit m-2 rounded-lg pt-2 pr-4 pb-4 pl-4 bg-dark-400">
                    <c:forEach items="${sessionScope.cart}" var="cartItem">
                        <algebra:CartItem
                                id="${cartItem.id}"
                                numberOfItems="${cartItem.quantity}"
                                itemPrice="${cartItem.product.price}"
                                title="${cartItem.product.title}"
                                imageName="${cartItem.product.imageName}"
                                isEditable="${true}"/>
                    </c:forEach>
                    <c:if test="${sessionScope.cart.size() == 0 || sessionScope.cart == null}">
                        <label class="text-lg font-bold text-light-100">
                            Nothing to show
                        </label>
                    </c:if>
                </div>
                <div class="flex flex-col max-w-6xl h-fit m-2 rounded-lg pt-2 pr-4 pb-4 pl-4 bg-dark-400">
                    <div>
                        <label class="text-lg font-bold text-light-100">
                            Total checkout price:
                        </label>
                        <label class="text-2xl font-bold text-light-100 ml-4">
                            $${sessionScope.totalPrice}
                        </label>
                    </div>
                    <button type="submit"
                            class="text-primary-light bg-transparent border border-primary hover:bg-primary-dark hover:text-primary-light font-medium rounded-2xl text-lg py-2 mt-4">
                        CHECKOUT
                    </button>
                </div>
            </div>
        </form>
    </body>
</html>
