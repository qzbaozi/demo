package com.sfh.feign.error;

public class ResponseRunError extends RuntimeException{

    int status;

    String body;

    private ResponseRunError(int status, String body) {
        this.status = status;
        this.body = body;
    }


    public static  ResponseRunError of (int status, String body) {
    return     new ResponseRunError(status,body);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
