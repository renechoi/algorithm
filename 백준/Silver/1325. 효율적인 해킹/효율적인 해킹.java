import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int nodeNumbers, edgeNumbers;
	static boolean[] visited;
	static int[] hackingNumbers;
	static ArrayList<Integer>[] adjacentNodes;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		receiveNodeInfo(stringTokenizer);
		hackingNumbers = new int[nodeNumbers + 1];
		initializeAdjacentNodes();
		storeNodeInfo(bufferedReader);

		for (int i = 1; i <= nodeNumbers; i++) {
			visited = new boolean[nodeNumbers + 1];
			BFS(i);
		}

		int maxHacking = calculateMaxHacking();
		printAnswer(maxHacking);
	}

	private static void receiveNodeInfo(StringTokenizer stringTokenizer) {
		nodeNumbers = Integer.parseInt(stringTokenizer.nextToken());
		edgeNumbers = Integer.parseInt(stringTokenizer.nextToken());
	}

	private static void initializeAdjacentNodes() {
		adjacentNodes = new ArrayList[nodeNumbers + 1];
		for (int i = 1; i <= nodeNumbers; i++)
			adjacentNodes[i] = new ArrayList<>();
	}

	private static void storeNodeInfo(BufferedReader br) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < edgeNumbers; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			adjacentNodes[S].add(E);
		}
	}


	private static void printAnswer(int maxHacking) {
		for (int i = 1; i <= nodeNumbers; i++) {
			if (hackingNumbers[i] == maxHacking)                    // 정답 배열에서는 최대 해킹 값을 가진 idx가 곧 해당 노드
				System.out.print(i + " ");
		}
	}

	private static int calculateMaxHacking() {
		int maxVal = 0;
		for (int i = 1; i <= nodeNumbers; i++) {
			maxVal = Math.max(maxVal, hackingNumbers[i]);
		}
		return maxVal;
	}

	public static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		visited[index] = true;
		while (!queue.isEmpty()) {
			int now_node = queue.poll();
			for (int i : adjacentNodes[now_node]) {
				if (!visited[i]) {
					visited[i] = true;
					hackingNumbers[i]++; //신규 정점인덱스의 정답 배열 값을 증가 시키기
					queue.add(i);
				}
			}
		}
	}
}
