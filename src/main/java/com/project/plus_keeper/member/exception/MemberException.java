package com.project.plus_keeper.member.exception;

import com.project.plus_keeper.member.code.MemberErrorCode;
import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {
    private final int code;
    private final String message;

    public MemberException(MemberErrorCode errorCode) {
        this.code = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }
}
