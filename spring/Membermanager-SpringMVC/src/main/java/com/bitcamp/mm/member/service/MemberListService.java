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
	
	final int MEMBER_CNT_List = 3;
	
	public ListViewData getListData(int currentPageNumber) {
		
		ListViewData listData = new ListViewData();
		
		Connection conn = null;		 
		
		
		
		try {
			conn = ConnectionProvider.getConnection();
			
			// 현재 페이지 번호
			listData.setCurrentPageNumber(currentPageNumber);
			
			// 전체 게시물의 개수
			int totalCnt = dao.selectTotalCount(conn);
			
			int totalPageCnt = 0;
			// 전체 페이지 개수
			if(totalCnt>0) {
				totalPageCnt = totalCnt/MEMBER_CNT_List;
				if(totalCnt%MEMBER_CNT_List>0) {
					totalPageCnt++;
				}
			}
			listData.setPageTotalCount(totalPageCnt);
			
			
			// 구간 검색을 위한 index
			// 1 -> 0 , 2 -> 3, 3 -> 6, 4 -> 9
			int index = (currentPageNumber-1)*MEMBER_CNT_List;
			// 회원 정보 리스트 
			listData.setMemberList(dao.selectList(conn,index, MEMBER_CNT_List));
			
			// 1 -> 9-0 =9, 2 -> 9-3=6
			int no = totalCnt - index;
			listData.setNo(no);
			
			listData.setTotalCount(totalCnt);
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listData;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
