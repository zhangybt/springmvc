package com.product.controller.resultData;

public class BaseControllerRS {
    private boolean success;
    private String message;
    private Object data;
    private int code = 1;
    public static final int code_success = 1;
    public static final int code_failure = 0;

    public BaseControllerRS(boolean success, String message, Object data) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(data);
    }

    public BaseControllerRS(boolean success, int code, String message, Object data) {
        this.setSuccess(success);
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
