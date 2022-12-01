import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int numberGiven = receiveInput(bufferedReader);

			if (numberGiven ==0){
				break;
			}
			
			System.out.println(getPrimeNumberCounts(numberGiven));
		}
	}

	private static int getPrimeNumberCounts(int numberGiven) {
		int primeNumberCounts=0;
		for (int number = numberGiven +1; number<= numberGiven *2; number++){
			primeNumberCounts = countPrimeNumbers(number, primeNumberCounts);
		}
		return primeNumberCounts;
	}

	private static int receiveInput(BufferedReader bufferedReader) throws IOException {
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		return Integer.parseInt(stringTokenizer.nextToken());
	}

	private static int countPrimeNumbers(int number, int primeNumberCounts) {
		if (isPrime(number)) {
			primeNumberCounts++;
		}
		return primeNumberCounts;
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
