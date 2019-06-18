
public class ThreadMain {

	public static void main(String[] args) throws Exception {
		
		//throw new Exception();
		
		// thread 클래스를 상속하는 Thread 객체 생성
		ThreadEx1 t1 = new ThreadEx1();
		
		// Runnable 인터페이스를 구현한 클래스 생성
		ThreadRunable r = new ThreadRunable();
		// Runnable 클래스 기반으로 Thread 인스턴스 생성
		Thread t2 = new Thread(r);

		// Thread의 시작은 start()로 시작 -> 쓰래스 생성(일의 흐름) -> run() 호출
		
		t1.start();
		t2.start();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
