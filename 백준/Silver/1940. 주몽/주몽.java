import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// 받은 재료의 번호를 배열 A에 저장한다.
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// 재료들의 번호를 오름차순 정렬한다.
		Arrays.sort(A);

		int count = 0;
		int i = 0;
		int j = N - 1;   // 포인터의 끝점 j는 N-1로 설정할 수 있다. 
		
		while (i < j) {
			if (A[i] + A[j] < M) {
				i++;
			} else if (A[i] + A[j] > M) {
				j--;
			} else {
				count++;
				i++;
				j--;
			}
		}

		System.out.println(count);
		br.close();
	}
}
