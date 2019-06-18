package test;

public class Man { // extends Object
	
	String name;
	
	public Man(String name) {
		this.name = name;
	}
	
	public Man() {
		this.name = "name";
	}
	
	public void tellYourName() {
		System.out.println("나의 이름은 " + name + "입니다.");
	}

}
