import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int peopleNeverHeardOf = Integer.parseInt(stringTokenizer.nextToken());
		int peopleNeverSeen = Integer.parseInt(stringTokenizer.nextToken());

		HashMap<String, Integer> neverHeardOfAndSeen = new HashMap<>();
		for (int i = 0; i < peopleNeverHeardOf; i++) {
			neverHeardOfAndSeen.put(bufferedReader.readLine(), 1);
		}

		ArrayList<String> bothOf = new ArrayList<>();
		for (int i = 0; i < peopleNeverSeen; i++) {
			String neverSeen = bufferedReader.readLine();
			neverHeardOfAndSeen.put(neverSeen, neverHeardOfAndSeen.getOrDefault(neverSeen, 0) + 1);
			if (neverHeardOfAndSeen.get(neverSeen) == 2) {
				bothOf.add(neverSeen);
			}
		}

		Collections.sort(bothOf);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(bothOf.size()).append("\n");
		for (String name : bothOf) {
			stringBuilder.append(name).append("\n");
		}
		System.out.println(stringBuilder);
	}
}
