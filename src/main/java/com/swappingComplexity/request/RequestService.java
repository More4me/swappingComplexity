package com.swappingComplexity.request;

import com.swappingComplexity.algorithm.BubblesSort;
import com.swappingComplexity.input.InputGeneration;
import com.swappingComplexity.util.RequestStatus;
import com.swappingComplexity.util.ServiceResponse;
import com.swappingComplexity.util.ServiceResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;


import javax.xml.bind.SchemaOutputResolver;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class RequestService {

    @Autowired
    InputGeneration input;

    @Autowired
    BubblesSort bubblesSort;

    @Autowired
    RequestRepository requestRepository;

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

    @Async
    public Future<String> HelloTooLong(){

        for(int i=0;i<1000;i++) {
            for(int j=0;j<1000;j++){
                System.out.println(Thread.currentThread().getName()+ " - Do you know I need time out");
            }
        }
        try {
            System.out.println("Thread "+Thread.currentThread().getName()+ " sleeping for a while in function Hello too long");
            Thread.sleep(5000L);
            System.out.println("Thread "+Thread.currentThread().getName()+ " finished sleeping for a while in function Hello too long");
        }catch (InterruptedException e){
            System.out.println("Something went wrong with sleeping of thread "+ Thread.currentThread().getName());
        }
        return new AsyncResult<String> ("Hello EveryOne");

    }

    public ServiceResponse<Long> submitRequest(Long size){
        if(size==null ||size==0){
            return ServiceResponse.<Long>builder()
                    .status(ServiceResponseStatus.FAILED)
                    .details(Collections.singletonList("Invalid Input"))
                    .build();
        }
        ServiceResponse<Long> requestModelServiceResponse
                =ServiceResponse.<Long> builder().build();
        try {
            Future<ServiceResponse<List<Integer>>> Sortedlist = GenerateBubbleSortedArray(size);
            while (true) {
                if (Sortedlist.isDone()) {
                    System.out.println("Result from asynchronous process - " + Sortedlist.get());
                    break;
                }
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Thread in execptioon" + Thread.currentThread().getName());

            System.out.println("Something wrong happen" + interruptedException);
        } catch (ExecutionException excetion) {
            System.out.println("Thread in execuptioon" + Thread.currentThread().getName());

            System.out.println("Something wrong happen" + excetion);
        }
        System.out.println("Thread "+Thread.currentThread().getName()+" Saving data in database" );
        RequestModel requestModel=new RequestModel(1L,size, RequestStatus.FINISHED,new Date(),null);
        RequestModel savedRequestModel=null;
        synchronized(this) {
            savedRequestModel = this.requestRepository.save(requestModel);
        }

        requestModelServiceResponse.setBody(savedRequestModel.getID());
        requestModelServiceResponse.setStatus(ServiceResponseStatus.SUCCESS);


        return requestModelServiceResponse;
        /*
        *  while (true) {
                if (toolong.isDone()) {
                    System.out.println("Result from asynchronous process - " + toolong.get());
                    System.out.println("Result from asynchronous process - " + toolong2.get());
                    break;
                }
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Thread in execptioon" + Thread.currentThread().getName());

            System.out.println("Something wrong happen" + interruptedException);
        } catch (ExecutionException excetion) {
            System.out.println("Thread in execuptioon" + Thread.currentThread().getName());

            System.out.println("Something wrong happen" + excetion);
        }*/
    }
}
