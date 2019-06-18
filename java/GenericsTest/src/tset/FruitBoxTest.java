package tset;

public class FruitBoxTest {

	public static void main(String[] args) {
		
		FruitBox<Apple> fb1 = new FruitBox<Apple>(new Apple(100));
		//fb1.store(new Apple(100));
		Apple apple = fb1.pullOut();
		apple.showAppleWeight();
		
		FruitBox<Orange> fb2 = new FruitBox<Orange>(new Orange(10));
		//fb2.store(new Apple(10));
		Orange orange = fb2.pullOut();
		orange.showSugarContent();
	

	}

	
	
	
	
	
	
	
	
	
	
}
