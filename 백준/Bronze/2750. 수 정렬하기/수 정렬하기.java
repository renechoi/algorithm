import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = 0; i < N - 1; i++) {    // 마지막 정렬이 되면 더이상 볼필요가 없기 때문에 N - 1
			for (int j = 0; j < N - 1; j++) {
				if (A[j] > A[j + 1]) {    // 현재 칸보다 한 칸 더가 크작다면 두 수를 바꾼다.
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(A[i]);
		}

	}
}
