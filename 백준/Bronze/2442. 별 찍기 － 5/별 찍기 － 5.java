import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(bufferedReader.readLine());

		for (int i = 1; i <= number; i++) {

			for (int k = number - i; k > 0; k--) {
				System.out.print(" ");
			}

			for (int j = i * 2 - 1; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
