package com.baidu.exam.except;

/**
 * @author Administrator
 * @date 2019-09-16 11:42
 * @desc：自定义异常.
 */
public class MyException extends RuntimeException{

    private String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
