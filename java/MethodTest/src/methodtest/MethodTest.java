package methodtest;

public class MethodTest {

	public static void main(String[] args) {

		System.out.println("프로그램 시작합니다.");

		hiEveryone(12);

		hiEveryone(15);

		System.out.println("프로그램 종료");

	}

	static void hiEveryone(int age) {

		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는 " + age + "세입니다.");

	}

	static float circle1(float r) {

		float result = 0.0f;
		float pi = 3.14f;

		result = pi * r * r;

		return result;

	}

	static float circle2(float r) {
		float result = 0.0f;
		float pi = 3.14f;

		result = 2 * pi * r;

		return result;
	}

	static boolean checkNum(int num) {
		boolean check = true;

		if (num > 2) {
			for (int i = 2; i < num; i++) {

				if (num % i == 0) {
					check = false;
				}

			}
		} else {
			System.out.println("2보다 큰수의 소수 판별이 가능합니다.");
		}

		return check;
	}

}
