package hr.algebra.utils.helpers;

import javax.servlet.http.HttpServletRequest;

public class RouteParameterHelper {
    public static int getIntParameter(HttpServletRequest request, String parameterName){
        String value = request.getParameter(parameterName);
        return Integer.parseInt(value);
    }

    public static boolean getBooleanParameter(HttpServletRequest request, String parameterName){
        String value = request.getParameter(parameterName);
        return Boolean.parseBoolean(value);
    }
}
