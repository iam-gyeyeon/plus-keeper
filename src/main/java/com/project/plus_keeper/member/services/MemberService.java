package com.project.plus_keeper.member.services;

import com.project.plus_keeper.member.domain.Member;
import com.project.plus_keeper.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }


}
