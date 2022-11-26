import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 플로이드 워셜 알고리즘의 기본 문제이다
	 * <p>
	 * 플로이드 워셜의 핵심은 A -> C 노드 까지 최단 경라고 한다면
	 * A - B
	 * B - C
	 * 경로 역시 최단 경로라는 것이다
	 * <p>
	 * 이와 같은 원리에 따라 플로이드 워셜의 핵심 로직이 파생된다
	 * <p>
	 * 거리 z = A - C = start - end = D[start][end]
	 * 거리 y = A - B = start - k = D[start][k]
	 * 거리 x = B - C = k - end = D[k][end]
	 * => min(z, y+x)
	 * => 즉, 최단 거리 z값 보다 큰 상황이라면 작은 값으로 업데이트 해줌으로써 최단 거리를 업데이트할 수 있다
	 * <p>
	 * 플로이드 워셜은 인접 행렬로 그래프를 표현한다
	 * 1) start와 end가 같은 값은 0으로, 나머지는 INF로 초기화 한다
	 * 2) 최단 거리 배열에 그래프 데이터를 저장한다 (가중치 = 거리 업데이트)
	 * 3) A, B, C에 대해서 3중의 반복문을 돌면서 핵심 로직으로 최단 거리 업데이트
	 * => 이때 중간 위치인 B(일반적으로 k로 표현)가 가장 바깥에 위치해야 한다
	 */

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int numberOfCities;
	static int numberOfRoutes;
	static int[][] mapWithDistance;

	public static void main(String[] args) throws IOException {
		receiveInfo();
		initializeMap();
		saveDistances();
		floydWarshallAlgorithm();
		drawAnswer();

	}

	private static void receiveInfo() throws IOException {
		numberOfCities = Integer.parseInt(bufferedReader.readLine());
		numberOfRoutes = Integer.parseInt(bufferedReader.readLine());
		mapWithDistance = new int[numberOfCities + 1][numberOfCities + 1];
	}

	private static void initializeMap() {
		for (int i = 1; i <= numberOfCities; i++) {
			for (int j = 1; j <= numberOfCities; j++) {
				if (i == j)
					mapWithDistance[i][j] = 0;
				else
					mapWithDistance[i][j] = 10000001; // INF로 설정
			}
		}
	}

	private static void saveDistances() throws IOException {
		for (int i = 0; i < numberOfRoutes; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int nodeDeparting = Integer.parseInt(stringTokenizer.nextToken());
			int nodeArriving = Integer.parseInt(stringTokenizer.nextToken());
			int distance = Integer.parseInt(stringTokenizer.nextToken());
			if (isInitialDistanceShorter(nodeDeparting, nodeArriving, distance)) {
				mapWithDistance[nodeDeparting][nodeArriving] = distance;
			}
		}
	}

	private static void floydWarshallAlgorithm() {
		for (int k = 1; k <= numberOfCities; k++) { // 플로이드 워셜 알고리즘 수행
			for (int i = 1; i <= numberOfCities; i++) {
				for (int j = 1; j <= numberOfCities; j++) {
					if (isAnotherShorterDistanceExist(k, i, j))
						mapWithDistance[i][j] = mapWithDistance[i][k] + mapWithDistance[k][j];
				}
			}
		}
	}

	private static boolean isAnotherShorterDistanceExist(int k, int i, int j) {
		return mapWithDistance[i][j] > mapWithDistance[i][k] + mapWithDistance[k][j];
	}

	private static boolean isInitialDistanceShorter(int nodeDeparting, int nodeArriving, int distance) {
		return mapWithDistance[nodeDeparting][nodeArriving] > distance;
	}

	private static void drawAnswer() {
		for (int i = 1; i <= numberOfCities; i++) {
			for (int j = 1; j <= numberOfCities; j++) {            // 맵을 순회 = i, j 배열
				if (mapWithDistance[i][j] == 10000001) {        // 업데이트가 되지 않았다는 것은 최소 거리가 없음을 의미 = 갈수 없음을 의미
					System.out.print("0 ");
				} else {
					System.out.print(mapWithDistance[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
