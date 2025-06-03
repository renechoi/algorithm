
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		BilliardTable table = new BilliardTable(m, n);
		Point startPoint = new Point(startX, startY);
		List<Integer> answerList = new ArrayList<>();

		for (int[] ballCoords : balls) {
			Point targetPoint = new Point(ballCoords[0], ballCoords[1]);
			int minSquaredDistance = Integer.MAX_VALUE;

			// 네 방향 벽에 대한 Shot 객체 생성
			Shot[] potentialShots = {
				new Shot(startPoint, targetPoint, Wall.LEFT, table),
				new Shot(startPoint, targetPoint, Wall.RIGHT, table),
				new Shot(startPoint, targetPoint, Wall.TOP, table),
				new Shot(startPoint, targetPoint, Wall.BOTTOM, table)
			};

			for (Shot shot : potentialShots) {
				if (shot.isValid()) {
					minSquaredDistance = Math.min(minSquaredDistance, shot.getSquaredDistance());
				}
			}
			answerList.add(minSquaredDistance);
		}

		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}

	public static class Point {
		final int x;
		final int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		// 두 점 사이의 거리 제곱을 계산 (오버플로우 방지를 위해 long 사용 후 int로 변환)
		public int squaredDistanceTo(Point other) {
			long dx = (long)this.x - other.x;
			long dy = (long)this.y - other.y;
			return (int)(dx * dx + dy * dy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Point point = (Point)o;
			return x == point.x && y == point.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	enum Wall {
		LEFT, RIGHT, TOP, BOTTOM
	}

	public static class BilliardTable {
		final int width;
		final int height;

		BilliardTable(int m, int n) {
			this.width = m;
			this.height = n;
		}

		/**
		 * 특정 벽에 대해 목표 지점(target)을 반사시킨 가상의 목표 지점을 계산한다.
		 * <p>
		 * 공이 벽에 부딪혀 목표 지점으로 향하는 최단 경로는, 마치 벽이 거울인 것처럼
		 * 벽 너머에 있는 '반사된 목표 지점'을 향해 직선으로 나아가는 경로와 동일하다.
		 * 각 벽에 대한 반사점 계산 원리는 다음과 같다 (당구대의 좌하단이 (0,0)이라고 가정):
		 * </p>
		 * <ol>
		 * <li><b>왼쪽 벽 (x=0, 즉 Y축) 에 대한 반사</b>:
		 * <ul>
		 * <li>목표점의 Y좌표는 변하지 않는다.</li>
		 * <li>X좌표는 Y축을 기준으로 대칭 이동한다. 즉, 원래 X좌표가 {@code target.x}라면,
		 * Y축까지의 거리는 {@code target.x}이고, 반사점의 X좌표는 Y축의 반대편으로
		 * 같은 거리만큼 이동하여 {@code -target.x}가 된다.</li>
		 * <li>따라서 반사된 지점은 {@code (-target.x, target.y)} 이다.</li>
		 * </ul>
		 * </li>
		 * <li><b>오른쪽 벽 (x=width) 에 대한 반사</b>:
		 * <ul>
		 * <li>목표점의 Y좌표는 변하지 않는다.</li>
		 * <li>X좌표는 {@code x=width} 직선을 기준으로 대칭 이동한다.</li>
		 * <li>원래 X좌표 {@code target.x}에서 오른쪽 벽까지의 거리는 {@code width - target.x} 이다.</li>
		 * <li>반사점의 X좌표는 오른쪽 벽 너머로 이 거리만큼 더 간 위치이므로,
		 * {@code width + (width - target.x) = 2 * width - target.x}가 된다.</li>
		 * <li>따라서 반사된 지점은 {@code (2 * width - target.x, target.y)} 이다.</li>
		 * </ul>
		 * </li>
		 * <li><b>위쪽 벽 (y=height) 에 대한 반사</b>:
		 * <ul>
		 * <li>목표점의 X좌표는 변하지 않습니다.</li>
		 * <li>Y좌표는 {@code y=height} 직선을 기준으로 대칭 이동합니다.</li>
		 * <li>원래 Y좌표 {@code target.y}에서 위쪽 벽까지의 거리는 {@code height - target.y} 입니다.</li>
		 * <li>반사점의 Y좌표는 위쪽 벽 너머로 이 거리만큼 더 간 위치이므로,
		 * {@code height + (height - target.y) = 2 * height - target.y}가 됩니다.</li>
		 * <li>따라서 반사된 지점은 {@code (target.x, 2 * height - target.y)} 입니다.</li>
		 * </ul>
		 * </li>
		 * <li><b>아래쪽 벽 (y=0, 즉 X축) 에 대한 반사</b>:
		 * <ul>
		 * <li>목표점의 X좌표는 변하지 않는다.</li>
		 * <li>Y좌표는 X축을 기준으로 대칭 이동한다. 즉, 원래 Y좌표가 {@code target.y}라면,
		 * X축까지의 거리는 {@code target.y}이고, 반사점의 Y좌표는 X축의 반대편으로
		 * 같은 거리만큼 이동하여 {@code -target.y}가 된다.</li>
		 * <li>따라서 반사된 지점은 {@code (target.x, -target.y)} 이다.</li>
		 * </ul>
		 * </li>
		 * </ol>
		 *
		 * @param target 반사시킬 원래 목표 지점의 {@link Point} 객체
		 * @param wall   반사가 일어나는 벽의 종류 ({@link Wall} 열거형)
		 * @return 벽에 대해 반사된 새로운 가상의 목표 지점의 {@link Point} 객체
		 * @throws IllegalArgumentException 알 수 없는 {@link Wall} 타입이 입력된 경우 (Enum 사용 시 정상적으로는 발생하지 않음)
		 */
		public Point reflectTarget(Point target, Wall wall) {
			switch (wall) {
				case LEFT:
					return new Point(-target.x, target.y);
				case RIGHT:
					return new Point(2 * width - target.x, target.y);
				case TOP:
					return new Point(target.x, 2 * height - target.y);
				case BOTTOM:
					return new Point(target.x, -target.y);
				default:
					throw new IllegalArgumentException("Unknown wall type");
			}
		}
	}

	// 단일 시도(경로)를 나타내는 객체
	static class Shot {
		private final Point startPosition;
		private final Point originalTargetPosition;
		private final Point reflectedTargetPosition;
		private final Wall reflectionWall;

		Shot(Point startPosition, Point originalTargetPosition, Wall reflectionWall, BilliardTable table) {
			this.startPosition = startPosition;
			this.originalTargetPosition = originalTargetPosition;
			this.reflectionWall = reflectionWall;
			this.reflectedTargetPosition = table.reflectTarget(originalTargetPosition, reflectionWall);
		}


		/**
		 * 이 경조가 유효한지 (벽에 도달하기 전에 목표 공을 먼저 치는지) 판단
		 * <p>
		 * "원쿠션" 규칙은 공이 벽에 먼저 맞고 목표 공을 맞춰야 함을 의미한다.
		 * 이 함수는 반사의 원리로 계산된 특정 최적 경로가 규칙을 위반하는지 확인한다,
		 * <ol>
		 * <li>반사된 '유령 목표 공'을 향해 직선으로 칠 때, 그 경로가 벽에 닿기 전에
		 * 실제 목표 공의 위치를 먼저 지나면 해당 경로는 유효하지 않다.</li>
		 * <li>이러한 "경로 막힘" 현상은 다음 특정 조건에서만 발생한다.
		 * <ul>
		 * <li>좌/우 벽 반사 시: 출발점과 목표 공의 y좌표(높이)가 같고,
		 * 목표 공이 출발점과 해당 벽 사이에 위치할 때.</li>
		 * <li>상/하 벽 반사 시: 출발점과 목표 공의 x좌표(가로선)가 같고,
		 * 목표 공이 출발점과 해당 벽 사이에 위치할 때.</li>
		 * </ul>
		 * <li><b>수학적 증명 (좌측 벽 반사 예시)</b>:
		 *     <ul>
		 *         <li>출발점 S(sx, sy), 목표 공 T(tx, ty), T를 좌측 벽(x=0)에 반사한 유령 공 T'(-tx, ty).</li>
		 *         <li>공이 벽에 맞는 지점 W는 S와 T'를 잇는 직선이 x=0과 만나는 점이다.</li>
		 *         <li>T가 S와 W 사이에 있어 경로를 막으려면 S, T, W가 일직선상에 있어야 한다.</li>
		 *         <li>W가 S-T' 직선 위의 점이므로, 결국 S, T, T'가 일직선상에 있어야 한다.</li>
		 *         <li>T와 T'의 y좌표는 ty로 같다. 따라서 T와 T'를 잇는 선은 수평선 (기울기 0).</li>
		 *         <li>따라서, S, T, T'가 일직선이려면 S와 T를 잇는 선도 수평선이어야 하므로, sy = ty 여야 한다. Q.E.D </li>
		 *         <li>다른 벽의 경우도 동일하게 증명됨. </li>
		 *         <li>즉, y좌표가 다르면 T는 S에서 T'로 향하는 (벽에 최적으로 반사되는) 직선 경로의 첫 번째 구간(S-W) 위에 정확히 놓일 수 없으므로, 아래와 같은 valid 함수가 구현됨. </li>
		 *     </ul>
		 * </li>
		 * <li>다른 모든 경우는 목표 공이 해당 최적 직선 경로를 막지 않으므로 유효</li>
		 * </ol>
		 * @return 경로가 유효하면 true, 그렇지 않으면 false.
		 */
		public boolean isValid() {
			switch (reflectionWall) {
				case LEFT: // 왼쪽 벽(x=0) 반사
					// 출발점과 목표점이 같은 y선상에 있고, 목표점이 출발점보다 왼쪽에 있으면 무효
					return !(startPosition.y == originalTargetPosition.y && originalTargetPosition.x < startPosition.x);
				case RIGHT: // 오른쪽 벽(x=m) 반사
					// 출발점과 목표점이 같은 y선상에 있고, 목표점이 출발점보다 오른쪽에 있으면 무효
					return !(startPosition.y == originalTargetPosition.y && originalTargetPosition.x > startPosition.x);
				case BOTTOM: // 아래쪽 벽(y=0) 반사
					// 출발점과 목표점이 같은 x선상에 있고, 목표점이 출발점보다 아래쪽에 있으면 무효
					return !(startPosition.x == originalTargetPosition.x && originalTargetPosition.y < startPosition.y);
				case TOP: // 위쪽 벽(y=n) 반사
					// 출발점과 목표점이 같은 x선상에 있고, 목표점이 출발점보다 위쪽에 있으면 무효
					return !(startPosition.x == originalTargetPosition.x && originalTargetPosition.y > startPosition.y);
				default:
					return false; 
			}
		}

		public int getSquaredDistance() {
			return startPosition.squaredDistanceTo(reflectedTargetPosition);
		}
	}



}
