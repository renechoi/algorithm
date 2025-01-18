import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

public class Main {




	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bufferedReader.readLine());

		for (int i = 1; i <= N; i++) {
			String line = bufferedReader.readLine();

			String[] words = line.split(" ");

			Collections.reverse(Arrays.asList(words));

			String reversedLine = String.join(" ", words);

			System.out.println("Case #" + i + ": " + reversedLine);
		}

	}
}


