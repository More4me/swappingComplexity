package com.swappingComplexity.request;

import com.swappingComplexity.util.ServiceResponse;
import com.swappingComplexity.util.ServiceResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@Controller
public class RequestController {

    @Autowired
    public RequestService requestService;

//    @RequestMapping(value = "/sort", method = RequestMethod.GET)
//    public ResponseEntity<?> GenerateBubbleSortedArray(@RequestParam(required = true) Long size){
//        ServiceResponse<List<Integer>> sortedArray=requestService.GenerateBubbleSortedArray(size);
//        if (sortedArray.getStatus().equals(ServiceResponseStatus.SUCCESS)) {
//            return ResponseEntity.status(sortedArray.getStatus().getCode()).body(sortedArray.body);
//        }
//        return ResponseEntity.status(sortedArray.getStatus().getCode()).body(sortedArray);
//    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String test(){
        return "Hello World";
    }

//    @RequestMapping(value="/sort",method = RequestMethod.POST)
//    public CompletableFuture<ServiceResponse<List<Integer>>> startSort(@RequestBody(required = true) Long size){
//        return CompletableFuture.supplyAsync(() -> requestService.GenerateBubbleSortedArray(size));
//    }

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public Long testfunction(@RequestParam(required = true)Long size) {
//        Future<ServiceResponse<List<Integer>>> future = requestService.GenerateBubbleSortedArray(size1);
//        Future<ServiceResponse<List<Integer>>> future2= requestService.GenerateBubbleSortedArray(size2);

            ServiceResponse<Long> toolong = requestService.submitRequest(size);

            return toolong.getBody();

    }
}
