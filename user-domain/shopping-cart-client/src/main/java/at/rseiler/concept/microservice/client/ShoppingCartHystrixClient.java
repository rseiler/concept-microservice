package at.rseiler.concept.microservice.client;

import at.rseiler.concept.microservice.model.ShoppingCart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ShoppingCartHystrixClient {

    private final ShoppingCartClient shoppingCartClient;

    @Autowired
    public ShoppingCartHystrixClient(ShoppingCartClient shoppingCartClient) {
        this.shoppingCartClient = shoppingCartClient;
    }

    @HystrixCommand(groupKey = "shopping-cart-service", commandKey = "getShoppingCart", fallbackMethod = "getShoppingCartFallback")
    public ShoppingCart getShoppingCart(@PathVariable("id") int id) {
        return shoppingCartClient.getShoppingCart(id);
    }

    public ShoppingCart getShoppingCartFallback(int id) {
        return null;
    }

}
