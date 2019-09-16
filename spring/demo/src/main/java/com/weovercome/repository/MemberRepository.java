package com.weovercome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weovercome.domain.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

	public MemberEntity findByIdx(Long idx);
	// find + by + idx
	// from Member where idx = 매개변수   새로운 쿼릴르 생성 후 실행
	
	// 메서드 구현 예제
	public List<MemberEntity> findByUnameLike(String name); // 인자에는 "%"+str+"%" 형태로 지정 필요
	public List<MemberEntity> findByUphotoNotNullOrderByIdxDesc();
	public List<MemberEntity> findByIdxBetween(int arg1, int arg2);
	
}
