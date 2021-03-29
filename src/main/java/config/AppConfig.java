package config;

import beans.LogService;
import beans.MangerMemoryStudent;
import beans.SimpleLogTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public LogService logService(){
        return new SimpleLogTime();
    }
    @Bean
    public MangerMemoryStudent memoryStudent(){
        return new MangerMemoryStudent(logService());
    }
}
