package v05;

import util.Menu;
import util.Util;

public class PhoneBookmanager {

	// 객체저장을 목적으로 배열 생성
	// 배열의 요소 컨트롤을 위한 메서드 구성

	final PhoneInfo[] pb;
	int cnt;
	
	// 싱글톤 패턴
	// 1. 생성자의 접근 제한 : private 생성자()
	// 2. 클래스 내부에서 인스턴스 생성 : static, private 
	// 3. 참조값을 반환하는 메서드 생성 : static
	
	
	// 인스턴스를 반환하는 메서드
	public static PhoneBookmanager getInstance() {
		if(m == null) {
			m = new PhoneBookmanager();
		}
		return m;
	}
	
	// 인스턴스 생성
	private static PhoneBookmanager m = new PhoneBookmanager();
	// PhoneBookmanager.m = null;

	// 외부에서 인스턴스 생성을 금지한다.
	private PhoneBookmanager() {
		// pb = new PhoneInfo[100];
		// cnt=0;
		this(100);
	}

	// 외부에서 인스턴스 생성을 금지한다.
	private PhoneBookmanager(int size) {
		pb = new PhoneInfo[size];
		cnt = 0;
	}

	// 친구정보 입력 메서드
	// PhoneInfo 타입의 배열에 저장
	// 사용자로부터 이름, 전화번호, 생일 데이터를 입력 받아서
	// 인스턴스 생성 ->
	// 배열에 저장, index -> cnt
	// cnt++
	public void insertMember(int select) {
		
		// 1. 기본정보 받기 : 이름 , 전화번호
		// 2. 흐름 결정 : if(select)
		//    1 - 대학친구의 추가정보 받기,인스턴스 생성
		//    2 - 회사친구의 추가정보 받기,인스턴스 생성
		//    3 - 동호회친구의 추가정보 받기,인스턴스 생성
		// 
		// 4. 배열에 저장
		
		PhoneInfo pi = null;
		
		
		// 1. 기본정보 받기
		System.out.println("친구의 이름을 입력해주세요.");
		String name = Util.keyboard.nextLine();
		System.out.println("친구의 전화번호를 입력해주세요.");
		String phoneNumber = Util.keyboard.nextLine();
		
		
		// 3. 입력의 흐름 처리
		
		if( select==Menu.INSERT_UNIV ) {
			// 대학친구의 추가정보 받기
			System.out.println("주소를 입력해주세요.");
			String address = Util.keyboard.nextLine();
			
			System.out.println("이메일을 입력해주세요.");
			String email = Util.keyboard.nextLine();
			
			System.out.println("전공을 입력해주세요.");
			String major = Util.keyboard.nextLine();
			
			System.out.println("학년을 입력해주세요.");
			int grade = Util.keyboard.nextInt();
			
			
			// 인스턴스 생성
			pi = new PhoneUnivInfo(
					name, 
					phoneNumber, 
					address, 
					email, 
					major, 
					grade);
			
			
		} else if( select==Menu.INSERT_COM ) {
			// 회사친구의 추가정보 받기
			
			System.out.println("회사이름을 입력해주세요.");
			String company = Util.keyboard.nextLine();
			
			System.out.println("이메일을 입력해 주세요.");
			String email = Util.keyboard.nextLine();
			
			// 인스턴스 생성
			
			pi = new PhoneCompanyInfo(
					name, 
					phoneNumber, 
					company, 
					email);
			
		} else {
			// 동호회 친구 정보 받기
			
			System.out.println("별명을 입력해주세요.");
			String nickName = Util.keyboard.nextLine();
						
			// 인스턴스 생성
			pi = new PhoneCafeInfo(
					name, 
					phoneNumber, 
					nickName);
		}
		
	
		
		
		// 4. 인스턴스를 배열에 저장
		pb[cnt++] = pi;
		
		System.out.println("입력하신 정보가 저장되었습니다.");
		

	}

	// 배열에 저장된 모든 데이터를 출력
	public void showAllData() {

		System.out.println("=======================");

		if (cnt > 0) {

			for (int i = 0; i < cnt; i++) {
				pb[i].showData(); // PhoneInfo.
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
	public void serchPrint() {

		System.out.println("검색할 친구의 이름을 입력해주세요.");
		String name = Util.keyboard.nextLine();

		// 검색 결과의 index : -1 ( 검색의 결과가 없다 )
		//int index = -1;

		// 배열에서 문자열 비교 후 같은 값을 가지는 객체의 index 값을 구하는 기능
		/*
		 * for (int i = 0; i < cnt; i++) { if (pb[i].name.equals(name)) { index = i;
		 * break; } }
		 */
		
		int index = searchIndex(name);
		
		

		// 검색된 index 값을 비교하고 정보 출력
		if (index < 0) {
			System.out.println("검색하신 이름의 정보가 없습니다.");
		} else {
			//pb[index].showData();
			pb[index].showBasicInfo();
		}

	}

	// 친구정보를 이름기준으로 검색 후 정보를 삭제하는 메서드
	// 1. 삭제하고자하는 친구의 이름 사용자로부터 받는다.
	// 2. 배열에서 친구의 이름을 비교 검색 -> index 값을 찾기
	// 3. 데이터를 삭제
	// : 배열의 요소에서 삭제하고자하는 객체를 참조하지 않으면 삭제와 동일
	// : pd[3] 삭제 -> pd[3] = null;
	// 4. 배열의 삭제 index 기준으로 <---- 시프트
	// : pd[3] 삭제 -> pd[3] = pd[4]; pd[4] = pd[5];
	public void searchDelete() {

		System.out.println("삭제하고자하는 친구의 이름을 입력해 주세요.");
		String name = Util.keyboard.nextLine();

		int index = searchIndex(name);

		

		if (index < 0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		} else {

			// 삭제 : 검색한 index 부터 저장된 위치까지 왼쪽으로 시프트 처리
			for (int i = index; i < cnt - 1; i++) {
				pb[i] = pb[i + 1];
			}

			// 저장된 친구 정보의 개수 감소
			cnt--;

			System.out.println("요청하신 이름의 정보를 삭제했습니다.");

		}

	}
	
	// 키워드로 배열의 요소.name 문자열과 비교 후 매칭되는 요소의 index를 반환
	public int searchIndex(String keyword) {
		
		// 검색 결과의 index : -1 ( 검색의 결과가 없다 )
		int index = -1;

		// 배열에서 문자열 비교 후 같은 값을 가지는 객체의 index 값을 구하는 기능
		for (int i = 0; i < cnt; i++) {
			if (pb[i].name.equals(keyword)) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	
	
	
	
	

	public int printMenu() {
		System.out.println("===================================");
		System.out.println("메뉴 번호를 선택해 주세요.");
		System.out.printf("%d. 입력\n%d. 검색\n%d. 삭제\n%d. 전체 정보 출력\n%d. 종료\n",
				Menu.INSERT,Menu.SEARCH, Menu.DELETE, Menu.ALLDATA, Menu.QUIT);
		System.out.println("===================================");

		int choice = Util.keyboard.nextInt();

		Util.keyboard.nextLine(); // 현재 라인의 버퍼를 출력(clear)

		return choice;

	}
	
	
	public void insert() {
		System.out.println("===============");
		System.out.println("입력 형태를 선택해 주세요.");
		System.out.println(Menu.INSERT_UNIV+". 대학친구");
		System.out.println(Menu.INSERT_COM+". 회사친구");
		System.out.println(Menu.INSERT_CAFE+". 동호회친구");
		System.out.println("===============");
		
		// 입력 방식 선택
		int select = Util.keyboard.nextInt();
		
		Util.keyboard.nextLine();
		
		insertMember(select);

		
	}
	

	

}
