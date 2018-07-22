package com.swappingComplexity.util;

public enum RequestStatus {

    PENDED("pended",1),RUNNING("running",2),FINISHED("finished",3),TERMINATED("terminated",4);

    private final String state;
    private final int code;

    public int getCode() {
        return code;
    }

    private RequestStatus(String state,int code) {
        this.code=code;
        this.state=state;
    }

    public String getState() {
        return state;
    }
}
