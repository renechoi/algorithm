import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		HashMap<Integer, Integer> xSets = new HashMap<>();
		HashMap<Integer, Integer> ySets = new HashMap<>();

		for (int i = 0; i < 3; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int x = Integer.parseInt(stringTokenizer.nextToken());
			int y = Integer.parseInt(stringTokenizer.nextToken());

			xSets.put(x, xSets.getOrDefault(x, 0) + 1);
			ySets.put(y, ySets.getOrDefault(y, 0) + 1);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int x : xSets.keySet()) {
			if (xSets.get(x) == 1) {
				stringBuilder.append(x).append(" ");
			}
		}
		for (int y : ySets.keySet()) {
			if (ySets.get(y) == 1) {
				stringBuilder.append(y).append(" ");
			}
		}
		System.out.println(stringBuilder);
	}
}
