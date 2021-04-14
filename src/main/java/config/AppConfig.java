package config;

import beans.*;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "config")
public class AppConfig {

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
