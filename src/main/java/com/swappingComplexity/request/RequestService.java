package com.swappingComplexity.request;

import com.swappingComplexity.algorithm.BubblesSort;
import com.swappingComplexity.input.InputGeneration;
import com.swappingComplexity.util.ServiceResponse;
import com.swappingComplexity.util.ServiceResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class RequestService {

    @Autowired
    InputGeneration input;

    @Autowired
    BubblesSort bubblesSort;

    public ServiceResponse<List<Integer>> GenerateBubbleSortedArray(Long elementSize) {
        if(elementSize == null) {
            return ServiceResponse.<List<Integer>>builder()
                    .status(ServiceResponseStatus.FAILED)
                    .details(Collections.singletonList("Invalid Input"))
                    .build();
        }

        ServiceResponse<List<Integer>> integerList=input.randomGeneration(elementSize);

        if(integerList==null || integerList.body.size()==0 ||integerList.body.isEmpty()) {
            return ServiceResponse.<List<Integer>>builder()
                    .status(ServiceResponseStatus.FAILED)
                    .details(Collections.singletonList("Failed Random Generation"))
                    .build();
        }

        ServiceResponse<List<Integer>> sortedList=bubblesSort.sort(integerList.body);

        return sortedList;
    }

    public Long submitRequest(){

        return null;
    }
}
