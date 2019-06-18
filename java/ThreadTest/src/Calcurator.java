public class Calcurator {
	
	int opCnt = 0;
	
	public  int add(int n1, int n2) {		
		synchronized (this) {
			opCnt++;
		}
		return n1+n2;
	}
	
	public  int min(int n1, int n2) {
		synchronized (this) {
			opCnt++;
		}		
		return n1-n2;
	}
	
	public void showOpCnt() {
		System.out.println("연산의 횟수 : " + opCnt);
	}
	
	public static void main(String[] args) {
		
		Calcurator c = new Calcurator();
		
		AddThread at = new AddThread(c);
		MinThread mt = new MinThread(c);
		
		at.start();
		mt.start();
		
		try {
			at.join();
			mt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.showOpCnt();
		
	}

}


class AddThread extends Thread{
	
	Calcurator cal;
	
	public AddThread(Calcurator c) {
		cal = c;		
	}
	
	public void run() {
		System.out.println("1+2="+cal.add(1, 2));
		System.out.println("2+4="+cal.add(2, 4));
	}
}

class MinThread extends Thread{
	
	Calcurator cal;
	
	public MinThread(Calcurator c) {
		cal = c;		
	}
	
	public void run() {
		System.out.println("2-1="+cal.min(2, 1));
		System.out.println("4-2="+cal.min(4, 2));
	}
	
}















