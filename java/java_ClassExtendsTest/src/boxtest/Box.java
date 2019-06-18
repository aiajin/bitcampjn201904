package boxtest;

public class Box {

	private void simpleWrap() {
		System.out.println("Simple Wrap");
	}
	
	public void wrap() {
		//System.out.println("Simple Wrap");
		simpleWrap();
	}
	
	public static void main(String[] args) {
		
		Box box = new Box();
		PaperBox paperBox = new PaperBox();
		GoldPaperBox goldPaperBox = new GoldPaperBox();
		
		Box b1 = box;
		Box b2 = paperBox;
		Box b3 = goldPaperBox;
		
		// Box 타입의 매개변수 : 상속관계에 있는 하위 클래스의 인스턴스 
		wrapBox(box);
		wrapBox(paperBox);
		wrapBox(goldPaperBox);
		
	}
	
	public static void wrapBox(Box box) {
		
		// 어떤 박스이냐에 따라 맞는 포장을 해야한다.
		// 어떤 박스이냐를 확인해야한다.
		// Box -> PaperBox , Box -> GoldPaperBox 
		// 대상 instanceof 확인할 참조변수  --> true / false
		
		box.wrap();
		
		/*
		 * if(box instanceof GoldPaperBox) { ((GoldPaperBox) box).goldWrap(); } else
		 * if(box instanceof PaperBox) { ((PaperBox)box).paperWrap(); } else {
		 * box.simpleWrap(); }
		 */
		
		
	}

}

class PaperBox extends Box {
	private void paperWrap() {
		System.out.println("Paper Wrap");
	}
	
	public void wrap() {
		//System.out.println("Paper Wrap");
		paperWrap();
	}
}

class GoldPaperBox extends PaperBox {
	private void goldWrap() {
		System.out.println("Gold Wrap");
	}
	
	public void wrap() {
		//System.out.println("Gold Wrap");
		goldWrap();
	}
}









