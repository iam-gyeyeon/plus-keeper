package com.project.plus_keeper.member.controller;

import com.project.plus_keeper.member.code.MemberErrorCode;
import com.project.plus_keeper.member.domain.Member;
import com.project.plus_keeper.member.domain.MemberForm;
import com.project.plus_keeper.member.exception.MemberException;
import com.project.plus_keeper.member.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.project.plus_keeper.util.OptionalUtils.processOptional;


@RequestMapping("/api")
@Controller
public class MemberController {


    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @ResponseBody
    @PostMapping("/members")
    public List<Member> list() {
        return memberService.findAllMembers();
    }

    @PostMapping("/member/join")
    @ResponseBody
    public ResponseEntity<?> join(@RequestBody MemberForm.Request.Add member) {
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
