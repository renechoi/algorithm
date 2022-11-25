import java.util.Scanner;
public class Main {

	/**
	 * 유니온 파인드 대표 문제라고 할 수 있다
	 *
	 * 문제에서 "합집합 연산"은 유니온 연산을 의미하고
	 * "두 원소가 같은 집합에 포함돼 있는지를 확인하는 연산"은 파인드 연산을 의미한다
	 *
	 * 예제 입력에서 0 1 3 은 1번과 3번을 합치라는 뜻이며
	 * 1 1 7은 1번과 7번의 원소가 같은지를 확인한다는 뜻이다
	 *
	 * i) 처음 각 노드의 대표로 자기 자신을 초기화 한다
	 * 배열 인덱스 1 2 3 4 5 6 7
	 * 원소 		 1 2 3 4 5 6 7
	 *
	 * ii) 이후 문제의 요구사항에 따라 쿼리를 실행한다
	 * e.g. 0 1 3 => union(1,3)
	 * => 1 2 3 4 5 6 7
	 * 	  1 2 1 4 5 6 7
	 * => 이 연산으로 1과 3이 한 집합이 되며 대표 노드인 1로 정해짐
	 *
	 * e.g. 1 1 7 => find(1) == find(7) 확인
	 * => 1 2 3 4 5 6 7
	 *    1 2 1 4 5 6 7
	 * => 1번과 7번 자리의 원소가 다르므로 no를 반환
	 */


	private static int[] representativeNode;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int nodes = scanner.nextInt();
		int queries = scanner.nextInt();
		representativeNode = new int[nodes + 1];

		initialRepresentativeAsSelf(nodes);

		for (int i = 0; i < queries; i++) {
			int command = scanner.nextInt();
			int nodeNumber1 = scanner.nextInt();
			int nodeNumber2 = scanner.nextInt();

			handleCommand(command, nodeNumber1, nodeNumber2);
		}
	}

	private static void handleCommand(int command, int nodeNumber1, int nodeNumber2) {
		if (command == Command.valueOf("union").getCommandType()) {
			union(nodeNumber1, nodeNumber2);
		} else {
			if (isSameElement(nodeNumber1, nodeNumber2)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	// 자기 자신으로 처음 대표 요소를 치기화
	private static void initialRepresentativeAsSelf(int nodes) {
		for (int i = 0; i <= nodes; i++) {
			representativeNode[i] = i;
		}
	}

	// 대표 노드끼리 연결하는 유니온 연산
	public static void union(int node1, int node2) {
		node1 = find(node1);			// 대표 노드를 먼저 찾기
		node2 = find(node2);
		if (node1 != node2) {
			representativeNode[node2] = node1;
		}
	}

	/*
		find의 로직은 다음과 같다

		=> e.g. find(6)
			=> 1 2 3 4 5 6
			   1 2 3 1 1 5
			=> idx 값과 value 값 비교
			=> A[6] vs 6 => 다름 => value인 5를 find의 var로 사용 => find(5)
			=> A[5] VS 5 => 다름 => vlaue인 1을 find의 var로 사용 => find(1)
			=> A[1] vs 1 = > 같음 => 대표 노드가 설정되면서 5, 6의 노드가 1로 설정됨
	 */
	
	public static int find(int node) {
		if (node == representativeNode[node])		// 해당 노드의 요소가 대표 노드면 리턴
			return node;
		else
			return representativeNode[node] = find(representativeNode[node]); 		// 아니라면 해당 노드의 노드값을 이동하여 index와 value 값이 같을 때까지 확인
	}

	
	// 각 원소가 한 집합 안에 있는지 확인
	private static boolean isSameElement(int node1, int node2) {
		node1 = find(node1);
		node2 = find(node2);
		return node1 == node2;
	}

	private enum Command {

		union("union", 0),
		find("find", 1);

		private final String commandName;
		private final int commandType;

		Command(String commandName, int commandType){
			this.commandName = commandName;
			this.commandType = commandType;
		}

		public int getCommandType() {
			return commandType;
		}

	}
}
