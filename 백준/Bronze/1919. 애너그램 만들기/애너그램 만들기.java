
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		// StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		String word1 = bufferedReader.readLine();
		String word2 = bufferedReader.readLine();

		int[] occurrenceArray1 = createOccurrenceArray(word1);
		int[] occurrenceArray2 = createOccurrenceArray(word2);

		int answer = 0;
		for (int i = 0; i < 26; i++) {
			 answer+= Math.abs(occurrenceArray1[i] - occurrenceArray2[i]);
		}
		System.out.println(answer);
	}

	public static int[] createOccurrenceArray(String word) {
		int[] occurrenceArray = new int[26];
		word.toLowerCase().chars()
			.forEach(alphabet -> occurrenceArray[alphabet - 'a']++);
		return occurrenceArray;
	}
}