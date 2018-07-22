package com.swappingComplexity.requestController;

import com.swappingComplexity.requestService.RequestService;
import com.swappingComplexity.util.ServiceResponse;
import com.swappingComplexity.util.ServiceResponseStatus;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
public class RequestController {

    @Autowired
    public RequestService requestService;

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public ResponseEntity<?> GenerateBubbleSortedArray(@RequestParam(required = true) Long size){
        ServiceResponse<List<Integer>> sortedArray=requestService.GenerateBubbleSortedArray(size);
        if (sortedArray.getStatus().equals(ServiceResponseStatus.SUCCESS)) {
            return ResponseEntity.status(sortedArray.getStatus().getCode()).body(sortedArray.body);
        }
        return ResponseEntity.status(sortedArray.getStatus().getCode()).body(sortedArray);
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String test(){
        return "Hello World";
    }
}
