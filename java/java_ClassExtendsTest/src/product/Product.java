package product;

public class Product {
	
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0f);
	}
}

class Tv extends Product{

	Tv() {
		super(100);		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TV";
	}	
}

class Computer extends Product {
	
	Computer(){
		super(200);
	}
	
	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio(){
		super(50);
	}
	public String toString() {
		return "Audio";
	}
}












