package at.rseiler.concept.microservice.user.rest;

import at.rseiler.concept.microservice.client.UserClient;
import at.rseiler.concept.microservice.model.User;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService implements UserClient {

    private static final Logger LOG = Logger.getLogger(UserService.class);

    @Override
    public User getUser(@PathVariable("id") int id) {
        LOG.info("getproduct(" + id + ")");

        switch (id) {
            case 1:
                return new User(1, "martin", 21);
            case 2:
                return new User(2, "thomas", 55);
            case 3:
                return new User(3, "daniel", 34);
            default:
                return null;
        }
    }

}
