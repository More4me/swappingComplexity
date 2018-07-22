package com.swappingComplexity.util;

import lombok.Builder;

import java.util.List;

@Builder
public class ServiceResponse<T> {
    public T body;
    public List<String> details;
    public ServiceResponseStatus status;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public ServiceResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceResponseStatus status) {
        this.status = status;
    }
}
