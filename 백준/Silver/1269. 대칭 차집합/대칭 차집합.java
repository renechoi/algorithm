import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int setACounts = Integer.parseInt(stringTokenizer.nextToken());
		int setBCounts = Integer.parseInt(stringTokenizer.nextToken());

		HashMap<Integer, Integer> sets = new HashMap<>();

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < setACounts; i++) {
			int numberA = Integer.parseInt(stringTokenizer.nextToken());
			sets.put(numberA, 1);
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < setBCounts; i++) {
			int numberB = Integer.parseInt(stringTokenizer.nextToken());
			sets.put(numberB, sets.getOrDefault(numberB, 0) + 1);
		}

		System.out.println(sets.values().stream().filter(number -> number == 1).count());
	}
}
