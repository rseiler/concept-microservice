package at.rseiler.concept.microservice.frontend;

import at.rseiler.concept.microservice.common.mvc.CommonWebMvcConfigurerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients({"at.rseiler.concept.microservice.client"})
@ComponentScan(basePackageClasses = {FrontendApplication.class})
public class FrontendApplication extends CommonWebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(FrontendApplication.class, args);
    }

}
