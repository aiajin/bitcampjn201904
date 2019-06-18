package collectiontest;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		
		TreeSet<Person> tSet = new TreeSet<Person>();
		
		tSet.add(new Person("tiger", 30));
		tSet.add(new Person("scott", 20));
		tSet.add(new Person("adams", 50));
				
		Iterator<Person> itr = tSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
	}

}


class Person implements Comparable<Person>{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/*
	 * void showdata() { System.out.println("이름 : " + name + " , 나이 : " + age); }
	 */
	
	

	@Override
	public int compareTo(Person o) {
		// 비교하는 데이터가 작으면 양수 반환
		// 비교하는 데이터가 크면 음수 반환
		// 같으면 0 반환
		int result = 0;
		
		if(this.age>o.age) {
			result = -100; // 양수 반환
		} else if(this.age<o.age) {
			result = 1000; //음수 반환
		} 
		
		
		//return result;
		return o.age-age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
	
}













