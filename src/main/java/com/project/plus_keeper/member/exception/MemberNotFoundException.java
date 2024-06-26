package com.project.plus_keeper.member.exception;

import com.project.plus_keeper.member.code.MemberErrorCode;
import lombok.Getter;


@Getter
public class MemberNotFoundException extends RuntimeException {
    private final MemberErrorCode errorCode;

    public MemberNotFoundException(MemberErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
