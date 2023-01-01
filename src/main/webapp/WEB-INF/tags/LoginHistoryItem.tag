<%@ tag description="Creates a login history item" pageEncoding="UTF-8" %>

<%@attribute name="fullName" required="true" type="java.lang.String" %>
<%@attribute name="ipAddress" required="true" type="java.lang.String" %>
<%@attribute name="date" required="true" type="java.lang.String" %>

<div class="flex flex-wrap flex-row justify-between w-[56rem] m-4 p-4 h-fit bg-dark-900 rounded-lg">
    <h2 class="text-2xl font-light tracking-tight text-white h-fit mx-4 mb-2">
        ${fullName}
    </h2>
    <h2 class="text-2xl font-light tracking-tight text-white h-fit mx-4 mb-2">
        ${ipAddress}
    </h2>
    <h2 class="text-2xl font-light tracking-tight text-white h-fit mx-4 mb-2">
        ${date}
    </h2>
</div>