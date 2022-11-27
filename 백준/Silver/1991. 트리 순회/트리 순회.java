import java.util.Scanner;

public class Main {

	static int[][] tree;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfNodes = scanner.nextInt();
		scanner.nextLine();

		saveNodeAsTree(scanner, numberOfNodes);

		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
	}

	private static void saveNodeAsTree(Scanner scanner, int numberOfNodes) {
		tree = new int[26][2];
		/**
		 * 2차원 배열 => 인덱싱이 자동으로 된다고 했을 때
		 * 0 => left
		 * 1 => right
		 *
		 *     A  B  C  D  E  F  G
		 *  L  B  D  E  .  .  .  .
		 *  R  C  .  F  .  .  G  .
		 *
		 *  =>
		 *     0  1  2  3  4  5  6
		 *     --------------------
		 * 0   1  3  4 -1 -1 -1 -1
		 * 1   2 -1  5 -1 -1  6 -1
		 *
		 *
		 */


		for (int i = 0; i < numberOfNodes; i++) {
			String[] nodeInput = scanner.nextLine().split(" ");
			// 아스키코드로 인덱싱하여 저장 => A => 0
			int node = node(nodeInput[0].charAt(0));
			char left = nodeInput[1].charAt(0);
			char right = nodeInput[2].charAt(0);

			// 자식 노드가 없이 끝나는 경우 . => -1로 저장
			if (left == '.') {
				tree[node][0] = -1;
			} else {
				tree[node][0] = node(left);
			}

			if (right == '.') {
				tree[node][1] = -1;
			} else {
				tree[node][1] = node(right);
			}
		}


	}

	private static int node(char nodeCharacter) {
		return nodeCharacter - 'A';
	}

	public static void preOrder(int node) {

		/**
		 * 1번인 A부터 시작
		 *
		 * 재귀 형태로 탐색
		 * => tree[0][0] = 1(B) => tree[1][0] = 3(D) => tree[3][0] = -1 => return => tree[3][1] = -1 -> return -> tree[1][1] = -1 -> return -> tree[0][1] = 2(C)
		 * => tree[2][0] = 4(E) => tree[4][0] = -1 => return => tree[4][1] -> -1 -> return -> tree[2][1] = 5(F)
		 * => tree[5][0] = -1 => return => tree[5][1] = 6(G)
		 * => tree[6][0] => -1 => return
		 */

		if (isLeaf(node)) {
			return;
		}

		System.out.print((char) (node + 'A'));  // 현재 노드 출력

		preOrder(tree[node][0]);
		preOrder(tree[node][1]);
	}

	public static void inOrder(int node) {
		if (isLeaf(node))
			return;

		// 0 = A -> tree[0][0] = B = 1 -> tree[1][0] = D = 3 -> tree[3][0] = -1 -> return -> 거꾸로 D 출력 -> B 출력 -> A 출력
		inOrder(tree[node][0]);
		System.out.print((char) (node + 'A'));
		inOrder(tree[node][1]);
	}

	public static void postOrder(int node) {
		if (isLeaf(node))
			return;
		postOrder(tree[node][0]);
		postOrder(tree[node][1]);
		System.out.print((char) (node + 'A'));
	}

	private static boolean isLeaf(int start) {
		return start == -1;
	}
}
