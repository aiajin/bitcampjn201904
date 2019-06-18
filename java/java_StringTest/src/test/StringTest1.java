package test;

public class StringTest1 {

	public static void main(String[] args) {
		
		
		
		String str1 = "My JAVA";
		String str2 = "My JAVA";
		String str3 = "Your JAVA";
		String str4 = new String("My JAVA");
		
		System.out.println(str1==str4.intern());
		
		System.out.println("=======================");

		
		boolean strCheck = str1.equals(str4);
		
		if(strCheck) {
			System.out.println("문자열이 같다.");
		} else {
			System.out.println("문자열이 다르다.");
		}
		
		System.out.println("==============================");
		
		
		if(str1==str2) {
			System.out.println("참조하는 주소값이 같다");
		}
		
		if(str1==str3) {
			System.out.println("참조하는 주소값이 같다.");
		} else {
			System.out.println("참조하는 주소값이 다르다.");
		}
		
		if(str1==str4) {
			System.out.println("참조하는 주소값이 같다.");
		} else {
			System.out.println("참조하는 주소값이 다르다.");
		}
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
