package at.rseiler.concept.microservice.common.feign;

import at.rseiler.concept.microservice.common.requestcontext.RequestContext;
import at.rseiler.concept.microservice.common.requestcontext.RequestContextService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceNameInterceptor implements RequestInterceptor {

    private final String applicationName;

    @Autowired
    public ServiceNameInterceptor(@Value("${spring.application.name}") String applicationName) {
        this.applicationName = applicationName;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        RequestContext requestContext = RequestContextService.get();
        requestTemplate
                .header("X-UUID", requestContext.getUuid())
                .header("X-Caller-Stack", applicationName + " <- " + requestContext.getCaller());
    }

}
