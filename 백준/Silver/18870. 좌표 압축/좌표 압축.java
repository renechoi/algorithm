
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int testCases = Integer.parseInt(bufferedReader.readLine());

		int[] original = new int[testCases];
		int count= 0;
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		while (testCases-->0){
			original[count++] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int[] originalCopy = Arrays.copyOf(original, original.length);
		Arrays.sort(original);

		HashMap<Integer, Integer> numberWithCompressed = new HashMap<>();

		count =0;
		numberWithCompressed.put(original[0], count++);
		for (int i =1 ; i < original.length; i++){
			if (numberWithCompressed.get(original[i]) == (numberWithCompressed.get(original[i - 1]))){
				numberWithCompressed.put(original[i], numberWithCompressed.get(original[i]));
			} else {
				numberWithCompressed.put(original[i], count++);
			}
		}

		

		StringBuilder stringBuilder = new StringBuilder();
		IntStream.range(0, original.length).forEach(i-> stringBuilder.append(numberWithCompressed.get(originalCopy[i])).append(" "));

		System.out.print(stringBuilder);
	}
}


