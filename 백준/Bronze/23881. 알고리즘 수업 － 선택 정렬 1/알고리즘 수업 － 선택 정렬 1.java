import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        selectionSort();
    }

    public static void selectionSort() {
        int swapCount = 0;

        for (int i = N - 1; i > 0; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (A[j] > A[maxIdx]) {
                    maxIdx = j;
                }
            }

            if (i != maxIdx) {
                int temp = A[i];
                A[i] = A[maxIdx];
                A[maxIdx] = temp;
                swapCount++;

                if (swapCount == K) {
                    System.out.println(Math.min(A[i], A[maxIdx]) + " " + Math.max(A[i], A[maxIdx]));
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}