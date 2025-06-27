
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arrA;
	static int[] arrB;
	static int 다른거개수count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());

		arrA = new int[N];
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		arrB = new int[N];
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrB[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		다른것으로count업데이트();

		if(다른거개수count == 0){
			System.out.println(1);
			return;
		}

		System.out.println(	버블정렬());
	}

	
	private static void updateAndSwap(int x, int y) {
		int before = (arrA[x] != arrB[x] ? 1 : 0) + (arrA[y] != arrB[y] ? 1 : 0);

		int tmp = arrA[x];
		arrA[x] = arrA[y];
		arrA[y] = tmp;

		int after  = (arrA[x] != arrB[x] ? 1 : 0) + (arrA[y] != arrB[y] ? 1 : 0);
		다른거개수count += after - before;
	}

	private static void 다른것으로count업데이트() {
		for (int i = 0; i < N; i++) {
			if (arrA[i] != arrB[i]) {
				다른거개수count++;
			}
		}

	}

	public static int 버블정렬() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				if (arrA[j] > arrA[j + 1]) {
					updateAndSwap(j, j + 1);
					if(다른거개수count == 0) {
						return 1;
					}
				}
			}
		}

		return 0;
	}

}