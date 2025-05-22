import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {

	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};

	private int n, m;
	private int[][] land;
	private boolean[][] visited;
	private int[][] 석유맵;
	private List<OilComponent> components;

	public int solution(int[][] land) {
		this.land = land;
		this.n = land.length;
		this.m = land[0].length;
		this.visited = new boolean[n][m];
		this.석유맵 = new int[n][m];
		this.components = new ArrayList<>();

		석유탐색하여지도그려놓기();
		return 열별로탐색하여max값찾기();
	}

	private void 석유탐색하여지도그려놓기() {
		int nextId = 1;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (land[r][c] == 1 && !visited[r][c]) {
					OilComponent comp = new OilComponent(nextId++);
					bfs(r, c, comp);
					components.add(comp);
				}
			}
		}
	}

	private void bfs(int r, int c, OilComponent oilComponent) {
		Queue<Cell> queue = new ArrayDeque<>();
		queue.add(new Cell(r, c));
		visited[r][c] = true;
		석유맵[r][c] = oilComponent.id;
		oilComponent.addCell();

		while (!queue.isEmpty()) {
			Cell current = queue.poll();
			for (Cell 인접 : current.getAdjacentOilNodes(land)) {
				if (!visited[인접.r][인접.c]) {
					visited[인접.r][인접.c] = true;
					석유맵[인접.r][인접.c] = oilComponent.id;
					oilComponent.addCell();
					queue.add(인접);
				}
			}
		}
	}


	private int 열별로탐색하여max값찾기() {
		int max = 0;
		for (int c = 0; c < m; c++) {
			boolean[] collected = new boolean[components.size() + 1];
			int sum = 0;
			for (int r = 0; r < n; r++) {
				if (land[r][c] == 1) {
					int id = 석유맵[r][c];
					if (!collected[id]) {
						collected[id] = true;
						sum += components.get(id - 1).size;
					}
				}
			}
			max = Math.max(max, sum);
		}
		return max;
	}


	public static class Cell {
		int r;
		int c;

		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public List<Cell> getAdjacentOilNodes(int[][] land) {
			List<Cell> list = new ArrayList<>();
			int n = land.length;
			int m = land[0].length;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && land[nr][nc] == 1) {
					list.add(new Cell(nr, nc));
				}
			}
			return list;
		}
	}

	/**
	 * 하나의 석유 덩어리 정보 보관
	 */
	public static class OilComponent {
		int id;
		int size = 0;

		OilComponent(int id) {
			this.id = id;
		}

		void addCell() {
			size++;
		}
	}


}
