package monkey.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ObjectIdConfiguration {

    @Bean
    public ObjectIdGenerator createObjectIdGenerator(@Value("${data.bus.member.id:0}") long workerId, @Value("${data.bus.group.id:0}") long dataCenterId) {
        return new ObjectIdGenerator(workerId, dataCenterId);
    }
}
