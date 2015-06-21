package at.rseiler.concept.microservice.frontend.controller;

import at.rseiler.concept.microservice.client.UserHystrixClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class);

    private final UserHystrixClient userClient;

    @Autowired
    public UserController(UserHystrixClient userClient) {
        this.userClient = userClient;
    }

    @RequestMapping("user/{id}")
    public String getUser(ModelMap modelMap, @PathVariable("id") int id) {
        LOG.info("getUser(" + id + ")");

        modelMap.put("user", userClient.getUser(id));
        return "user";
    }

}
