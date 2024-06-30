package com.project.plus_keeper.member.services;

import com.project.plus_keeper.member.domain.Member;
import com.project.plus_keeper.member.domain.MemberForm.Request;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

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

    @Test
    void findByMemberId(){
        //given
        String username = "gykim";

        //when
        Optional<Member> findMember = memberService.findByMemberId(username);
        logger.info("findMember: " + findMember.toString());
        Assertions.assertThat(username).isEqualTo(findMember.map(Member::getMemberId).orElse(null));

        //then
        logger.info(findMember.map(Member::getMemberId).orElse(null));
    }

    @Test
    void login(){
        //given
        Request.Login member = new Request.Login();
        member.setMemberId("gykim");
        member.setPassword("123");

        //when
        Optional<Member> memberOptional = memberService.login(member);
        //then
        if (memberOptional.isPresent()) {
            logger.info("findMember: " + memberOptional.get().getMemberId());
        } else {
            logger.info(memberOptional.toString());
        }
    }

}