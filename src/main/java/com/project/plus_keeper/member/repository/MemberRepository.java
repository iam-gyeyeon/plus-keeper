package com.project.plus_keeper.member.repository;

import com.project.plus_keeper.member.domain.Member;

import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
}
