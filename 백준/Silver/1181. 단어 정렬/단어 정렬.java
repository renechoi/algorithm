
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int wordCounts = Integer.parseInt(bufferedReader.readLine());

		String[] words = new String[wordCounts];
		int count=0;
		while(wordCounts-->0){
			words[count++] = bufferedReader.readLine();
		}

		Arrays.sort(words, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

		// Arrays.sort(words, new Comparator<String>() {
		// 	@Override
		// 	public int compare(String s1, String s2) {
		// 		int lengthCompare = Integer.compare(s1.length(), s2.length());
		// 		if (lengthCompare == 0) {
		// 			return s1.compareTo(s2);
		// 		} else {
		// 			return lengthCompare;
		// 		}
		// 	}
		// });


		Set<String> uniqueWords = new LinkedHashSet<>(Arrays.asList(words));
		uniqueWords.forEach(System.out::println);


	}
}

