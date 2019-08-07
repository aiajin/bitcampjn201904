package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.domain.ListViewData;

@Service("listServcie")
public class MemberListService implements MemberService {

	@Autowired
	private MemberDao dao;
	
	public ListViewData getListData(int currentPageNumber) {
		
		ListViewData listData = new ListViewData();
		
		Connection conn = null;		
		
		
		try {
			conn = ConnectionProvider.getConnection();
			listData.setMemberList(dao.selectList(conn));
			listData.setTotalCount(dao.selectTotalCount(conn));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listData;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
