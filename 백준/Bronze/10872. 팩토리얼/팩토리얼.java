import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		/**
		 * f(5) 
		 * = 5 x f(4) 
		 * =       4 x f(3)
		 * =             3 x f(2) 
		 * =                   2 x f(1) 
		 * -> f(1) = 1 (return)
		 * =                   2 x 1 
		 * =             3 x 2 x 1
		 * =       4 x 3 x 2 x 1
		 * = 5 x 4 x 3 x 2 x 1 
		 * = answer 
		 */

		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println(factorial(number));
	}

	private static int factorial(int number) {
		if (number <= 1) {
			return 1;
		}
		return number * factorial(number - 1);
	}
}