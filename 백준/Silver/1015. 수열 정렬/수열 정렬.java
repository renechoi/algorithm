import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
		int N = Integer.parseInt(bufferedReader.readLine().trim());
		int[] A = new int[N];
		String[] tokens = bufferedReader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tokens[i]);
		}

		Integer[] indices = new Integer[N];
		for (int i = 0; i < N; i++) {
			indices[i] = i;
		}

		// 배열 A의 원소를 기준으로 정렬
		Arrays.sort(indices, (o1, o2) -> {
			if (A[o1] != A[o2]) {
				return Integer.compare(A[o1], A[o2]);
			} else {
				return Integer.compare(o1, o2);
			}
		});

		// 배열 A의 원소를 기준으로 정렬하는 메서드 호출
		sortIndicesByArrayValues(A, indices);

		// 정렬된 인덱스를 이용하여 배열 P 생성
		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			P[indices[i]] = i;
		}

		// 결과 출력
		for (int i = 0; i < N; i++) {
			System.out.print(P[i] + " ");
		}

	}

	/**
	 * 주어진 배열 A의 값을 기준으로 인덱스 배열을 정렬
	 * 값이 같을 경우, 인덱스를 기준으로 오름차순 정렬
	 *
	 * @param A 배열 A
	 * @param indices 정렬할 인덱스 배열
	 */
	public static void sortIndicesByArrayValues(int[] A, Integer[] indices) {
		Arrays.sort(indices, (o1, o2) -> {
			if (A[o1] != A[o2]) {
				return Integer.compare(A[o1], A[o2]);
			} else {
				return Integer.compare(o1, o2);
			}
		});
	}
}
