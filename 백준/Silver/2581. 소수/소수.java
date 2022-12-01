import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static long answerCount;
	private static boolean isMinFound;
	private static int minPrime;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int numberFrom = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int numberTo = Integer.parseInt(stringTokenizer.nextToken());

		while (numberFrom++ <= numberTo) {

			if (isPrime(numberFrom-1)) {
				answerCount+=numberFrom-1;
				isMinFound(numberFrom-1);
			}
		}
		drawAnswer();
	}

	private static void drawAnswer() {
		if (answerCount==0){
			System.out.println(answerCount-1);
			return;
		}
		System.out.println(answerCount);
		System.out.println(minPrime);
	}

	private static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}

		for (int i = 2; i <= (int) Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static void isMinFound(int number){
		if (!isMinFound){
			minPrime = number;
			isMinFound = true;
		}
	}
}
