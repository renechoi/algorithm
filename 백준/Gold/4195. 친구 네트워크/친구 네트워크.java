
import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	private static int[] parent;           // 각 정점의 부모
	private static int[] size;             // 루트에 저장되는 집합 크기
	private static Map<String, Integer> idMap; // 이름 → ID 매핑
	private static int nextId;             // 다음에 부여할 ID


	public static void main(String[] args) throws IOException {
		StringBuilder output = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int testCaseCount = Integer.parseInt(bufferedReader.readLine());

		for (int testCaseIndex = 0; testCaseIndex < testCaseCount; testCaseIndex++) {
			int friendshipCount = Integer.parseInt(bufferedReader.readLine());

			parent = new int[friendshipCount * 2];
			size = new int[friendshipCount * 2];
			idMap = new HashMap<>(friendshipCount * 2);
			nextId = 0;

			for (int index = 0; index < friendshipCount * 2; index++) {
				parent[index] = index;   // 자기 자신을 부모로
				size[index] = 1;         // 집합 초기 크기 1
			}

			for (int line = 0; line < friendshipCount; line++) {
				StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				String nameA = stringTokenizer.nextToken();
				String nameB = stringTokenizer.nextToken();

				int idA = getId(nameA);
				int idB = getId(nameB);

				int networkSize = union(idA, idB);
				output.append(networkSize).append('\n');
			}
		}

		System.out.print(output.toString());
	}

	/**
	 * 이름을 ID로 변환한다. 처음 보는 이름이면 새 ID를 부여한다.
	 */
	private static int getId(String name) {
		Integer existingId = idMap.get(name);
		if (existingId == null) {
			existingId = nextId;
			idMap.put(name, existingId);
			nextId++;
		}
		return existingId;
	}

	/**
	 * find: 루트를 찾는다. (경로 압축 적용)
	 */
	private static int find(int node) {
		if (parent[node] != node) {
			parent[node] = find(parent[node]);
		}
		return parent[node];
	}

	/**
	 * union: 두 집합을 병합하고 병합 후 집합 크기를 반환한다. (트리 높이 최소화 적용)
	 */
	private static int union(int nodeA, int nodeB) {
		int rootA = find(nodeA);
		int rootB = find(nodeB);

		if (rootA == rootB) {
			return size[rootA];
		}

		if (size[rootA] < size[rootB]) {
			int temporary = rootA;
			rootA = rootB;
			rootB = temporary;
		}

		parent[rootB] = rootA;
		size[rootA] += size[rootB];

		return size[rootA];
	}

}
