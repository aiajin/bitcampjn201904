package tset;

public class FruitBox<T> {
	
	T item;
	
	public FruitBox(T item) {
		this.item = item;
	}

	public void store(T item) {
		this.item = item;
	}
	
	public T pullOut() {
		return item;
	}

}
