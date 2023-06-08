
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bufferedReader.readLine());

		int[] occurrences = new int[10000 + 1];
		while (N-->0) {
			occurrences[Integer.parseInt(bufferedReader.readLine())]++;
		}

		// System.out.println("Sorted numbers: " + Arrays.toString(occurrences));

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < occurrences.length; i++) {
			int occurrence = occurrences[i];
			while (occurrence != 0) {
				stringBuilder.append(i).append("\n");
				occurrence--;
			}
		}

		System.out.println(stringBuilder);
	}
}