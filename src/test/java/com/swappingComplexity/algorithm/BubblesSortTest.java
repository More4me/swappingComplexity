package com.swappingComplexity.algorithm;

import com.swappingComplexity.util.ServiceResponse;
import com.swappingComplexity.util.ServiceResponseStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BubblesSortTest {
    BubblesSort bubblesSort=new BubblesSort();
    List<Integer> unSortedIntegerList=new ArrayList<Integer>();
    List<Integer> sortedIntegerList=new ArrayList<Integer>();

    @BeforeEach
    public void initData(){
        unSortedIntegerList.add(3);
        unSortedIntegerList.add(1);
        sortedIntegerList.add(1);
        sortedIntegerList.add(3);
    }

    @Test
    public void sort_UnSortedListOfInteger_SortedListOfInteger(){
        ServiceResponse<List<Integer>> actualServiceResponse=
                bubblesSort.sort(unSortedIntegerList);
        assertEquals(actualServiceResponse.getStatus(),ServiceResponseStatus.SUCCESS);
        assertArrayEquals(sortedIntegerList.toArray(),actualServiceResponse.getBody().toArray());
    }

    @Test
    public void sort_sortedListOfInteger_SortedListOfInteger(){
        ServiceResponse<List<Integer>> actualServiceResponse=
                bubblesSort.sort(sortedIntegerList);
        assertEquals(actualServiceResponse.getStatus(),ServiceResponseStatus.SUCCESS);
        assertArrayEquals(sortedIntegerList.toArray(),actualServiceResponse.getBody().toArray());
    }

    @Test
    public void sort_nullArray_failedServiceResonse(){
        ServiceResponse<List<Integer>> actualServiceResponse=
                bubblesSort.sort(null);
        assertEquals(actualServiceResponse.getStatus(),ServiceResponseStatus.FAILED);
        assertNull(actualServiceResponse.getBody());
        assertNotNull(actualServiceResponse.getDetails());
    }

}
