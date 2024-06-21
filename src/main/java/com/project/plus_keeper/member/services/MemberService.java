package com.project.plus_keeper.member.services;

import com.project.plus_keeper.code.MemberErrorCode;
import com.project.plus_keeper.exception.MemberNotFoundException;
import com.project.plus_keeper.member.domain.Member;
import com.project.plus_keeper.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findByMemberId(String memberId){
        Optional<Member> findMember = memberRepository.findByMemberId(memberId);
        return handleMemberOptional(findMember);
    }

    private Optional<Member> handleMemberOptional(Optional<Member> optionalMember) {
        if (optionalMember.isPresent()) {
            return optionalMember;
        } else {
            throw new MemberNotFoundException(MemberErrorCode.MEMBER_NOT_FOUND);
        }
    }
}
