package com.weovercome.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.querydsl.binding.QuerydslPredicate;

@Entity
@NamedQuery(
		name = "findWithIdx",
		query ="from MemberEntity where idx= :fidx  "
		)
@NamedQueries(
		value= {
				@NamedQuery(
						name = "findWithName",
						query ="from MemberEntity where uname like :fname"
				),
				@NamedQuery(
						name = "findWithParam",
						query ="from MemberEntity where idx= :fidx or uname like :fname or uid like :fuid"
				)
		}
		
	)
@Table(name = "member")
public class MemberEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long idx;
	
	@Column(length = 45, nullable = false)
	@NotNull // ● 필수 항목
	@Email
	private String uid;
	
	@Column(length = 45, nullable = false)
	@NotNull // ● 필수 항목
	private String upw;
	
	@Column(length = 45, nullable = false)
	@NotEmpty // ● 필수 항목
	private String uname;
	
	@Column(length = 45, nullable = true)
	private String uphoto;

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUphoto() {
		return uphoto;
	}

	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}

	@Override
	public String toString() {
		return "MemberEntity [idx=" + idx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto
				+ "]";
	}
	
	
	
	
	
}
