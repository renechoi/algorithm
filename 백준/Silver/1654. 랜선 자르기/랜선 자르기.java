import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int lineCounts = parseInt(stringTokenizer.nextToken()); // 1<= lineCounts <=10000
		int linesInNeed = parseInt(stringTokenizer.nextToken()); // 1<= linesInNeed < 1000000
		// lineCounts <= linesInNeed

		int[] lines = new int[lineCounts];
		int maxLineLength = 0;
		while (lineCounts-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			lines[lineCounts] = parseInt(stringTokenizer.nextToken());
			maxLineLength = Math.max(maxLineLength, lines[lineCounts]);
		}

		long low = 1;
		// long high = maxLineLength;
		long high = (1L << 31) - 1;
		long answer = 0;

		while (low <= high) {
			long mid = (low + high) / 2;
			long count = calculateCount(lines, mid);

			if (count >= linesInNeed) {
				answer = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(answer);
	}

	public static int calculateCount(int[] lengths, long x) {
		int count = 0;
		for (int length : lengths) {
			count += length / x;
		}
		return count;
	}

}
