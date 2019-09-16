package com.weovercome.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.weovercome.domain.MemberEntity;

@Repository
public class MemberDaoImpl implements MemberDao<MemberEntity> {

	private EntityManager entityManager;

	public MemberDaoImpl() {
		super();
	}

	public MemberDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<MemberEntity> getAll() {

		Query query = entityManager.createQuery("from MemberEntity");
		List<MemberEntity> list = query.getResultList();
		entityManager.close();
		return list;
	}

	@Override
	public MemberEntity findByIdx(long idx) {
		Query query = entityManager.createQuery("from MemberEntity where idx =" + idx);
		MemberEntity memberEntity = (MemberEntity) query.getSingleResult();
		return memberEntity;
	}

	@Override
	public List<MemberEntity> findByUname(String name) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from MemberEntity where uname =" + name);
		List<MemberEntity> list = query.getResultList();
		return list;
	}

}
