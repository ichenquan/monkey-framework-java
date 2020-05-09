package monkey.data.bus.client;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DbCommandExecutor {

    @Pointcut("execution(public * monkey.common.DbMapper.*(..))")
    public void selectNode() {

    }

    @Around("selectNode()")
    public Object execute(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String commandName = method.getName();
        DbDataSourceScheduler.select(commandName);
        Object result = point.proceed();
        return result;
    }
}
