import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 문제의 요구 사항부터 이해해보자
	 * <p>
	 * 구해야 하는 것은
	 * i) 이들이 출발 도시에서 출발한 후 도착 도시에서 만나기까지 걸리는 최소 시간
	 * ii) 1분도 쉬지 않고 달려야 하는 사람들이 지나는 도로의 수
	 * <p>
	 * 문제에서 주어지는 것은 도시의 개수 n과 도로의 개수 m이다
	 * 이후 각각의 도시의 정보가 주어진다
	 * 정보는 다음과 같다
	 * <출발 도시의 번호>, <도착 도시의 번호>, <이 도로를 건너는데 걸리는 시간>
	 * <p>
	 * 예를들어, 1 2 4 라고 한다면,
	 * 1번 도시 -> 2번 도시 / 이때 걸리는 시간은 4라는 뜻이다
	 * <p>
	 * 이어서 2 6 3 이라는 정보가 주어진다고 하면
	 * 2번 도시 - > 6번 도시 / 이때 걸리는 시간 3이 될 것이다
	 * <p>
	 * 두 가지 정보로부터 도출되는 그림은 2번 도시를 거쳐서 1번 도시에서부터 6번 도시까지 갈 수 있다는 뜻이며
	 * 1번 도시 -> 2번 도시 -> 6번 도시 / 걸리는 시간은 4 + 3
	 * 이라는 것이다
	 * <p>
	 * 어떤 도시까지 도달하는데 특정 도시를 거쳐야 하므로
	 * 진입 순서를 갖고 있는 노드라고 생각할 수 있으며 이는 위상 정렬을 의미한다
	 * <p>
	 * <p>
	 * 다시 문제의 요구 사항으로 돌아오면
	 * i) <출발 도시> -> <도착도시> / 만나기까지 걸리는 최소 시간
	 * => 이는 곧 가장 늦은 경로를 했을 때 걸리는 시간을 의미한다 (모두가 만날 수 있는 시간이 최소라는 말의 의미)
	 * <p>
	 * ii) 1분도 쉬지 않고 달려야 하는 사람들이 지나는 도로의 수
	 * => 가장 시간이 오래 걸리는 경로에서 거치는 도시(노드)의 수를 의미한다
	 * <p>
	 * <p>
	 * <p>
	 * 먼저 1번을 구하는 방식은 위상정렬을 통해 구할 수 있다
	 * 가장 오래 걸린 시간으로 정렬된 배열이 [0 4 2 3 3 6 12]라고 가정해보자
	 * <p>
	 * 특정 경로가 가장 긴 경로에 속하는지 알 수 있는 방법은 최대 경로(임계 경로)에서 그 도로로 가는 시간을 뺐을 때의 시간이
	 * 그 도로가 고유하게 갖고 있는 시간과 일치하는지 여부로 판단된다
	 * 일치하면 최대 경로에 속하는 것이고 그렇지 않다면 최대 경로가 아닌 것이다
	 * <p>
	 * 예를 들어
	 * 1 - > 2 - > 3
	 * (3)   (2)
	 * <p>
	 * 이와 같은 경로가 있다고 하면 임계 경로의 값은 5이다
	 * 그렇다는 말은 3 -> 2로 온다고 할 때 5 - 2 = 3이 나온 값이 곧 2번 경로가 갖고 있는 임계 경로의 값과 일치한다는 것을 의미한다
	 * <p>
	 * 만약 1 - > 2 -> 3
	 * (3) | (2) ^
	 * (3) v     |
	 * 4  -> |
	 * (5)
	 * 이와 같은 경로가 있다고 하면 임계 경로는 1 -> 2 -> 4 -> 3 으로 걸리는 시간은 3 + 3 + 5 = 11이 될 것이다
	 * 그런데 이번에 거꾸로 3 - > 2로 간다고 하면 11 - 2 = 9라는 시간이 나오는데 실제 2의 임계값은 2에 불과하다
	 * 즉 같지 않다
	 * 하지만 3 -> 4로 간다고 하면 11 - 5 = 6이며, 이는 1 -> 2 -> 4의 경로를 고려할 때 같은 수치이다
	 * <p>
	 * 이와 같이 위상정렬을 역으로 수행했을 때 '이전 도시의 임계 경로값 - 해당 도시간의 도로 == 해당 도시의 임계 경로값'이라면 이 도시는 최대 거리의 도로로 판명날 수 있다
	 * <p>
	 * 이것으로서 2번의 값을 구할 수 있다
	 * <p>
	 * 한편, 여러가지 경로 중에 중복되는 도로가 있을 수 있기 때문에 중복 카운팅(도로의 수가 겹칠 수 있으므로)
	 * 방문 도시에 대한 체크를 해주어야 한다
	 */

	private static int numberOfCities;
	private static int numberOfRoads;
	private static ArrayList<ArrayList<node>> adjacentCities;
	private static ArrayList<ArrayList<node>> adjacentCitiesReversed;
	private static int[] inDegree;
	private static int[] criticalPaths;
	private static Queue<Integer> topologyQueue;
	private static int numberOfCriticalPaths;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		receiveMap(bufferedReader);
		initializeAdjacentCities();
		saveCitiesWithInDegree(bufferedReader);

		/**
		 * 경로의 출발 도시와 도착 도시가 주어진다
		 */
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int cityDeparting = Integer.parseInt(stringTokenizer.nextToken());
		int cityArriving = Integer.parseInt(stringTokenizer.nextToken());

		topologySort(cityDeparting);
		topologySortReversed(cityArriving);

		System.out.println(criticalPaths[cityArriving]);
		System.out.println(numberOfCriticalPaths);
	}

	private static void topologySort(int cityDeparting) {
		topologyQueue = new LinkedList<>();
		topologyQueue.offer(cityDeparting);                    // 주어진 출발 도시로부터 시작
		criticalPaths = new int[numberOfCities + 1];

		while (!topologyQueue.isEmpty()) {
			int currentCity = topologyQueue.poll();
			for (node cityNext : adjacentCities.get(currentCity)) {        // e.g. 1번 => 2번과 3번과 4번으로 향한다
				inDegree[cityNext.node]--;                                // e.g. 1번 => 2번의 entry를 0으로 내려준다
				criticalPaths[cityNext.node] = Math.max(criticalPaths[cityNext.node], criticalPaths[currentCity] + cityNext.time);    
				// 예를 들어 2번 노드의 임계 경로값 vs 1번 노드의 임계 경로값 + 2번 노드의 경로값 중 큰 것을 저장함으로써 최대 값을 저장한다
				if (inDegree[cityNext.node] == 0) {
					topologyQueue.offer(cityNext.node);
				}
			}
		}
	}
	
	private static void topologySortReversed(int cityArriving) {
		/**
		 * 예를 들어
		 * 7 -> 6 확인 = 일치 => 가장 긴 경로 => 큐에 삽입
		 * 7 -> 2 확인 = 일치 x => 삽입 x
		 *
		 * 6 -> 2 확인 = 일치 => 가장 긴 경로 => 큐에 삽입
		 * 6 -> 5 확인 = 일치 x
		 * 6 -> 4 확인 = 일치 => 가장 긴 경로 => 큐에 삽입
		 */

		boolean[] visited = new boolean[numberOfCities + 1];
		topologyQueue = new LinkedList<>();
		topologyQueue.offer(cityArriving);
		visited[cityArriving] = true;

		while (!topologyQueue.isEmpty()) {
			int currentCity = topologyQueue.poll();
			for (node cityNext : adjacentCitiesReversed.get(currentCity)) {
				if (criticalPaths[cityNext.node] + cityNext.time == criticalPaths[currentCity]) { // 가장 긴 경로 체크 로직
					numberOfCriticalPaths++;
					if (!visited[cityNext.node]) {        // 방문을 하지 않았다면 방문 하면서
						visited[cityNext.node] = true;            // 체크
						topologyQueue.offer(cityNext.node);        // 방문하지 않았던 것만 큐에 삽입
					}
				}
			}
		}
		/**
		 * 큐는 7 -> 6 -> 2 4 -> 4
		 * 형식으로 들어오고
		 * 다음 것을 넣으면서 빠지는 것 동일한 로직
		 */
	}

	private static void saveCitiesWithInDegree(BufferedReader bufferedReader) throws IOException {
		inDegree = new int[numberOfCities + 1];
		for (int i = 0; i < numberOfRoads; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int cityFrom = Integer.parseInt(stringTokenizer.nextToken());
			int cityTo = Integer.parseInt(stringTokenizer.nextToken());
			int timeRequired = Integer.parseInt(stringTokenizer.nextToken());
			adjacentCities.get(cityFrom).add(new node(cityTo, timeRequired));
			adjacentCitiesReversed.get(cityTo).add(new node(cityFrom, timeRequired));
			inDegree[cityTo]++;
			/**
			 * 진입차수 배열 형태 예시
			 * 1 2 4
			 * 1 3 2
			 * 1 4 3
			 * 2 6 3
			 * 2 7 5
			 * 3 5 1
			 * 4 6 4
			 * 5 6 2
			 * 6 7 5
			 * =>
			 * 1 2 3 4 5 6 7
			 * 0 1 1 1 1 3 2
			 */
		}
	}

	private static void receiveMap(BufferedReader bufferedReader) throws IOException {
		numberOfCities = Integer.parseInt(bufferedReader.readLine());
		numberOfRoads = Integer.parseInt(bufferedReader.readLine());
	}

	private static void initializeAdjacentCities() {
		adjacentCities = new ArrayList<>();
		adjacentCitiesReversed = new ArrayList<>();
		for (int i = 0; i <= numberOfCities; i++) {
			adjacentCities.add(new ArrayList<>());
			adjacentCitiesReversed.add(new ArrayList<>());
		}
	}
}

class node {
	int node;
	int time;

	node(int node, int time) {
		this.node = node;
		this.time = time;
	}
}
