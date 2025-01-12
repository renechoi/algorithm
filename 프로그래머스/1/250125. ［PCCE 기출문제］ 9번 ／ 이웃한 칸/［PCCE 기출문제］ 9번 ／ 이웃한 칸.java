
import java.util.ArrayList;

public class Solution {
	final int[] dx = {-1, 1, 0, 0};
	final int[] dy = {0, 0, -1, 1};

	public int solution(String[][] board, int h, int w) {

		int count =0;

		for (int i = 0; i < 4; i++) {
			int nx = h + dx[i];
			int ny = w + dy[i];

			if (범위를벗어났다면(nx, ny, board)) {
				continue;
			}

			if (board[nx][ny].equals(board[h][w])) {
				count++;
			}
		}

		return count;
	}

	private boolean 범위를벗어났다면(int nx, int ny, String[][] board) {
    return (nx < 0 || nx >= board.length) || (ny < 0 || ny >= board[0].length);
}

	
}
