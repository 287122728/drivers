package com.drivers.manager.exceptions;


import com.drivers.manager.web.response.base.Response;
import com.drivers.manager.web.response.base.StatusCode;

/**
 * @author tietang 2014/12/30.
 */
public class BizException extends RuntimeException {

    private Integer status;
    private String message;
    private Response<?> response = new Response<>();

    public BizException(Response<?> response) {
        this.response = response;
        this.status = response.getStatus();
        this.message = response.getMessage();
    }

    public BizException(StatusCode statusCode) {
        this.status = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.response.setStatusCode(statusCode);
    }

    public BizException(String message) {
        this.status = StatusCode.BusinessOperationFailed.getCode();
        this.message = message;
        this.response.setMessage(message);
        this.response.setStatus(this.status);
    }

    public BizException(StatusCode statusCode, String message) {
        this.status = statusCode.getCode();
        this.message = message;
        this.response.setMessage(this.message);
        this.response.setStatus(this.status);
    }

    public BizException(Integer statusCode, String message) {
        this.status = statusCode;
        this.message = message;
        this.response.setMessage(this.message);
        this.response.setStatus(this.status);
    }

    public Response<?> getResponse() {
        return response;
    }

    public void setResponse(Response<Object> response) {
        this.response = response;
    }

    /**
     * 提高性能，不记录堆栈信息，added by fw 2015-7-2
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    /**
     * by fw 2015-11-12
     */
    @Override
    public String getMessage() {
        return this.message;
    }

    public Integer getStatus() {
        return status;
    }
}
