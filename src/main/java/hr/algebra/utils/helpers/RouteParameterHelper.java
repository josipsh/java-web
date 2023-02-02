package hr.algebra.utils.helpers;

import javax.servlet.http.HttpServletRequest;

public class RouteParameterHelper {
    public static int getIntParameter(HttpServletRequest request, String parameterName){
        String productId = request.getParameter(parameterName);
        return Integer.parseInt(productId);
    }
}
