
import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static Node[][] originalMap;
	static final List<Node> houses = new ArrayList<>();
	static final List<Node> chickens = new ArrayList<>();
	static int minCityDist = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("fundamentals/src/test/java/template/Boj/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = parseInt(st.nextToken());
		m = parseInt(st.nextToken());

		originalMap = new Node[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int type = parseInt(st.nextToken());
				Node node = new Node(i, j, type);
				originalMap[i][j] = node;

				if (node.is집()) {
					houses.add(node);
				} else if (node.is치킨집()) {
					chickens.add(node);
				}
			}
		}

		boolean[] picked = new boolean[chickens.size()];
		pickChickenStores(0, 0, picked);

		System.out.println(minCityDist);
	}

	// 치킨집 M개를 조합으로 선택하는 것 == 백트래킹 이용 
    // 선택한 조합에 대해, 이미 구해놓은 치킨집들로 해당 조합에서의 치킨집을 꺼내서 
    // 그것과 집들에 대한 거리 최소를 구함 
	private static void pickChickenStores(int idx, int chosen, boolean[] picked) {
		// M개를 모두 선택한 경우 ==> 조합을 전부 선택한 것이므로 이 경우 탐색 시작 
		if (chosen == m) {
			int cityDist = calcCityChickenDistance(picked);
			minCityDist = Math.min(minCityDist, cityDist);
			return;
		}

		// 더 이상 선택할 치킨집이 없는 경우
		if (idx == chickens.size()) {
			return;
		}

		// 조합 선택 백트래킹 로직 
		picked[idx] = true;
		pickChickenStores(idx + 1, chosen + 1, picked);

		picked[idx] = false;
		pickChickenStores(idx + 1, chosen, picked);
	}

	// 현재 선택된 치킨집 집합(picked)에 대해 도시 치킨 거리 계산
	private static int calcCityChickenDistance(boolean[] picked) {
		int sum = 0;

		for (Node house : houses) {
			int minDist = Integer.MAX_VALUE;

			for (int i = 0; i < chickens.size(); i++) {
				if (!picked[i]) {
					continue; // 폐업한 치킨집임 == 조합에 선택되지 않음 
				}
				int dist = house.getDistance(chickens.get(i));
				if (dist < minDist) {
					minDist = dist;
					if (minDist == 1){  // 1인 경우 최소 거리이므로 더 이상 탐색할 필요 없음
						break;
					}
				}
			}
			sum += minDist;
			// sum이 이미 현재 최솟값보다 크면 중단 (가지치기)
			if (sum >= minCityDist) {
				return sum;
			}
		}

		return sum;
	}

	public static class Node {
		int x;
		int y;
		int type;

		public Node(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}

		boolean isEmpty() {
			return type == 0;
		}

		boolean is집() {
			return type == 1;
		}

		boolean is치킨집() {
			return type == 2;
		}

		int getDistance(Node other) {
			return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
		}
	}
}
