import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int number = Integer.parseInt(stringTokenizer.nextToken());

		printOutPrimeFactors(number);
	}

	private static void printOutPrimeFactors(int number) {
		int primeFactor = 2;
		while( number !=1) {
			if (number %primeFactor ==0){
				System.out.println(primeFactor);
				number = number / primeFactor;
				continue;
			}
			primeFactor++;
		}
	}
}
