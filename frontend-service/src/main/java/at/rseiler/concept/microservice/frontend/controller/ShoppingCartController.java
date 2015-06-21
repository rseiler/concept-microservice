package at.rseiler.concept.microservice.frontend.controller;

import at.rseiler.concept.microservice.frontend.service.DisplayShoppingCartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {

    private static final Logger LOG = Logger.getLogger(ShoppingCartController.class);

    private final DisplayShoppingCartService displayShoppingCartService;

    @Autowired
    public ShoppingCartController(DisplayShoppingCartService displayShoppingCartService) {
        this.displayShoppingCartService = displayShoppingCartService;
    }

    @RequestMapping("shopping-cart/{id}")
    public String getShoppingCart(ModelMap modelMap, @PathVariable("id") int id) {
        LOG.info("getShoppingCart(" + id + ")");

        modelMap.put("shoppingCart", displayShoppingCartService.getShoppingCart(id));
        return "shopping-cart";
    }

}
