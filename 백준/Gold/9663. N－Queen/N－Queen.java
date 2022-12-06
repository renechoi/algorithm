import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[] map;
	private static int okCount;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		okCount = 0;
		map = new int[N];

		nQueen(0);

		System.out.println(okCount);
	}

	private static void nQueen(int depth) {
		if (depth == N) {
			okCount++;
			return;
		}

		for (int i = 0; i < N; i++) {
			map[depth] = i;
			if (!isAttackable(depth)) {
				nQueen(depth + 1);
			}
		}
	}

	private static boolean isAttackable(int depth) {
		for (int i = 0; i < depth; i++) {
			if (map[depth] == map[i] || Math.abs(map[depth] - map[i]) == Math.abs(depth - i)) {
				return true;
			}
		}
		return false;
	}
}
