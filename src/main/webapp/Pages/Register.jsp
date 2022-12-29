<%@ page import="hr.algebra.viewModel.PageType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="algebra" uri="https://algebra.hr/web-shop" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Register</title>
    <link href="${pageContext.request.contextPath}/Styles/output.css" rel="stylesheet"/>
</head>
<body>
<algebra:NavigationHeader activePage="<%= PageType.Register %>"/>

<div class="flex flex-row justify-center pt-4 min-h-screen max-h-fit bg-dark-700">

    <form   action="${pageContext.request.contextPath}/auth/register"
            method="post"
            class="grid grid-cols-2-auto gap-2 h-fit w-fit rounded-lg pt-4 pr-6 pb-4 pl-6 bg-dark-400">
        <label for="firstName" class="w-full text-sm text-right self-center font-medium text-light-200">
            First name:
        </label>
        <input type="text" id="firstName" name="firstName"
               class="w-96 bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
               placeholder="John" required/>
        <label for="lastName" class="w-full text-sm text-right self-center font-medium text-light-200">
            Last name:
        </label>
        <input type="text" id="lastName" name="lastName"
               class="w-96 bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
               placeholder="John" required/>
        <label for="userName" class="w-fulltext-sm text-right self-center font-medium text-light-200">
            User name:
        </label>
        <input type="text" id="userName" name="userName"
               class="w-96 bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
               placeholder="John" required/>
        <label for="email" class="w-fulltext-sm text-right self-center font-medium text-light-200">
            Email:
        </label>
        <input type="text" id="email" name="email"
               class="w-96 bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
               placeholder="John" required/>
        <div class="col-span-2 flex flex-wrap justify-end pt-3">
            <button type="button"
                    class="w-fit text-secondary-light bg-transparent border border-negative hover:bg-negative hover:text-white font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                Cancel
            </button>

            <button type="submit"
                    class="w-fit text-secondary-light bg-transparent border border-primary hover:bg-primary-dark hover:text-light-00 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                Register
            </button>
        </div>
    </form>
</div>
</body>
</html>
