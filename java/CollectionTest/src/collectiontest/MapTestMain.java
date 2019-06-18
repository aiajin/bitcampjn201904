package collectiontest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class MapTestMain {

	public static void main(String[] args) {
		
		// HashMap 형식의 저장 공간 생성
		//HashMap<Integer,String> hMap = new HashMap<Integer, String>();
		TreeMap<Integer, String> tMap = new TreeMap<Integer,String>();
		
		//hMap.put(new Integer("1"), "박나래");
		//hMap.put(new Integer(2), "손흥민");
		//hMap.put(3, "배철수");
		//hMap.put(4, "김신영");
		//hMap.put(5, "유동하");
		
		tMap.put(new Integer("1"), "박나래");
		tMap.put(3, "배철수");
		tMap.put(5, "유동하");
		tMap.put(new Integer(2), "손흥민");		
		tMap.put(4, "김신영");
		
		
		/*
		 * System.out.println("1번 학생의 이름은 "+ hMap.get(new Integer("1")) +"입니다.");
		 * System.out.println("2번 학생의 이름은 "+ hMap.get(new Integer(2)) +"입니다.");
		 * System.out.println("3번 학생의 이름은 "+ hMap.get(3) +"입니다.");
		 * System.out.println("4번 학생의 이름은 "+ hMap.get(4) +"입니다.");
		 * System.out.println("5번 학생의 이름은 "+ hMap.get(5) +"입니다.");
		 */
		
		/*
		 * System.out.println("1번 학생의 이름은 "+ tMap.get(new Integer("1")) +"입니다.");
		 * System.out.println("2번 학생의 이름은 "+ tMap.get(new Integer(2)) +"입니다.");
		 * System.out.println("3번 학생의 이름은 "+ tMap.get(3) +"입니다.");
		 * System.out.println("4번 학생의 이름은 "+ tMap.get(4) +"입니다.");
		 * System.out.println("5번 학생의 이름은 "+ tMap.get(5) +"입니다.");
		 */
		
		NavigableSet<Integer> nav = tMap.navigableKeySet();
		
		Iterator<Integer> itr = nav.iterator();
		
		System.out.println("오름차순 정렬");
		
		while(itr.hasNext()) {
			System.out.println(tMap.get(itr.next()));
		}
		
		System.out.println("내림차순 정렬");
		
		itr = nav.descendingIterator();
		
		while(itr.hasNext()) {
			System.out.println(tMap.get(itr.next()));
		}
		
		
		
		
	
				
				
				
				
		

	}

}
