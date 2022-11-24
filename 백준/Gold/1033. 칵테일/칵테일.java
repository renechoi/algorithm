import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/**
	 * 결국 비율을 계산해서 전체 재료를 만드는데 필요한 값(양)을 구하는 문제이다
	 *
	 * 예제를 보면 5개의 재료가 주어지고 tree 형태의 구조를 띄게 되는 것을 알 수 있다
	 *
	 * 4 - 0
	 * 4 - 1
	 * 4 - 2
	 * 4 - 3
	 * 으로 연결되는 노드들이 있고 p, q 값은 가중치로 이해하면 된다
	 *
	 * 먼저 임의의 트리리를 정하고 전체 비율의 최소 공배수로 업데이트 한다 
	 * 이후 dfs 탐색을 수행하며 이전 노드의 값과 비교하면서 해당 노드가 가진 값으로 업데이트 한다 = 재료의 질량을 구하는 로직 
	 * 
	 * 최종적으로 구해진 질량에 최대 공약수를 나누면 재료의 최소 질량이 된다 
	 *
	 * i) 재료 = 노드와 각 노드간 비율을 인접리스트 그래프로 구현한다
	 * ii) 데이터를 받으면서 비율 정보를 함께 받음으로써 최소 공배수를 구한다 
	 * iii) 임의의 시작점에 최대 공배수 값을 설정한다 
	 * iv) dfs로 노드를 순회하며 이전 노드의 값과의 비율을 계산한다 
	 * v) 최대 공약수를 계산하고 각 값들을 나누기 = 최소 질량
	 * 
	 */

	static ArrayList<Cocktail>[] adjacentNodes;
	static long lcm;
	static boolean[] visited;
	static long[] nodes;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numberOfElement = scanner.nextInt();
		visited = new boolean[numberOfElement];
		nodes = new long[numberOfElement];

		setUpAdjacentNodes(numberOfElement);
		storeNodeInfoWithGettingLcm(scanner, numberOfElement);

		nodes[0] = lcm;				// 0번 노드에 최소 공배수 저장
		dfs(0);				// 0번부터 dfs 탐색

		long gcd = calculateMinimumMass(numberOfElement);

		for (int i = 0; i < numberOfElement; i++) {
			System.out.print(minimumMass(gcd, i));
		}
	}

	private static String minimumMass(long gcd, int i) {
		return nodes[i] / gcd + " ";
	}

	private static long calculateMinimumMass(int numberOfElement) {
		long mgcd = nodes[0];
		for (int i = 1; i < numberOfElement; i++) {
			mgcd = gcd(mgcd, nodes[i]);
		}
		return mgcd;
	}

	private static void storeNodeInfoWithGettingLcm(Scanner scanner, int numberOfElement) {
		lcm = 1;
		for (int i = 0; i < numberOfElement - 1; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			adjacentNodes[a].add(new Cocktail(b, p, q));
			adjacentNodes[b].add(new Cocktail(a, q, p));
			lcm *= lcm(p, q); // 최소 공배수 공식
		}
	}

	private static long lcm(int p, int q) {
		return (long) p * q / gcd(p, q);
	}

	private static void setUpAdjacentNodes(int numberOfElement) {
		adjacentNodes = new ArrayList[numberOfElement];
		for (int i = 0; i < numberOfElement; i++) {
			adjacentNodes[i] = new ArrayList<>();
		}
	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void dfs(int node) {
		visited[node] = true;

		for (Cocktail element : adjacentNodes[node]) {
			int next = element.getB();
			if (!visited[next]) {
				nodes[next] = nodes[node] * element.getQ() / element.getP(); 			// 노드 값 업데이트 = 최소 공배수 * 주어진 비율 => 보유하는 질량
				dfs(next);
			}
		}
	}
}

class Cocktail {
	int b;
	int p;
	int q;

	public Cocktail(int b, int p, int q) {
		super();
		this.b = b;
		this.p = p;
		this.q = q;
	}
	public int getB() {
		return b;
	}
	public int getP() {
		return p;
	}
	public int getQ() {
		return q;
	}
}
