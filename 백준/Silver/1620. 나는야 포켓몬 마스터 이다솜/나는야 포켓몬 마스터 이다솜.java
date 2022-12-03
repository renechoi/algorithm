import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int numberOfPocketmons = Integer.parseInt(stringTokenizer.nextToken());
		int queries = Integer.parseInt(stringTokenizer.nextToken());

		HashMap<String, Integer> book = new HashMap<>(numberOfPocketmons+1);
		String[] bookWithNames = new String[numberOfPocketmons+1];
		for (int i = 1; i <= numberOfPocketmons; i++) {
			String name = bufferedReader.readLine();
			book.put(name, i);
			bookWithNames[i] = name;
		}

		StringBuilder stringBuilder = new StringBuilder();
		while (queries-- > 0) {
			String query = bufferedReader.readLine();
			if (isText(query)) {
				stringBuilder.append(book.get(query)).append("\n");
				continue;
			}
			stringBuilder.append(bookWithNames[Integer.parseInt(query)]).append("\n");
//			stringBuilder.append(book.keySet().toArray()[Integer.parseInt(query)]).append("\n");
		}
		System.out.println(stringBuilder);
	}

	private static boolean isText(String input) {
		if (input.matches("[A-Za-z]*")) {
			return true;
		}
		return false;
	}
}
