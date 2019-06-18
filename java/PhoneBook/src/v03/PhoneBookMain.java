package v03;

import util.Util;

public class PhoneBookMain {
	
	// 친구정보를 배열로 저장 : 100개 저장 가능
	static PhoneInfo[] pb = new PhoneInfo[100];
	
	// 입력된 친구 정보의 개수 : 입력 시 +1, 삭제 시 -1
	// 배열의 전체 참조시에 배열의 사이즈 대신 반복의 횟수를 정의
	static int cnt = 0;

	public static void main(String[] args) {

		while (true) {
			
			int choice = printMenu();

			// System.out.println("사용자가 입력한 메뉴 값 : " + choice);

			switch (choice) {
			case 1:
				insertMember();
				break;
			case 2:
				serchPrint();
				break;
			case 3:
				searchDelete();
				break;
			case 4 :
				showAllData();
				break;
			case 5:
				System.out.println("사용자가 입력한 명령은 종료 입니다. \n 프로그램을 종료 합니다.");
				return;
				

			default:
				break;
			}
		}

	}

	// 친구정보 입력 메서드 
	// PhoneInfo 타입의 배열에 저장
	// 사용자로부터 이름, 전화번호, 생일 데이터를 입력 받아서 
	// 인스턴스 생성 -> 
	// 배열에 저장, index -> cnt 
	// cnt++
	public static void insertMember() {
				
		System.out.println("친구 정보 입력");
		
		System.out.println("이름을 입력해주세요.");
		String name = Util.keyboard.nextLine();
		
		System.out.println("전화번호를 입력해주세요.");
		String pNum = Util.keyboard.nextLine();
		
		System.out.println("생일정보를 입력해주세요.");
		String birthday = Util.keyboard.nextLine();
		
		// 저장을 위한 인스턴스의 참조변수 생성
		PhoneInfo pi = null;
		
		
		// 데이터의 저장
		//if(birthday == null || birthday.trim().length()<1) {
		//	pi = new PhoneInfo(name, pNum);
		//} else {
		//	pi = new PhoneInfo(name, pNum, birthday);
		//}
		
		// 배열에 저장 : PhoneInfo[] 저장 -> PhoneInfo 참조값을 저장
		//pb[cnt] = pi;
		
		// 등록된 친구저옵의 개수를 1 증가
		//cnt++;
		
		
		if(birthday == null || birthday.trim().length()<1) {					
			pb[cnt++] = new PhoneInfo(name, pNum);
		} else {
			pb[cnt++] = new PhoneInfo(name, pNum, birthday);
		}
		

		System.out.println("입력하신 정보가 저장되었습니다.");
		
		
		
		
	}
	
	// 배열에 저장된 모든 데이터를 출력
	public static void showAllData() {
		
		System.out.println("=======================");
		
		if(cnt>0) {
		
			for(int i=0; i<cnt; i++) {
				pb[i].showInfo();
				System.out.println("------------");
			}
		} else {
			System.out.println("등록된 친구정보가 없습니다.");
		}
		
		System.out.println("=======================");
		
	}
	
	
	// 친구정보를 이름기준으로 검색후 정보 출력 하는 메서드
	// 배열의 요소인 PhoneInfo 객체의 name 의 문자열과 검색 키워드 문자열을 비교 해당 객체의 정보를 출력
	// 1. 사용자에게 찾고자하는 이름 데이터 문자열을 받는다.
	// 2. 배열의 모든 요소에서 PhoneInfo 객체의 name과 키워드(검색 이름) 비교
	// 3. 같은 문자열이 나온 index 저장 : index 값을 저장할 변수가 필요 -> 변수 선언
	// 4. 찾은 index 값의 배열 위치의 객체 데이터 출력
	public static void serchPrint() {
		
		
		
		System.out.println("검색할 친구의 이름을 입력해주세요.");
		String name = Util.keyboard.nextLine();
		
		// 검색 결과의 index : -1 ( 검색의 결과가 없다 )
		int index = -1;
		
		// 배열에서 문자열 비교 후 같은 값을 가지는 객체의 index 값을 구하는 기능 
		for(int i=0; i<cnt; i++) {
			if(pb[i].name.equals(name)) {
				index=i ;
				break;
			}
		}
		
		// 검색된 index 값을 비교하고 정보 출력
		if(index<0) {
			System.out.println("검색하신 이름의 정보가 없습니다.");
		} else {
			pb[index].showInfo();
		}
		
		
	}
	
	// 친구정보를 이름기준으로 검색 후 정보를 삭제하는 메서드
	// 1. 삭제하고자하는 친구의 이름 사용자로부터 받는다.
	// 2. 배열에서 친구의 이름을 비교 검색 -> index 값을 찾기
	// 3. 데이터를 삭제 
	//    : 배열의 요소에서 삭제하고자하는 객체를 참조하지 않으면 삭제와 동일
	//    : pd[3] 삭제 -> pd[3] = null;
	// 4. 배열의 삭제 index 기준으로    <---- 시프트
	//    : pd[3] 삭제 -> pd[3] = pd[4]; pd[4] = pd[5];
	public static void searchDelete() {
		
		
		
		System.out.println("삭제하고자하는 친구의 이름을 입력해 주세요.");
		String name = Util.keyboard.nextLine();
		
		int index = -1;
		
		for(int i=0; i<cnt; i++) {
			if(pb[i].name.equals(name)) {
				index = i;
			}
		}
		
		if(index<0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		} else {
			
			// 삭제 : 검색한 index 부터 저장된 위치까지 왼쪽으로 시프트 처리
			for(int i=index; i<cnt-1 ; i++) {
				pb[i] = pb[i+1];
			}
			
			// 저장된 친구 정보의 개수 감소
			cnt--;
			
			System.out.println("요청하신 이름의 정보를 삭제했습니다.");
			
		}
		
	}
	
	
	
	
	
	
	
	

	public static int printMenu() {
		System.out.println("===================================");
		System.out.println("메뉴 번호를 선택해 주세요.");
		System.out.println("1. 입력\n2. 검색\n3. 삭제\n4. 전체 정보 출력\n5. 종료");
		System.out.println("===================================");

		int choice = Util.keyboard.nextInt();
		
		
		Util.keyboard.nextLine(); // 현재 라인의 버퍼를 출력(clear)
		

		return choice;

	}
	
	
	
	
	
	
	
	

}
