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

        <div class="flex flex-row justify-center min-h-screen max-h-fit bg-dark-700">
            <!-- Profile info -->

            <div class="grid grid-cols-2-auto gap-2 h-fit m-2 rounded-lg pt-4 pr-6 pb-4 pl-6 bg-dark-400">
                <label for="firstName" class="w-full mb-2 text-sm text-right self-center font-medium text-light-200">
                    Email:
                </label>
                <input type="text" id="firstName"
                       class="w-96 bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5" placeholder="pero.peric@gmail.com"
                       required value="${sessionScope.user.email}" />
                <label for="middleName" class="w-full mb-2 text-sm text-right self-center font-medium mr-4 text-light-200">
                    First name:
                </label>
                <input type="text" id="middleName"
                       class="w-96 bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5" placeholder="Pero"
                       required value="${sessionScope.user.firstName}" />
                <label for="lastName" class="w-full mb-2 text-sm text-right self-center font-medium mr-4 text-light-200">
                    Last name:
                </label>
                <input type="text" id="lastName"
                       class="w-96 bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5" placeholder="Peric"
                       required value="${sessionScope.user.lastName}" />
                <div class="col-span-2 flex flex-wrap justify-between pt-3">
                    <button type="button"
                            class="w-fit text-secondary-light bg-transparent border border-negative hover:bg-negative hover:text-white font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Delete account
                    </button>

                    <button type="button"
                            class="w-fit text-secondary-light bg-transparent border border-secondary-light hover:bg-secondary-dark hover:text-dark-900 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Change password
                    </button>

                    <button type="button"
                            class="w-fit text-secondary-light bg-transparent border border-secondary-light hover:bg-secondary-dark hover:text-dark-900 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Update account
                    </button>
                </div>
            </div>

            <div class="flex flex-wrap flex-col justify-start max-w-full h-fit m-2 pb-3 rounded-lg bg-dark-400">
                <algebra:CartHistoryCard id="1" purchaseDate="01-02-2022" totalAmount="200" paymentType="PayPal" numberOfItems="1" />
                <algebra:CartHistoryCard id="2" purchaseDate="02-02-2022" totalAmount="300" paymentType="PayPal" numberOfItems="1" />
                <algebra:CartHistoryCard id="3" purchaseDate="03-02-2022" totalAmount="400" paymentType="PayPal" numberOfItems="1" />
            </div>
        </div>
    </body>
</html>
