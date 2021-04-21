package config;

import beans.*;
import beans.shopApp.Order;
import beans.shopApp.Product;
import org.springframework.context.annotation.*;

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

    @Bean
    public Product product(){
        return new Product("Cukier",3,4.0);
    }
    @Bean Product product_1(){
        return new Product("Masło",2,5.99);
    }
    @Bean
    public Order order(){
        return new Order();
    }

}
