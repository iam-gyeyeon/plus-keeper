package com.project.plus_keeper.member.services;

import com.project.plus_keeper.member.domain.MemberForm;
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

    public Optional<Member> login(MemberForm.Request.Add member) {
        Optional<Member> optionalMember = findByMemberId(member.getMemberId());

        if (optionalMember.isPresent()) {
            Member findMember = optionalMember.get();
            if (member.getPassword().equals(findMember.getPassword())) {
                return Optional.of(findMember);
            }
        }
        return Optional.empty();
    }

    public Optional<Member> findByMemberId(String memberId){
        return memberRepository.findByMemberId(memberId);
    }
}
