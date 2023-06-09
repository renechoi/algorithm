
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine());
		while (testCases-- > 0) {
			boolean palindromic = false;
			int number = Integer.parseInt(bufferedReader.readLine());
			for (int base = 2; base <= 64; base++) {
				if (isPalindromicNumber(convertToBaseSystem(number, base))) {
					System.out.println("1");
					palindromic = true;
					break;
				}
			}

			if (!palindromic) {
				System.out.println("0");
			}
		}
	}

	private static String convertToBaseSystem(int number, int base) {
		StringBuilder answer = new StringBuilder();
		while (number > 0) {
			int remainder = number % base;
			if (remainder < 10) {
				answer.append(remainder);
			} else {
				answer.append((char)('A' + remainder - 10));
			}
			number /= base;
		}
		return answer.toString();
	}

	private static boolean isPalindromicNumber(int number) {
		return isPalindromicNumber(String.valueOf(number));
	}

	private static boolean isPalindromicNumber(String number) {
		return new StringBuilder(number).toString().equals(new StringBuilder(number).reverse().toString());
	}
}

