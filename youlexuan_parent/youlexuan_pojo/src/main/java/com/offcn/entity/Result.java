package com.offcn.entity;

import java.io.Serializable;

/**
 * @author 邢会兴
 * date 2019/11/14   21:28
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
