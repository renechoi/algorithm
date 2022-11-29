import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bufferedReader.readLine());

		while (testCase -- > 0) {
			HashMap<String, Integer> clothTypeWithNumber = new HashMap<>();
			int numberOfClothSet = Integer.parseInt(bufferedReader.readLine());

			while (numberOfClothSet-- > 0) {
				StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
				stringTokenizer.nextToken();

				String type = stringTokenizer.nextToken();
				clothTypeWithNumber.put(type, clothTypeWithNumber.getOrDefault(type, 0) + 1);
			}

			System.out.println(calculateCounts(clothTypeWithNumber)-1);
		}

	}

	private static int calculateCounts(HashMap<String, Integer> clothTypeWithNumber) {
		int answer = 1;
		for (int typeNumbers : clothTypeWithNumber.values()) {
			answer *= (typeNumbers + 1);
		}
		return answer;
	}
}
