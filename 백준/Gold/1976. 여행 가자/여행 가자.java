import java.util.Scanner;

public class Main {

	/**
	 * 유니온 연산을 인접 행렬 기반으로 수행하는 문제이다
	 * <p>
	 * 인접 행렬을 탐색하며 연결될 때 유니온 연산을 수행해
	 * 대표 노드를 설정하고
	 * 대표 노드가 동일하면 연결된 경로라고 판단할 수 있다
	 */

	public static int[] representativeNode;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfCities = scanner.nextInt();
		int citiesPlanned = scanner.nextInt();

		int[][] cities = getCities(scanner, numberOfCities);
		int[] route = getRoute(scanner, citiesPlanned);

		initializeRepresentative(numberOfCities);
		identifyCityConnection(numberOfCities, cities);

		checkRouteAndDrawAnswer(route);
	}

	private static void checkRouteAndDrawAnswer(int[] route) {
		int index = find(route[1]);                // 1을 가장 처음으로 세팅
		for (int i = 2; i < route.length; i++) {
			if (index != find(route[i])) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}

	private static void identifyCityConnection(int numberOfCities, int[][] cities) {
		// 인접 행렬을 탐색한다
		// 연결이 되어 있다면 유니온 연산을 수행한다 => 집합화를 통해 대표 노드 파악 후 초기화
		for (int row = 1; row <= numberOfCities; row++) {
			for (int column = 1; column <= numberOfCities; column++) {
				if (isConnected(column, cities[row])) union(row, column);
			}
		}
	}

	private static boolean isConnected(int j, int[] cities) {
		return cities[j] == 1;
	}

	private static void initializeRepresentative(int numberOfCities) {
		representativeNode = new int[numberOfCities + 1];
		for (int i = 1; i <= numberOfCities; i++) {
			representativeNode[i] = i;
		}
	}

	private static int[] getRoute(Scanner scanner, int citiesPlanned) {
		int[] route = new int[citiesPlanned + 1];
		for (int i = 1; i <= citiesPlanned; i++) {
			route[i] = scanner.nextInt();
		}
		return route;
	}

	private static int[][] getCities(Scanner scanner, int N) {
		int[][] cities = new int[N + 1][N + 1];

		// 도시의 정보를 입력받는다
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cities[i][j] = scanner.nextInt();
			}
		}
		return cities;
	}


	public static void union(int node1, int node2) {
		// 대표 노드끼리 연결하는 유니온 연산
		node1 = find(node1);            // 대표 노드를 먼저 찾기
		node2 = find(node2);
		if (node1 != node2) {
			representativeNode[node2] = node1;
		}
	}

	public static int find(int node) {
		if (node == representativeNode[node])        // 해당 노드의 요소가 대표 노드면 리턴
			return node;
		else
			return representativeNode[node] = find(representativeNode[node]);        // 아니라면 해당 노드의 노드값을 이동하여 index와 value 값이 같을 때까지 확인
	}
}
