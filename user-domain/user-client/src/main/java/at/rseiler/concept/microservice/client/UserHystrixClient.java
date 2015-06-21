package at.rseiler.concept.microservice.client;

import at.rseiler.concept.microservice.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHystrixClient {

    private final UserClient userClient;

    @Autowired
    public UserHystrixClient(UserClient userClient) {
        this.userClient = userClient;
    }

    @HystrixCommand(groupKey = "user-service", commandKey = "getUser", fallbackMethod = "getUserFallback")
    public User getUser(int id) {
        return userClient.getUser(id);
    }

    public User getUserFallback(int id) {
        return null;
    }

}
