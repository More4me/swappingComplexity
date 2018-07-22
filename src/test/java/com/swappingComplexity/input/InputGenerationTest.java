package com.swappingComplexity.input;

import com.swappingComplexity.util.ServiceResponse;
import com.swappingComplexity.util.ServiceResponseStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Target;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputGenerationTest {

    InputGeneration inputGeneration = new InputGeneration();

    @Test
    public void randomGeneration_longInput_ArrayContainRandomNumber(){
        ServiceResponse<List<Integer>> actualOutput=inputGeneration.randomGeneration(5L);
        assertEquals(actualOutput.status.getCode(), ServiceResponseStatus.SUCCESS.getCode());
        assertEquals(actualOutput.body.size(),5);
    }

    @Test
    public void randomGeneration_nullInput_NullBodyServiceResponse(){
        ServiceResponse<List<Integer>> actualOutput=inputGeneration.randomGeneration(null);
        assertEquals(actualOutput.status.getCode(),ServiceResponseStatus.FAILED.getCode());
        assertNull(actualOutput.body);
    }

}
