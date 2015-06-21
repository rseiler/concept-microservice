package at.rseiler.concept.microservice.user;

import at.rseiler.concept.microservice.common.mvc.CommonWebMvcConfigurerAdapter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients({"at.rseiler.whms.client"})
public class UserApplication extends CommonWebMvcConfigurerAdapter {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UserApplication.class).run(args);
    }

}
