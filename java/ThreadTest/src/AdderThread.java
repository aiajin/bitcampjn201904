
public class AdderThread extends Sum implements Runnable{

	int start;
	int end;
	
	public AdderThread(int s, int e) {
		start = s;
		end = e;
	}
	
	
	@Override
	public void run() {
		
		for(int i=start;i<=end;i++) {
			addNum(i);
		}
	}

}
