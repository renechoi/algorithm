
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Solution {
	public int solution(int n, int[][] costs) {

		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		List<Connection> connections = new ArrayList<>();
		for (int[] cost : costs) {
			int from = cost[0];
			int to = cost[1];
			int costValue = cost[2];

			connections.add(new Connection(from, to, costValue));
		}

		Collections.sort(connections);

		int totalCost = 0;
		for (Connection connection : connections) {
			int from = connection.from;
			int to = connection.to;

			if (findParent(parent, from) != findParent(parent, to)) {
				union(parent, from, to);
				totalCost += connection.cost;
			}
		}
		return totalCost;
	}

	public void union(int[] parent, int a, int b) {
		int rootA = findParent(parent, a);
		int rootB = findParent(parent, b);
		if (rootA != rootB) {
			parent[rootB] = rootA;
		}
	}

	public int findParent(int[] parent, int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = findParent(parent, parent[a]);
	}



	static class Connection implements Comparable<Connection> {
		int from;
		int to;
		int cost;

		public Connection(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		public int getFrom() {
			return from;
		}

		public int getTo() {
			return to;
		}

		public int getCost() {
			return cost;
		}

		@Override
		public int compareTo(Connection o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}