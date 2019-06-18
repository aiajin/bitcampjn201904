package collectiontest;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		// 컬렉션(List -> ArrayList) 객체에 요소(객체, 참조변수) 저장 
		list.add(new Integer(11));
		list.add(new Integer("22"));
		list.add(33);
		
		// 요소 전체 참조
		System.out.println("리스트에 저장된 요소들의 출력");
		for(int i=0;i<list.size(); i++) {			
			System.out.println(list.get(i));
		}
		
		// 요소 삭제
		list.remove(1);
		

		// 요소 전체 참조
		System.out.println("삭제 후 리스트에 저장된 요소들의 출력");
		for(int i=0;i<list.size(); i++) {			
			System.out.println(list.get(i));
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
}
