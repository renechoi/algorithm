
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		int T = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int K = Integer.parseInt(stringTokenizer.nextToken());
		int A = Integer.parseInt(stringTokenizer.nextToken());
		int B = Integer.parseInt(stringTokenizer.nextToken());

		char[][] board = new char[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String input = bufferedReader.readLine();
			for (int j = 1; j <= M; j++) {
				board[i][j] = input.charAt(j - 1);
			}
		}

		while (T-- > 0) {
			// 누적합 배열 구하기
			int[][] boardS = getAccumulatedRangeSum(board);

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					// i, j => 현재 => 주위 탐색
					int count = searchNeighbors(boardS, i, j, K);
					// 상태 업데이트
					board[i][j] = update(A, B, count, board[i][j]);
				}
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				stringBuilder.append(board[i][j]);
			}
			stringBuilder.append("\n");
		}

		System.out.print(stringBuilder);
	}

	private static int[][] getAccumulatedRangeSum(char[][] board) {
		int[][] boardS = new int[board.length - 1 + 1][board[0].length - 1 + 1];
		for (int i = 1; i <= board.length - 1; i++) {
			for (int j = 1; j <= board[0].length - 1; j++) {
				boardS[i][j] = convertToInt(board[i][j]) + boardS[i - 1][j] + boardS[i][j - 1] - boardS[i - 1][j - 1];
			}
		}
		return boardS;
	}

	private static int convertToInt(char mark) {
		if (mark == '*') {
			return 1;
		}
		return 0;
	}

	private static int searchNeighbors(int[][] boardS, int i, int j, int K) {
		int x1 = Math.max(i - K, 1);
		int y1 = Math.max(j - K, 1);
		int x2 = Math.min(i + K, boardS.length - 1);
		int y2 = Math.min(j + K, boardS[0].length - 1);
		return boardS[x2][y2] - boardS[x2][y1 - 1] - boardS[x1 - 1][y2] + boardS[x1 - 1][y1 - 1];
	}

	private static char update(int a, int b, int count, char current) {
		if ((current == '*')) {
			count--;
			if (count >= a && count <= b) {
				return '*';
			}
		}
		if ((current == '.') && count > a && count <= b) {
			return '*';
		}
		return '.';
	}
}


