<%@ page import="hr.algebra.viewModel.PageType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="algebra" uri="https://algebra.hr/web-shop" %>

<html>
<head>
    <title>Product</title>
    <link href="${pageContext.request.contextPath}/Styles/output.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/Styles/CustomStyleSheet.css" rel="stylesheet"/>
</head>
<body>
<algebra:NavigationHeader activePage="<%= PageType.Home %>"/>
<div class="flex flex-row justify-center min-h-screen max-h-fit bg-dark-700">
    <div class="flex flex-col m-2 pt-2 pb-6 pl-3 pr-6 h-fit rounded-lg bg-dark-400">
        <h1 class="text-light-100 text-2xl ">
            Categories:
        </h1>
        <algebra:CategoryView contextPath="${pageContext.request.contextPath}"/>
    </div>
    <div class="m-2">
        <a href="${pageContext.request.contextPath}/" class="flex p-3">
            <img src="${pageContext.request.contextPath}/Icons/arrow_left_24.svg" alt="left arrow"/>
            <h1 class="text-light-500 uppercase text-sm font-semibold self-center">Home</h1>
        </a>
        <div class="flex flex-col h-fit m-2 rounded-lg pt-4 pr-6 pb-4 pl-6 bg-dark-400">
            <div class="flex flex-row max-w-6xl rounded-lg bg-dark-900">
                <img class="max-w-xs h-full rounded-l-lg"
                     src="${pageContext.request.contextPath}/blob?name=${sessionScope.product.imageName}"
                     alt=""/>
                <!-- Product price and quantity -->
                <div class="flex flex-col flex-wrap justify-start h-full mt-4 mr-4 ml-4 leading-normal w-full">
                    <h5 class="mb-2 text-2xl font-semibold tracking-tight text-light-200">
                        ${sessionScope.product.title}
                    </h5>
                    <div class="flex flex-row flex-wrap flex-grow justify-between">
                        <div class="flex flex-row">
                            <label for="quantity" class="text-lg self-center pr-3 text-light-900">
                                Quantity
                            </label>
                            <input type="number" id="quantity"
                                   class="w-fit block bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
                                   value="1"/>
                        </div>
                        <!-- TotalPrice -->
                        <div class="flex flex-row">
                            <label class="text-lg self-center pr-3 text-light-900 ">
                                Total price:
                            </label>
                            <label id="totalPrice" class="text-2xl font-bold text-light-200">
                                $${sessionScope.product.price}
                            </label>
                        </div>
                    </div>

                    <!-- Price per item -->
                    <div class="flex flex-row mt-3">
                        <label class="text-lg self-center pr-3 text-light-900 ">
                            Item price:
                        </label>
                        <label class="text-2xl font-bold text-light-200">
                            $${sessionScope.product.price}
                        </label>
                    </div>
                    <!-- Add BTN -->
                    <div class="flex flex-row flex-wrap justify-end w-full my-3">
                        <button type="button"
                                class="w-fit text-primary-light bg-transparent border border-primary-light hover:bg-primary-dark hover:text-primary-light font-medium rounded-2xl text-sm px-5 py-2.5 mr-2">
                            Add to basket
                        </button>
                    </div>
                </div>
            </div>

            <!-- Description -->
            <div class="max-w-6xl rounded-lg mt-4 p-4 bg-dark-900">
                <h1 class="text-light-500 text-center text-2xl font-bold mb-3">Description</h1>
                <p class="text-light-500 text-center text-lg">
                    ${sessionScope.product.description}
                </p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
