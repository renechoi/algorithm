import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static ArrayList<ArrayList<Integer>> adjacentStudents;
	private static int[] inDegree;
	private static int numberOfStudents;
	private static int numberOfComparison;

	/**
	 * 노드의 순서를 도출하는 위상 정렬 기본 문제이다
	 * <p>
	 * 문제에서 답이 여러 가지일 경우에는 아무거나 출력한다는 의미는 위상 정렬의 결과값은 일정하지 않을 수 있다는
	 * 위상 정렬 알고리즘의 특성을 나타내는 표현이다
	 * <p>
	 * i) 인접 리스트에 노드 데이터를 저장한다 - 이때 진입 차수 배열 역시 업데이트 한다
	 * <p>
	 * ii) 위상 정렬 로직을 수행한다
	 * 1. 진입 차수가 0인 노드를 큐에 저장
	 * 2. poll을 통해 노드를 가져오고 이를 탐색 결과에 추가, 그 노드가 가리키는 노드의 진입 차수를 1씩 감소시킨다
	 * 3. 그럼으로써 다시 진입 차수가 0인 노드를 가져와 큐에 저장한다
	 * 4. 큐에 항목이 없을 때까지 반복한다
	 */

	public static void main(String[] args) {
		setup();

		Queue<Integer> queueForEntry = new LinkedList<>();
		saveInitialInDegree(queueForEntry);
		mainAlgorithm(queueForEntry);
	}

	private static void mainAlgorithm(Queue<Integer> queueForEntry) {
		while (!queueForEntry.isEmpty()) {
			int student = queueForEntry.poll();                    // 가져온 node는 결과 값으로 출력 
			System.out.print(student + " ");
			for (int node : edgeOfThisNode(student)) {        // 그 노드가 가리키는 노드의 진입 차수를 1씩 감소 
				inDegree[node]--;
				if (inDegree[node] == 0) {                    // 감소시키면서 0이라면 큐에 저장 	=> 저장한 것은 반복문을 돌면서 출력하게 된다 
					queueForEntry.offer(node);
				}
			}
		}
	}

	private static void saveInitialInDegree(Queue<Integer> queueForEntry) {
		for (int entry = 1; entry <= numberOfStudents; entry++) {
			if (inDegree[entry] == 0) {
				queueForEntry.offer(entry);
			}
		}
	}

	private static void setup() {
		Scanner scanner = new Scanner(System.in);
		numberOfStudents = scanner.nextInt();
		numberOfComparison = scanner.nextInt();
		initializeAdjacentNodes();
		saveAdjacentNodesWithTopology(scanner);
	}

	private static void saveAdjacentNodesWithTopology(Scanner scanner) {
		inDegree = new int[numberOfStudents + 1];
		for (int i = 0; i < numberOfComparison; i++) {
			int student = scanner.nextInt();
			int edge = scanner.nextInt();
			edgeOfThisNode(student).add(edge);
			inDegree[edge]++;
		}
	}

	private static void initializeAdjacentNodes() {
		adjacentStudents = new ArrayList<>();
		for (int student = 0; student <= numberOfStudents; student++) {
			adjacentStudents.add(new ArrayList<>());
		}
	}

	private static ArrayList<Integer> edgeOfThisNode(int student) {
		return adjacentStudents.get(student);
	}
}