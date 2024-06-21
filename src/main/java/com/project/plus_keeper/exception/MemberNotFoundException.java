package com.project.plus_keeper.exception;

import com.project.plus_keeper.code.MemberErrorCode;
import lombok.Getter;


@Getter
public class MemberNotFoundException extends RuntimeException {
    private final MemberErrorCode errorCode;

    public MemberNotFoundException(MemberErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
