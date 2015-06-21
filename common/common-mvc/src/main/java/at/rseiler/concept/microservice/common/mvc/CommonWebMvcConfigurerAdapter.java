package at.rseiler.concept.microservice.common.mvc;

import at.rseiler.concept.microservice.common.requestcontext.RequestContextCallable;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.Callable;

@ComponentScan(basePackages = {
        "at.rseiler.concept.microservice.common",
        "at.rseiler.concept.microservice.client"})
public class CommonWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    public CommonWebMvcConfigurerAdapter() {
        HystrixPlugins.getInstance().registerConcurrencyStrategy(new RequestContextHystrixConcurrencyStrategy());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestContextInterceptor());
    }

//    @Bean
//    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
////        builder.serializationInclusion(JsonInclude.Include.NON_EMPTY);
//        builder.featuresToEnable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//        builder.featuresToDisable(
//                DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,
//                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
//        );
//        return builder;
//    }

    private static class RequestContextHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
        @Override
        public <T> Callable<T> wrapCallable(final Callable<T> callable) {
            return new RequestContextCallable<>(callable);
        }
    }

}
