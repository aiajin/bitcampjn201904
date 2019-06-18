package v01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneBookCollectionMain {

	public static void main(String[] args) {
		
		
		//iteratorTest();
		
		//hashSetTest();
		
		//hashSetTest1();
		
		testHashSet();
	}
	
	
	static void testHashSet() {
		
		HashSet<PhoneInfo> pSet = new HashSet<PhoneInfo>();
		
		PhoneInfo pi1 = new PhoneInfo("유동하", "01099991111", "20120517");
		PhoneInfo pi2 = new PhoneInfo("손흥민", "01088887777");
		PhoneInfo pi3 = new PhoneInfo("유동하", "01099991111", "20120517");
		
		pSet.add(pi1);
		pSet.add(pi2);
		pSet.add(pi3);
		
		System.out.println("저장된 요소의 개수 : " + pSet.size());
		
		Iterator<PhoneInfo> itr = pSet.iterator();
		
		while(itr.hasNext()) {
			itr.next().showInfo();
		}
	
		
		
		
		
		
		
	}
	
	
	
	static void testArrayList() {
		/*
		 * int cnt = 0; PhoneInfo[] arr = new PhoneInfo[30]; arr[10] = new
		 * PhoneInfo("test", "1111");
		 */
		
		ArrayList<PhoneInfo> pList = new ArrayList<PhoneInfo>();
		
		
		// 친구의 데이터를 저장하고 출력하는 프로그램
		
		PhoneInfo pi1 = new PhoneInfo("유동하", "01099991111", "20120517");
		PhoneInfo pi2 = new PhoneInfo("손흥민", "01088887777");
		
		pList.add(pi1);
		pList.add(pi2);
		
		/*
		 * pi1.showInfo(); System.out.println("---------------------------");
		 * pi2.showInfo();
		 */
		
		for(int i=0; i<pList.size(); i++) {
			pList.get(i).showInfo();
			System.out.println("-----------------------");
			
			if(pList.get(i).name.equals("손흥민")) {
				System.out.println("찾았다 손흥민!!! -> " + i);
			}
		}
		
		pList.remove(1);
		

		for(int i=0; i<pList.size(); i++) {
			pList.get(i).showInfo();
			System.out.println("-----------------------");
			
			if(pList.get(i).name.equals("손흥민")) {
				System.out.println("찾았다 손흥민!!! -> " + i);
			}
		}
	}
	
	

	static void iteratorTest() {
		
		
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("forth");
		
		// 정렬을 위한 인터페이스 Iterator<E>
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			//System.out.println(itr.next());
			//System.out.println(itr.next().equals("first"));
			//System.out.println(itr.next());
			String str = itr.next();
			System.out.println(str);
			
			// 문자열 확인 후 요소 삭제
			if(str.compareTo("third")==0) {
				itr.remove();
			}
		}
		
		System.out.println("삭제 후 요소 참조");
		
		itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		
		
		
		
	}
	
	
	
	
	static void hashSetTest() {
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("first");
		set.add("second");
		set.add("third");
		set.add("first");
		set.add("third");
		
		System.out.println("저장된 요소의 개수 : " + set.size());
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("=======================");
		System.out.println("배열객체로 변환 , 참조");
		
		Object[] strArr = set.toArray();
		
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		System.out.println("========================");
		System.out.println("Set -> List");
		
		ArrayList<String> list = new ArrayList<String>(set);
		
		System.out.println("리스트 요소의 개수 : " + list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		
	}
	
	
	
	static void hashSetTest1() {
		
		HashSet<SimpleNumber> set = new HashSet<SimpleNumber>();
		set.add(new SimpleNumber(10));
		set.add(new SimpleNumber(20));
		set.add(new SimpleNumber(20));
		
		System.out.println("저장된 요소의 개수 : " + set.size());
		
		Iterator<SimpleNumber> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
 		
	}
	
	
	
	
	
	
	
	
	
}

class SimpleNumber {
	
	int num;
	
	public SimpleNumber(int num) {
		this.num = num;
	}
	
	
	
	
	@Override
	public int hashCode() {
		
		return num%3;
	}




	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		
		if(obj !=null && obj instanceof SimpleNumber) {
			SimpleNumber number = (SimpleNumber) obj;
			result = this.num == number.num;
		}
		
		
		return result;
	}




	public String toString() {
		return String.valueOf(num);
		//return ""+num;
	}
}













