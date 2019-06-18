package product;

public class ProductTestMain {

	public static void main(String[] args) {
		
		Buyer buyer = new Buyer();
		
		Tv tv = new Tv();
		Computer computer = new Computer();
		Audio audio = new Audio();
		
		
		buyer.buy(computer);
		buyer.buy(tv);
		buyer.buy(audio);
		
		buyer.summary();
		
		//System.out.println("현재 남은 돈은 " + buyer.money + "만원 입니다.");
		//System.out.println("현재 보너스포인트는 " + buyer.bonusPoint + "포인트 입니다.");
		

	}

	
	
	
	
	
	
	
	
	
	
}
