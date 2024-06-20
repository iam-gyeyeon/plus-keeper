package com.project.plus_keeper.member.services;

import com.project.plus_keeper.member.domain.Member;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    private final Logger logger = getLogger(this.getClass().getName());
    @Autowired
    public MemberService memberService;

    @Test
    void findAllMembers() {
        //given

        //when
        List<Member> list = memberService.findAllMembers();
        //then
        list.forEach(member -> logger.info(member.getMemberId()));
    }
}