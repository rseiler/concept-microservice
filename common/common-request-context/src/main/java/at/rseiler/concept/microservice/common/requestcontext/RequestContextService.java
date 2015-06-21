package at.rseiler.concept.microservice.common.requestcontext;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.apache.log4j.Logger;

public final class RequestContextService {

    private static final Logger LOG = Logger.getLogger(RequestContextService.class);
    private static final ThreadLocal<RequestContext> REQUEST_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<HystrixRequestContext> HYSTRIX_REQUEST_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();

    private RequestContextService() {
    }

    public static RequestContext create(String uuid, String caller) {
        if (HYSTRIX_REQUEST_CONTEXT_THREAD_LOCAL.get() != null) {
            LOG.warn("The RequestContext wasn't cleared correctly.");
            HYSTRIX_REQUEST_CONTEXT_THREAD_LOCAL.get().shutdown();
        }

        HYSTRIX_REQUEST_CONTEXT_THREAD_LOCAL.set(HystrixRequestContext.initializeContext());
        RequestContext requestContext = new RequestContext(uuid, caller);
        REQUEST_CONTEXT_THREAD_LOCAL.set(requestContext);

        return requestContext;
    }

    public static RequestContext get() {
        return REQUEST_CONTEXT_THREAD_LOCAL.get();
    }

    public static void set(RequestContext requestContext) {
        REQUEST_CONTEXT_THREAD_LOCAL.set(requestContext);
    }

    public static void clear() {
        REQUEST_CONTEXT_THREAD_LOCAL.remove();

        if (HYSTRIX_REQUEST_CONTEXT_THREAD_LOCAL.get() != null) {
            HYSTRIX_REQUEST_CONTEXT_THREAD_LOCAL.get().shutdown();
            HYSTRIX_REQUEST_CONTEXT_THREAD_LOCAL.remove();
        }
    }

}
