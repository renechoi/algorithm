import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		// StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		String word = bufferedReader.readLine();
		int[] occurrenceArray = createOccurrenceArray(word);
		char max = findMaxAlphabet(occurrenceArray);

		System.out.println(max);
	}

	public static int[] createOccurrenceArray(String word) {
		int[] occurrenceArray = new int[26];
		word.toUpperCase().chars()
			.forEach(alphabet -> occurrenceArray[alphabet - 'A']++);
		return occurrenceArray;
	}

	public static char findMaxAlphabet(int[] arr) {
		int max = Integer.MIN_VALUE;
		int alphabet = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				alphabet = i;
			}
		}
		return isMaxAlphabetDuplicate(max, arr) ? '?' : (char)(alphabet + 'A');
	}

	private static boolean isMaxAlphabetDuplicate(int max, int[] arr) {
		return Arrays.stream(arr).filter(i -> i == max)
			.count() > 1;
	}

}