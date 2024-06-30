package com.project.plus_keeper.member.controller;

import com.project.plus_keeper.member.code.MemberErrorCode;
import com.project.plus_keeper.member.domain.Member;
import com.project.plus_keeper.member.domain.MemberForm;
import com.project.plus_keeper.member.exception.MemberException;
import com.project.plus_keeper.member.services.MemberService;
import com.project.plus_keeper.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.project.plus_keeper.util.ProcessUtils.processList;
import static com.project.plus_keeper.util.ProcessUtils.processOptional;


@RequestMapping("/api")
@Controller
public class MemberController {


    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    /**
     * 회원 조회 API
     * @return
     */
    @ResponseBody
    @PostMapping("/members")
    public ResponseEntity<CommonResponse<List<Member>>> list() {
        List<Member> members = memberService.findAllMembers();
        return processList(members);
    }

    /**
     * 로그인 API
     * @param member 로그인 정보
     * @return
     */
    @PostMapping("/member/login")
    @ResponseBody
    public ResponseEntity<?> join(@RequestBody MemberForm.Request.Login member) {
        Optional<Member> memberOptional = memberService.login(member);
        return processOptional(memberOptional, () -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));
    }

    @ResponseBody
    @PostMapping("/member/{memberId}")
    public ResponseEntity<?> getMember(@PathVariable String memberId) {
        Optional<Member> findMember = memberService.findByMemberId(memberId);
        return processOptional(findMember, () -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));
    }



}
