package test;

public class CarTestMain {

	public static void main(String[] args) {
		HybridWaterCar car = new HybridWaterCar(10, 150, 5);
		
		car.showCurrentData();

	}

}

class Car {
	int gasolin;	
	Car(int g){
		gasolin = g;
	}
}

class HybridCar extends Car {
	// int gasolin
	int electronic;	
	HybridCar(int g, int e){
		super(g);
		electronic = e;
	}
}

class HybridWaterCar extends HybridCar{
	// int gasolin, int electronic
	int water;
	
	HybridWaterCar(int g, int e, int w){
		super(g, e);
		water = w;
	}
	
	
	void showCurrentData() {
		System.out.println("잔여 가솔린 : " + gasolin);
		System.out.println("잔여 전기   : " + electronic);
		System.out.println("잔여 물     : " + water);
	}
}













