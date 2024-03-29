<%@tag description="Creates a cart item" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="id" required="true" type="java.lang.String" %>
<%@attribute name="numberOfItems" required="true" type="java.lang.String" %>
<%@attribute name="imageName" required="true" type="java.lang.String" %>
<%@attribute name="itemPrice" required="true" type="java.lang.String" %>
<%@attribute name="title" required="true" type="java.lang.String" %>
<%@attribute name="isEditable" required="true" type="java.lang.Boolean" %>


<div class="flex flex-row max-w-6xl m-2 rounded-lg bg-dark-900">
    <img class="max-w-xs h-full rounded-l-lg"
         src="${pageContext.request.contextPath}/blob?name=${imageName}"
         alt=""/>
    <!-- Product price and quantity -->
    <div class="flex flex-col flex-wrap justify-start h-full mt-4 mr-4 ml-4 leading-normal w-full">
        <h5 class="mb-2 text-2xl font-semibold tracking-tight text-light-200">
            ${title}
        </h5>
        <div class="flex flex-row flex-wrap flex-grow justify-between">
            <div class="flex flex-row">
                <label for="quantity-${id}" class="text-lg self-center pr-3 text-light-900">
                    Quantity
                </label>
                <c:if test="${isEditable}">
                    <input type="number" id="quantity-${id}"
                           class="w-fit block bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
                           value="${numberOfItems}"/>
                </c:if>
                <c:if test="${!isEditable}">
                    <input type="number" id="quantity-${id}"
                           class="w-fit block bg-dark-600 text-light-100 placeholder:text-light-900 text-sm rounded-lg p-2.5"
                           value="${numberOfItems}" disabled/>
                </c:if>

            </div>
            <!-- TotalPrice -->
            <div class="flex flex-row pl-4">
                <label class="text-lg self-center pr-3 text-light-900 ">
                    Total price:
                </label>
                <label id="total-price-${id}" class="text-2xl font-bold text-light-200">

                </label>
            </div>
        </div>

        <!-- Price per item -->
        <div class="flex flex-row mt-3">
            <label class="text-lg self-center pr-3 text-light-900 ">
                Item price:
            </label>
            <label class="text-2xl font-bold text-light-200">
                $${itemPrice}
            </label>
        </div>
        <c:if test="${isEditable}">
            <!-- Add BTN -->
            <div class="flex flex-row flex-wrap justify-end w-full my-3">
                <button type="button" onclick="deleteFormCart${id}()"
                        class="w-fit text-negative bg-transparent border border-negative hover:bg-primary-dark hover:text-negative font-medium rounded-2xl text-sm px-5 py-2.5 mr-2">
                    Remove
                </button>
            </div>
        </c:if>
    </div>
</div>
<script>
    let totalPrice${id} = document.querySelector("#total-price-${id}")
    let quantityInputField${id} = document.querySelector("#quantity-${id}")
    totalPrice${id}.innerText = "$" + calculatePrice(quantityInputField${id}.value, ${itemPrice});

    quantityInputField${id}.addEventListener('change', () => {
        if (quantityInputField${id}.value < 1) {
            quantityInputField${id}.value = 1
            return
        }
        totalPrice${id}.innerText = "$" + calculatePrice(quantityInputField${id}.value, ${itemPrice})

        const url${id} = "${pageContext.request.contextPath}/cart?basketId=${id}&quantity=" + quantityInputField${id}.value;
        let request${id} = new XMLHttpRequest();
        request${id}.open('PUT', url${id}, true);
        request${id}.onload = function () {
            window.location.reload();
        };

        request${id}.onerror = function () {
        };

        request${id}.send();
    })

    function deleteFormCart${id}() {
        const url = "${pageContext.request.contextPath}/cart?basketId=${id}";
        let request = new XMLHttpRequest();
        request.open('DELETE', url, true);
        request.onload = function () {
            window.location.reload();
        };

        request.onerror = function () {
        };

        request.send();
    }

    function calculatePrice(quantity, price){
        return quantity * price;
    }
</script>