package v01;

class PhoneBookMain {

	public static void main(String[] args) {
		
		// 친구의 데이터를 저장하고 출력하는 프로그램
		
		PhoneInfo pi1 = new PhoneInfo("유동하", "01099991111", "20120517");
		PhoneInfo pi2 = new PhoneInfo("손흥민", "01088887777"); 
		
		pi1.showInfo();
		System.out.println("---------------------------");
		pi2.showInfo();

	}

}
