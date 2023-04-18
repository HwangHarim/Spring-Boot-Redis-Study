package com.study.core.service;

import com.study.core.entity.Member;
import com.study.core.repository.MemberRedisRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRedisRepository memberRedisRepository;

    public void addMember() {
        Member member = new Member("test", 32);
        memberRedisRepository.save(member);
    }

    public List<Member> findMember() {
        Member member = new Member("test", 32);
       return (List<Member>) memberRedisRepository.findAll();
    }
}
