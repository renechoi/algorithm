
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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0){
				break;
			}

			int[][] map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[][] visited = new boolean[h][w];
			int count = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(map, i, j, visited);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void bfs(int[][] map, int x, int y, boolean[][] visited) {
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,-1,1,-1,0,1};

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 8; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length){
					continue;
				}
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[]{nx, ny});
				}
			}
		}
	}

}
