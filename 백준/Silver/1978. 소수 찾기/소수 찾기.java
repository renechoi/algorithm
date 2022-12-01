import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static long answerCount;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int numbers = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		while (numbers-- > 0) {
			int number = Integer.parseInt(stringTokenizer.nextToken());
			if (isPrime(number)) {
				answerCount++;
			}
		}
		System.out.println(answerCount);
	}

	private static boolean isPrime(int number) {
		if (number == 1){
			return false;
		}

		for (int i = 2; i <= (int) Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}

