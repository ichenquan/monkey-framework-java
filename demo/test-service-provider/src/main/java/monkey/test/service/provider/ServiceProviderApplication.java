package monkey.test.service.provider;

import monkey.service.bus.server.ServiceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@ComponentScan(basePackages = {"monkey"})
@MapperScan(basePackages = {"monkey.test.data.mapper"}, sqlSessionFactoryRef = "dbSessionFactory")
public class ServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class, args);
        ServiceProvider.start();
    }
}
