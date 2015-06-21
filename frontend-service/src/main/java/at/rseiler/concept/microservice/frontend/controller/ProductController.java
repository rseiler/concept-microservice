package at.rseiler.concept.microservice.frontend.controller;

import at.rseiler.concept.microservice.client.ProductHystrixClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    private static final Logger LOG = Logger.getLogger(ProductController.class);

    private final ProductHystrixClient productClient;

    @Autowired
    public ProductController(ProductHystrixClient productClient) {
        this.productClient = productClient;
    }

    @RequestMapping("product/{id}")
    public String getProduct(ModelMap modelMap, @PathVariable("id") int id) {
        LOG.info("getProduct(" + id + ")");

        modelMap.put("product", productClient.getProduct(id));
        return "product";
    }

}
