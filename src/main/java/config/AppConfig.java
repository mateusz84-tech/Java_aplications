package config;

import beans.*;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "java")
public class AppConfig{

    @Bean
    public LogService logService(){
        return new SimpleLogTime();
    }
    @Bean
    public LogService fileLogService(){
        return new FileLogTime("log.txt");
    }
    @Bean
    public MangerMemoryStudent memoryStudent(){
        return new MangerMemoryStudent(fileLogService());
    }

    @Bean
    public Quote quote(){
        return new Quote();
    }

}
