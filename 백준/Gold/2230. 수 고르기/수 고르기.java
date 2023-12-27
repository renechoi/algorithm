import static java.lang.Integer.*;
import static java.util.Arrays.*;

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
		int numberCounts = parseInt(stringTokenizer.nextToken());
		int requiredDiff = parseInt(stringTokenizer.nextToken());

		int[] numbers = new int[numberCounts];
		for (int i = 0; i < numberCounts; i++) {
			stringTokenizer = receiveInput(bufferedReader);
			numbers[i] = parseInt(stringTokenizer.nextToken());
		}

		sort(numbers);

		int end = 0;
		int answer = MAX_VALUE;
		for (int i = 0; i < numberCounts ; i++) {
			while (numbers[end] - numbers[i] < requiredDiff && end < numberCounts -1 ) {
				end++;
			}
			int currentDiff = numbers[end] - numbers[i];
			if ( currentDiff>= requiredDiff) {
				answer = Math.min(answer, currentDiff);
			}
		}
		System.out.println(answer);
	}

}
