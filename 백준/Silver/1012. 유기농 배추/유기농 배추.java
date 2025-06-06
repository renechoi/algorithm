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

	static int tc;
	static int M;
	static int N;
	static 배추[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		tc = Integer.parseInt(stringTokenizer.nextToken());

		while (tc-- > 0) {
			stringTokenizer = new StringTokenizer(br.readLine());
			M = Integer.parseInt(stringTokenizer.nextToken());
			N = Integer.parseInt(stringTokenizer.nextToken());
			int K = Integer.parseInt(stringTokenizer.nextToken());
			map = new 배추[M][N];
			for (int i = 0; i < K; i++) {
				stringTokenizer = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(stringTokenizer.nextToken());
				int y = Integer.parseInt(stringTokenizer.nextToken());
				map[x][y] = new 배추(x, y, 1);
			}
			List<Integer> 배추밭의군집 = new ArrayList<>();
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] != null && map[j][k].is배추() && !map[j][k].visited) {
						배추밭의군집.add(bfs(map[j][k]));
					}
				}
			}
			System.out.println(배추밭의군집.size());
		}

	}

	public static int bfs(배추 start) {
		Queue<배추> queue = new ArrayDeque<>();
		queue.offer(start);
		start.markVisited();
		int count = 1;
		while (!queue.isEmpty()) {
			배추 current = queue.poll();
			List<배추> neighbors = current.getAdjacentHomes();
			for (배추 neighbor : neighbors) {
				neighbor.markVisited();
				queue.offer(neighbor);
				count++;
			}
		}

		return count;

	}

	public static class 배추 {
		int x;
		int y;
		int type;
		boolean visited;

		public 배추(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.visited = false;
		}

		private boolean is배추() {
			return type == 1;
		}

		List<배추> getAdjacentHomes() {
			List<배추> neighbors = new ArrayList<>(4);
			int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			for (int[] dir : dirs) {
				int newX = this.x + dir[0];
				int newY = this.y + dir[1];
				if (newX >= 0 && newX < M && newY >= 0 && newY < N && map[newX][newY] != null && map[newX][newY].is배추() && !map[newX][newY].visited) {
					neighbors.add(map[newX][newY]);
				}
			}

			return neighbors;
		}

		public void markVisited() {
			this.visited = true;
		}
	}


}