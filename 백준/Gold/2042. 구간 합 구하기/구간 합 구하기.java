import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 자료의 변경이 일어나기 때문에 합 배열 자료구조로 풀면 시간초과 발생 => 트리 자료 구조를 이용한 풀이
	 * <p>
	 * i) 트리 사이즈 구하여 배열 초기화
	 * - 2^k > N 을  만족하는 k 구하기 함수 (시작 인덱스는 k에 따라 설정 = 2^k)
	 * - k+1의 사이즈로 배열 사이즈 세팅하는 함수
	 * - 트리에 받는 데이터 입력
	 * <p>
	 * ii) 질의에 따른 로직 수행
	 * - 값 변경 함수
	 * - 구간합 구하는 함수
	 */

	static long[] tree;    // 1차원 배열의 트리 배열
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static int treeHeight;
	private static int treeSize;
	private static int leafNodeStartIndex;
	private static long partSum;

	public static void main(String[] args) throws IOException {
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int numberOfNodes = Integer.parseInt(stringTokenizer.nextToken()); // 수의 개수
		int numberOfChanges = Integer.parseInt(stringTokenizer.nextToken()); // 변경이 일어나는 횟수
		int numberOfSummationCounting = Integer.parseInt(stringTokenizer.nextToken()); // 구간 합을 구하는 횟수

		calculateTreeHeight(numberOfNodes);        // e.g. N= 5 -> 2^3 > N을 만족하는 k = 3 ->
		setUpTreeSize();                    // => 트리 사이즈 = 2^3 * 2 = 16

		setUpLeafNode(numberOfNodes);
		setTotalTree(treeSize - 1);
		partSumAlgorithm(numberOfChanges, numberOfSummationCounting);
	}

	private static void partSumAlgorithm(int numberOfChanges, int numberOfSummationCounting) throws IOException {
		StringTokenizer stringTokenizer;
		for (int i = 0; i < numberOfChanges + numberOfSummationCounting; i++) {
			partSum = 0;
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			long command = Integer.parseInt(stringTokenizer.nextToken());
			int from = Integer.parseInt(stringTokenizer.nextToken());
			long to = Long.parseLong(stringTokenizer.nextToken());

			if (command == 1) {
				changeNumber(from + leafNodeStartIndex, to);
			} else if (command == 2) {
				System.out.println(getPartSum(from+leafNodeStartIndex , to + leafNodeStartIndex));
			} else {
				return;
			}
		}

		bufferedReader.close();
	}

	private static void setUpLeafNode(int numberOfNodes) throws IOException {
		leafNodeStartIndex = treeSize / 2 - 1;
		tree = new long[treeSize + 1];
		for (int i = leafNodeStartIndex + 1; i <= leafNodeStartIndex + numberOfNodes; i++) {
			tree[i] = Long.parseLong(bufferedReader.readLine());
		}

		/**
		 * e.g.
		 *
		 * 8  9  10 11 12
		 * 1  2  3  4  5
		 *
		 */
	}

	private static void setUpTreeSize() {
		treeSize = (int) Math.pow(2, treeHeight + 1);
	}

	private static void calculateTreeHeight(int numberOfNodes) {
		int length = numberOfNodes;
		while (length != 0) {
			length /= 2;
			treeHeight++;
		}
	}

	private static long getPartSum(int nodeFrom, long nodeTo) {

		/**
		 * e.g.
		 * getSum(2, 5) ->
		 *
		 * from = 2 + 7 = 9
		 * to = 5 + 7 = 12
		 *
		 * -> from은 %2 = 1인 경우, to는 %2 = 0인 경우 해당 노드 선택
		 * -> to < from까지 반복
		 * -> 최종 선택한 것들을 sum
		 *
		 * i) 사이클 1
		 * 	1) from % 2 = 1 => 노드 선택 (9=>2) -> 다음 노드 진행 = (from + 1) / 2 = 5
		 * 	2) to % 2 = 0 => 노드 선택 (12=>5) -> 다음 노드 진행 = (to - 1) / 2 = 5
		 *  => 선택 2, 5
		 *
		 * ii) 사이클 2
		 * 	1) from % 2 = 1 -> 노드 선택(5=>10) -> 다음 노드 진행 = (from + 1) / 2 = 3
		 *  2) to % 2 = 1 -> 노드 미선택 -> 다음 노드 진행 = (to - 1) / 2 = 2
		 *  => 선택 10
		 *
		 * iii) 사이클 3
		 * 	- from > to 이므로 종료
		 *
		 *
		 */

		while (nodeFrom <= nodeTo) {
			nodeFrom = calculatePartSumOfNodeFrom(nodeFrom);
			nodeFrom = nodeFrom / 2;
			nodeTo = calculatePartSumOfNodeTo((int) nodeTo);
			nodeTo = nodeTo / 2;
		}
		return partSum;
	}

	private static long calculatePartSumOfNodeTo(int nodeTo) {
		if (nodeTo % 2 == 0) {
			partSum = partSum + tree[nodeTo];
			nodeTo--;
		}
		return nodeTo;
	}

	private static int calculatePartSumOfNodeFrom(int nodeFrom) {
		if (nodeFrom % 2 == 1) {
			partSum = partSum + tree[nodeFrom];
			nodeFrom++;
		}
		return nodeFrom;
	}

	private static void changeNumber(int nodeFrom, long numberTo) {
		long valueDifference = numberTo - tree[nodeFrom];        // e.g. 3, 6 -> 3번째 값에 기본 + 7을 더해서  10을 6으로 바꾸기
		while (nodeFrom > 0) {
			tree[nodeFrom] = tree[nodeFrom] + valueDifference;
			nodeFrom = nodeFrom / 2;
		}
		/**
		 * changeNumber(10, 6)
		 * ->
		 * 차이 = 3
		 *
		 * tree[10] = tree[3] + 3
		 * 10 = 10 / 2 = 5
		 * ->
		 * tree[5] = tree[5] + 3
		 * ->
		 * tree[2] = tree[2] + 3
		 * ->
		 * tree[1] = tree[1] + 3
		 */
	}

	private static void setTotalTree(int i) {

		/**
		 * 구간합으로 이루어진 트리를 구성한다
		 *
		 * A[N] = A[2N]+A[2N+1]
		 *
		 * e.g.
		 *
		 * i = 15 ->
		 * tree[7] = tree[15] = 0 -> i = 14
		 * tree[7] = tree[14] = 0 -> i = 13
		 * tree[6] = tree[13] = 0 -> i = 12
		 * tree[6] = tree[12] = 5 -> i = 11 		0 1 2 3 4 5 6 7
		 * tree[5] = tree[11] = 4 -> i = 10 					5 0
		 * tree[5] = tree[10] = 3 -> i = 9					  7
		 * tree[4] = tree[9] = 2 -> i = 8
		 * tree[4] = tree[8] = 1 -> i = 7 				    3
		 * tree[3] = tree[7] = 0 -> i = 6
		 * tree[3] = tree[6] = 5 -> i = 5                 5
		 * tree[2] = tree[5] = 7 -> i = 4
		 * tree[2] = tree[4] = 3 -> i = 3 		        10
		 * tree[1] = tree[3] -> 5 -> i =2
		 * tree[0] = tree[2] -> 10 -> i =1          15
		 *
		 */

		while (i != 1) {
			tree[i / 2] += tree[i];
			i--;
		}
	}
}
