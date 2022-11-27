import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	/**
	 * 인접 리스트 자료구조를 통해 주어지는 데이터를 입력한다
	 * <p>
	 * 루트를 1로 지정해주므로 1번 노드부터 dfs로 탐색한다
	 * <p>
	 * i) 인접 리스트로 트리 데이터 받기
	 * ii) dfs 탐색 -> 수행하며 부모 노드의 값을 정답 배열에 저장
	 * iii) 정답 배열의 2번 인덱스부터 출력
	 */

	static int numberOfNodes;
	static boolean[] visitedNodes;
	static ArrayList<Integer>[] tree;
	static int[] answers;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		numberOfNodes = scanner.nextInt();

		visitedNodes = new boolean[numberOfNodes + 1];
		answers = new int[numberOfNodes + 1];

		initializeTree();
		saveNodes(scanner);

		dfs(1);
		drawAnswer();
	}

	private static void drawAnswer() {
		for (int i = 2; i <= numberOfNodes; i++) {
			System.out.println(answers[i]);
		}
	}

	private static void saveNodes(Scanner scanner) {
		for (int i = 1; i < numberOfNodes; i++) {            // e.g. 1 6
			int nodeConnected1 = scanner.nextInt();            // => 1
			int nodeConnected2 = scanner.nextInt();        // => 6
			tree[nodeConnected1].add(nodeConnected2);
			tree[nodeConnected2].add(nodeConnected1);        // => 1 => 6, 6 => 1
		}
	}

	private static void initializeTree() {
		tree = new ArrayList[numberOfNodes + 1];
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
	}

	static void dfs(int number) {
		visitedNodes[number] = true;
		for (int node : tree[number]) {
			if (!visitedNodes[node]) {
				answers[node] = number;
				dfs(node);
			}
		}
		
		/**
		 * e.g 
		 * 1 시작 => 6 ,4 중 6 탐색 
		 * 6 => 방문 x => 1번으로 부모 노드 업데이트 
		 * 6 => 1, 3 중 1 탐색 
		 * => 방문 o => 3 탐색  
		 * 3 => 방문 x => 6번으로 부모 노드 업데이트 
		 * 3 => 6, 5 탐색 중 6번 방문 o => 5 탐색 
		 * 5 => 방문 x => 3으로 부모 노드 업데이트
		 * => leaf 노드이므로 다시 올라가면서 탐색 
		 * => 3, 7, 1 => 
		 * 1 = > 4 탐색 
		 * => 같은 로직으로 탐색 
		 */
	}
}
