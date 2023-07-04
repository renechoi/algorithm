
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		String word = bufferedReader.readLine();
		int N = Integer.parseInt(bufferedReader.readLine());
		System.out.println(word.charAt(N-1));
	}
}


