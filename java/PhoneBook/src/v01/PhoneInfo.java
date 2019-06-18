package v01;


// v01.PhoneInfo
class PhoneInfo {
	
	/*
	 * 친구의 정보를 저장하는 클래스
	 * 
	 * • 이름 	name 		String 
	 * • 전화번호 phoneNumber String 
	 * • 생년월일 birthday 	String 
	 * 저장된 데이터의 적절한 출력이 가능하도록 메소드 
	 * 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성
	 */
	
	String name;		// 친구의 이름 저장
	String phoneNumber;	// 친구의 전화번호 저장
	String birthday;	// 친구의 생일 저장
	
	
	// 속성 = 변수 = 필드
	
	// 생성자 : 기본 정보 초기화 ( 이름, 전화번호, 생일 )
	PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	// 생성자 : 이름과 전화번호 저장
	PhoneInfo(String name, String phoneNumber) {
		//this(name, phoneNumber, null);
		this(name, phoneNumber, "저장된 데이터가 없습니다.");
	}
	
	// 친구 정보출력 메서드
	void showInfo() {
		System.out.println("이름     : " + name );
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("생일     : " + birthday);
		/*
		 * if(birthday != null ) { 
		 * System.out.println("생일     : " + birthday); 
		 * } else {
		 * System.out.println("생일     : 등록된 정보가 없습니다."); }
		 */
	}

	@Override
	public int hashCode() {
		
		// phonenumber : String -> int
		// 010-0000-1112 : 문자열의 마지막 문자 축출
		// 

		return phoneNumber.charAt(phoneNumber.length()-1);
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		
		if(obj != null && obj instanceof PhoneInfo) {
			PhoneInfo pi = (PhoneInfo) obj;
			result = this.phoneNumber.equals(pi.phoneNumber);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
