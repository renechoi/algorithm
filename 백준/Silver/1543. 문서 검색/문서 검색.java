
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		// StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		String document = bufferedReader.readLine();
		String word = bufferedReader.readLine();

		int count = 0;
		for (int i = 0; i < document.length() - word.length() +1; i++) {
			if (document.startsWith(word, i)){
				count++;
				i = i + word.length() -1;
			}
		}

		System.out.println(count);
	}
}
