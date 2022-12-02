import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int numberOfCoordinates = Integer.parseInt(bufferedReader.readLine());

		int[] coordinates = receiveCoordinates(bufferedReader, numberOfCoordinates);
		int[] coordinatesCopied = coordinates.clone();        // 정렬을 수행하고 order를 구하기위한 copy 배열

		Arrays.sort(coordinatesCopied);

		HashMap<Integer, Integer> orderedNumbers = new HashMap<>();
		int order = 0;
		for (int i = 0; i < coordinatesCopied.length; i++) {
			if (orderedNumbers.containsKey(coordinatesCopied[i])) {
				continue;
			}
			orderedNumbers.put(coordinatesCopied[i], order);
			order++;
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int number : coordinates) {
			stringBuilder.append(orderedNumbers.get(number)).append(" ");
		}
		System.out.println(stringBuilder);
	}

	private static int[] receiveCoordinates(BufferedReader bufferedReader, int numberOfCoordinates) throws IOException {
		int[] coordinates = new int[numberOfCoordinates];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < numberOfCoordinates; i++) {
			coordinates[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		return coordinates;
	}
}
