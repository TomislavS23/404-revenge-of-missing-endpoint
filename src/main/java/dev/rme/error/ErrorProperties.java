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

    public Error getProductsNotFound() {
        var key = "10000";
        return new Error(getCode(key), getMessage(key), getHttpCode(key));
    }

    public Error getProductNotFound() {
        var key = "10001";
        return new Error(getCode(key), getMessage(key), getHttpCode(key));
    }

    public Error getProductInsertFailed() {
        var key = "20000";
        return new Error(getCode(key), getMessage(key), getHttpCode(key));
    }

    public Error getProductDisplayInsertFailed() {
        var key = "20001";
        return new Error(getCode(key), getMessage(key), getHttpCode(key));
    }

    public Error getMultiLanguageInfoInsertFailed() {
        var key = "20002";
        return new Error(getCode(key), getMessage(key), getHttpCode(key));
    }

    public Error getFailedProductUpdate() {
        var key = "30000";
        return new Error(getCode(key), getMessage(key), getHttpCode(key));
    }

    public Error getProductDeleteFailed() {
        var key = "40000";
        return new Error(getCode(key), getMessage(key), getHttpCode(key));
    }

    public Error getPromotionDisplayDeleteFailed() {
        var key = "40001";
        return new Error(getCode(key), getMessage(key), getHttpCode(key));
    }

    public Error getMultiLanguageInfoDeleteFailed() {
        var key = "40002";
        return new Error(getCode(key), getMessage(key), getHttpCode(key));
    }
}
