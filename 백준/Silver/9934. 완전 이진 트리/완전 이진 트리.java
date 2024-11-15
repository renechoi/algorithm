import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		int N = (1 << K) - 1; // 2^K - 1
		int[] 빌딩리스트 = new int[N];
		String[] parts = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			빌딩리스트[i] = Integer.parseInt(parts[i]);
		}

		int[] tree = new int[N + 1]; // 1 base

		buildTree(1, N, 빌딩리스트, tree, new Index());

		System.out.println(getTreeDescription(tree, K, N));
	}

	/**
	 * e.g. level이 2일 때 start = 2 , end = 3 <- 1 base
	 */
	private static String  getTreeDescription(int[] tree, int K, int N) {
		StringBuilder sb = new StringBuilder();

		for(int level = 1; level <= K; level++) {
			int start = 1 << (level - 1); // 2^(level-1)
			int end = (1 << level) - 1;   // 2^level - 1
			for(int i = start; i <= end && i <= N; i++) {
				sb.append(tree[i]).append(" ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		return sb.toString();
	}

	// 인덱스를 추적하기 위한 내부 클래스 -> 지역 변수로 할당하면 사라지니깐 이렇게 사용
	static class Index {
		int value = 0;
	}

	/**
	 * inorder로 작동하면서, 맨처음 inoder를 마치면 가장 왼쪽 끝으로 갈 것
	 * 그때 빠져나왔을 때 해당하는 노드가 그 빌딩 방문한 순서이므로 이를 마킹해줌
	 * e.g. -> node : 1-> current idx: 0 -> 가장 처음으로 방문한 빌딩
	 */
	public static void buildTree(int node, int N, int[] 빌딩리스트, int[] tree, Index currentIndex) {
		if(node > N){
			return;
		}
		// left
		buildTree(node * 2, N, 빌딩리스트, tree, currentIndex);

		// 현재 노드
		tree[node] = 빌딩리스트[currentIndex.value++];

		// right
		buildTree(node * 2 + 1, N, 빌딩리스트, tree, currentIndex);
	}
}
