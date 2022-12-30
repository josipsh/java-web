<%@ tag description="Creates a sentence case based on a sentence" pageEncoding="UTF-8" %>
<%@ tag import="hr.algebra.viewModel.PageType" %>
<%@ taglib prefix="algebra" uri="https://algebra.hr/web-shop" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="activePage" required="true" type="hr.algebra.viewModel.PageType" %>

<nav class="bg-dark-900 px-2 py-2.5">
    <div class="container flex flex-wrap items-center justify-between mx-auto">
        <a href="${pageContext.request.contextPath}/"
           class="flex items-center">
            <img src="https://flowbite.com/docs/images/logo.svg" class="h-6 mr-3 sm:h-9" alt="logo"/>
            <span class="self-center text-xl font-semibold whitespace-nowrap text-light-500">WebShop</span>
        </a>
        <div class="hidden w-full md:block md:w-auto" id="navbar-default">
            <ul class="flex flex-row space-x-8 text-xl font-medium">
                <li>
                    <a href="${pageContext.request.contextPath}/"
                            <algebra:IsLinkActive
                                    active="${activePage}"
                                    current="<%= PageType.Home %>"
                                    activeColorClass="class=\"block p-4 text-light-50 hover:text-light-900\""
                                    passiveColorClass="class=\"block p-4 text-light-500 hover:text-light-900\""/>>
                        Home
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/cart"
                            <algebra:IsLinkActive
                                    active="${activePage}"
                                    current="<%= PageType.Cart %>"
                                    activeColorClass="class=\"block p-4 text-light-50 hover:text-light-900\""
                                    passiveColorClass="class=\"block p-4 text-light-500 hover:text-light-900\""/>>
                        Cart
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/profile"
                            <algebra:IsLinkActive
                                    active="${activePage}"
                                    current="<%= PageType.Profile %>"
                                    activeColorClass="class=\"block p-4 text-light-50 hover:text-light-900\""
                                    passiveColorClass="class=\"block p-4 text-light-500 hover:text-light-900\""/>>
                        Profile
                    </a>
                </li>
                <c:if test="${user.role.name == 'ADMIN'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/login-history"
                                <algebra:IsLinkActive
                                        active="${activePage}"
                                        current="<%= PageType.LoginHistory %>"
                                        activeColorClass="class=\"block p-4 text-light-50 hover:text-light-900\""
                                        passiveColorClass="class=\"block p-4 text-light-500 hover:text-light-900\""/>>
                            Login history
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/order-history"
                                <algebra:IsLinkActive
                                        active="${activePage}"
                                        current="<%= PageType.OrderHistory %>"
                                        activeColorClass="class=\"block p-4 text-light-50 hover:text-light-900\""
                                        passiveColorClass="class=\"block p-4 text-light-500 hover:text-light-900\""/>>
                            Order history
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/edit/category"
                                <algebra:IsLinkActive
                                        active="${activePage}"
                                        current="<%= PageType.CategoryEditor %>"
                                        activeColorClass="class=\"block p-4 text-light-50 hover:text-light-900\""
                                        passiveColorClass="class=\"block p-4 text-light-500 hover:text-light-900\""/>>
                            Category editor
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/edit/product"
                                <algebra:IsLinkActive
                                        active="${activePage}"
                                        current="<%= PageType.ProductEditor %>"
                                        activeColorClass="class=\"block p-4 text-light-50 hover:text-light-900\""
                                        passiveColorClass="class=\"block p-4 text-light-500 hover:text-light-900\""/>>
                            Product editor
                        </a>
                    </li>
                </c:if>
                <c:if test="${user == null}">
                    <li>
                        <a href="${pageContext.request.contextPath}/auth/logout"
                           class="block p-4 text-light-500 hover:text-light-900">
                            Logout
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>