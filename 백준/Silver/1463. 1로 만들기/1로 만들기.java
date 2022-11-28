import java.util.Scanner;

public class Main {
	static int numberTargeted;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		numberTargeted = scanner.nextInt();

		numbers = new int[numberTargeted + 1];
		numbers[1] = 0;
		for (int i = 2; i <= numberTargeted; i++) {

			/**
			 * N = 2 -> 2 - 1 -> 1
			 * N = 3 -> 3 % 3 -> 1
			 * N = 4 -> 4 % 2 => 2
			 * N = 5 -> ( ( 5 - 1 ) % 2 ) - 1=> 3
			 * N = 6 -> ( 6 % 3 ) - 1 => 2
			 * ...
			 * N = 12 -> min( %3 or %2 or -1) => min(N[12/3]+1, N[12/2]+1, N[12-1]+1)
			 */

			recurrence1(i);
			recurrence2(i);
			recurrence3(i);
		}
		System.out.println(numbers[numberTargeted]);
	}

	private static void recurrence3(int i) {
		if (i % 3 == 0) {
			numbers[i] = Math.min(numbers[i], numbers[i / 3] + 1);
		}
	}

	private static void recurrence2(int i) {
		if (i % 2 == 0) {
			numbers[i] = Math.min(numbers[i], numbers[i / 2] + 1);
		}
	}

	private static void recurrence1(int i) {
		numbers[i] = numbers[i - 1] + 1;
	}
}
