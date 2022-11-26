import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 어떤 건물을 짓기 위해 먼저 지어야 하는 건물이 있다 => 진입 순서가 있는 위상 정렬
	 * <p>
	 * 건물의 번호는 순차적으로 주어지는 순서를 따른다
	 * <p>
	 * 각 건물을 짓는데 걸리는 자기 자신의 시간과 선행 건물의 시간을 구분해서 고려하고
	 * 선행 건물의 시간을 위상 정렬을 수행하면서 구해주고
	 * 마지막에 자기 자신의 시간을 더해준다
	 */

	public static void main(String[] args) throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int numberOfBuildings = Integer.parseInt(bufferedReader.readLine());
		ArrayList<ArrayList<Integer>> adjacentBuildings = initializeBuildingsInfo(numberOfBuildings);

		int[] inDegree = new int[numberOfBuildings + 1];
		int[] timeForSelfBuilding = new int[numberOfBuildings + 1];
		saveAdjacentBuildings(bufferedReader, numberOfBuildings, adjacentBuildings, inDegree, timeForSelfBuilding);

		int[] timeSummation = topologySort(numberOfBuildings, adjacentBuildings, inDegree, timeForSelfBuilding);

		drawAnswer(numberOfBuildings, timeForSelfBuilding, timeSummation);
	}

	private static void drawAnswer(int numberOfBuildings, int[] timeForSelfBuilding, int[] timeSummation) {
		for (int i = 1; i <= numberOfBuildings; i++) {
			System.out.println(timeSummation[i] + timeForSelfBuilding[i]);
		}
	}

	private static int[] topologySort(int numberOfBuildings, ArrayList<ArrayList<Integer>> adjacentBuildings, int[] inDegree, int[] timeForSelfBuilding) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= numberOfBuildings; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		int[] timeSummation = new int[numberOfBuildings + 1];            // 시간의 합을 구하는 배열
		while (!queue.isEmpty()) {
			int currentBuilding = queue.poll();
			for (int buildingNumber : adjacentBuildings.get(currentBuilding)) {
				inDegree[buildingNumber]--;
				if (inDegree[buildingNumber] == 0) {
					queue.offer(buildingNumber);
				}

				// max(현재 건물에 저장된 시간, 이전 건물에 저장된 시간 + 현재 건물의 생산시간) => 큰 것으로 현재 건물에 저장된 시간을 업데이트
				// => 시간 업데이트
				timeSummation[buildingNumber] = Math.max(timeSummation[buildingNumber], timeSummation[currentBuilding] + timeForSelfBuilding[currentBuilding]);
			}
		}
		return timeSummation;
	}

	private static void saveAdjacentBuildings(BufferedReader bufferedReader, int numberOfBuildings, ArrayList<ArrayList<Integer>> adjacentBuildings, int[] inDegree, int[] timeForSelfBuilding) throws IOException {
		for (int i = 1; i <= numberOfBuildings; i++) {

			/**
			 * e.g 10 1 -1 => x번째 건물과 걸리는 시간 10, 선행 건물 1
			 */
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			timeForSelfBuilding[i] = Integer.parseInt(stringTokenizer.nextToken());                // 10

			while (true) {
				int preBuilding = Integer.parseInt(stringTokenizer.nextToken());                    // 1 (선행건물)
				if (preBuilding == -1)                                                                // -1이면 다음
					break;
				adjacentBuildings.get(preBuilding).add(i);                                            // 1 -> 2,10 / 3,10, 4,10
				inDegree[i]++; // 진입차수 배열 초기화
			}
		}
	}

	private static ArrayList<ArrayList<Integer>> initializeBuildingsInfo(int numberOfBuildings) {
		ArrayList<ArrayList<Integer>> adjacentBuildings = new ArrayList<>();
		for (int i = 0; i <= numberOfBuildings; i++) {
			adjacentBuildings.add(new ArrayList<>());
		}
		return adjacentBuildings;
	}
}
