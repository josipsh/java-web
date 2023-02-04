<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="hr.algebra.viewModel.PageType" %>
<%@ taglib prefix="algebra" uri="https://algebra.hr/web-shop" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Order history</title>
      <link href="${pageContext.request.contextPath}/Styles/output.css" rel="stylesheet" />
      <link href="${pageContext.request.contextPath}/Styles/CustomStyleSheet.css" rel="stylesheet" />
    </head>
    <body>
        <algebra:NavigationHeader activePage="<%= PageType.OrderHistory %>" />

        <div class="flex flex-row justify-center pt-4 min-h-screen max-h-fit bg-dark-700">
            <!-- Listed orders -->
            <div class="flex flex-col justify-start w-fit h-fit rounded-md bg-dark-400">
                <!-- Filter -->
                <div class="grid grid-cols-4-auto gap-2 p-2 m-4 bg-dark-700">
                    <label class="w-full mb-2 text-sm text-right self-center font-medium mr-4 text-light-200">
                        First name:
                    </label>
                    <input type="text" id="firstName"
                           class="w-64 bg-dark-400 border border-dark-400 text-light-200 text-sm rounded-lg p-2.5"
                           placeholder="John" required />
                    <label class="w-full mb-2 text-sm text-right self-center font-medium mr-4 text-light-200">
                        Last name:
                    </label>
                    <input type="text" id="dateStart"
                           class="w-64 bg-dark-400 border border-dark-400 text-light-200 text-sm rounded-lg p-2.5"
                           placeholder="John" required />
                    <label class="w-full mb-2 text-sm text-right self-center font-medium mr-4 text-light-200">
                        Date start:
                    </label>
                    <input type="text" id="dateEnd"
                           class="w-64 bg-dark-400 border border-dark-400 text-light-200 text-sm rounded-lg p-2.5"
                           placeholder="John" required />

                    <label class="w-full mb-2 text-sm text-right self-center font-medium mr-4 text-light-200">
                        Date end:
                    </label>
                    <input type="text" id="lastName"
                           class="w-64 bg-dark-400 border border-dark-400 text-light-200 text-sm rounded-lg p-2.5"
                           placeholder="John" required />
                    <button
                            class="col-span-4 w-full text-secondary-light bg-transparent border border-secondary-light hover:bg-secondary-dark hover:text-dark-900 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Filter
                    </button>

                </div>
                <!-- Order List -->
                <div class="flex flex-col items-center h-fit my-2 mx-4 bg-dark-700 rounded-full md:flex-row max-w-4xl">
                    <div class="flex flex-wrap flex-grow flex-row justify-between p-4 h-fit">
                        <h2 class="mb-2 text-2xl font-light tracking-tight text-light-200 mr-4 ml-4">
                            Pero peric
                        </h2>
                        <h2 class="mb-2 text-2xl font-light tracking-tight text-light-200 mr-4 ml-4">
                            20.03.2022
                        </h2>
                    </div>
                </div>
                <div class="flex flex-col items-center h-fit my-2 mx-4 bg-dark-700 rounded-full md:flex-row max-w-4xl">
                    <div class="flex flex-wrap flex-grow flex-row justify-between p-4 h-fit">
                        <h2 class="mb-2 text-2xl font-light tracking-tight text-light-200 mr-4 ml-4">
                            Pero peric
                        </h2>
                        <h2 class="mb-2 text-2xl font-light tracking-tight text-light-200 mr-4 ml-4">
                            20.03.2022
                        </h2>
                    </div>
                </div>
                <div class="flex flex-col items-center h-fit my-2 mx-4 bg-dark-700 rounded-full md:flex-row max-w-4xl">
                    <div class="flex flex-wrap flex-grow flex-row justify-between p-4 h-fit">
                        <h2 class="mb-2 text-2xl font-light tracking-tight text-light-200 mr-4 ml-4">
                            Pero peric
                        </h2>
                        <h2 class="mb-2 text-2xl font-light tracking-tight text-light-200 mr-4 ml-4">
                            20.03.2022
                        </h2>
                    </div>
                </div>
            </div>
            <!-- Order diteils -->
            <div class="flex flex-col justify-start w-fit h-fit ml-4 p-4 rounded-md bg-dark-400">
                <!-- User info -->
                <div class="flex flex-row justify-between mb-4 bg-dark-900">
                    <label class="w-fit mb-2 text-sm text-right font-medium mr-4 text-light-200">
                        Pero Peric
                    </label>
                    <label class="w-fit mb-2 text-sm text-right font-medium mr-4 text-light-200">
                        20.03.2022
                    </label>
                </div>
                <!-- Basket items -->
                <div class="flex flex-col items-center h-36 mb-4 bg-dark-700 rounded-lg md:flex-row md:max-w-4xl">
                    <img class="max-w-xs h-full rounded-l-lg" src="${pageContext.request.contextPath}/blob?name=products/IMG_8201.jpg" alt="" />
                    <div class="flex flex-col h-full mt-4 mr-4 ml-4 leading-normal max-w-lg">
                        <h5 class="mb-2 text-2xl font-bold tracking-tight text-light-200">
                            Noteworthy technology acquisitions 2021
                        </h5>
                    </div>

                    <div class="flex flex-col h-full mt-4 mr-4 ml-4 justify-items-center leading-normal w-96">
                        <!-- Quantity -->
                        <div class="flex flex-row pr-3 h-fit w-fit">
                            <label for="quantity"
                                   class="text-sm font-medium self-center mr-3 text-light-200">
                                Quantity
                            </label>
                            <input type="number" id="quantity1"
                                   class="w-fit block bg-dark-400 border border-dark-400 text-light-200 text-sm rounded-lg p-2.5"
                                   value="2" disabled />
                        </div>
                        <!-- Price per item -->
                        <div>
                            <label class="text-sm font-medium text-gray-900 dark:text-white">
                                Item price:
                            </label>
                            <label class="text-sm font-medium text-gray-900 dark:text-white">
                                7659.35$
                            </label>
                        </div>
                        <!-- Total price -->
                        <div>
                            <label class="text-sm font-medium text-light-200">
                                Total price:
                            </label>
                            <label class="text-sm font-medium text-light-200">
                                7659.35$
                            </label>
                        </div>
                    </div>
                </div>
                <div class="flex flex-col items-center h-36 mb-4 bg-dark-700 rounded-lg md:flex-row md:max-w-4xl">
                    <img class="max-w-xs h-full rounded-l-lg" src="${pageContext.request.contextPath}/blob?name=products/IMG_8202.jpg" alt="" />
                    <div class="flex flex-col h-full mt-4 mr-4 ml-4 leading-normal max-w-lg">
                        <h5 class="mb-2 text-2xl font-bold tracking-tight text-light-200">
                            Noteworthy technology acquisitions 2021
                        </h5>
                    </div>

                    <div class="flex flex-col h-full mt-4 mr-4 ml-4 justify-items-center leading-normal w-96">
                        <!-- Quantity -->
                        <div class="flex flex-row pr-3 h-fit w-fit">
                            <label for="quantity"
                                   class="text-sm font-medium self-center mr-3 text-light-200">
                                Quantity
                            </label>
                            <input type="number" id="quantity"
                                   class="w-fit block bg-dark-400 border border-dark-400 text-light-200 text-sm rounded-lg p-2.5"
                                   value="2" disabled />
                        </div>
                        <!-- Price per item -->
                        <div>
                            <label class="text-sm font-medium text-light-200">
                                Item price:
                            </label>
                            <label class="text-sm font-medium text-light-200">
                                7659.35$
                            </label>
                        </div>
                        <!-- Total price -->
                        <div>
                            <label class="text-sm font-medium text-light-200">
                                Total price:
                            </label>
                            <label class="text-sm font-medium text-light-200">
                                7659.35$
                            </label>
                        </div>
                    </div>
                </div>
                <!-- Payment details -->
                <div class="flex flex-row justify-between h-fit p-4 mb-4 bg-dark-700 rounded-lg md:flex-row md:max-w-4xl">
                    <label class="text-light-200">
                        Pyment type
                    </label>
                    <label class="text-light-200">
                        PayPal
                    </label>
                </div>
                <!-- Shipping details details -->
                <div class="flex flex-row justify-between  h-fit p-4 bg-dark-700 rounded-lg md:flex-row md:max-w-4xl">
                    <label class="text-light-200">
                        Shipping details
                    </label>
                    <label class="text-light-200">
                        Collecting
                    </label>
                </div>
            </div>
        </div>
    </body>
</html>
