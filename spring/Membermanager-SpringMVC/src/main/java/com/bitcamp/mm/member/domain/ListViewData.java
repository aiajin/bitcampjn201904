package com.bitcamp.mm.member.domain;

import java.util.List;

public class ListViewData {
	
	private List<MemberInfo> memberList;
	private int totalCount ;
	private int no;
	private int currentPageNumber;

	public List<MemberInfo> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberInfo> memberList) {
		this.memberList = memberList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
	
	

}
