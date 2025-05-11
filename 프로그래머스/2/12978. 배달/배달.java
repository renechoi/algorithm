
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	public int solution(int N, int[][] road, int K) {

		ArrayList<Node>[] graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < road.length; i++) {
			int a = road[i][0];
			int b = road[i][1];
			int c = road[i][2];

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[1] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
		pq.add(new Node(1, 0));
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int currentIndex = current.index;
			int currentCost = current.cost;

			if (currentCost > distance[currentIndex]) {
				continue;
			}

			for (Node next : graph[currentIndex]) {
				int nextIndex = next.index;
				int nextCost = next.cost;

				if (currentCost + nextCost < distance[nextIndex] ) {
					distance[nextIndex] = currentCost + nextCost;
					pq.add(new Node(nextIndex, distance[nextIndex]));
				}
			}
		}

		int answer = 0;
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] <= K) {
				answer++;
			}
		}
		return answer;
	}


	public class Node {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}

	
}
