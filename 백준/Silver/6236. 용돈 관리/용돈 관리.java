import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N_Days = parseInt(stringTokenizer.nextToken());
		int M_WithdrawlCounts = parseInt(stringTokenizer.nextToken());

		int[] plannedUsingMoney = new int[N_Days];
		int min = MAX_VALUE;
		int max = MIN_VALUE;
		for (int i = 0; i < N_Days; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			plannedUsingMoney[i] = parseInt(stringTokenizer.nextToken());
			min = Math.min(min, plannedUsingMoney[i]);
			max = Math.max(max, plannedUsingMoney[i]);
		}

		int l = max; // 최소 인출 금액은 가장 큰 금액과 같거나 커야 함
		int r = 10000 * N_Days; // 최대 인출 금액은 모든 금액의 합과 같거나 작음
		int answer = r;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (isPossible(plannedUsingMoney, mid, M_WithdrawlCounts)) {
				answer = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(answer);
	}

	public static boolean isPossible(int[] plannedUsingMoney, int x, int M_WithdrawlCounts) {
		int count = 1;
		int current = x; // 현재 인출한 금액

		for (int money : plannedUsingMoney) {
			if (current < money) { // 현재 금액으로 충분하지 않으면 인출

				if(count >= M_WithdrawlCounts) { // 카운트 횟수가 중간에  M_WithdrawlCounts보다 같거나 커지면 false
					return false;
				}

				count++;
				current = x;
			}
			current -= money; // 남은 금액 업데이트
		}

		return count <= M_WithdrawlCounts;
	}
}