import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int K;
	static int[] arr;

	static int count;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		K = Integer.parseInt(stringTokenizer.nextToken());

		arr = new int[N];
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int 삽입정렬 = 삽입정렬();
		if (삽입정렬 == -1) {
			System.out.println(-1);
		} else {
			Arrays.stream(arr).forEach(e -> {
				sb.append(e).append(" ");
			});
			System.out.println(sb.toString().trim());
		}

	}

	public static int 삽입정렬(){
		for (int i = 1; i < N; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				count++;
				if(count == K){
					return arr[j + 1];
				}
				j--;
			}
			if (j + 1 != i) {{
				arr[j + 1] = key;
				count++;
				if(count == K){
					return arr[j + 1];
				}
			}}

		}
		return -1;

	}


}