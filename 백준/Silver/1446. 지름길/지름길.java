
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
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int n = parseInt(stringTokenizer.nextToken());
		int D = parseInt(stringTokenizer.nextToken());

		List<Node> list = new ArrayList<>();
		while (n-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int a = parseInt(stringTokenizer.nextToken());
			int b = parseInt(stringTokenizer.nextToken());
			int c = parseInt(stringTokenizer.nextToken());
			if(c < b-a && b <= D){
				list.add(new Node(a, b, c));
			}
		}

		List<List<Node>> graph = new ArrayList<>();
		for (int i = 0; i <= D; i++) {
			graph.add(new ArrayList<>());
		}

		for (Node node : list) {
			int start = node.start;
			int end = node.end;
			int d = node.cost;

			graph.get(start).add(new Node(start, end, d));
		}

		int[] dist = new int[D + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

		PriorityQueue<State> pq = new PriorityQueue<>();
		pq.offer(new State(0, 0));

		while (!pq.isEmpty()) {
			State current = pq.poll();
			int currentX  = current.x;
			int currentCost = current.cost;
			if (currentCost > dist[currentX]){
				continue;
			}

			// 1km씩 전진
			if (도착지점까지도달하지못했고(currentX, D) && 더짧은거리인가(currentCost + 1, dist[currentX + 1])) {
				dist[currentX + 1] = currentCost + 1;
				pq.offer(new State(currentX + 1, dist[currentX + 1]));
			}

			// 지름길
			for (Node 지름길 : graph.get(currentX)) {
				if (더짧은거리인가(currentCost + 지름길.cost, dist[지름길.end])) {
					dist[지름길.end] = currentCost + 지름길.cost;
					pq.offer(new State(지름길.end, dist[지름길.end]));
				}
			}
		}

		System.out.println(dist[D]);

	}

	private static boolean 더짧은거리인가(int 후보거리, int 현재최단) {
		return 후보거리 < 현재최단;
	}

	private static boolean 도착지점까지도달하지못했고(int x, int D) {
		return x + 1 <= D;
	}

	public static class State implements Comparable<State> {
		int x;   // 1차원 평면에서 현재 위치 (0 ~ D)
		int cost;  // 출발점(0)에서 pos까지의 누적 거리

		State(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(State o) {
			return Integer.compare(this.cost, o.cost);
		}
	}



	public static class Node {
		int start;
		int end;
		int cost;

		public Node(int x, int y, int cost) {
			this.start = x;
			this.end = y;
			this.cost = cost;
		}
	}

}
