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

<div class="flex flex-row justify-center min-h-screen max-h-fit bg-dark-700">
    <div class="grid grid-cols-2-auto gap-2 h-fit m-2 rounded-lg pt-4 pr-6 pb-4 pl-6 bg-dark-400">
        <label  class="w-full mb-2 text-sm text-right self-center font-medium text-light-200">
            Category edit
        </label>
    </div>
</div>
</body>
</html>
