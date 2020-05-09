package monkey.common;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class UserCommandExecutor {

    private static Long threadPoolSize = 8L;
    private static Map<Long, ScheduledExecutorService> services = new ConcurrentHashMap<>();

    public static void start() {
        start(threadPoolSize);
    }

    public static void start(Long threadPoolSize) {
        UserCommandExecutor.threadPoolSize = threadPoolSize;
        for (Long i = 0L; i < threadPoolSize; i++) {
            ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder().namingPattern("user-command-%d").daemon(true).build());
            services.put(i, service);
        }
    }

    public static void execute(Long userId, Runnable command) {
        Long serviceId = Math.abs(userId) % threadPoolSize;
        ScheduledExecutorService service = services.get(serviceId);
        service.execute(command);
    }
}
