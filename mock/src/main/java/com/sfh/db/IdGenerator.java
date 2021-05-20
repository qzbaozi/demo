package com.sfh.db;

public interface IdGenerator {

    default long next(){
        return 1L;
    }
}
