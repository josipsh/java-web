<%@tag description="Creates a catalog product view" pageEncoding="UTF-8" %>

<%@attribute name="id" %>
<%@attribute name="imageLink" %>
<%@attribute name="title" %>
<%@attribute name="price" %>

<div class="max-w-xs h-fit bg-dark-400 rounded-lg shadow-md mt-4 mr-4 mb-4 ml-4">
    <a href="${pageContext.request.contextPath}/product?productId=${id}">
        <img class="rounded-t-lg" src="${pageContext.request.contextPath}/blob?name=${imageLink}" alt="Image"/>
    </a>
    <div class="px-5 pb-5">
        <h5 class="text-xl font-bold tracking-tight text-light-200 pt-3 pb-3">
            ${title}
        </h5>
        <div class="flex items-center justify-between">
            <span class="text-3xl font-bold text-light-50">
                $${price}
            </span>
            <button onclick="addToCart${id}()" id="add-btn-${id}"
                    class="w-fit text-primary-light bg-transparent border border-primary-light hover:bg-primary-dark hover:text-primary-light font-medium rounded-2xl text-sm px-5 py-2.5 mr-2 mb-2">
                Add to cart
            </button>
        </div>
    </div>
</div>
<script>
    function addToCart${id}() {
        const url = "${pageContext.request.contextPath}/cart?productId=1&quantity=2";
        let request = new XMLHttpRequest();
        request.open('POST', url, true);
        request.onload = function () {
            let addBtn = document.querySelector("#add-btn-${id}")
            addBtn.innerText = "Added"
        };

        request.onerror = function () {
        };

        request.send();
    }
</script>