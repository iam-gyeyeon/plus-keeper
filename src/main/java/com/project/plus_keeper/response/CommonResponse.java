package com.project.plus_keeper.response;

import lombok.Getter;

@Getter
public class CommonResponse<T> {
    private int code;
    private String message;
    private T data;

    public CommonResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
