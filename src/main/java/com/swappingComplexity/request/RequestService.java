package com.swappingComplexity.request;

import com.swappingComplexity.algorithm.BubblesSort;
import com.swappingComplexity.input.InputGeneration;
import com.swappingComplexity.util.ServiceResponse;
import com.swappingComplexity.util.ServiceResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class RequestService {

    @Autowired
    InputGeneration input;

    @Autowired
    BubblesSort bubblesSort;

    @Async
    public Future<ServiceResponse<List<Integer>>> GenerateBubbleSortedArray(Long elementSize) {
        System.out.println("Thread "+Thread.currentThread().getName()+ " is starting function GenerateBubbleSortedArray");
        if(elementSize == null) {
            return new AsyncResult<ServiceResponse<List<Integer>>>(ServiceResponse.<List<Integer>>builder()
                    .status(ServiceResponseStatus.FAILED)
                    .details(Collections.singletonList("Invalid Input"))
                    .build());
        }
        try {
            System.out.println("Thread "+Thread.currentThread().getName()+ " sleeping for a while in function GenerateBubbleSortedArray");
            Thread.sleep(5000L);
            System.out.println("Thread "+Thread.currentThread().getName()+ " finished sleeping for a while in function GenerateBubbleSortedArray");
        }catch (InterruptedException e){
            System.out.println("Something went wrong with sleeping of thread "+ Thread.currentThread().getName());
        }
        System.out.println("Thread "+Thread.currentThread().getName()+ " finished the element size validation in function GeneratedBubbleSortedArray");
        ServiceResponse<List<Integer>> integerList=input.randomGeneration(elementSize);
        System.out.println("Thread "+Thread.currentThread().getName()+ " finished List generation in function GenerateBubbleSortedArray");
        if(integerList==null || integerList.body.size()==0 ||integerList.body.isEmpty()) {
            return new AsyncResult<ServiceResponse<List<Integer>>>(ServiceResponse.<List<Integer>>builder()
                    .status(ServiceResponseStatus.FAILED)
                    .details(Collections.singletonList("Failed Random Generation"))
                    .build());
        }
        System.out.println("Thread "+Thread.currentThread().getName()+ " finished the list validation in function GenerateBubbleSortedArray");
        ServiceResponse<List<Integer>> sortedList=bubblesSort.sort(integerList.body);
        System.out.println("Thread "+Thread.currentThread().getName()+ " finished sorting of list in function GenerateBubbleSortedArray");
        return new AsyncResult<ServiceResponse<List<Integer>>>(sortedList);
    }

    public Long submitRequest(){

        return null;
    }
}
