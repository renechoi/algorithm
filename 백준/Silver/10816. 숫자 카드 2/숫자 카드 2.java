import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int numberOfCards = Integer.parseInt(bufferedReader.readLine());

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		HashMap<Integer, Integer> cards = new HashMap<>();
		for (int i = 0; i < numberOfCards; i++) {
			int card = Integer.parseInt(stringTokenizer.nextToken());
			cards.put(card, cards.getOrDefault(card, 0) + 1);
		}

		int testCases = Integer.parseInt(bufferedReader.readLine());
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < testCases; i++) {
			int query = Integer.parseInt(stringTokenizer.nextToken());
			stringBuilder.append(cards.getOrDefault(query, 0)).append(" ");
		}
		System.out.println(stringBuilder);
	}
}
