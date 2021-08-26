package com.sfh;

public enum DDportTaskStatus {
    FINISHED(1)
    ;

    private final int intValue;

    DDportTaskStatus(int i) {
        intValue=i;
    }


    public int intValue(){
        return intValue;
    }
}
