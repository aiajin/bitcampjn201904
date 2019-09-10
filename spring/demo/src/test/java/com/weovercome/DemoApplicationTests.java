package com.weovercome;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.weovercome.domain.MemberInfo;
import com.weovercome.mapper.MemberMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private DataSource datasource;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testConnection() throws SQLException {
		System.out.println(datasource);
		Connection conn = datasource.getConnection();
		System.out.println(conn);
		conn.close();
	}
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	
	@Test
	public void testSqlSessionFactory() {
		System.out.println(sessionFactory);
	}
	
	
	
	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testSelectList() {
		
		List<MemberInfo> members = mapper.getMemberList();
		
		for( MemberInfo m : members) {
			System.out.println(m);
		}
	}

	@Test
	public void testSelectMemberById() {
		
		MemberInfo memberInfo = mapper.selectMemberById("ryuyj76@naver.com");
		
		System.out.println("찾았다? --> " + memberInfo);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
