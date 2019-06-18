import javax.swing.JOptionPane;

public class ThreadEx2 {
	
	static boolean inputCheck = false;
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread4();
		t1.start();
		
		
		String str = JOptionPane.showInputDialog("값을 입력해주세요.");
		
		System.out.println("입력완료 : " + str);
		inputCheck = true;
		
		
	}

}

class Thread4 extends Thread {
	
	public void run() {

		for(int i=10; i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
				if(ThreadEx2.inputCheck) {
					System.out.println("카운트 다운을 중단합니다.");
					return;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("입력시간을 초과해서 종료합니다.");
		System.exit(0);
		
		
	}
	
}













