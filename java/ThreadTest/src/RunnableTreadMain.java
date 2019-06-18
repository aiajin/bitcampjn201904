
public class RunnableTreadMain {

	public static void main(String[] args) {
		
		// Runnable 객체 이용한 쓰레드 생성
		// 1. Runnable interface를 구현하는 크래스 기반의 객체 생성
		AdderThread aT1 = new AdderThread(0, 50);
		AdderThread aT2 = new AdderThread(51, 100);
		
		// 2. Thread 생성 : 해야할일을 정의.
		Thread t1 = new Thread(aT1);
		Thread t2 = new Thread(aT2); 
		
		// 3. 쓰레드의 실행
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println("aT1 num : " + aT1.getNum());
		//System.out.println("aT2 num : " + aT2.getNum());
		System.out.println("0~100까지의 합은 : " + (aT1.getNum()+aT2.getNum()));

	}

	
	
	
	
	
	
	
	
	
	
}
