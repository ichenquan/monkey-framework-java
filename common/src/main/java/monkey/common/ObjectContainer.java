package monkey.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * FileName: ObjectContainer
 * Description: 对象容器
 * Author: ChenQ
 * Date: 2020/4/28
 */
@Component
public class ObjectContainer implements ApplicationContextAware {
    /**
     * 上下文对象实例
     */
    private static org.springframework.context.ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ObjectContainer.applicationContext = applicationContext;
    }


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getObject(String name) {
        return getApplicationContext().getBean(name);
    }


    public static <T> T getObject(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }


    public static <T> T getObject(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
