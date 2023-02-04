<%@tag description="Creates a shop option item" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="id" required="true" type="java.lang.String" %>
<%@attribute name="shopName" required="true" type="java.lang.String" %>
<%@attribute name="address" required="true" type="java.lang.String" %>
<%@attribute name="city" required="true" type="java.lang.String" %>
<%@attribute name="postcode" required="true" type="java.lang.String" %>
<%@attribute name="optionName" required="true" type="java.lang.String" %>

<input type="radio" id="hosting-small-${id}" name="${optionName}" value="${id}"
       class="hidden peer" required>
<label for="hosting-small-${id}"
       class="inline-flex items-center justify-between w-full p-5 text-light-200 bg-dark-700 border border-dark-100 rounded-lg cursor-pointer peer-checked:border-light-500 hover:text-light-100 hover:bg-dark-600">
    <div class="block">
        <div class="w-full text-lg font-semibold">${shopName}</div>
        <div class="w-full text-lg">Address: ${address}</div>
        <div class="w-full text-lg">City: ${city}</div>
        <div class="w-full text-lg">Postcode: ${postcode}</div>
    </div>
</label>