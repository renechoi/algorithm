import java.util.Scanner;
public class Main {

	static int[] fibonacciSequenceMap;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		initializeDynamicMap(number);

		fibonacciSequenceMap[0] = 0;
		fibonacciSequenceMap[1] = 1;
		fibonacciCalculation(number);
		
		System.out.println(fibonacciSequenceMap[number]);
	}

	private static void fibonacciCalculation(int number) {
		for (int i = 2; i <= number; i++) {
			fibonacciSequenceMap[i] = fibonacciSequenceMap[i - 1] + fibonacciSequenceMap[i - 2];
		}
	}

	private static void initializeDynamicMap(int number) {
		fibonacciSequenceMap = new int[number + 1];
		for (int i = 0; i <= number; i++) {
			fibonacciSequenceMap[i] = -1;
		}
	}
}
