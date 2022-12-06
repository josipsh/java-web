<%@tag  description="Creates a catalog product view" pageEncoding="UTF-8"%>

<%@attribute name="imageLink" %>
<%@attribute name="title" %>
<%@attribute name="price" %>

<div class="max-w-xs h-fit bg-slate-500 rounded-lg shadow-md mt-4 mr-4 mb-4 ml-4">
    <img class="rounded-t-lg" src="${imageLink}" alt="Image"/>
    <div class="px-5 pb-5">
        <h5 class="text-xl font-bold tracking-tight text-gray-900 pt-3 pb-3">
            ${title}
        </h5>
        <div class="flex items-center justify-between">
            <span class="text-3xl font-bold text-gray-900 dark:text-white">
                ${price}
            </span>
            <button class="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center">
                Add to cart
            </button>
        </div>
    </div>
</div>