
public class Increment {
	
	private int num=0;
	
	public synchronized void increment() {
		num++;
	}
	
	public int getNum() {
		return num;
	}
	

	public static void main(String[] args) {
		
		Increment increment = new Increment();
		
		IncThread t1 = new IncThread(increment);
		IncThread t2 = new IncThread(increment);
		IncThread t3 = new IncThread(increment);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(increment.getNum());

	}

}

class IncThread extends Thread{
	
	Increment increment;
	
	public IncThread(Increment inc) {
		this.increment = inc;
	}
	
	public void run() {
		for(int i=0; i<10000; i++) {
			increment.increment();
		}
	}
	
}

















