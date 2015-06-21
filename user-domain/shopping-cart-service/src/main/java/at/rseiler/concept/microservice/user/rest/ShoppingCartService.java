package at.rseiler.concept.microservice.user.rest;

import at.rseiler.concept.microservice.client.ShoppingCartClient;
import at.rseiler.concept.microservice.model.ShoppingCart;
import at.rseiler.concept.microservice.model.ShoppingCartItem;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@RestController
public class ShoppingCartService implements ShoppingCartClient {

    private static final Logger LOG = Logger.getLogger(ShoppingCartService.class);

    @Override
    public ShoppingCart getShoppingCart(@PathVariable("id") int id) {
        LOG.info("getShoppingCart(" + id + ")");

        switch (id) {
            case 1:
                return new ShoppingCart(1, 1, "computer", Arrays.asList(
                        new ShoppingCartItem(1, 1, new Date(1420113600000L)),
                        new ShoppingCartItem(2, 2, new Date(1420117200000L))
                ));
            case 2:
                return new ShoppingCart(2, 1, "mouse", Arrays.asList(
                        new ShoppingCartItem(3, 3, new Date(1420113600000L))
                ));
            case 3:
                return new ShoppingCart(3, 2, "my cart", Arrays.asList(
                        new ShoppingCartItem(4, 1, new Date(1420113600000L)),
                        new ShoppingCartItem(4, 2, new Date(1420113700000L)),
                        new ShoppingCartItem(2, 3, new Date(1420117200000L))
                ));
            default:
                return new ShoppingCart(-1, -1, "", new ArrayList<>());
        }
    }
}
