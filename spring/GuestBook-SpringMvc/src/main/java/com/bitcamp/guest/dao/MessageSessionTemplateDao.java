package com.bitcamp.guest.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.guest.domain.Message;

@Repository("sessionTemplateDao")
public class MessageSessionTemplateDao { // messageDao

	@Autowired
	private SqlSessionTemplate template;

	private String nameSpace = "com.bitcamp.guest.mapper.mybatis.guestMapper";

	public int insert(Message message) {
		// com.bitcamp.guest.mapper.mybatis.guestMapper.insertMessage		
		return template.update(nameSpace + ".insertMessage", message);
	}

	public int selectCount() {
		return template.selectOne(nameSpace+".selectCount");
	}

	public List<Message> selectList(Map<String, Object> params) {
		return template.selectList(nameSpace+".selectList", params);
	}

	
	public Message select(int messageId) {
		return template.selectOne(nameSpace+".select", messageId);
	}
	
	public int deleteMessage(int messageId) {
		return template.update(nameSpace+".deleteMessage",messageId);
	}
	

}
