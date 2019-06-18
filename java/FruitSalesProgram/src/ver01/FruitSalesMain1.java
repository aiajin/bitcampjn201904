package ver01;

public class FruitSalesMain1 {

	public static void main(String[] args) {
		/*
		 * FruitSeller seller = new FruitSeller(); FruitBuyer buyer = new FruitBuyer();
		 * buyer.buyApple(seller, 2000); System.out.println("과일 판매자의 현재 상황");
		 * seller.showSaleResult(); System.out.println("과일 구매자의 현재 상황");
		 * buyer.showBuyResult();
		 */
		
		/* 사과장수 등록 */
		FruitSeller seller1 = new FruitSeller(20, 0, 1000);
		FruitSeller seller2 = new FruitSeller(10, 0, 1500);
		
		/* 구매자 등록 */
		FruitBuyer buyer1 = new FruitBuyer();
		FruitBuyer buyer2 = new FruitBuyer(10000);
		
		
		//seller1.myMoney += 10000;
		//buyer1.numOfApple += 20;
		
		
		buyer1.buyApple(seller1, 2000);
		buyer1.buyApple(seller2, 3000);
		
		buyer2.buyApple(seller1, 3000);
		buyer2.buyApple(seller2, 6000);
		
		
		System.out.println("판매자1 의 현황");
		seller1.showSaleResult();
		
		System.out.println("판매자2 의 현황");
		seller2.showSaleResult();
		
		System.out.println("=============================");
		
		System.out.println("구매자1 의 현황");
		buyer1.showBuyResult();

		System.out.println("구매자2 의 현황");
		buyer2.showBuyResult();

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
