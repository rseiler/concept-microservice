package at.rseiler.concept.microservice.common.mvc;

import at.rseiler.concept.microservice.common.requestcontext.RequestContextService;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class RequestContextInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uuid = getUuid(request);
        String caller = getCaller(request);
        RequestContextService.create(uuid, caller);
        MDC.put("uuid", uuid);
        MDC.put("caller", caller);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestContextService.clear();
        MDC.clear();

        super.afterCompletion(request, response, handler, ex);
    }

    private String getCaller(HttpServletRequest request) {
        String caller = request.getHeader("X-Caller-Stack");
        if (StringUtils.isEmpty(caller)) {
            caller = request.getRequestURI() + " <- " + request.getRemoteAddr();
        }
        return caller;
    }

    private String getUuid(HttpServletRequest request) {
        String uuid = request.getHeader("X-UUID");
        if (StringUtils.isEmpty(uuid)) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

}
