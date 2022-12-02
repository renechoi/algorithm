import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		boolean[] eratosthenes = getEratosthenes();
		int testCases = receiveInput(bufferedReader);

		while (testCases-- > 0) {
			int givenNumber = receiveInput(bufferedReader);
			goldBach(eratosthenes, givenNumber);
		}
	}

	private static void goldBach(boolean[] eratosthenes, int givenNumber) {
		int binaryNumber1 = givenNumber / 2;
		int binaryNumber2 = givenNumber / 2;

		while (true) {
			if (eratosthenes[binaryNumber1] && eratosthenes[binaryNumber2]) {
				System.out.printf("%d %d\n", binaryNumber1, binaryNumber2);
				break;
			}
			binaryNumber1--;
			binaryNumber2++;
		}
	}

	private static boolean[] getEratosthenes() {
		boolean[] eratosthenes = new boolean[10001];
		Arrays.fill(eratosthenes, true);
		eratosthenes[0] = eratosthenes[1] = false;

		for (int i = 2; i <= Math.sqrt(eratosthenes.length); i++) {
			if (!eratosthenes[i])
				continue;
			for (int j = i * i; j < eratosthenes.length; j += i) {
				eratosthenes[j] = false;
			}
		}
		return eratosthenes;
	}

	private static int receiveInput(BufferedReader bufferedReader) throws IOException {
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		return Integer.parseInt(stringTokenizer.nextToken());
	}
}