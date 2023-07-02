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

		int[] buckets = new int[N+1];
		while(M-->0){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int end = Integer.parseInt(stringTokenizer.nextToken());
			int number = Integer.parseInt(stringTokenizer.nextToken());
			IntStream.rangeClosed(start, end).forEach(i->buckets[i] = number);
		}

		StringBuilder stringBuilder = new StringBuilder();
		IntStream.range(1, buckets.length).forEach(i -> stringBuilder.append(buckets[i]).append(" "));
		System.out.println(stringBuilder);
	}

}