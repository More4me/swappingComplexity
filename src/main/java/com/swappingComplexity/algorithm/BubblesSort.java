package com.swappingComplexity.algorithm;

import com.swappingComplexity.util.ServiceResponse;
import com.swappingComplexity.util.ServiceResponseStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class BubblesSort {

    public ServiceResponse<List<Integer>> sort(List<Integer> arr) {
        if(arr==null || arr.size()==0 ||arr.isEmpty()){
            return ServiceResponse.<List<Integer>> builder().status(ServiceResponseStatus.FAILED)
                    .details(Collections.singletonList("Invalid Input")).build();
        }

       Integer arrSize=arr.size();
       for(int i=0;i<arrSize;i++) {
           for(int j=0;j<arrSize;j++){
               if(arr.get(i)<arr.get(j)) {
                   Collections.swap(arr,i,j);
               }
           }
       }
        ServiceResponse<List<Integer>> afterSorting=
                ServiceResponse.<List<Integer>>builder().status(ServiceResponseStatus.SUCCESS).body(arr).build();
       return afterSorting;
    }

}
