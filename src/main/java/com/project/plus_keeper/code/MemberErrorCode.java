package com.project.plus_keeper.code;

import lombok.Getter;

@Getter
public enum MemberErrorCode {
    MEMBER_NOT_FOUND(404, "회원 정보를 찾을 수 없습니다."),
    INVALID_MEMBER_ID(400, "잘못된 회원 ID 입니다.");

    private final int status;
    private final String message;

    MemberErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}

