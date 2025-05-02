package dev.rme.error;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@PropertySource("classpath:error.properties")
public class ErrorProperties {
    private final Environment environment;

    private String getCode(String key) {
        return environment.getProperty(key + ".code");
    }

    private String getMessage(String key) {
        return environment.getProperty(key + ".message");
    }

    private HttpStatus getHttpCode(String key) {
        var httpCodeString = environment.getProperty(key + ".status");
        var httpCodeInt = httpCodeString.isEmpty() ? 500 : Integer.parseInt(httpCodeString);
        return HttpStatus.valueOf(httpCodeInt);
    }

    public Error getError() {
        var key = "10000";
        return new Error(getCode(key), getMessage(key), getHttpCode(key));
    }
}
