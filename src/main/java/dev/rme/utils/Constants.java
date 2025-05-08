package dev.rme.utils;

import org.springframework.stereotype.Component;

@Component
public class Constants {

    private Constants() {
    }

    public static final Integer SALT_LENGTH = 16;
    public static final Integer ITERATIONS = 700_001;
    public static final Integer KEY_LENGTH = 256;

    public static final Long ACCESS_TOKEN_TTL = 600_000L;
    public static final Long REFRESH_TOKEN_TTL = 1_200_000L;

    public static final String ERROR_RESPONSE_TIMESTAMP_KEY = "timestamp";
    public static final String ERROR_RESPONSE_STATUS_CODE_KEY = "status";
    public static final String ERROR_RESPONSE_ERROR_KEY = "error";
    public static final String ERROR_RESPONSE_REQUEST_URI_KEY = "requestURI";
    public static final String ERROR_RESPONSE_METHOD_KEY = "method";

    public static final String XSD_SCHEMA_PATH = "/validation/entity-validation.xsd";
    public static final String FULL_XSD_SCHEMA_PATH = "/soap/schema.xsd";
    public static final String RNG_SCHEMA_PATH = "/validation/entity-validation-rng.xml";
}
