package monkey.service.bus.client;

import java.lang.reflect.Proxy;

public class ServiceClient<T> {

    private Class<T> clazz;
    private ServiceInvocationHandler handler;
    private long timeout = 30000;

    public ServiceClient(Class<T> clazz) {
        this.clazz = clazz;
    }

    public ServiceClient<T> setTimeout(long value) {
        this.timeout = value;
        if (this.timeout < 0) {
            this.timeout = 30000;
        }
        return this;
    }

    public T newInstance() {
        ServiceInvocationHandler handler = new ServiceInvocationHandler(clazz.getName());
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, handler);
    }
}
