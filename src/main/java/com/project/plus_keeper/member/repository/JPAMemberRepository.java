package com.project.plus_keeper.member.repository;

import com.project.plus_keeper.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberRepository extends JpaRepository<Member, String> , MemberRepository {
}
