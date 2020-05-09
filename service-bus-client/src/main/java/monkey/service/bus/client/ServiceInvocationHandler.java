package monkey.service.bus.client;

import monkey.common.ObjectMapper;
import monkey.common.Result;
import monkey.common.StatusCode;
import monkey.service.bus.common.ServiceRequest;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ServiceInvocationHandler implements InvocationHandler {

    private String serviceInterfaceName;

    public ServiceInvocationHandler(String serviceInterfaceName) {
        this.serviceInterfaceName = serviceInterfaceName;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            ServiceRequest request = ServiceRequestBuilder.create(proxy, method, args, serviceInterfaceName);
            String jsonResult = ServiceRequestExecutor.execute(request);
            Type type = TypeToken.get(method.getGenericReturnType()).getType();
            Object result = ObjectMapper.fromJson(jsonResult, type);
            return result;
        } catch (Throwable t) {
            String message = getMessage(t);
            return new Result(StatusCode.SERVICE_CONSUMER_ERROR, message);
        }
    }

    private String getMessage(Throwable t) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        t.printStackTrace(printStream);
        String result = new String(outputStream.toByteArray());
        try {
            printStream.close();
            outputStream.close();
            return result;
        } catch (Exception e) {
            return "";
        }
    }
}
