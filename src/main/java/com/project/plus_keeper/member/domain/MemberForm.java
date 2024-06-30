package com.project.plus_keeper.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class MemberForm {

    public static class Request{

        @Entity
        @Getter
        @Setter
        public static class Add{
            @Id
            private String memberId;
            private String name;
            private String password;
            private String nickname;
            private String lockYn;
            private String regId;
        }

        @Entity
        @Getter
        @Setter
        public static class Login{
            @Id
            private String memberId;
            private String password;
        }
        @Entity
        @Getter
        @Setter
        public static class Search{
            @Id
            private String memberId;
            private String searchName;

        }
    }
}
