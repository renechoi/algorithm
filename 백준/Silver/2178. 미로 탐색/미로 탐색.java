import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {1, 0, -1, 0};
	private static boolean[][] visited;
	private static int[][] maze;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		maze = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String line = stringTokenizer.nextToken();

			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}

		bfs();	// 0, 0에서부터 시작하는 것과 같은 의미
		System.out.println(maze[N - 1][M - 1]);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0});
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] coordinate = queue.poll();

			for (int position = 0; position < 4; position++) {    // 상하좌우 탐색
				int x = coordinate[0] + dx[position];
				int y = coordinate[1] + dy[position];

				if (validateCoordinate(x, y)) {
					if (isAbleToStretchFurther(x, y)) {
						visited[x][y] = true;
						maze[x][y] = maze[coordinate[0]][coordinate[1]] + 1;		// 깊이 업데이트 = 지도에 +1로 그릴 때 사실상 depth를 카운팅하는 횟수가 된다
						queue.add(new int[]{x, y});
					}
				}
			}
		}
	}

	private static boolean isAbleToStretchFurther(int x, int y) {
		return maze[x][y] != 0 && !visited[x][y];
	}

	private static boolean validateCoordinate(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}