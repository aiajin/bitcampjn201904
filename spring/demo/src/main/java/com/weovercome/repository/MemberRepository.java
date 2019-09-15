package com.weovercome.repository;

import java.awt.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weovercome.domain.MemberInfo;

public interface MemberRepository extends JpaRepository<MemberInfo, Long> {
 
}
