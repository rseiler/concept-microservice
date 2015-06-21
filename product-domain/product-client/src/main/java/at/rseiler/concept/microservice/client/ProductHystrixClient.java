package at.rseiler.concept.microservice.client;

import at.rseiler.concept.microservice.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductHystrixClient {

    private final ProductClient productClient;

    @Autowired
    public ProductHystrixClient(ProductClient productClient) {
        this.productClient = productClient;
    }

    @HystrixCommand(groupKey = "product-service", commandKey = "getProduct", fallbackMethod = "getProductFallback")
    public Product getProduct(int id) {
        return productClient.getProduct(id);
    }

    public Product getProductFallback(int id) {
        return null;
    }

}
