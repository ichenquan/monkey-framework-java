package monkey.service.bus.server;

import lombok.extern.slf4j.Slf4j;
import monkey.common.ObjectMapper;
import monkey.common.Result;
import monkey.common.StatusCode;
import monkey.service.bus.common.ServiceRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

@Slf4j
@RestController
public class ServiceRequestHandler {

    @RequestMapping("/ping")
    public String ping() {
        return "Server time is: " + Calendar.getInstance().getTime();
    }

    @RequestMapping("/execute")
    public String execute(String request) {
        try {
            String jsonResult = ServiceMethodInvoker.execute(ObjectMapper.fromJson(request, ServiceRequest.class));
            return jsonResult;
        } catch (Throwable t) {
            t.printStackTrace();
            return ObjectMapper.toJson(new Result(StatusCode.SERVICE_PROVIDER_ERROR, getMessage(t)));
        }
    }

    private String getMessage(Throwable t) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        t.printStackTrace(printStream);
        String result = new String(outputStream.toByteArray());
        try {
            printStream.close();
            outputStream.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
