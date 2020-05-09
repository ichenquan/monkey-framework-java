package monkey.config.bus.client;

import monkey.common.ObjectContainer;
import monkey.common.Result;
import monkey.common.ObjectIdGenerator;
import monkey.config.bus.data.model.ScApplicationProperty;
import monkey.config.bus.client.service.ScApplicationPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;


public class ConfigBus {

    private static String applicationId = "";
    private static boolean isFirstStart = true;
    private static ScApplicationPropertyService scApplicationPropertyService;
    private final static Logger logger = LoggerFactory.getLogger(ConfigBus.class);
    private static boolean isDebugOpen = false;
    //配置总线服务器地址环境变量名称
    public static String SERVER_URL_ENV_VAR_NAME = "CONFIG_BUS_SERVER_URL";

    public static synchronized void start() {
        if (isFirstStart) {
            isFirstStart = false;
            ConfigBusConfiguration configuration = ObjectContainer.getObject(ConfigBusConfiguration.class);
            setApplicationId(configuration.getApplicationId());
            setApplicationPropertyService();
            setDataBus();
            isDebugOpen = configuration.getDebugModeOpen().equals("yes");
        }
    }

    public static void setApplicationId(String id) {
        applicationId = id;
    }

    public static String getApplicationId() {
        return applicationId;
    }

    private static void setDataBus() {
        String propertyId = "data.bus.group.id";
        Long dataCenterId = getApplicationPropertyValue(propertyId, Long.class);
        if (dataCenterId == null) {
            waringWhenPropertyNotFound(propertyId);
        }

        propertyId = "data.bus.member.id";
        Long workerId = getApplicationPropertyValue(propertyId, Long.class);
        if (workerId == null) {
            waringWhenPropertyNotFound(propertyId);
        }

        if (dataCenterId != null && workerId != null) {
            ObjectIdGenerator generator = ObjectContainer.getObject(ObjectIdGenerator.class);
            generator.setDataCenterId(dataCenterId);
            generator.setWorkerId(workerId);
        }
    }

    private static void setApplicationPropertyService() {
        scApplicationPropertyService = ObjectContainer.getObject(ScApplicationPropertyService.class);
    }

    public static String getPublicPropertyValue(String propertyId) {
        return getApplicationPropertyValue("public", propertyId);
    }

    public static String getApplicationPropertyValue(String propertyId) {
        return getApplicationPropertyValue(applicationId, propertyId);
    }

    public static <T> T getApplicationPropertyValue(String propertyId, Class<T> clazz) {
        return getApplicationPropertyValue(applicationId, propertyId, clazz);
    }

    public static String getApplicationPropertyValue(String applicationId, String propertyId) {
        String propertyValue = null;
        Result<ScApplicationProperty> result = scApplicationPropertyService.get(applicationId, propertyId);
        if (result == null) {
            ConfigBus.exit("请确认配置总线服务器已启动");
        }

        if (result.isSuccess()) {
            ScApplicationProperty data = result.getData();
            if (data != null) {
                propertyValue = data.getPropertyValue();
            }
        }
        return propertyValue;
    }

    public static <T> T getApplicationPropertyValue(String applicationId, String propertyId, Class<T> clazz) {
        String propertyValue = getApplicationPropertyValue(applicationId, propertyId);
        if (propertyValue == null) {
            return null;
        }

        T value = null;
        try {
            if (clazz.getTypeName().equals("java.lang.Long")) {
                value = clazz.cast(Long.valueOf(propertyValue));
            } else if (clazz.getTypeName().equals("java.math.BigDecimal")) {
                value = clazz.cast(new BigDecimal(propertyValue));
            } else if (clazz.getTypeName().equals("java.lang.Integer")) {
                value = clazz.cast(Integer.valueOf(propertyValue));
            } else if (clazz.getTypeName().equals("java.lang.Boolean")) {
                value = clazz.cast(Boolean.valueOf(propertyValue));
            } else if (clazz.getTypeName().equals("java.lang.String")) {
                value = clazz.cast(propertyValue);
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        return value;
    }

    public static void exitWhenPropertyNotFound(String propertyId) {
        String message = "缺少参数: " + propertyId + ", 程序被迫退出";
        logger.error(message);
        System.exit(0);
    }

    private static void exitWhenPropertyNotFound() {
        String message = "缺少参数，程序被迫退出";
        logger.error(message);
        System.exit(0);
    }

    public static void waringWhenPropertyNotFound(String propertyId) {
        String message = "缺少参数: " + propertyId;
        logger.warn(message);
    }

    private static void showProperties(List<ScApplicationProperty> properties) {
        logger.warn("请排查参数异常情况，这可能导致程序退出");
        logger.info("--------------------------------------");
        for (ScApplicationProperty property : properties) {
            String message = property.getPropertyId() + ": " + property.getPropertyValue();
            logger.info(message);
        }
        logger.info("--------------------------------------");
    }

    public static void exit(String cause) {
        logger.error("程序被迫退出: " + cause);
        System.exit(0);
    }

    public static void exitWhenPathNotFound(String type, String path) {
        logger.error("程序被迫退出: 未找到路由<" + type + "//:" + path + ">");
        System.exit(0);
    }

    public static void exitWhenClusterNotFound(String type, String clusterId) {
        logger.error("程序被迫退出: 未找到集群<" + type + "//:" + clusterId + ">");
        System.exit(0);
    }

    public static void waring(String cause) {
        logger.warn(cause);
    }


    public static void showSelectedPath(String host, int port, String serviceInterfaceName) {
        if (isDebugOpen) {
            logger.info("service://" + host + ":" + port + "|" + serviceInterfaceName);
        }
    }

    public static int getPort(String applicationId) {
        return 0;
    }
}
