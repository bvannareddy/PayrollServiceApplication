package com.dxc.payrollservice.exception;

public class PayrollDeleteException extends RuntimeException {

    private Integer statusCode;
    private String message;

    public PayrollDeleteException(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
