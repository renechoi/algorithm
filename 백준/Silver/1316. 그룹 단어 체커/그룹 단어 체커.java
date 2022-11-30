import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static long answerCount;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int numberOfWords = Integer.parseInt(stringTokenizer.nextToken());

		while (numberOfWords-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			boolean[] alphabetRecords = createAlphabetRecords();
			if (identifyGroupWord(stringTokenizer.nextToken(), alphabetRecords)) {
				answerCount++;
			}
		}
		System.out.println(answerCount);
	}

	private static boolean[] createAlphabetRecords() {
		boolean[] alphabetRecords = new boolean[26];
		Arrays.fill(alphabetRecords, false);
		return alphabetRecords;
	}

	private static boolean identifyGroupWord(String word, boolean[] alphabetRecords) {
		boolean groupWord = false;
		for (int i = 0; i < word.length(); i++) {        // previous count를 구하기 위해 idx가 필요하기 때문에 enhanced loop이 아닌 idx iteration을 사용한다
			groupWord = isGroupWord(word, i, alphabetRecords);
			if (!groupWord){
				return false;	// false가 구해지면 더 이상 탐색하지 않고 바로 리턴하도록 한다
			}
			checkRecords(alphabetRecords, word.charAt(i));
		}
		return groupWord;
	}

	private static boolean isGroupWord(String word, int idx, boolean[] alphabetRecords) {
		if (idx == 0 || word.length() == 1) {
			return true;
		}

		if (!alphabetRecords[word.charAt(idx) - 'a']) {
			return true;
		}

		return isPreviousSame(word, idx);
	}

	private static boolean isPreviousSame(String word, int idx) {
		return word.charAt(idx) == word.charAt(idx - 1);
	}

	private static void checkRecords(boolean[] alphabetRecords, char alphabet) {
		alphabetRecords[alphabet - 'a'] = true;
	}
}
