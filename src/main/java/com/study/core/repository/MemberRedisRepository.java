package com.study.core.repository;

import com.study.core.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRedisRepository extends CrudRepository<Member, String> {
}
