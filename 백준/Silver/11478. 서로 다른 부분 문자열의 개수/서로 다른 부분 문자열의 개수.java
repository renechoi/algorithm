import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String text = bufferedReader.readLine();
		Integer textLength = text.length();
		HashMap<String, Integer> textSeperated = new HashMap<>();

		for (int i = 0; i < textLength + 1; i++) {
			for (int j = i; j < textLength + 1; j++) {
				if (i == j) {
					continue;
				}
				String textEach = text.substring(i, j);
				textSeperated.put(textEach, textSeperated.getOrDefault(textEach, 0) + 1);
			}
		}
		System.out.println(textSeperated.size());
	}
}
