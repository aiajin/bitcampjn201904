
public class ThreadEx1 extends Thread {

	@Override
	public void run() {
		
		throwException();
		
		/*
		 * for(int i=0; i<5;i++) { System.out.println(getName() + " : " + getId()); }
		 */
		
	}
	
	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	

}
