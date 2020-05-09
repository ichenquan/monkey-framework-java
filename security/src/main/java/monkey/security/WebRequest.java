package monkey.security;

import org.apache.catalina.util.ParameterMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Map;

public class WebRequest extends HttpServletRequestWrapper {

    private ParameterMap<String, String[]> parameterMap = new ParameterMap<>();

    public WebRequest(HttpServletRequest request) {
        super(request);
        parameterMap.putAll(request.getParameterMap());
    }

    @Override
    public String getParameter(String name) {
        String[] values = parameterMap.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return parameterMap;
    }

    @Override
    public String[] getParameterValues(String name) {
        return parameterMap.get(name);
    }

    public void addParameter(String name, Object value) {
        if (value != null) {
            parameterMap.setLocked(false);
            if (value instanceof String[]) {
                parameterMap.put(name, (String[]) value);
            } else if (value instanceof String) {
                parameterMap.put(name, new String[]{(String) value});
            } else {
                parameterMap.put(name, new String[]{String.valueOf(value)});
            }
            parameterMap.setLocked(true);
        }
    }

}
