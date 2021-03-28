package config;

import beans.MangerMemoryStudent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MangerMemoryStudent memoryStudent(){
        return new MangerMemoryStudent();
    }
}
