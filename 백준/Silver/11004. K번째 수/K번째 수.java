import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] array = new int[N];

		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		quickSort(array, 0, N - 1, K - 1);

		// 출력부
		System.out.println(array[K - 1]);
	}

	public static void quickSort(int[] array, int L, int R, int K) {

		if (L < R) {
			int pivot = partition(array, L, R);

			if (pivot == K) { return; }
			else if (K < pivot) {
				quickSort(array, L, pivot - 1, K);
			} else {
				quickSort(array, pivot + 1, R, K);
			}
		}
	}

	public static int partition(int[] array, int L, int R) {

		if (L + 1 == R) {                // Value가 두개일 경우 바로 비교하여 정렬할 수 있다.
			if (array[L] > array[R]) {
				swap(array, L, R);
				return R;
			}
		}

		int Median = (L + R) / 2;
		swap(array, L, Median); // i, j의 이동을 편하게 하기 위해 중앙값을 처음으로 옮긴다.

		int pivot = array[L];    // 피벗 위치 설정

		int i = L + 1;    // 탐색 시작 지점
		int j = R;        // 탐색 종료 지점

		while (i <= j) {
			while (pivot < array[j] && j > 0) {        // 피벗보다 작은 수가 나올 때까지
				j--;
			}
			while (pivot > array[i] && i < array.length - 1) {    // 피벗보다 큰수가 나올 때까지
				i++;
			}
			if (i <= j) {                    // i와 j가 만난 시점에
				swap(array, i++, j--);
			}
		}

		array[L] = array[j];        // 피벗 데이터를 나눠진 두 그룹의 경계 idx에 저장하기
		array[j] = pivot;            // 새로운 피벗 리턴
		return j;

	}

	private static void swap(int[] arr, int L, int R) {
		int temp = arr[L];
		arr[L] = arr[R];
		arr[R] = temp;
	}
}
