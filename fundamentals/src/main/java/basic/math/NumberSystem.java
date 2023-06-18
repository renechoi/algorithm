package basic.math;

import static basic.math.Division.*;

import java.io.IOException;

public class NumberSystem {
	public static void main(String[] args) {
		convert(4, 2);

	}

	private static String convertNumberWithAppliedNumberSystem(int n, int m)  {

		int initialN = n;
		int initialM = m;
		StringBuilder stringBuilder = new StringBuilder();
		while (true) {
			int remainder = getRemainder(n, m);
			int quotient = getQuotient(n, m);
			n = quotient;

			write(stringBuilder, remainder);

			if (n == initialM) {
				write(stringBuilder, getRemainder(n, m));
				write(stringBuilder, getQuotient(n, m));
				break;
			}
			if (n < initialM) {
				if (quotient == 0) {
					break;
				}
				write(stringBuilder, quotient);
				break;
			}
		}
		return stringBuilder.reverse().toString();
	}

	private static String convertNumberWithAppliedNumberSystem2(int number, int base)  {
		StringBuilder answer = new StringBuilder();
		while (number > 0) {
			int remainder = number % base;
			if (remainder < 10){
				answer.append(remainder);
			}
			else {
				answer.append((char)('A' + remainder - 10));
			}
			number /= base;
		}

		return answer.reverse().toString();
	}


	private static void convert(int N, int B){
		String ans = "";
		while (N > 0) {
			int digit = N % B;
			if (digit < 10){
				ans += digit;
			}
			else {
				ans += (char)('A' + digit - 10);
			}
			N /= B;
		}

		System.out.println(new StringBuilder(ans).reverse());
	}


	private static void write(StringBuilder stringBuilder, int number) {
		if (number >= 10) {
			char alphabet = (char)(number + 'A' - 10);
			stringBuilder.append(alphabet);
			return;
		}
		stringBuilder.append(number);
	}

}
