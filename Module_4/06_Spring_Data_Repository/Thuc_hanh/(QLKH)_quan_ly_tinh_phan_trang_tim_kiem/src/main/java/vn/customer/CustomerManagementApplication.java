package vn.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import vn.customer.formatter.ProvinceFormatter;

@SpringBootApplication
public class CustomerManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerManagementApplication.class, args);
    }

//    @Configuration
//    static class MyConfig extends WebMvcConfigurerAdapter{
//        @Override
//        public void addFormatters(FormatterRegistry registry) {
//            registry.addFormatter(new ProvinceFormatter());
//        }
//    }
}
