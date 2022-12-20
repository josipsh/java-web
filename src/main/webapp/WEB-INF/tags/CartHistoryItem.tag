<%@tag  description="Creates a cart Hystory item" pageEncoding="UTF-8"%>

<%@attribute name="id" required="true" type="java.lang.String" %>
<%@attribute name="numberOfItems" required="true" type="java.lang.String" %>
<%@attribute name="paymentType" required="true" type="java.lang.String" %>
<%@attribute name="totalAmount" required="true" type="java.lang.String" %>
<%@attribute name="purchaseDate" required="true" type="java.lang.String" %>

<div class="flex flex-wrap flex-row justify-start w-[56rem] mx-4 mt-4">
    <!-- Title -->
    <div id="card-title-${id}" class="flex flex-row bg-dark-900 border-b-2 border-light-900 rounded-t-lg w-full h-fit">
        <button id="expandButton-${id}" class="flex pl-1 items-center" type="button">
            <img src="${pageContext.request.contextPath}/Icons/expand-less.svg" alt="expend" />
        </button>
        <div class="flex flex-grow flex-row flex-wrap justify-between w-full pt-2 pr-4">
            <h2 class="mb-2 text-2xl font-light tracking-tight text-light-200 mr-4 ml-4">
                ${numberOfItems} Items
            </h2>
            <h2 class="mb-2 text-2xl font-light tracking-tight text-light-200 mr-4 ml-4">
                ${paymentType} - $${totalAmount}
            </h2>
            <h2 class="mb-2 text-2xl font-light tracking-tight text-light-200 mr-4 ml-4">
                ${  purchaseDate}
            </h2>
        </div>
    </div>
    <!-- Content -->
    <div id="items-${id}" class="flex flex-col items-center h-36 bg-dark-900 rounded-b-lg md:flex-row">
        <img class="max-w-xs h-full rounded-bl-lg" src="${pageContext.request.contextPath}/Images/IMG_8202.JPG" alt="" />
        <div class="flex flex-col h-full mt-4 mr-4 ml-4 leading-normal max-w-lg">
            <h5 class="mb-2 text-2xl font-bold tracking-tight text-light-100">
                Noteworthy technology acquisitions 2021
            </h5>
        </div>

        <div class="flex flex-col h-full mt-4 mr-4 ml-4 justify-items-center leading-normal w-96">
            <!-- Quantity -->
            <div class="flex flex-row pr-3 h-fit w-fit">
                <label for="quantity" class="text-sm font-medium self-center mr-3 text-light-100">
                    Quantity
                </label>
                <input type="number" id="quantity" class="w-fit block p-2.5 text-sm bg-dark-600 text-light-100 rounded-lg"
                       value="2" disabled />
            </div>
            <!-- Price per item -->
            <div>
                <label class="text-sm font-medium text-light-100">
                    Item price:
                </label>
                <label class="text-sm font-medium text-light-100">
                    7659.35$
                </label>
            </div>
            <!-- Total price -->
            <div>
                <label class="text-sm font-medium text-light-100">
                    Total price:
                </label>
                <label class="text-sm font-medium text-light-100">
                    7659.35$
                </label>
            </div>
        </div>
    </div>
</div>
<script>
    const expandButton${id} = document.querySelector("#expandButton-${id}");
    const items${id} = document.querySelector("#items-${id}");
    const cardTitle${id} = document.querySelector("#card-title-${id}");
    if (expandButton${id} == null) {
        console.log("Unable to load expandButton element!");
    }
    expandButton${id} === null || expandButton${id} === void 0 ? void 0 : expandButton${id}.addEventListener("click", () => {
        if (items${id} == null || cardTitle${id} == null) {
            console.log("Unable to load items and/or card element!");
            return;
        }
        if (items${id}.classList.contains("flex")) {
            items${id}.classList.remove("flex");
            items${id}.classList.add("hidden");
            cardTitle${id}.classList.add("rounded-b-lg");
            cardTitle${id}.classList.remove("border-b-2");
            putExpandMoreIcon${id}();
        }
        else {
            items${id}.classList.add("flex");
            items${id}.classList.remove("hidden");
            cardTitle${id}.classList.remove("rounded-b-lg");
            cardTitle${id}.classList.add("border-b-2");
            putExpandLessIcon${id}();
        }
    });
    function putExpandMoreIcon${id}() {
        const imgElement${id} = expandButton${id} === null || expandButton${id} === void 0 ? void 0 : expandButton${id}.childNodes[1];
        if (imgElement${id} == null) {
            console.log("Unable to load imgElement.");
            return;
        }
        imgElement${id}.src = imgElement${id} === null || imgElement${id} === void 0 ? void 0 : imgElement${id}.src.replace("less", "more");
    }
    function putExpandLessIcon${id}() {
        const imgElement${id} = expandButton${id} === null || expandButton${id} === void 0 ? void 0 : expandButton${id}.childNodes[1];
        if (imgElement${id} == null) {
            console.log("Unable to load imgElement.");
            return;
        }
        imgElement${id}.src = imgElement${id} === null || imgElement${id} === void 0 ? void 0 : imgElement${id}.src.replace("more", "less");
    }
</script>