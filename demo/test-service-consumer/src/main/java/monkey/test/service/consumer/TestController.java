package monkey.test.service.consumer;

import lombok.extern.slf4j.Slf4j;
import monkey.service.bus.client.ServiceBus;
import monkey.test.data.model.TestCity;
import monkey.test.service.contract.HelloService;
import monkey.test.service.contract.TestCityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;


@Slf4j
@RestController
public class TestController {

    private HelloService helloService = ServiceBus.create(HelloService.class);
    private TestCityService testCityService = ServiceBus.create(TestCityService.class);

    @RequestMapping("/say")
    public String say(String words) {
        String result = helloService.say(words);
        return result;
    }

    @RequestMapping("/save")
    public String save(String name) {
        TestCity created = new TestCity();
        created.setName(name);
        created.setRemark(Calendar.getInstance().getTime().toString());
        testCityService.save(created);
        return name;
    }

    @RequestMapping("/delete")
    public Long delete(Long id) {
        testCityService.delete(id);
        return id;
    }
}
