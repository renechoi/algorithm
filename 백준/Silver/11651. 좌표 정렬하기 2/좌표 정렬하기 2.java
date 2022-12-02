import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;

		int numberOfCoordinates = Integer.parseInt(bufferedReader.readLine());
		Integer[][] map = new Integer[numberOfCoordinates][2];

		while (numberOfCoordinates-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			map[numberOfCoordinates][0] = Integer.valueOf(stringTokenizer.nextToken());
			map[numberOfCoordinates][1] = Integer.valueOf(stringTokenizer.nextToken());
		}

		sort2dMap(map);
		drawAnswer(map);
	}

	private static void drawAnswer(Integer[][] map) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer[] coordinates : map) {
			stringBuilder.append(coordinates[0])
					.append(" ")
					.append(coordinates[1])
					.append("\n");
		}
		System.out.println(stringBuilder);
	}

	private static void sort2dMap(Integer[][] map) {
		Arrays.sort(map, (coordinate1, coordinate2) -> {
			if (coordinate1[1].equals(coordinate2[1])) {
				return coordinate1[0] - coordinate2[0];
			}
			return coordinate1[1] - coordinate2[1];


			/**
			 * return 값이 음수라면 위치가 바뀌지 않고
			 * 양수인 경우 바뀐다
			 */
		});
	}
}
