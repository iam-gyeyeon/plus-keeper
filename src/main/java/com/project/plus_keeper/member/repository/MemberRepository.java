package com.project.plus_keeper.member.repository;

import com.project.plus_keeper.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    List<Member> findAll();
    Optional<Member> findByMemberId(String memberId);
}
