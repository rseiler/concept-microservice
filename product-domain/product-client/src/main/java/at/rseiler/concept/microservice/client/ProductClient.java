package at.rseiler.concept.microservice.client;

import at.rseiler.concept.microservice.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("product-service")
public interface ProductClient {

    @RequestMapping(value = "product-service/{id}", method = RequestMethod.GET)
    Product getProduct(@PathVariable("id") int id);

}
