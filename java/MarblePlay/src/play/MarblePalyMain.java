package play;

public class MarblePalyMain {

	public static void main(String[] args) {
		
		/*
		어린이 1의 보유자산  구슬 15개
		어린이 2의 보유자산  구슬 9개
		*/
		
		Boy boy1 = new Boy("철수", 15);
		Boy boy2 = new Boy("영희", 9);
		
		
		/* 구슬의 개수 설정 -> 변수 참조 */		
		//boy1.mNum = 15;
		//boy2.mNum = 9;
		

		//System.out.println("어린이 1의 구슬의 개수 : ");
		boy1.showNumber();
		//System.out.println("어린이 2의 구슬의 개수 : ");
		boy2.showNumber();
		System.out.println("=================================");
		
		
		/* 게임 플레이 */
		
		// 1차 게임 : 어린이1이 구슬 2개 획득
		boy1.gameWin(2, boy2);
		
		


		boy1.showNumber();
		boy2.showNumber();
		
		System.out.println("=================================");
		
		
		
		
		// 2차 게임 : 어린이2가 구슬 7개 획득
		boy2.gameWin(7, boy1);
		
		
		/* 각각의 어린이들의 구슬의 개수 현황 출력 */
		

		boy1.showNumber();
		boy2.showNumber();
		
		
		
		
		
		
		
	}

}
