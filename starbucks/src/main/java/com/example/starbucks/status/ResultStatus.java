package com.example.starbucks.status;

public enum ResultStatus {
    SUCCESS("Success"),
    FAIL("Error"),
    ;

    private String result;

    public String getResult() {
        return result;
    }

    ResultStatus(String result) {
        this.result = result;
    }
}
