import java.util.Scanner;
public class Main {
	/**
	 * 문제에서 배열은 N X N 형식의 정사각형으로 주어지고 각 요소들은 A[i][j]이기 때문에
	 * n의 배수 형태가 된다
	 * 이것을 (1) 사실로 두고
	 *
	 * 다음으로 k의 성질에 대해 살펴보면 (1)에 따라 배열은 배수 형태로 순차적인 특성을 띄고 있기 때문에
	 * k 번째의 값은 k보다 작거나 같은 숫자의 개수는 k보다 크지 않다
	 * 즉, k번째 안으로 정답이 존재한다는 것이다
	 * 예를 들어 N이 2이고 k가 3이라면
	 * 1 2
	 * 2 4
	 * 형태의 배열이 될 것이며 이때 k의 값은 A[k]는 2이다
	 * 절대로 그 실제 오름차순으로 나열된 A[k]의 값은 k보다 커질 수가 없다
	 * 이것을 (2) 사실로 본다면
	 *
	 * (1), (2)를 통해 추론되는 법칙은
	 * 다음과 같다
	 *
	 * 1의 배수 형태인 1행(혹은 1열)에서는 A[K]를 만족하는 값이 몇 개가 존재할 것인가
	 * 2의 배수 형태인 2행(혹은 2열)에서는 A[k]를 만족하는 값이 몇 개가 존재할 것인가
	 *
	 * 이것을 따져본다면
	 * 각 행(열)은 1 ~ k 번째 숫자 중 중앙값 M으로 나눈 몫이며, 만약 이 몫이 중앙값보다 크다면 한 행이 가지는 최대 값은 N이므로 N으로 처리한다
	 * 이는 곧 Math.min(middle / i, N) 형식으로 표현될 수 있다.
	 *
	 * 따라서 1 ~ k 번째 값에 대해 중앙값을 구하고, 이진 탐색을 하며
	 * 이진 탐색의 로직은
	 * 각 행에서 찾은 k보다 작은 숫자들을 더했을 때 k보다 작다면 시작 idx를 올려 중앙값을 다시 구하여 다시 이진탐색을 한다
	 * 각 행에서 찾은 k보다 작은 숫자들을 더했을 때 k보다 크거나 같다면 시작 idx를 내려 중앙값을 다시 구하여 다시 이진탐색을 한다
	 * => 이 두 로직을 반복하다 시작 idx가 마지막 idx보다 커지는 시점이면 이진 탐색을 종료하고 이전에 구한 값이 정답이 된다
	 */
	
	private static long N;
	private static long K;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		K = scanner.nextInt();

		long startNumber = 1;
		long lastNumber = K;
		long answer = 0;

		// 이진 탐색을 통한 정답 도출 이후 출력
		System.out.println(binarySearch(startNumber, lastNumber, answer));
	}

	private static long binarySearch(long startNumber, long lastNumber, long answer) {
		while (startNumber <= lastNumber) {
			long middleNumber = (startNumber + lastNumber) / 2;

			if (numbersLessThanMiddle(middleNumber) < K) {		// 중앙값보다 작은 수들이 K보다 작다면
				startNumber = middleNumber + 1;
			} else {											// 중앙값보다 작은 수들이 K를 넘어선 시점
				answer = middleNumber;  						// 정답 설정
				lastNumber = middleNumber - 1;
			}
		}
		return answer;
	}

	private static long numbersLessThanMiddle(long middleNumber) {
		long cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += Math.min(middleNumber / i, N);  // 행(혹은 열) 별로 중앙값보다 작은 수들을 구하는 로직
		}
		return cnt;
	}
}
