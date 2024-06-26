package com.project.plus_keeper.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {

    @Id
    private String memberId;
    private String nickname;
    private String password;
    private String lockYn;
    private String regId;
    private String regDt;
    private String modId;
    private String modDt;
}
