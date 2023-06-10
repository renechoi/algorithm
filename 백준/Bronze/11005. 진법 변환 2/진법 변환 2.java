
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());

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

				// stringBuilder.append(getRemainder(n, m)).append(getQuotient(n,m));
				break;
			}
			if (n < initialM) {
				if (quotient == 0) {
					break;
				}
				write(stringBuilder, quotient);
				// stringBuilder.append(quotient);
				break;
			}
		}
		System.out.println(stringBuilder.reverse());
	}

	private static void write(StringBuilder stringBuilder, int number) {
		if (number >= 10) {
			char alphabet = (char)(number + 'A' - 10);
			stringBuilder.append(alphabet);
			return;
		}
		stringBuilder.append(number);
	}

	private static int getRemainder(int divisor, int dividend) {
		return divisor % dividend;
	}

	private static int getQuotient(int divisor, int dividend) {
		return divisor / dividend;
	}

	private static int convertAboveTen(int number) {
		if (number >= 10) {
			return number + 'A' - 10;
		}
		return number;
	}

}
