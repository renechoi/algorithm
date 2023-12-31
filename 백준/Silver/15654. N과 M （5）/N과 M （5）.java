import static java.lang.Integer.*;
import static java.util.Arrays.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	private static boolean used[];
	private static int selected[];
	private static int numbers[];
	private static int N;
	private static int M;


	private static StringTokenizer receiveInput(BufferedReader bufferedReader) throws IOException {
		return new StringTokenizer(bufferedReader.readLine());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = receiveInput(bufferedReader);
		N = parseInt(stringTokenizer.nextToken());
		M = parseInt(stringTokenizer.nextToken());

		numbers = new int[N];
		stringTokenizer = receiveInput(bufferedReader);
		for (int i = 0; i < N; i++) {
			numbers[i] = parseInt(stringTokenizer.nextToken());
		}

		sort(numbers); // 주어진 수열 정렬

		used = new boolean[N];
		selected = new int[M];

		permutation(0);

	}

	private static void permutation(int depth){
		if (depth == M) {
			// M개를 모두 선택했을 때 결과를 출력
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < M; i++) {
				stringBuilder.append(selected[i]).append(" ");
			}
			System.out.println(stringBuilder);
			return;
		}

		for (int i =0; i< N; i++){
			if(!used[i]){
				used[i] = true;
				selected[depth] = numbers[i];
				permutation(depth+1);
				used[i] = false;
			}
		}
	}
}