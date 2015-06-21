package at.rseiler.concept.microservice.common.requestcontext;

import java.util.concurrent.Callable;

public class RequestContextCallable<T> implements Callable<T> {
    private final Callable<T> callable;
    private final RequestContext requestId;

    public RequestContextCallable(Callable<T> callable) {
        this.callable = callable;
        this.requestId = RequestContextService.get();
    }

    @Override
    public T call() throws Exception {
        RequestContext original = RequestContextService.get();
        RequestContextService.set(requestId);
        try {
            return callable.call();
        } finally {
            RequestContextService.set(original);
        }
    }
}