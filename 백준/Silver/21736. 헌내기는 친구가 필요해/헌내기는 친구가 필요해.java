import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static 좌표[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());
		map = new 좌표[n][m];
		좌표 start = null;
		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			String trim = stringTokenizer.nextToken().trim();
			for (int j = 0; j < m; j++) {
				String type = String.valueOf(trim.charAt(j));
				map[i][j] = new 좌표(i, j, type);
				if (type.equals("I")) {
					start = map[i][j];
				}
			}
		}

		int result = bfs(start);
		if (result == 0) {
			System.out.println("TT");
		} else {
			System.out.println(result);
		}
	}

	
	public static int bfs(좌표 start){
		Queue <좌표> queue = new ArrayDeque<>();
		queue.offer(start);
		int count = 0;
		while (!queue.isEmpty()) {
			좌표 cur = queue.poll();
			if (cur.visited || cur.is벽()) {
				continue;
			}

			cur.markVisited();

			if (cur.is사람()) {
				count++;
			}

			for (좌표 nxt : cur.getAdjacent()) {
				if (!nxt.visited && !nxt.is벽()) {
					queue.offer(nxt);
				}
			}
		}
		return count;
	}


	/**
	 * 시간 초과
	 */
	public static int dfs(좌표 cur) {
		if (cur.visited || cur.is벽()) {
			return 0;
		}

		cur.markVisited();

		int count = 0;
		if (cur.is사람()) {
			count++;
		}

		for (좌표 nxt : cur.getAdjacent()) {
			if (!nxt.visited && !nxt.is벽()) {
				count += dfs(nxt);
			}
		}

		return count;
	}





	public static class 좌표 {
		int x;
		int y;
		String  type;
		boolean visited;

		public 좌표(int x, int y, String type) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.visited = false;
		}

		private boolean is도연() {
			return type.equals("I");
		}

		private boolean is벽() {
			return type.equals("X");
		}

		private boolean is길() {
			return type.equals("O");
		}

		private boolean is사람() {
			return type.equals("P");
		}

		public List<좌표> getAdjacent() {
			List<좌표> neighbors = new ArrayList<>(4);
			int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

			for (int[] d : dirs) {
				int nx = this.x + d[0];
				int ny = this.y + d[1];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					neighbors.add(map[nx][ny]);
				}
			}
			return neighbors;
		}

		public void markVisited() {
			this.visited = true;
		}
	}

}