package monkey.config.bus.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * FileName: DBConfigInfo
 * Description:
 * Author: ChenQ
 * Date: 2020/4/28
 */
@Component
@ConfigurationProperties(prefix = "config.bus.db")
public class DatabaseConfiguration {

    private String url;

    private String user;

    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
