package monkey.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Date;
import java.util.List;


@Configuration
public class WebCustomizer implements WebMvcConfigurer {

    @Autowired
    private WebAuthenticator authenticator;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    //HTTP请求返回内容格式开启自定义
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);

        //自定义Long类型转换 超过12个数字用String格式返回，由于js的number只能表示15个数字
        builder.serializerByType(Long.class, new LongSerializer());
        builder.serializerByType(Long.TYPE, new LongSerializer());
        builder.serializerByType(Date.class, new DateSerializer());
        //自定义BigDecimal类型转换
        converters.add(0, new MappingJackson2HttpMessageConverter(builder.build()));
    }

    //跨域请求配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .exposedHeaders("token");
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticator).addPathPatterns("/**");
    }

    //取消后缀匹配
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

}
