import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int number1 = Integer.parseInt(stringTokenizer.nextToken());
		int number2 = Integer.parseInt(stringTokenizer.nextToken());

		int gcd = gcd(number1, number2);
		System.out.println(gcd);
		System.out.println(lcm(number1, number2, gcd));
	}

	private static int gcd(int number1, int number2){
		if (number2 ==0) {
			return number1;
		}
		return gcd(number2, number1 % number2);
	}

	private static int lcm(int number1, int number2){
		return number1 * number2 / gcd(number1, number2);
	}

	private static int lcm(int number1, int number2, int gcd){
		return number1 * number2 / gcd;
	}
}
