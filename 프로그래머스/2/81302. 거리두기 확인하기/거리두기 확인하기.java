import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {

	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	static String[] place;

	public int[] solution(String[][] places) {

		int[] answer = new int[places.length];

		for (int i = 0; i < places.length; i++) {
			place = places[i];
			answer[i] = checkRoom() ? 1 : 0;
		}

		return answer;
	}

	private boolean checkRoom() {
		for (int i =0; i<5; i++) {
			for (int j = 0; j<5; j++) {
				if(place[i].charAt(j) == 'P') {
					Cell cell = new Cell(i, j, place[i].charAt(j));
					if(!거리두기를어기는지Bfs탐색(cell)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean 거리두기를어기는지Bfs탐색(Cell cell) {

		ArrayDeque<Cell> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[5][5];
		queue.add(cell);

		visited[cell.r][cell.c] = true;
		int distance = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			distance++;
			if(distance > 2) {
				break;
			}
			for (int i = 0; i < size; i++) {
				Cell cur = queue.poll();
				List<Cell> adjacentCells = cur.getAdjacentCells();
				for (Cell adjacentCell : adjacentCells) {
					if(visited[adjacentCell.r][adjacentCell.c]) {
						continue;
					}
					if(adjacentCell.isPerson()) {
						return false;
					}
					if(adjacentCell.is벽()) {
						continue;
					}
					queue.add(adjacentCell);
					visited[adjacentCell.r][adjacentCell.c] = true;
				}
			}
		}
		return true;

	}

	public static class Cell{
		int r;
		int c;
		char value;

		public Cell(int r, int c, char value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}

		public List<Cell> getAdjacentCells(){
			List<Cell> cells = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
					cells.add(new Cell(nr, nc, place[nr].charAt(nc)));
				}
			}
			return cells;
		}

		public boolean isPerson() {
			return value == 'P';
		}

		public boolean is벽() {
			return value == 'X';
		}
	}

	public static class Link {
		final Cell cell;
		final int distance;   // 시작점으로부터 맨해튼 거리

		Link(Cell cell, int distance) {
			this.cell = cell;
			this.distance = distance;
		}
	}

}
