import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int Q = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int[] numbers = new int[N+1];
		int[] Snumbers = new int[N+1];
		for (int i =1; i<=N;i++){
			numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
			Snumbers[i] =  Snumbers[i-1] ^ numbers[i];
		}


		int answer = 0;
		for (int i = 0; i<Q; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int L = Integer.parseInt(stringTokenizer.nextToken());
			int R = Integer.parseInt(stringTokenizer.nextToken());

			answer ^=Snumbers[R] ^Snumbers[L-1];
		}

		System.out.println(answer);
	}

}