import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int numberOfCards = Integer.parseInt(bufferedReader.readLine());

		int[] cards = new int[numberOfCards];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < numberOfCards; i++) {
			cards[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(cards);

		int testCases = Integer.parseInt(bufferedReader.readLine());
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();
		while (testCases-->0){
			int testNumber = Integer.parseInt(stringTokenizer.nextToken());
			stringBuilder.append(binarySearch(cards, testNumber)).append(" ");
		}
		System.out.println(stringBuilder);
	}

	private static int binarySearch(int[] cards, int number) {
		int left = 0;
		int right = cards.length - 1;
		int mid;

		while (left <= right) {
			mid = (left + right) / 2;
			if (cards[mid] == number) {
				return 1;
			}
			if (cards[mid] < number) {
				left = mid + 1;
				continue;
			}
			if (cards[mid] >= number) {
				right = mid - 1;
			}
		}
		return 0;
	}

}
