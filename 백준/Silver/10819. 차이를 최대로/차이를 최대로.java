
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] originalNumbers;
	static int answer;
	static int[] choice; // [20, 1, 15, .... ]
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(br.readLine());
		originalNumbers = new int[n];
		visited = new boolean[n];
		answer = Integer.MIN_VALUE;
		choice = new int[n];
		for (int i = 0; i < n; i++) {
			originalNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		dfs(0, -1, 0);
		System.out.println(answer);

	}

	public static void dfs(int depth, int last, int currentSum){
		if (depth == n){
			answer = Math.max(answer, currentSum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i]){
				continue;  
			}
			visited[i] = true;
			if (depth == 0) {
				// 첫 번째 자리에 원소를 고를 때는 비교할 “이전 값”이 없으므로 added=0
				dfs(depth+1, originalNumbers[i], 0);
			} else {
				// 두 번째 이후 자리부터는 “마지막으로 고른 값(last)”이 있으므로 차이를 추가
				int added = Math.abs(last - originalNumbers[i]);
				dfs(depth + 1, originalNumbers[i], currentSum + added);
			}
			visited[i] = false;  
		}

	}

	public static void dfs(int depth) {
		if (depth == n) {
			answer = Math.max(answer, calculate(choice));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choice[depth] = originalNumbers[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static int calculate(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			sum += Math.abs(arr[i] - arr[i + 1]);
		}
		return sum;

	}
}
