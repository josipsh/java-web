<%@ page import="hr.algebra.viewModel.PageType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="algebra" uri="https://algebra.hr/web-shop" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Order</title>
        <link href="${pageContext.request.contextPath}/Styles/output.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/Styles/CustomStyleSheet.css" rel="stylesheet"/>
    </head>
    <body>
    <algebra:NavigationHeader activePage="<%= PageType.ORDER %>" />
        <form action="${pageContext.request.contextPath}/checkout" method="post">
            <div class="flex flex-row justify-center min-h-screen max-h-fit bg-dark-700">
                <div class="flex flex-wrap flex-col justify-start max-w-full h-fit m-2 pb-3 rounded-lg bg-dark-400">
                    <c:forEach items="${sessionScope.cart}" var="cartItem">
                        <algebra:CartItem
                                id="${cartItem.id}"
                                numberOfItems="${cartItem.quantity}"
                                itemPrice="${cartItem.product.price}"
                                title="${cartItem.product.title}"
                                imageName="${cartItem.product.imageName}"
                                isEditable="${false}"/>
                    </c:forEach>
                </div>

                <!-- Shipping method -->
                <div class="flex flex-wrap flex-col justify-start max-w-full h-fit m-2 p-4 rounded-lg bg-dark-400">
                    <h1 class="text-2xl font-semibold tracking-tight text-light-200">
                        Shipping details
                    </h1>
                    <div class="flex flex-row my-4">
                        <label class="text-lg text-light-200">
                            Do you want to pick up order by yourself?
                        </label>
                        <div class="flex items-center ml-4">
                            <input id="yes" type="radio" value="true" name="isUserPickingUp" required
                                   class="w-4 h-4 text-light-900 bg-light-200 border-light-200 focus:ring-light-900 focus:ring-2">
                            <label for="yes" class="ml-2 text-lg font-medium text-light-200">Yes</label>
                        </div>
                        <div class="flex items-center ml-4">
                            <input id="no" type="radio" value="false" name="isUserPickingUp" required
                                   class="w-4 h-4 text-light-900 bg-light-200 border-light-200 focus:ring-light-900 focus:ring-2">
                            <label for="no" class="ml-2 text-lg font-medium text-light-200">No</label>
                        </div>
                    </div>
                    <div class="">
                        <ul class="grid w-full gap-6 md:grid-cols-2">
                            <c:forEach items="${sessionScope.orderPickupDetails}" var="item">
                                <li>
                                    <algebra:ShopNameOption
                                            id="${item.id}"
                                            shopName="${item.shopName}"
                                            address="${item.streetAddress}"
                                            city="${item.city}"
                                            postcode="${item.zipcode}"
                                            optionName="store"/>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

                <!-- Payment method -->
                <div class="flex flex-wrap flex-col justify-start max-w-full h-fit m-2 p-4 rounded-lg bg-dark-400">
                    <h1 class="text-2xl font-semibold tracking-tight text-light-200">
                        Payment details
                    </h1>
                    <div class="flex flex-row justify-between my-4">
                        <label class="text-lg text-light-200">
                            Total price:
                        </label>
                        <label class="text-2xl text-light-200 font-semibold">
                            $${sessionScope.totalPrice}
                        </label>
                    </div>
                    <div class="flex flex-row">
                        <label for="payment-method" class="font-medium text-light-200">
                            Payment menthod:
                        </label>
                        <select id="payment-method" name="payment-method"
                                class="bg-dark-700 border border-dark-100 text-light-200 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2">
                            <c:forEach items="${sessionScope.paymentMethods}" var="paymentMethod">
                                <option value="${paymentMethod.id}">${paymentMethod.type}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit"
                            class="text-primary bg-transparent border border-primary-light hover:bg-primary-dark hover:text-primary-light font-medium rounded-2xl text-lg px-5 py-2.5 mt-4">
                        Buy
                    </button>
                </div>
            </div>

        </form>
    </body>
</html>
