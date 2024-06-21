package com.project.plus_keeper.member.controller;

import com.project.plus_keeper.member.domain.Member;
import com.project.plus_keeper.member.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {


    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @ResponseBody
    @PostMapping("/api/members")
    public List<Member> list() {
        return memberService.findAllMembers();
    }
}
