package monkey.common;

import java.util.Iterator;
import java.util.Map;

//应用程序模式
public class ApplicationMode {

    private static int id = 0;
    private static String name = "";
    private static String k8sFullName = "KUBERNETES";

    private static void check() {
        if (id == 0) {
            Map<String, String> map = System.getenv();
            for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
                String key = iterator.next();
                if (key.startsWith(k8sFullName)) {
                    //找到K8S相关的环境变量：应用程序模式即为K8S，否则为FAST
                    id = 1;
                    name = "K8S";
                    break;
                }
            }
        }

        if (id == 0) {
            id = 2;
            name = "FAST";
        }
    }

    public static boolean isK8s() {
        check();
        return id == 1;
    }

    public static String getName() {
        return name;
    }

    public static boolean isFast() {
        check();
        return id == 2;
    }
}
