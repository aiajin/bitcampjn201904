package v02;

import util.Util;

class PhoneBookMain {
	
	//static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		// 1. 프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성
		// 2. 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
		// 3. 프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
		
		// java.util.Scanner keyboard;
		// Scanner keyboard = new Scanner(System.in);
		
		//Manager manager = new Manager();
		
		Manager manager = Manager.getinstance();
		
		
		while(true) {
			
			System.out.println("===================");
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 입력 , 2. 종료");
			System.out.println("===================");
			
			int choice = Util.keyboard.nextInt();
			
			if(choice == 1) {
				
				// 입력처리
				manager.insertMember();
				
			} else if(choice == 2 ) {
				System.out.println("프로그램 종료");
				//return; // 메인메서드 종료 -> 프로그램의 종료
				break;
			} else {
				System.out.println("정상적인 메뉴번호를 입력해주세요.");
			}
		}
		
				
	}
	
	/*
	 * static void insertMember() { // 입력 받기 -> 인스턴스 생성 -> 출력
	 * 
	 * 
	 * 
	 * // 현재 입력 스케너의 버퍼를 삭제 // 1 Util.keyboard.nextLine();
	 * 
	 * // 사용자의 입력데이터 임시 저장 String name = null; String pNumber = null; String
	 * birthday = null;
	 * 
	 * System.out.println("데이터 입력"); System.out.println("친구의 이름을 입력해 주세요."); name =
	 * Util.keyboard.nextLine();
	 * 
	 * System.out.println("친구의 전화번호를 입력해 주세요."); pNumber = Util.keyboard.nextLine();
	 * 
	 * System.out.println("친구의 생일을 입력해 주세요."); birthday = Util.keyboard.nextLine();
	 * 
	 * // 사용자로부터 입력받은 데이터로 인스턴스 생성 ( 객체의 변수에 저장 ) PhoneInfo pi = null;
	 * 
	 * if(birthday == null || birthday.trim().length()<1) { //pi = new
	 * PhoneInfo(name, pNumber); pi = new PhoneInfo(name, pNumber); } else { pi =
	 * new PhoneInfo(name, pNumber, birthday); }
	 * 
	 * pi.showInfo();
	 * 
	 * }
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	

}
