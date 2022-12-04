import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int numberCounts = Integer.parseInt(bufferedReader.readLine());

		int[] numbers = new int[numberCounts];
		for (int i = 0; i < numberCounts; i++) {
			numbers[i] = Integer.parseInt(bufferedReader.readLine());
		}

		int gcdBtwDifference = Math.abs(numbers[0] - numbers[1]);
		for (int i = 1; i < numberCounts - 1; i++) {
			gcdBtwDifference = gcd(gcdBtwDifference, Math.abs(numbers[i] - numbers[i + 1]));
		}

		System.out.println(commonDivisors(gcdBtwDifference));
	}

	private static StringBuilder commonDivisors(int gcdBtwDifference) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 2; i <= gcdBtwDifference; i++) {
			if (gcdBtwDifference % i == 0) {
				stringBuilder.append(i).append(" ");
			}
		}
		return stringBuilder;
	}

	private static int gcd(int number1, int number2) {
		if (number2 == 0) {
			return number1;
		}
		return gcd(number2, number1 % number2);
	}

	private static int lcm(int number1, int number2) {
		return number1 * number2 / gcd(number1, number2);
	}

	private static int lcm(int number1, int number2, int gcd) {
		return number1 * number2 / gcd;
	}
}
