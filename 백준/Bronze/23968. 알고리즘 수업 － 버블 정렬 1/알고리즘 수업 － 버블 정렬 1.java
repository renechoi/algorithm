import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int 총카운트;
	static int K;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		K = Integer.parseInt(stringTokenizer.nextToken());
		int[] ints = new int[N];
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ints[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		버블정렬(ints);
		if (총카운트 < K) {
			sb.append(-1);
		}
		System.out.println(sb.toString());
	}

	public static void 버블정렬(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					총카운트++;
					swap(arr, j, j + 1);
					if(총카운트 == K) {
						sb.append(arr[j]).append(" ").append(arr[j + 1]);
					}
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}