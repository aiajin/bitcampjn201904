package v04;

public class PhoneUnivInfo extends PhoneInfo {
	
	String address;	// 주소
	String email;	// 이메일
	String major;	// 전공
	int grade;	// 학년
	
	
	// 데이터의 초기화
	PhoneUnivInfo(
			String name, 
			String phoneNumber, 
			String address,
			String email, 
			String major, 
			int grade){
		
		super(name, phoneNumber);	// 상위 클래스의 생성자 호출 : 맴버변수의 초기화
		
		this.address = address;
		this.email = email;
		this.major = major;
		this.grade = grade;		
	}


	@Override
	public void showData() {
		//System.out.println("이름		: " + name);
		//System.out.println("전화번호 	: " + phoneNumber);
		super.showData();
		System.out.println("주소 : " + this.address);
		System.out.println("이메일 : " + this.email);
		System.out.println("전공 : " + this.major);
		System.out.println("학년 : " + this.grade);
	}
	
	
	static public void  send (){
		
	}
	

	
	
	
	
	
	
	
	
	
}
