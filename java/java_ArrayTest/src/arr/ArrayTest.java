package arr;

public class ArrayTest {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int[] ref;
		ref = addAllArray(arr, 7);
		
		String str = null;
		
		
		if(arr==ref) {
			System.out.println("같은 배열 참조");
		} else {
			System.out.println("다른 배열 참조");
		} // if end
		
		System.out.println("============================");
		System.out.println("arr 배열의 요소 출력");
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		System.out.println("============================");
		System.out.println("ref 배열의 요소 출력");
		
		for(int i=0; i<ref.length; i++) {
			System.out.println(ref[i]);
		}
		
	}
	
	// 특정 int[]배열과 증가값 을 받아서 
	// 배열의 각 요소에 값을 증가시키고,
	// 처리한 배열을 다시 반환 하는 메서드 구성
	
	String str;
	
	static int[] addAllArray(int[] arr, int addNum) {
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr[i] + addNum; //  arr[i] += addNum;
		}
		
		return arr;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
