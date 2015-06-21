package at.rseiler.concept.microservice.client;

import at.rseiler.concept.microservice.model.ShoppingCart;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("shopping-cart-service")
public interface ShoppingCartClient {

    @RequestMapping(value = "shopping-cart-service/{id}", method = RequestMethod.GET)
    ShoppingCart getShoppingCart(@PathVariable("id") int id);

}
