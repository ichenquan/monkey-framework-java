package monkey.service.bus.client;

import monkey.common.ObjectMapper;
import monkey.service.bus.common.ServiceParameter;
import monkey.service.bus.common.ServiceRequest;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ServiceRequestBuilder {

    public static ServiceRequest create(Object proxy, Method method, Object[] args, String serviceInterfaceName) {
        ServiceRequest request = new ServiceRequest();
        request.setServiceInterfaceName(serviceInterfaceName);
        request.setServiceMethodName(method.getName());

        int parameterIndex = 0;
        Class<?>[] parameterTypes = method.getParameterTypes();
        List<ServiceParameter> parameters = new ArrayList<>();

        int genericParameterIndex = 0;
        for (Class<?> clazz : parameterTypes) {
            ServiceParameter parameter = new ServiceParameter();
            String type = clazz.getTypeName();

            if (isBasicType(type)) {
                genericParameterIndex++;
            } else if (isListType(type)) {
                Type genericParameterType = method.getGenericParameterTypes()[genericParameterIndex];
                type = genericParameterType.getTypeName();
                genericParameterIndex++;
            }

            parameter.setType(type);
            String value = ObjectMapper.toJson(args[parameterIndex]);
            parameter.setValue(value);
            parameterIndex += 1;
            parameters.add(parameter);
        }
        request.setServiceParameters(parameters);
        return request;
    }

    private static String basicTypes = "java.lang.String,java.lang.Byte,byte,java.lang.Short,short,java.lang.Integer,int,java.lang.Long,long,java.lang.Float,float,java.lang.Double,double,java.lang.Character,char";

    private static boolean isBasicType(String type) {
        return basicTypes.contains(type);
    }

    private static boolean isListType(String type) {
        return type.equals("java.util.List");
    }
}
