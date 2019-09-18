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
	
	}

	public MemberDaoImpl(EntityManager entityManager) {
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

	@Override
	public List<MemberEntity> find(String fstr) {
		
		System.out.println("데이터 확인 : " + fstr);
		
		List<MemberEntity> list = null;
		
		//String qStr = "from MemberEntity where idx= :fstr"; // :○○○ --> JPQL 에서 매개변수로 사용 
		//Query query = entityManager.createQuery(qStr).setParameter("fstr", Long.parseLong(fstr));
		
		//String qStr = "from MemberEntity where idx= :fidx or uname like :fname or uid like :fuid ";
		String qStr = "from MemberEntity where idx= ?1 or uname like ?2 or uid like ?3 ";
		Long fidx = 0L;
		try {
			fidx = Long.parseLong(fstr);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		Query query = entityManager.createQuery(qStr)
//				.setParameter("fidx", fidx)
//				.setParameter("fname", "%"+fstr+"%")
//				.setParameter("fuid", "%"+fstr);
		

		
//		Query query = entityManager.createQuery(qStr)
//				.setParameter(1, fidx)
//				.setParameter(2, "%"+fstr+"%")
//				.setParameter(3, "%"+fstr);
		
		Query query = entityManager.createNamedQuery("findWithParam")
				.setParameter("fidx", fidx)
				.setParameter("fname", "%"+fstr+"%")
				.setParameter("fuid", "%"+fstr);
		
		list = query.getResultList();
				
		return list;
	}
	
	

}
