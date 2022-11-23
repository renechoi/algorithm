import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static boolean[] visistedDfs;
	private static ArrayList<Integer>[] adjacentNodes;
	private static boolean satisfyingAssignedDepth;

	public static void main(String[] args) {
		int N;    // 주어지는 사람의 수 = node
		int M;    // 주어지는 관계의 수 = edge
		satisfyingAssignedDepth = false;
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		adjacentNodes = new ArrayList[N];
		visistedDfs = new boolean[N];

		for (int i = 0; i < N; i++) {
			adjacentNodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			adjacentNodes[node1].add(node2);
			adjacentNodes[node2].add(node1);
		}

		for (int i = 0; i < N; i++) {
			dfs(i, 1);					// depth 1부터 시작하도록 설정
			if (satisfyingAssignedDepth) {
				break;
			}
		}

		if (satisfyingAssignedDepth) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}

	private static void dfs(int now, int depth) {
		if (depth == 5) {
			satisfyingAssignedDepth = true;
			return;
		}
		visistedDfs[now] = true;

		for (int i : adjacentNodes[now]) {
			if (!visistedDfs[i]) {
				dfs(i, depth + 1);
			}
		}
		visistedDfs[now] = false;
	}
}
