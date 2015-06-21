package at.rseiler.concept.microservice.frontend.service;

import at.rseiler.concept.microservice.frontend.model.DisplayShoppingCart;
import at.rseiler.concept.microservice.frontend.model.DisplayShoppingCartItem;
import at.rseiler.concept.microservice.client.ProductClient;
import at.rseiler.concept.microservice.model.Product;
import at.rseiler.concept.microservice.client.ShoppingCartHystrixClient;
import at.rseiler.concept.microservice.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisplayShoppingCartService {

    private final ShoppingCartHystrixClient shoppingCartClient;
    private final ProductClient productClient;

    @Autowired
    public DisplayShoppingCartService(ShoppingCartHystrixClient shoppingCartClient, ProductClient productClient) {
        this.shoppingCartClient = shoppingCartClient;
        this.productClient = productClient;
    }

    public DisplayShoppingCart getShoppingCart(int id) {
        ShoppingCart shoppingCart = shoppingCartClient.getShoppingCart(id);
        List<DisplayShoppingCartItem> items = shoppingCart.getItems().stream().map(shoppingCartItem -> {
            Product product = productClient.getProduct(shoppingCartItem.getIdProduct());
            String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(shoppingCartItem.getCreationDate());
            return new DisplayShoppingCartItem(shoppingCartItem.getId(), product, creationDate);
        }).collect(Collectors.toList());
        return new DisplayShoppingCart(shoppingCart.getId(), shoppingCart.getIdUser(), shoppingCart.getName(), items);
    }

}
