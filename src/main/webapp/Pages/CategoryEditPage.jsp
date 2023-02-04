<%@ page import="hr.algebra.viewModel.PageType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="algebra" uri="https://algebra.hr/web-shop" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Category edit</title>
      <link href="${pageContext.request.contextPath}/Styles/output.css" rel="stylesheet" />
      <link href="${pageContext.request.contextPath}/Styles/CustomStyleSheet.css" rel="stylesheet" />
    </head>
    <body>
        <algebra:NavigationHeader activePage="<%= PageType.CategoryEditor %>" />
        <div class="flex flex-row justify-center pt-4 min-h-screen max-h-fit bg-dark-700">

            <div class="flex flex-col justify-start w-fit h-fit rounded-md bg-dark-400">
                <!-- Category edito -->
                <div class="grid grid-cols-3-auto gap-2 p-4 m-4 bg-dark-700">
                    <h1 class="col-span-3 text-light-200 text-lg font-semibold">
                        Category editor:
                    </h1>
                    <label class="w-fit mb-2 text-sm text-right self-center font-medium mr-4 text-light-200 text-lg">
                        Choose category:
                    </label>
                    <input type="text" id="Category"
                           class="col-span-2 w-full bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
                           placeholder="choose category" required />
                    <input type="text" id="categoryName"
                           class="col-span-3 w-full bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
                           placeholder="insert category" required />

                    <button
                            class="w-fit text-secondary-light bg-transparent border border-negative hover:bg-negative hover:text-white font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Delete
                    </button>

                    <button
                            class="w-fit text-secondary-light bg-transparent border border-secondary-light hover:bg-secondary-dark hover:text-dark-900 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Update
                    </button>

                    <button
                            class="w-fit text-secondary-light bg-transparent border border-secondary-light hover:bg-secondary-dark hover:text-dark-900 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Create
                    </button>
                </div>

                <!-- Subcategory editor -->
                <div class="grid grid-cols-3-auto gap-2 p-4 m-4 bg-dark-700">
                    <h1 class="col-span-3 text-light-200 text-lg font-semibold">
                        Subcategory editor:
                    </h1>
                    <label class="w-fit mb-2 text-sm text-right self-center font-medium mr-4 text-light-200">
                        Choose category:
                    </label>
                    <input type="text" id="categoryChooser"
                           class="col-span-2 w-full bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
                           placeholder="Choose category" required />
                    <label class="w-fit mb-2 text-sm text-right self-center font-medium mr-4 text-light-200">
                        Choose subcategory:
                    </label>
                    <input type="text" id="SubcategoryChooser"
                           class="col-span-2 w-full bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
                           placeholder="Choose subcategory" required />
                    <input type="text" id="SubcategoryName"
                           class="col-span-3 w-full bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
                           placeholder="Insert subcategory" required />

                    <button
                            class="w-fit text-secondary-light bg-transparent border border-negative hover:bg-negative hover:text-white font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Delete
                    </button>

                    <button
                            class="w-fit text-secondary-light bg-transparent border border-secondary-light hover:bg-secondary-dark hover:text-dark-900 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Update
                    </button>

                    <button
                            class="w-fit text-secondary-light bg-transparent border border-secondary-light hover:bg-secondary-dark hover:text-dark-900 font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                        Create
                    </button>
                </div>
            </div>
        </div>
    </body>
</html>
