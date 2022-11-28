import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	private static final Deque<Snake> snakeAtBoard = new ArrayDeque<>();
	private static HashMap<Integer, String> directionCommandWithTime;
	private static int N;
	private static int K;
	private static int[][] board;
	private static final int[] dx = {-1, 0, 1, 0};
	private static final int[] dy = {0, -1, 0, 1};
	private static int time = 0;
	private static int direction = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());
		K = Integer.parseInt(bufferedReader.readLine());
		board = new int[N][N];

		initializeSnake();
		saveAppleAtBoard(bufferedReader);
		saveDirectionChangeInfo(bufferedReader);

		bufferedReader.close();

		snakeMovement();

		System.out.println(time);
	}

	private static void snakeMovement() {
		while (true) {
			time++;

			int x = snakeAtBoard.peekFirst().x + dx[direction];
			int y = snakeAtBoard.peekFirst().y + dy[direction];

			if (isGameEnd(x, y)) {
				break;
			}

			if (board[x][y] == 1) {
				moveAhead(x, y);
			}else{
				moveAhead(x, y);
				removeTail();
			}

			if (isDirectionChangeTime()) {
				String directionCommand = directionCommandWithTime.get(time);
				direction = setDirection(direction, directionCommand);
			}
		}
	}

	private static void removeTail() {
		Snake snake = snakeAtBoard.pollLast();
		board[snake.x][snake.y] = 0;
	}

	private static void moveAhead(int x, int y) {
		board[x][y] = 2;
		snakeAtBoard.offerFirst(new Snake(x, y));
	}

	private static boolean isDirectionChangeTime() {
		return directionCommandWithTime.containsKey(time);
	}

	private static int setDirection(int direction, String directionCommand) {
		if (directionCommand.equals("L")) {
			return (direction + 1) % 4;
		}
		return (direction + 3) % 4;
	}

	private static boolean isGameEnd(int x, int y) {
		return y < 0 || y >= N || x < 0 || x >= N || board[x][y] == 2;
	}

	private static void initializeSnake() {
		board[0][0] = 2;
		snakeAtBoard.offer(new Snake(0, 0));
	}

	private static void saveDirectionChangeInfo(BufferedReader bufferedReader) throws IOException {
		StringTokenizer stringTokenizer;
		int L = Integer.parseInt(bufferedReader.readLine());
		directionCommandWithTime = new HashMap<>(L);
		for (int i = 0; i < L; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			int time = Integer.parseInt(stringTokenizer.nextToken());
			String changeDirection = stringTokenizer.nextToken();

			directionCommandWithTime.put(time, changeDirection);
		}
	}

	private static void saveAppleAtBoard(BufferedReader bufferedReader) throws IOException {
		StringTokenizer stringTokenizer;
		for (int i = 0; i < K; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int xApple = Integer.parseInt(stringTokenizer.nextToken()) -1;
			int yApple = Integer.parseInt(stringTokenizer.nextToken()) -1;

			board[xApple][yApple] = 1;
		}
	}

	static class Snake {
		int x;
		int y;

		Snake(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
