import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {


	public int[] solution(String[] park, String[] routes) {
		Park parkObj = new Park(park);

		// 공원에서 시작 위치 'S'를 찾아 Position 객체로 생성
		Position startPos = null;
		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length(); j++) {
				if (park[i].charAt(j) == 'S') {
					startPos = new Position(i, j);
					break;
				}
			}
			if (startPos != null) break;
		}
		if (startPos == null) {
			throw new IllegalArgumentException("시작 위치 'S'를 찾을 수 없습니다.");
		}

		Robot robot = new Robot(startPos);

		Queue<Command> commandQueue = new ArrayDeque<>();
		for (String route : routes) {

			String[] parts = route.split(" ");
			char direction = parts[0].charAt(0);
			int distance = Integer.parseInt(parts[1]);
			commandQueue.offer(new Command(direction, distance));
		}

		while (!commandQueue.isEmpty()) {
			Command cmd = commandQueue.poll();
			if (robot.canMove(parkObj, cmd)) {
				robot.move(cmd);
			}
		}

		return new int[]{robot.getPosition().row, robot.getPosition().col};
	}



	static class Position {
		int row;
		int col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static class Command {
		char direction;
		int distance;

		public Command(char direction, int distance) {
			this.direction = direction;
			this.distance = distance;
		}
	}

	static class Park {
		char[][] grid;
		int height;
		int width;

		public Park(String[] park) {
			this.height = park.length;
			this.width = park[0].length();
			grid = new char[height][width];
			for (int i = 0; i < height; i++) {
				grid[i] = park[i].toCharArray();
			}
		}

		// 주어진 좌표가 공원 내에 있는지 확인
		public boolean isValid(Position pos) {
			return pos.row >= 0 && pos.row < height && pos.col >= 0 && pos.col < width;
		}

		// 해당 좌표가 장애물('X')인지 확인
		public boolean isObstacle(Position pos) {
			return grid[pos.row][pos.col] == 'X';
		}
	}

	static class Robot {
		Position pos;

		public Robot(Position startPos) {
			this.pos = startPos;
		}

		public Position getPosition() {
			return pos;
		}

		/**
		 * 주어진 명령을 실행할 수 있는지 검사.
		 * 이동 경로 상에 범위를 벗어나거나 장애물이 있으면 false 반환.
		 */
		public boolean canMove(Park park, Command cmd) {
			int dr = 0, dc = 0;
			switch (cmd.direction) {
				case 'N': dr = -1; break;
				case 'S': dr = 1; break;
				case 'W': dc = -1; break;
				case 'E': dc = 1; break;
				default: throw new IllegalArgumentException("잘못된 방향: " + cmd.direction);
			}

			int newRow = pos.row;
			int newCol = pos.col;

			for (int i = 0; i < cmd.distance; i++) {
				newRow += dr;
				newCol += dc;
				Position nextPos = new Position(newRow, newCol);
				if (!park.isValid(nextPos) || park.isObstacle(nextPos)) {
					return false;
				}
			}
			return true;
		}

		// 주어진 명령어에 따라 실제로 이동 (이동 전에는 이미 검증되었다고 가정)
		public void move(Command cmd) {
			int dr = 0, dc = 0;
			switch (cmd.direction) {
				case 'N': dr = -1; break;
				case 'S': dr = 1; break;
				case 'W': dc = -1; break;
				case 'E': dc = 1; break;
				default: throw new IllegalArgumentException("잘못된 방향: " + cmd.direction);
			}
			pos.row += dr * cmd.distance;
			pos.col += dc * cmd.distance;
		}
	}



}
