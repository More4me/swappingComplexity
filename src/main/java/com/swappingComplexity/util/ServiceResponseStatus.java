package com.swappingComplexity.util;

public enum ServiceResponseStatus {
    FAILED("Operation is failed", 500),
    SUCCESS("Operation is completed successfully", 200);

    private final String message;
    private final Integer code;

    private ServiceResponseStatus(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
