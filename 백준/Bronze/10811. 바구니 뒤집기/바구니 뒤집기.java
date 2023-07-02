
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		int[] bucket = new int[N + 1];

		IntStream.range(1, bucket.length).forEach(i -> bucket[i] = i);

		while (M-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());

			reverse(i, j, bucket);
		}

		StringBuilder stringBuilder = new StringBuilder();
		IntStream.range(1, bucket.length).forEach(i -> stringBuilder.append(bucket[i]).append(" "));
		System.out.println(stringBuilder);
	}

	private static void swap(int i, int j, int[] bucket) {
		int temp = bucket[i];
		bucket[i] = bucket[j];
		bucket[j] = temp;
	}

	private static void reverse(int start, int end, int[] bucket) {
		int repeat = (end - start + 1) / 2;
		while (repeat-- > 0) {
			swap(start, end, bucket);
			start++;
			end--;
		}
	}

	private static void reverse2(int start, int end, int[] bucket) {
		int repeat = (end - start + 1) / 2;
		for (int i = 0; i < repeat; i++) {
			swap(start + i, end - i, bucket);
		}
	}
}

