package at.rseiler.concept.microservice.client;

import at.rseiler.concept.microservice.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user-service")
public interface UserClient {

    @RequestMapping(value = "user-service/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") int id);

}
