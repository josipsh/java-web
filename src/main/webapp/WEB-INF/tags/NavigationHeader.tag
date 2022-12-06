<%@tag  description="Creates a sentence case based on a sentence" pageEncoding="UTF-8"%>

<nav class="bg-gray-900 px-2 py-2.5">
    <div class="container flex flex-wrap items-center justify-between mx-auto">
        <a href="#" class="flex items-center">
            <img src="https://flowbite.com/docs/images/logo.svg" class="h-6 mr-3 sm:h-9" alt="logo" />
            <span class="self-center text-xl font-semibold whitespace-nowrap dark:text-white">WebShop</span>
        </a>
        <div class="hidden w-full md:block md:w-auto" id="navbar-default">
            <ul class="flex flex-row space-x-8 text-xl font-medium">
                <li>
                    <a href="${pageContext.request.contextPath}/cart"
                       class="block p-4 text-gray-400 hover:text-gray-200">
                        Cart
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/profile"
                       class="block p-4 text-gray-400 hover:text-gray-200">
                        Profile
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>