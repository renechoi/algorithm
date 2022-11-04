import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N 입력

		// N 의 값 배열에 저장
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// 배열 A 오름차순 정렬
		Arrays.sort(A);
		int count = 0;
		for (int k = 0; k < N; k++) {
			long find = A[k];
			int i = 0;
			int j = N - 1;

			while (i < j) {
				if (A[i] + A[j] == find) {        //K 값 검증

					if (i != k && j != k) {    // 중복이 아니어야 하므로
						count++;
						break;
					} else if (j == k) {
						j--;
					} else if (i == k) {
						i++;
					}
				} else if (A[i] + A[j] < find) {
					i++;
				} else {        // j값을 낮춰줌으로써 반복문 탈출을 위한 장치를 마련 
					j--;
				}
			}
		}

		System.out.println(count);
		br.close();
	}
}

