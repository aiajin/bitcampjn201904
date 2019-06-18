package product;

public class Buyer {

	int money = 1000;
	int bonusPoint = 0;
	
	/* 제품을 담을 배열을 생성 */
	Product[] cart = new Product[10];
	int cartCnt = 0;

	void buy(Product p) { // Computer, Tv, Audio
		
		if(money >= p.price) {
			money -= p.price;
			bonusPoint += p.bonusPoint;
			
			// 카트에 제품을 담는다.
			cart[cartCnt++] = p;
			
			System.out.println(p+"을/를 구입하셨습니다.");
		} else {
		}
		
	}

	void summary() {
		
		int sum = 0;
		String itemList = "";
		
		for(int i=0; i<cartCnt; i++) {
			
			sum += cart[i].price;
			itemList += cart[i]+", " ;
		}
		
		System.out.println("구입하신 제품들의 총 구매액은 "+ sum + "만원 입니다.");
		System.out.println("구입하신 제품의 목록은 "+ itemList + "입니다.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
