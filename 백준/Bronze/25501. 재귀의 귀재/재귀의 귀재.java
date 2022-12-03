import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int recursionCounts;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(bufferedReader.readLine());

		while (testCases-->0){
			recursionCounts = 0;
			String text = bufferedReader.readLine();
			System.out.printf("%d %d\n", isPalindrome(text), recursionCounts);
		}
	}

	public static int recursion(String text, int left, int right) {
		recursionCounts++;
		if (left >= right) {
			return 1;
		}
		if (text.charAt(left) != text.charAt(right)) {
			return 0;
		}
		return recursion(text, left + 1, right - 1);
	}

	public static int isPalindrome(String text) {
		return recursion(text, 0, text.length() - 1);
	}
}
