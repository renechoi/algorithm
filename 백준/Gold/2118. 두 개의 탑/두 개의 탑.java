import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	private static StringTokenizer receiveInput(BufferedReader bufferedReader) throws IOException {
		return new StringTokenizer(bufferedReader.readLine());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = receiveInput(bufferedReader);
		int N = parseInt(stringTokenizer.nextToken());

		int[] distances = new int[N * 2];
		int totalDistance = 0;
		for (int i = 0; i < N; i++) {
			distances[i] = Integer.parseInt(bufferedReader.readLine());
			distances[i + N] = distances[i]; // 환형 배열 처리
			totalDistance += distances[i];
		}

		int start = 0, end = 0;
		int maxDistance = 0;
		int currentDistance = 0;

		for (start = 0; start < N; start++) {
			while (end < start + N && currentDistance + distances[end % N] <= totalDistance / 2) {
				currentDistance += distances[end % N];
				end++;
			}

			int distanceClockwise = currentDistance;
			int distanceCounterClockwise = totalDistance - distanceClockwise;

			maxDistance = Math.max(maxDistance, Math.min(distanceClockwise, distanceCounterClockwise));

			currentDistance -= distances[start];
		}

		System.out.println(maxDistance);

	}

}
