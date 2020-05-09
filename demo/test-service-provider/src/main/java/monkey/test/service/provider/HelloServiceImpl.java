package monkey.test.service.provider;

import monkey.test.service.contract.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String words) {
        log.info(words);
        return words;
    }
}
