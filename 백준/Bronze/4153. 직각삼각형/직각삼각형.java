import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int[] numbers = {Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())};
			if (numbers[0] == 0) {
				break;
			}
			Arrays.sort(numbers);

			if (numbers[2] * numbers[2] == (numbers[0] * numbers[0]) + (numbers[1] * numbers[1])) {
				System.out.println("right");
				continue;
			}
			System.out.println("wrong");
		}
	}
}