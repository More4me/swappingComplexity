package com.swappingComplexity.request;

import com.swappingComplexity.util.RequestStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class RequestModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long ID;
    public Long size;
    public RequestStatus requestStatus;
    public Date startTime;
    public Date endTime;
}
