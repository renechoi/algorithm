import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {

	private static int MeetingNumbers;
	private static int[][] meetings;

	/**
	 * 회의가 종료되는 시간이 빠를수록 다음 회의를 빨리 시작할 수 있다
	 * 즉, 빠른 종료 시간으로 정렬하고, 겹치지 않는 회의가 나오면 선택한다
	 * 최종 선택된 개수가 정답이 된다
	 *
	 * 다만 이 문제에서 독특한 조건은 시작 시간과 종료 시간이 같은 경우다
	 * 예를 들어 (2,2)라면 2시에 시작해 2시에 끝난다 (2시 x분에 시작해 2시 59분에 내에 끝난다는 의미)
	 * 이러한 경우라면 종료 시간 기준이 아니라 시작 시간으로 정렬을 해주어야 카운팅이 된다
	 *
	 * 자바의 comparator를 사용할 경우, 두 매개변수를 가진 객체를 비교할 수 있다.
	 *
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MeetingNumbers = scanner.nextInt();			// 입력받는 회의개수
		meetings = getMeetings(scanner);			// 입력받는 회의와 해당 회의의 시간 정보

		Arrays.sort(meetings, comparator);
		
		System.out.println(calculateCount());
	}

	private static int calculateCount() {
		int count = 0;
		int end = 0;								
		for (int i = 0; i < MeetingNumbers; i++) {
			if (meetings[i][0] >= end) { 			// 회의할 수 있는 시간 범위 바깥에 종료 시간 존재 => 시간 사용 가능
				end = meetings[i][1]; 				// 해당 시간에 회의를 하므로 종료 시간 업데이트
				count++;
			}
		}
		return count;
	}

	private static final Comparator<int[]> comparator = (meeting1, meeting2) -> {
		if (meeting1[1] == meeting2[1]) { 					// 종료 시간이 같을 경우
			return meeting1[0] - meeting2[0];					// 시작 시간 기준으로 정렬
		}
		return meeting1[1] - meeting2[1];						// 종료 시간 기준으로 정렬 로직
	};

	private static int[][] getMeetings(Scanner scanner) {
		int[][] meetings = new int[MeetingNumbers][2];	// 1자리는 starting time, 2자리는 ending time
		for (int i = 0; i < MeetingNumbers; i++) {
			meetings[i][0] = scanner.nextInt();
			meetings[i][1] = scanner.nextInt();
		}
		return meetings;
	}
}
