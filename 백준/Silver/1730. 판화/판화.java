
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bufferedReader.readLine());

		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 46;
			}
		}

		char[] movements = bufferedReader.readLine().toCharArray();
		currentPosition currentPosition = new currentPosition(N);
		for (char movement : movements) {

			currentPosition.move(movement, map);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				stringBuilder.append(map[i][j]);
			}
			stringBuilder.append("\n");
		}

		System.out.println(stringBuilder);
	}

	static class currentPosition {
		int x;
		int y;
		int limit;

		final char up = 124;
		final char down = 124;
		final char left = 45;
		final char right = 45;
		final char dual = 43;
		final char untouched = 46;

		public currentPosition(int limit) {
			this.limit = limit - 1;
		}

		public void move(char movement, char[][] map) {
			if (isOutOfLine(movement)) {
				return;
			}
			if (movement == 'D') {
				mark(down, map);
				moveDown();
				mark(down, map);
			}

			if (movement == 'U') {
				mark(up, map);
				moveUp();
				mark(up, map);
			}

			if (movement == 'L') {
				mark(left, map);
				moveLeft();
				mark(left, map);
			}

			if (movement == 'R') {
				mark(right, map);
				moveRight();
				mark(right, map);
			}

		}

		private boolean isOutOfLine(char movement) {
			if (movement == 'D' && this.y == limit) {
				return true;
			}

			if (movement == 'U' && this.y == 0) {
				return true;
			}

			if (movement == 'L' && this.x == 0) {
				return true;
			}

			if (movement == 'R' && this.x == limit) {
				return true;
			}

			return false;
		}

		public void moveLeft() {
			this.x -= 1;
			if (x < 0) {
				this.x += 1;
			}
		}

		public void moveRight() {
			this.x += 1;
			if (x > limit) {
				this.x -= 1;
			}
		}

		public void moveUp() {
			this.y -= 1;
			if (y < 0) {
				this.y += 1;
			}
		}

		public void moveDown() {
			this.y += 1;
			if (y > limit) {
				this.y -= 1;
			}
		}

		public void mark(int mark, char[][] map) {

			if (map[y][x] == untouched) {
				map[y][x] = (char)mark;
				return;
			}

			if (map[y][x] == up) {
				if (mark == up) {
					return;
				} else {
					map[y][x] = dual;
				}
			}
			if (map[y][x] == right) {
				if (mark == right) {
					return;
				} else {
					map[y][x] = dual;
				}
			}

		}

		@Override
		public String toString() {
			return String.format("%d, %d", x, y);
		}

	}
}

