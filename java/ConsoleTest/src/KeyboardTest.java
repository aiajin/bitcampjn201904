import java.util.Scanner;

public class KeyboardTest {

	public static void main(String[] args) {

		Scanner sc;
		sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력해 주세요.");
		int num1 = sc.nextInt();
		System.out.println("두번째 숫자를 입력해 주세요.");
		int num2 = sc.nextInt();
		System.out.println("세번째 숫자를 입력해 주세요.");
		int num3 = sc.nextInt();

		int sum = num1 + num2 + num3;

		System.out.printf("입력된 정수 %d, %d, %d 의 합은 %d 입니다.", 
				num1, num2, num3, sum);

		
		
		
		
		
		
		
		
		
		
	}

}
