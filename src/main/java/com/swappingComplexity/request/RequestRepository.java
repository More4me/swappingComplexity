package com.swappingComplexity.request;

import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<RequestModel,Long> {
    public RequestModel save(RequestModel requestModel);
}
