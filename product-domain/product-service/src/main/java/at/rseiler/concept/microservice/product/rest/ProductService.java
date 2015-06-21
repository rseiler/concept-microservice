package at.rseiler.concept.microservice.product.rest;

import at.rseiler.concept.microservice.client.ProductClient;
import at.rseiler.concept.microservice.model.Product;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductService implements ProductClient {

    private static final Logger LOG = Logger.getLogger(ProductService.class);

    @Override
    public Product getProduct(@PathVariable("id") int id) {
        LOG.info("getproduct(" + id + ")");

        switch (id) {
            case 1:
                return new Product(1, "keyboard", 10);
            case 2:
                return new Product(2, "cpu", 250);
            case 3:
                return new Product(3, "mouse", 8);
            default:
                return null;
        }
    }

}
