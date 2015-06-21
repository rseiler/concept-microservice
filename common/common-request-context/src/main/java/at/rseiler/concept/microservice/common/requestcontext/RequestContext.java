package at.rseiler.concept.microservice.common.requestcontext;

public class RequestContext {

    private final String uuid;
    private final String caller;

    public RequestContext(String uuid, String caller) {
        this.uuid = uuid;
        this.caller = caller;
    }

    public String getUuid() {
        return uuid;
    }

    public String getCaller() {
        return caller;
    }

    @Override
    public String toString() {
        return "RequestContext{" +
                "uuid='" + uuid + '\'' +
                ", caller='" + caller + '\'' +
                '}';
    }

}
