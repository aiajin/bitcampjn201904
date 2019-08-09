package com.bitcamp.mm.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.mm.jdbc.JdbcUtil;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;


@Repository("templateDao")
public class MemberJdbcTemplateDao { // memberDao
	
	@Autowired
	JdbcTemplate template;
	
	public MemberInfo selectMemberById(String userId) {
		
		String sql = "select * from member where uid=?";
		
		List<MemberInfo> list = 
				template.query(
						sql, 
						new Object[] {userId}, 
						new MemberInfoRowMapper()
						);
		
		return list.isEmpty()?null:list.get(0);
		
	}
	
	
	public int insertMember(MemberInfo memberInfo) {
		
		String sql = "insert into member "
				+ " (uid, uname, upw, uphoto) "
				+ " values (?,?,?,?) ";
		
		return template.update(
				sql, 
				memberInfo.getuId(),
				memberInfo.getuName(),
				memberInfo.getuPW(),
				memberInfo.getuPhoto()
				);
		
	}
	
	
	public int selectTotalCount(SearchParam searchParam) {
		
		String sql = "select count(*) from member";

		if(searchParam != null) {
			sql = "select count(*) from member where ";
			if(searchParam.getStype().equals("both")) {
				sql += " uid like '%"+searchParam.getKeyword()+"%' or uname  like '%"+searchParam.getKeyword()+"%' ";
			}
			if(searchParam.getStype().equals("id")) {
				sql += " uid  like '%"+searchParam.getKeyword()+ "%'";
			}
			if(searchParam.getStype().equals("name")) {
				sql += " uname  like '%"+searchParam.getKeyword()+"%' ";
			}
		}
		
		return template.queryForObject(sql, Integer.class);
		
	}

	public List<MemberInfo> selectList(int index, int count) {
		String sql = "SELECT * FROM member limit ?, ?";		
		return template.query(
				sql, 
				new MemberInfoRowMapper() , 
				index, 
				count);
	}
	
	public List<MemberInfo> selectListById(int index, int count, SearchParam searchParam) {
		
		String sql = "SELECT * FROM member where uid like ?  limit ?, ?";
		
		return template.query(
				sql, 
				new MemberInfoRowMapper(), 
				"%"+searchParam.getKeyword()+"%",
				index, 
				count
				);
	}
	
	public List<MemberInfo> selectListByName(int index, int count, SearchParam searchParam) {
		
		String sql = "SELECT * FROM member where uname like ?  limit ?, ?";
		
		return template.query(
				sql, 
				new MemberInfoRowMapper(), 
				"%"+searchParam.getKeyword()+"%",
				index, 
				count
				);
	}

	
	public List<MemberInfo> selectListByBoth(int index, int count, SearchParam searchParam) {
		
		String sql = "SELECT * FROM member where uid like ? or  uname like ?  limit ?, ?";
		
		return template.query(
				sql, 
				new MemberInfoRowMapper(), 
				"%"+searchParam.getKeyword()+"%", 
				"%"+searchParam.getKeyword()+"%",
				index,
				count
				);
		
	}
	

	public MemberInfo selectMemberByIdx(int id) {
		
		String sql = "select * from member where idx=?";
		
		return template.queryForObject(
				sql, 
				new MemberInfoRowMapper(), 
				id
				);
	}
	
	
	public int memberUpdate(MemberInfo memberInfo) {
		String sql = "update member set uname=?, upw=?, uphoto=? where idx=?";
		
		return template.update(
				sql, 
				memberInfo.getuName(), 
				memberInfo.getuPW(), 
				memberInfo.getuPhoto(), 
				memberInfo.getIdx()
				);
		
	}
	

	public int memberUpdate(Connection conn, MemberInfo memberInfo) {
		
		System.out.println(">>>>>>>>>>>> "+memberInfo);
		int rCnt = 0;
		PreparedStatement pstmt = null;
		String sql = 
				"update member set uname=?, upw=?, uphoto=? where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getuName());
			pstmt.setString(2, memberInfo.getuPW());
			pstmt.setString(3, memberInfo.getuPhoto());
			pstmt.setInt(4, memberInfo.getIdx());
			rCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return rCnt;
	}

	
	
	public int memberDelete(Connection conn, int id) {
		
		int rCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from member where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rCnt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
