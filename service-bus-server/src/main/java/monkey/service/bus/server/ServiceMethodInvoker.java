package monkey.service.bus.server;

import monkey.common.ObjectContainer;
import monkey.common.ObjectMapper;
import monkey.service.bus.common.ServiceParameter;
import monkey.service.bus.common.ServiceRequest;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceMethodInvoker {

    private static ConcurrentHashMap<String, Object> serviceObjects = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Class<?>> serviceClasses = new ConcurrentHashMap<>();

    public static String execute(ServiceRequest request) throws Throwable {
        Object serviceObject = null;
        Class<?> serviceClass = null;

        String serviceInterfaceName = request.getServiceInterfaceName();
        if (serviceObjects.containsKey(serviceInterfaceName)) {
            serviceObject = serviceObjects.get(serviceInterfaceName);
            serviceClass = serviceClasses.get(serviceInterfaceName);
        } else {
            serviceClass = getServiceClass(serviceInterfaceName);
            serviceObject = ObjectContainer.getObject(serviceClass);
            serviceObjects.put(serviceInterfaceName, serviceObject);
            serviceClasses.put(serviceInterfaceName, serviceClass);
        }

        String serviceMethodName = request.getServiceMethodName();
        List<ServiceParameter> serviceParameters = request.getServiceParameters();
        Class<?>[] serviceParameterTypes = new Class<?>[serviceParameters.size()];
        Object[] serviceParameterValues = new Object[serviceParameters.size()];

        int parameterIndex = 0;
        for (ServiceParameter parameter : serviceParameters) {
            Class<?> type = getServiceParameterType(parameter.getType());
            serviceParameterTypes[parameterIndex] = type;
            if (type == List.class) {
                int beginIndex = parameter.getType().indexOf("<") + 1;
                int endIndex = parameter.getType().indexOf(">");
                String className = parameter.getType().substring(beginIndex, endIndex);
                Class<?> clazz = Class.forName(className);
                Type listType = TypeToken.getParameterized(ArrayList.class, clazz).getType();
                listType = TypeToken.get(listType).getType();
                serviceParameterValues[parameterIndex] = ObjectMapper.fromJson(parameter.getValue(), listType);
            } else {
                serviceParameterValues[parameterIndex] = ObjectMapper.fromJson(parameter.getValue(), type);
            }

            parameterIndex++;
        }

        Method serviceMethod = serviceClass.getDeclaredMethod(serviceMethodName, serviceParameterTypes);
        Object serviceResult = serviceMethod.invoke(serviceObject, serviceParameterValues);
        String jsonServiceResult = ObjectMapper.toJson(serviceResult);

        return jsonServiceResult;
    }

    private static Class<?> getServiceParameterType(String type) throws Throwable {
        if (type.equals("boolean")) {
            return boolean.class;
        } else if (type.equals("int")) {
            return int.class;
        } else if (type.equals("long")) {
            return long.class;
        } else if (type.equals("double")) {
            return double.class;
        } else if (type.equals("float")) {
            return float.class;
        } else if (type.equals("short")) {
            return short.class;
        } else if (type.equals("byte")) {
            return byte.class;
        } else if (type.equals("char")) {
            return char.class;
        } else if (type.startsWith("java.util.List")) {
            return List.class;
        } else {
            return Class.forName(type);
        }
    }

    private static Class<?> getServiceClass(String serviceInterfaceName) throws Throwable {
        String serviceClassName = serviceInterfaceName.replace("contract", "provider");
        serviceClassName = serviceClassName + "Impl";
        Class<?> serviceClass = Class.forName(serviceClassName);
        return serviceClass;
    }
}
