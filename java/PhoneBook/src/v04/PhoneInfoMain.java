package v04;

import util.Util;

public class PhoneInfoMain {

	public static void main(String[] args) {
		
		//PhoneBookmanager manager = new PhoneBookmanager(100);
		
		PhoneBookmanager manager = PhoneBookmanager.getInstance();
		
		while (true) {
			
			int choice = manager.printMenu();

			switch (choice) {
			case Util.INSERT:
				
				manager.insert();
				
				break;
			case Util.SEARCH:
				manager.serchPrint();
				break;
			case Util.ALLDATA:
				manager.showAllData();
				break;
			case Util.DELETE:
				manager.searchDelete();
				break;
			case Util.QUIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}

		}

	}
	

	
	
	
	
	
	
	
	
	
	
}
