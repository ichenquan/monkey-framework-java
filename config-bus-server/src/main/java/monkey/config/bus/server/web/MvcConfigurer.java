package monkey.config.bus.server.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * Method：configureMessageConverters
     * Description: HTTP请求返回内容格式开启自定义，LONG转STRING
     * Author: ChenQ
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
        //builder.serializationInclusion(JsonInclude.Include.NON_EMPTY);

        //自定义Long类型转换 超过12个数字用String格式返回，由于js的number只能表示15个数字
        builder.serializerByType(Long.class, new LongSerializer());
        builder.serializerByType(Long.TYPE, new LongSerializer());
        builder.serializerByType(Date.class, new DateSerializer());
        //自定义BigDecimal类型转换
        builder.serializerByType(BigDecimal.class, new BigDecimalSerializer());
        converters.add(0, new MappingJackson2HttpMessageConverter(builder.build()));
    }

    /**
     * Method：addCorsMappings
     * Description: 跨域请求配置
     * Author: ChenQ
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .exposedHeaders("token");
    }

    /**
     * Description: 取消后缀匹配
     * Author: ChenQ
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

}
