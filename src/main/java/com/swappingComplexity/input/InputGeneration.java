package com.swappingComplexity.input;

import com.swappingComplexity.util.ServiceResponse;
import com.swappingComplexity.util.ServiceResponseStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class InputGeneration {

    public ServiceResponse<List<Integer>> randomGeneration(Long number){
        System.out.println("Thread "+Thread.currentThread().getName()+ " is starting function randomGeneration");
        if(number == null) {
            return ServiceResponse.<List<Integer>>builder()
                    .status(ServiceResponseStatus.FAILED)
                    .details(Collections.singletonList("Invalid Input"))
                    .body(null).build();
        }

        List<Integer> input=new ArrayList<Integer>();
        Random random=new Random();

        for(long i=0;i<number;i++) {
            input.add(random.nextInt());
        }

        return ServiceResponse.<List<Integer>>builder()
                .status(ServiceResponseStatus.SUCCESS)
                .body(input).build();
    }
}
