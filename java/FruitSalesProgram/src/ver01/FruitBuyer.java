package ver01;

public  class FruitBuyer {
	
	//int myMoney = 5000;
	//int numOfApple = 0;
	
	private int myMoney;
	private int numOfApple;
	
	/* 생성자
	 * @money : 사용자 보유 금액 
	*/	
	FruitBuyer(int money){
		myMoney = money;
		numOfApple = 0;	 // 최초 보유 개수는 0으로 한다.	
	}
	
	FruitBuyer() {
		//myMoney = 5000;
		this(5000);
		
	}
	
	
	
	

	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}

	public void showBuyResult() {
		System.out.println("현재 잔액: " + myMoney);
		System.out.println("사과 개수: " + numOfApple);
	}
}













