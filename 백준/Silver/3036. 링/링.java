import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int rings = Integer.parseInt(bufferedReader.readLine());
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int firstRing = Integer.parseInt(stringTokenizer.nextToken());
		while (rings-- > 1) {
			int nextRing = Integer.parseInt(stringTokenizer.nextToken());
			int gcd = gcd(firstRing, nextRing);
			System.out.printf("%d/%d\n", firstRing / gcd, nextRing / gcd);
		}
	}

	private static int gcd(int number1, int number2) {
		if (number2 == 0) {
			return number1;
		}
		return gcd(number2, number1 % number2);
	}
}
