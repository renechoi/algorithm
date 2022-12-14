import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		int[] dp = new int[501];
		HashMap<Integer, Integer> lineSet = new HashMap<>(501);
		for (int i = 0; i < N; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int numberA = Integer.parseInt(stringTokenizer.nextToken());
			int numberB = Integer.parseInt(stringTokenizer.nextToken());
			lineSet.put(numberA, numberB);
			dp[i] = 1;
		}

		List<Map.Entry<Integer, Integer>> entries = lineSet.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toList());
		ArrayList<Integer> numbers = new ArrayList<>(501);
		for (Map.Entry<Integer, Integer> entry : entries) {
			numbers.add(entry.getValue());
		}

		dp[0] =1;
		int lineMax = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (numbers.get(i) > numbers.get(j)) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			lineMax = Math.max(lineMax, dp[i]);
		}
		
		System.out.println(N - lineMax);
	}
}
