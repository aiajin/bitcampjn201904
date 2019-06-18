package v02;

import util.Util;

class Manager {
	
	
	// Singleton 패턴 적용
	
	// 1. 생성자의 접근제어지시자를 private 정의 
	//    : 외부에서 생성자 호출 불가 -> 인스턴스 생성 불가	
	private Manager(){}
	
	// 2. 사용할 인스턴스 생성 
	//    : static 메서드에서 사용가능하도록 변수에 static 처리
	//    : 외부의 직접 참조를 막기 위해 private 처리	
	static private Manager m = new Manager();
	
	// 3. 외부에서 인스턴스 요청할 메서드 
	//    : static 을 통한 외부 호출이 가능하도록 처리
	//    : 외부 어디에서든 호출이 가능하도록 public 처리	
	public static Manager getinstance() {		
		if(m == null) {
			m = new Manager();
		}		
		return m;
	}
	
	
	
	void insertMember() {
		// 입력 받기 -> 인스턴스 생성 -> 출력

		// 현재 입력 스케너의 버퍼를 삭제
		// 1
		Util.keyboard.nextLine();

		// 사용자의 입력데이터 임시 저장
		String name = null;
		String pNumber = null;
		String birthday = null;

		System.out.println("데이터 입력");
		System.out.println("친구의 이름을 입력해 주세요.");
		name = Util.keyboard.nextLine();

		System.out.println("친구의 전화번호를 입력해 주세요.");
		pNumber = Util.keyboard.nextLine();

		System.out.println("친구의 생일을 입력해 주세요.");
		birthday = Util.keyboard.nextLine();

		// 사용자로부터 입력받은 데이터로 인스턴스 생성 ( 객체의 변수에 저장 )
		PhoneInfo pi = null;

		if (birthday == null || birthday.trim().length() < 1) {
			// pi = new PhoneInfo(name, pNumber);
			pi = new PhoneInfo(name, pNumber);
		} else {
			pi = new PhoneInfo(name, pNumber, birthday);
		}

		pi.showInfo();

	}
}
