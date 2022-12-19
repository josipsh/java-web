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

        <div class="flex flex-row justify-center min-h-screen max-h-fit">
            <div class="grid grid-cols-2-auto gap-2 h-fit m-2 rounded-lg pt-4 pr-6 pb-4 pl-6 bg-gray-500">
                <label for="firstName" class="w-full mb-2 text-sm text-right self-center font-medium text-gray-900">
                    First name:
                </label>
                <input type="text" id="firstName"
                       class="w-96 bg-gray-700 border border-gray-900 text-gray-100 text-sm rounded-lg p-2.5" placeholder="John"
                       required />
                <label for="middleName" class="w-full mb-2 text-sm text-right self-center font-medium mr-4 text-gray-900">
                    Middle name:
                </label>
                <input type="text" id="middleName"
                       class="w-96 bg-gray-700 border border-gray-900 text-gray-100 text-sm rounded-lg p-2.5" placeholder="Middle"
                       required />
                <label for="lastName" class="w-full mb-2 text-sm text-right self-center font-medium mr-4 text-gray-900">
                    Last name:
                </label>
                <input type="text" id="lastName"
                       class="w-96 bg-gray-700 border border-gray-900 text-gray-100 text-sm rounded-lg p-2.5" placeholder="John"
                       required />
                <label for="userName" class="w-full mb-2 text-sm text-right self-center font-medium mr-4 text-gray-900">
                    User name:
                </label>
                <input type="text" id="userName"
                       class="w-96 bg-gray-700 border border-gray-900 text-gray-100 text-sm rounded-lg p-2.5" placeholder="John"
                       required />
                <div class="col-span-2 flex flex-wrap justify-between pt-3">
                    <button type="button"
                            class="w-fit text-white bg-red-700 hover:bg-red-800 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Delete account
                    </button>

                    <button type="button"
                            class="w-fit text-white bg-red-700 hover:bg-red-800 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Change password
                    </button>

                    <button type="button"
                            class="w-fit text-white bg-red-700 hover:bg-red-800 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Update account
                    </button>
                </div>
            </div>

        </div>
    </body>
</html>
