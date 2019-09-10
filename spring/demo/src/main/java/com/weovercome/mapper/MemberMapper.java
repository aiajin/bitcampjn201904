package com.weovercome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import com.weovercome.domain.MemberInfo;

public interface MemberMapper {
	
	@Select("SELECT * FROM member order by idx")
	public List<MemberInfo> getMemberList();
	public MemberInfo selectMemberById(@RequestParam("uId") String uId);
 
}
