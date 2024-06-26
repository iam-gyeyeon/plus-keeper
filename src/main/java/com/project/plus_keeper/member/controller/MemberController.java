package com.project.plus_keeper.member.controller;

import com.project.plus_keeper.member.domain.Member;
import com.project.plus_keeper.member.domain.MemberForm;
import com.project.plus_keeper.member.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String join(@RequestBody MemberForm.Request.Add member){
        return null;
    }

    @ResponseBody
    @PostMapping("/member/{memberId}")
    public Optional<Member> getMember(@PathVariable String memberId) {
        return memberService.findByMemberId(memberId);
    }


}
