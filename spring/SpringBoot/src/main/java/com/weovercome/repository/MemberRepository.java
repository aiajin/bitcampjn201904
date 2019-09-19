package com.weovercome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weovercome.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
