package com.bitcamp.guest.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.guest.dao.MessageSessionDao;
import com.bitcamp.guest.dao.MessageSessionTemplateDao;
import com.bitcamp.guest.domain.Message;

@Service("writeService")
public class WriteMessageService implements GuestBookService {
	

	//@Autowired private MessageDao dao;

	
	//@Autowired
	//private MessageJdbcTemplateDao templateDao;
	
	//@Autowired
	//private MessageSessionTemplateDao templateDao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MessageSessionDao dao;
	
	
	
	public int write(Message message) {
		
		// dao 생성
		dao = template.getMapper(MessageSessionDao.class);
		
		
		
		int rCnt = 0 ;
		//rCnt = templateDao.insert(message);
		rCnt = dao.insert(message);
		
		// 1. Connection 생성
		// 2. dao 생성
		// 3. insert 메서드 실행
		
		//Connection conn = null;		
		//try {
			//conn = ConnectionProvider.getConnection();			
			//MessageDao dao = MessageDao.getInstance();			
			//rCnt = dao.insert(conn, message);			
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		
		
		return rCnt;	
		
	}

}












