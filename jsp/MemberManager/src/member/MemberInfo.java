package member;

import java.util.Date;

// usebean Class
public class MemberInfo {
	
	
	// 각 변수의 저근 제어지시자는 private 
	private String uId;
	private String uPW;
	private String uName;
	private String uPhoto;
	private Date regDate;

	
	// default 생성자 필수 
	public MemberInfo() {
		this.regDate = new Date();
	}
	
	public MemberInfo(String uId, String uPW, String uName, String uPhoto) {
		super();
		this.uId = uId;
		this.uPW = uPW;
		this.uName = uName;
		this.uPhoto = uPhoto;
		this.regDate = new Date();
	}
	
	// 변수들의 Getter/Setter  시작

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPW() {
		return uPW;
	}

	public void setuPW(String uPW) {
		this.uPW = uPW;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
	// 데이터 확인을 위한 toString 오버라이딩
	@Override
	public String toString() {
		return "MemberInfo [uId=" + uId + ", uPW=" + uPW + ", uName=" + uName + ", uPhoto=" + uPhoto + ", regDate="
				+ regDate + "]";
	}
	
	// 화면 결과 출력을 위한 HTML 코드 반환
	public String makeHtmlDiv() {
		String str = "";
		
		str += "<div class=\"mInfor\"> \n";
		str += "	<h3> \n";
		str += "		" + uId + "("+ uName +")\n";
		str += "	</h3> \n";
		str += "	<p> \n";
		str += "		"+ uPW;
		str += "	</p> \n";
		str += "</div> \n";
		
		
		
		return str;
	}
	
	// MemberInfo 객체 -> LoginInfo 객체 반환
	public LoginInfo toLoginInfo() {
		
		return new LoginInfo(uId, uName, uPhoto);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
